package fr.cnam.pbuttons;

import fr.cnam.pdatabase.MysqlConnection;
import fr.cnam.pdatabase.managment.dao.DateActivityDAO;
import fr.cnam.pdatabase.managment.model.DateActivityItem;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.pmain.MainPanel;
import fr.cnam.putils.penums.ErrorMessage;
import fr.cnam.putils.penums.FormControlAction;
import fr.cnam.putils.ReformatDate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static fr.cnam.pactivity.ActivityFormFrame.*;
import static fr.cnam.putils.MonthPageIncrement.getIncrementValue;


/**
 * @author Yannis Guéguen
 */
public class FormControlButton extends JPanel implements FormControlButtonInterface, ActionListener {


    /**
     * constructor 1: (A FAIRE) utilisé par ControlButton 'EnterActivity' ??
     */
    public FormControlButton(String controlBtnValue) {

        super();

        this.formControlJButton = new JButton(controlBtnValue);
        this.formControlJButton.setPreferredSize(new Dimension(120, 60));

        this.formControlJButton.addActionListener(this);

        this.add(this.formControlJButton);
    }

    /**
     * Default constructor
     */
    public FormControlButton() {
        super();
    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());

    /**
     * JButton - bouton de Contrôle (<, Enter, >)
     */
    private JButton formControlJButton;

    /**
     * ImageIcon
     */
    private ImageIcon formControlBtnIcon;

    /**
     * MainPanel - mainPanel
     */
    private MainPanel mainPanel;


