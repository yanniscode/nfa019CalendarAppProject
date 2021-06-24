package fr.cnam.pbuttons;

import fr.cnam.pdatabase.MysqlConnection;
import fr.cnam.pdatabase.managment.dao.DateActivityDAO;
import fr.cnam.pdatabase.managment.model.DateActivityItem;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.pmain.MainPanel;
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
import java.util.ArrayList;

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

//        this.activityMainFormPanel = new ActivityMainFormPanel(); // si ici, une seule instance créée

        this.formControlButton = new JButton(controlBtnValue);
        this.formControlButton.setPreferredSize(new Dimension(120, 60));

        this.formControlButton.addActionListener(this);

        this.add(this.formControlButton);
    }

    /**
     * Default constructor
     */
    public FormControlButton() {
    }

    // ************************************

    /**
     * JButton - bouton de Contrôle (<, Enter, >)
     */
    private JButton formControlButton;


    // ************************************

    /**
     * 
     */
    private String formControlBtnValue;

    /**
     * 
     */
    private ImageIcon formControlBtnIcon;

    public static void setMainPanel(MainPanel mainPanel) {
        FormControlButton.mainPanel = mainPanel;
    }


    // ************************************


    /**
     * @param ev - méthode de déclenchement des évènements liés aux ControlButtons
     */
    @Override
    public void actionPerformed(ActionEvent ev) {

        System.out.println("ev ############################### "+ ev);
        this.formControlBtnValue = ev.getActionCommand();

        if(this.formControlBtnValue.equals(FormControlAction.ANNULATION)) {
            System.out.println("*** Click sur Annulation");

            // *** fermeture de la fenêtre sans modification:
            activityFormFrame.dispose();
        }
        else if(this.formControlBtnValue.equals(FormControlAction.VALIDATION)) {
            System.out.println("*** Click sur Validation");

            try {
                this.onValidateFunction();

                this.reinitCalendar();

            } catch (ClassNotFoundException | SQLException | ParseException e) {
                e.printStackTrace();
            }
        }
        else if(this.formControlBtnValue.equals(FormControlAction.SUPPRESSION)) {
            System.out.println("*** Click sur Suppression");

            try {
                this.onSuppressionFunction();
                this.reinitCalendar();
            } catch (ClassNotFoundException | SQLException | ParseException e) {
                e.printStackTrace();
            }
        }

    }





    /**
     * MainPanel - mainPanel en param (à revoir si MainPanel = static -> nécessaire ??)
     */
    private static MainPanel mainPanel;

    /**
     * Connection - variable de connexion à MySql
     */
    private Connection connection;

    /**
     * int - index du mois à afficher (static)
     */
    private static int indexMonth;

    private static Date newReferenceDay;


    /**
     *
     */
    private void reinitCalendar() throws SQLException, ClassNotFoundException {

        // *** appel du 'getter' de la classe MonthPageIncrement (putils)
        indexMonth = getIncrementValue();

        DatePart newDatePart = new DatePart();

        // *** suppression des données de la page actuelle pour mise à jour

        this.mainPanel.getCalendarPanel().removeAllDaysFromCalendarPanel();
        this.mainPanel.getCalendarPanel().removeAllFromDaysList();

        // *** recherche de l'intitulé du mois à afficher (selon la page actuelle)

        System.out.println("THIS.MONTH INDEX = "+ indexMonth);

        this.newReferenceDay = newDatePart.getOneMonthInterval(indexMonth);
//        System.out.println("NWRefDAY: "+ newFirstMonday);

        // ******** Ajout  du titre du mois précédent au CalendarPanel (string):
        this.mainPanel.getCalendarPanel().setNewMonthLabel(this.newReferenceDay);


        // **** recherche et ajout des jours avec leurs données éventuelles (JDBC)

        ArrayList<DateButton> newDatesList= new ArrayList<DateButton>();

        this.connection = this.mainPanel.getCalendarPanel().getConnection();


        for(int i = 0; i < 41; i++) {
            DateButton newDateButton = new DateButton(indexMonth, i, this.connection);
            newDatesList.add(newDateButton);
        }

        // *** création de la liste de boutons avec les dates du mois actuel
        this.mainPanel.getCalendarPanel().buildDaysList(newDatesList);

        // *** update des boutons ayant une activité déjà enregistré avant l'affichage de la page
//        this.mainPanel.getCalendarPanel().buildActivitiesList(newDatesList, this.indexMonth);

        this.mainPanel.getCalendarPanel().revalidate(); // nécessaire pour mettre à jour l'affichage

//        this.mainPanel.add(this.mainPanel.getCalendarPanel());

        return;
    }





    /**
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws ParseException
     * @return void
     */
    public void onSuppressionFunction() throws ClassNotFoundException, SQLException, ParseException {

        MysqlConnection mysqlConnection = new MysqlConnection();

        // *** ouverture de la connection
        boolean connectResponse = mysqlConnection.connection();

        if(connectResponse == true) {

            Connection connection = mysqlConnection.getConnection();
            DateActivityDAO dateActivityDAO = new DateActivityDAO(connection);


            // *** Datas des champs de ActivityFormFrame

            // *** écouteur du champs date
            String newDateFromField = activityFormFrame.getDateTextField().getText();
            ReformatDate reformatDate = new ReformatDate();
            Long formatedNewDateToLong = reformatDate.formatStringToLong(newDateFromField);

            // *************************

            // *** insertion en BDD d'une nouvelle activité
            dateActivityDAO.delete(formatedNewDateToLong);

            connection.close();

            // *** fermeture de la fenêtre lorsque la nouvelle activité a été créée
            activityFormFrame.dispose();

        }
        else {
            System.out.println("erreur de connexion...");
        }

    }


    /**
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws ParseException
     * @return void - fonction de validation des données du formulaire d'édition d'une Activité
     */
    public void onValidateFunction() throws ClassNotFoundException, SQLException, ParseException {

        MysqlConnection mysqlConnection = new MysqlConnection();
//        Class.forName("com.mysql.cj.jdbc.Driver");
        // *** ouverture de la connection:

        boolean connectResponse = mysqlConnection.connection();

        if(connectResponse == true) {

            Connection connection = mysqlConnection.getConnection();

            // *** Datas des champs de ActivityFormFrame

            // *** écouteur du champs date
//            System.out.println("~~~~~~~~~~~~ ACTIVITY FRAME FROM CONTROLBUTTON: "+ activityFormFrame.getDateTextField().getText());
            String newDateFromField = activityFormFrame.getDateTextField().getText();
            ReformatDate reformatDate = new ReformatDate();
            Long formatedNewDateToLong = reformatDate.formatStringToLong(newDateFromField);
//            System.out.println("date long = "+ formatedNewDateToLong);

            // *** écouteur du champs Description de l'activité:
//            System.out.println("~~~~~~~~~~~~ ACTIVITY FRAME FROM CONTROLBUTTON: "+ activityFormFrame.getActivityDescriptionText().getText());
            String newActivityDescription = activityFormFrame.getActivityDescriptionText().getText();

            // *** écouteur du champs Status de l'activité:
//            System.out.println("~~~~~~~~~~~~ ACTIVITY FRAME FROM CONTROLBUTTON: "+ activityFormFrame.getActivityStatusText().getSelectedItem());
            String newActivityStatus = activityFormFrame.getActivityStatusText().getSelectedItem().toString();

            DateActivityItem dateActivityItem = new DateActivityItem();

            DatePart newDatePart = new DatePart();
            newDatePart.setDatePartValue(formatedNewDateToLong);

            dateActivityItem.setDatePart(newDatePart);
            dateActivityItem.setDateActivityDescription(newActivityDescription);
            // *** ajout de guillemets pour l'Enum
            dateActivityItem.setDateActivityStatus("\""+ newActivityStatus +"\"");

            // *************************
            // *** insertion en BDD d'une nouvelle activité
            DateActivityDAO dateActivityDAO = new DateActivityDAO(connection);

            dateActivityDAO.create(dateActivityItem);

            connection.close();

            // *** fermeture de la fenêtre lorsque la nouvelle activité a été créée
            activityFormFrame.dispose();

        }
        else {
            System.out.println("FormControlButton - erreur de connexion...");

            // *** JLabel (à refactoriser  avec class errorPanel ?? // marche pas encore
//            JLabel errorLabel = new JLabel("Erreur de connexion à la BDD...", SwingConstants.CENTER);
//            errorLabel.setFont(new Font("Serif", 0, 25));
//            activityFormFrame.add(errorLabel);
        }

    }


    // ************************************

    /**
     * @return
     */
    public String getFormControlBtnValue() {
        // TODO implement here
        return "";
    }

    /**
     * @param formControlValue
     * @return
     */
    public void setControlBtnValue(String formControlValue) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public ImageIcon getFormControlBtnIcon() {
        // TODO implement here
        return null;
    }

    /**
     * @param imageIcon
     * @return void - si ajout d'une icone au bouton (à faire)
     */
    public void setFormControlBtnIcon(ImageIcon imageIcon) {
        // TODO implement here
        return;
    }

    @Override
    /**
     * @return void
     */
    public void displayFormControlBtn() {
        // TODO implement here
        return;
    }

}