    /**
     * @param mainPanel
     * @return void
     */
    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }


    /**
     * @param ev - méthode de déclenchement des évènements liés aux ControlButtons
     */
    @Override
    public void actionPerformed(ActionEvent ev) {

        /**
         * String
         */
        String formControlBtnValue;

        formControlBtnValue = ev.getActionCommand();

        if(formControlBtnValue.equals(FormControlAction.ANNULATION)) {

            // *** fermeture de la fenêtre sans modification:
            activityFormFrame.dispose();
        }
        else if(formControlBtnValue.equals(FormControlAction.VALIDATION)) {

            try {
                this.onValidateFunction();

                this.reinitCalendar();

            } catch (ClassNotFoundException | SQLException | ParseException e) {
                this.logger.log(Level.SEVERE, ErrorMessage.BDD_CONNECT_ERROR, e.getStackTrace());
            }
        }
        else if(formControlBtnValue.equals(FormControlAction.SUPPRESSION)) {

            try {
                this.onSuppressionFunction();

                this.reinitCalendar();

            } catch (ClassNotFoundException | SQLException | ParseException e) {
                this.logger.log(Level.SEVERE, ErrorMessage.BDD_CONNECT_ERROR, e.getStackTrace());
            }
        }

    }

    /**
     *
     */
    private void reinitCalendar() throws SQLException, ClassNotFoundException {

        Connection connection;

        int indexMonth;
        Date newReferenceDay;

        // *** appel du 'getter' de la classe MonthPageIncrement (putils)
        indexMonth = getIncrementValue();

        DatePart newDatePart = new DatePart();

        // *** suppression des données de la page actuelle pour mise à jour
        this.mainPanel.getCalendarPanel().removeAllDaysFromCalendarPanel();
        this.mainPanel.getCalendarPanel().removeAllFromDaysList();

        // *** recherche de l'intitulé du mois à afficher (selon la page actuelle)
        newReferenceDay = newDatePart.getOneMonthInterval(indexMonth);

        // ******** Ajout  du titre du mois précédent au CalendarPanel (string):
        this.mainPanel.getCalendarPanel().buildNewMonthLabel(newReferenceDay);


        // **** recherche et ajout des jours avec leurs données éventuelles (JDBC)
        List<DateButton> newDatesList = new ArrayList<>();

        connection = this.mainPanel.getCalendarPanel().getConnection();


        for(int i = 0; i < 41; i++) {
            DateButton newDateButton = new DateButton(indexMonth, i, connection);
            newDatesList.add(newDateButton);
        }

        // *** création de la liste de boutons avec les dates du mois actuel
        this.mainPanel.getCalendarPanel().buildDaysList(newDatesList);

        // *** update des boutons ayant une activité déjà enregistré avant l'affichage de la page
        this.mainPanel.getCalendarPanel().revalidate(); // nécessaire pour mettre à jour l'affichage
    }



    /**
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws ParseException
     * @return void
     */
    public boolean onSuppressionFunction() throws ClassNotFoundException, SQLException, ParseException {

        MysqlConnection mysqlConnection = new MysqlConnection();

        // *** ouverture de la connection
        boolean connectResponse = mysqlConnection.connection();

        Connection suppressionConnection = mysqlConnection.getConnection();
        DateActivityDAO dateActivityDAO = new DateActivityDAO(suppressionConnection);


        // *** Datas des champs de ActivityFormFrame

        // *** écouteur du champs date
        String newDateFromField = activityFormFrame.getDateTextField().getText();
        ReformatDate reformatDate = new ReformatDate();
        Long formatedNewDateToLong = reformatDate.formatStringToLong(newDateFromField);

        // *** insertion en BDD d'une nouvelle activité
        dateActivityDAO.delete(formatedNewDateToLong);

        suppressionConnection.close();

        // *** fermeture de la fenêtre lorsque la nouvelle activité a été créée
        activityFormFrame.dispose();

        return connectResponse;
    }


    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws ParseException
     * @return void - fonction de validation des données du formulaire d'édition d'une Activité
     */
    public boolean onValidateFunction() throws ClassNotFoundException, SQLException, ParseException {

        MysqlConnection mysqlConnection = new MysqlConnection();

        boolean connectResponse = mysqlConnection.connection();

        Connection validateConnection = mysqlConnection.getConnection();

        // *** Datas des champs de ActivityFormFrame

        // *** écouteur du champs date
        String newDateFromField = activityFormFrame.getDateTextField().getText();
        ReformatDate reformatDate = new ReformatDate();
        Long formatedNewDateToLong = reformatDate.formatStringToLong(newDateFromField);

        // *** écouteur du champs Description de l'activité:
        String newActivityDescription = activityFormFrame.getActivityDescriptionText().getText();

        // *** écouteur du champs Status de l'activité:
        String newActivityStatus = activityFormFrame.getActivityStatusText().getSelectedItem().toString();

        DateActivityItem dateActivityItem = new DateActivityItem();

        DatePart newDatePart = new DatePart();
        newDatePart.setDatePartValue(formatedNewDateToLong);

        dateActivityItem.setDatePart(newDatePart);
        dateActivityItem.setDateActivityDescription(newActivityDescription);

        // *** ajout de guillemets pour l'Enum
        dateActivityItem.setDateActivityStatus("\""+ newActivityStatus +"\"");

        // *** insertion en BDD d'une nouvelle activité
        DateActivityDAO dateActivityDAO = new DateActivityDAO(validateConnection);

        dateActivityDAO.create(dateActivityItem);

        validateConnection.close();

        // *** fermeture de la fenêtre lorsque la nouvelle activité a été créée
        activityFormFrame.dispose();

        return connectResponse;
    }


    /**
     * @return ImageIcon
     */
    public ImageIcon getFormControlBtnIcon() {
        // A faire
        return this.formControlBtnIcon;
    }

    /**
     * @param formControlBtnIcon
     * @return void - si ajout d'une icone au bouton (à faire)
     */
    public void setFormControlBtnIcon(ImageIcon formControlBtnIcon) {
        this.formControlBtnIcon = formControlBtnIcon;
    }

    @Override
    /**
     * @return void
     */
    public void displayFormControlBtn() {
        this.logger.log(Level.INFO, () -> "info (displayFormControlBtn): "+ this.formControlJButton);
    }

}