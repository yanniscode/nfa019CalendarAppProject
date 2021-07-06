package fr.cnam.pbuttons;

import fr.cnam.pdatabase.managment.dao.DateActivityDAO;
import fr.cnam.pdatabase.managment.model.DateActivityItem;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.putils.penums.ActivityColor;
import fr.cnam.putils.ReformatDate;
import fr.cnam.putils.penums.ErrorMessage;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static fr.cnam.pactivity.ActivityFormFrame.*;


/**
 * @author Yannis Guéguen
 */
public class DateButton extends JPanel implements DateButtonInterface, ActionListener {


    /**
     * constructor 2: pour création des boutons des pages précédentes ou suivantes (par le param Date = du mois précédent ou suivant)
     * @param monthIndex, dayIndex, connection
     */
    public DateButton(int monthIndex, int dayIndex, Connection connection) {

        super();

        // *** Appel des données (JDBC) des boutons ayant une activité déjà enregistré avant l'affichage de la page
        this.rebuildActivityDatas(connection, monthIndex, dayIndex);
        this.dateJButton.setPreferredSize(new Dimension(120, 100));

        this.add(this.dateJButton);
    }


    /**
     * Constructor 1: pour création des boutons de base (date = actuelle)
     * @param dayIndex, connection
     */
    public DateButton(int dayIndex, Connection connection) {

        super();

        // *** Appel des données (JDBC) des boutons ayant une activité déjà enregistré avant l'affichage de la page
        this.rebuildActivityDatas(connection, 0, dayIndex);
        this.dateJButton.setPreferredSize(new Dimension(120, 100));

        this.add(this.dateJButton);
    }


    /**
     * Constructor par défault : Java Bean (ici, pour tests JUnit)
     */
    public DateButton() throws ClassNotFoundException, SQLException {

        super();

        this.dateJButton = new JButton("test JUnit");

        this.add(this.dateJButton);
    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());

    /**
     * DatePart - date considérée (au sens générique)
     */
    private DatePart datePart;

    /**
     * Date - nouvelle date sélectionnée
     */
    private java.sql.Date dateValue;

    /**
     * @return Date
     */
    public java.sql.Date getDateValue() {
        return this.dateValue;
    }

    /**
     * @param dateValue
     * return void
     */
    public void setDateValue(java.sql.Date dateValue) {
        this.dateValue = dateValue;
    }

    /**
     * ReformatDate
     */
    private ReformatDate reformatDate;

    /**
     * String - date formatée
     */
    private String formatedDate;

    /**
     * JButton - bouton de date
     */
    private JButton dateJButton;


    /**
     * String - description de l'activité saisie dans le formulaire
     */
    private String activityDescription = null;

    /**
     * String - (enum) status d'une activité selectionné dans le formulaire
     */
    private String activityStatus = null;


    /**
     *
     * @return JButton
     */
    public JButton getDateButton() {
        return this.dateJButton;
    }



    @Override
    public void actionPerformed(ActionEvent ev) {

        try {
            this.openActivityDateFormPanel();
        }
        catch(Exception e) {
            this.logger.log(Level.SEVERE, ErrorMessage.CLICK_ERROR, e.getStackTrace());
        }
    }


    /**
     * @return void - Ouverture d'ActivityFormFrame à partir du clic sur le DateButton
     */
    public void openActivityDateFormPanel() {

        // *** si une fenêtre 'activityFormPanel' est déjà visible, on ne peut en créer une nouvelle (la première est initialisée dans le constructeur)
        this.activityDescription = this.getActivityDescription();
        this.activityStatus = this.getActivityStatus();

        if(this.getActivityDescription() == null || this.getActivityStatus() == null) {
            activityFormFrame.initFormFields();
        }


        // *** initialisation des champs de ActivityFormFrame avec les données de l'Activité (à la date correspondante)
        this.reformatDate = new ReformatDate();
        this.formatedDate = this.reformatDate.formatDateToString(this.dateValue);

        activityFormFrame.initFormFieldsWithDatas(this.formatedDate, this.activityDescription, this.activityStatus);
        activityFormFrame.setVisible(true);
    }


    /**
     *
     * @param connection
     * @param indexMonth
     * @param dayIndex
     * @return Jbutton - reconstruit le DateButton avec des données extraites de la BDD MySQL, si présentes, ou un bouton "vierge", sinon
     */
    public void rebuildActivityDatas(Connection connection, int indexMonth, int dayIndex) {

        // **** création du bouton de base contenant une Date:
        this.buildDateButton(indexMonth, dayIndex);

        // *** recherche d'infos correspondant à cette date pour le bouton:
        DateActivityItem dateActivityItem = this.searchDatasForButton(connection);

        this.setActivityDescription(dateActivityItem.getDateActivityDescription());
        this.setActivityStatus(dateActivityItem.getDateActivityStatus());

        Long resLongDateFromBdd = dateActivityItem.getDatePart().getDatePartValue();


        /**
         * si la bdd envoie une dateActivityItem correspondante au jour passé, ET si le bouton est actif (= correspond bien au mois affiché)
         */
        if(resLongDateFromBdd != null && !this.dateJButton.getBackground().toString().equals("java.awt.Color[r=192,g=192,b=192]")) {

            // *** le bouton est reconstruit avec les datas de la BDD:
            this.rebuildButtonWithDatas(dateActivityItem, indexMonth, dayIndex);

        }

        this.setDateButton(this.dateJButton);
    }



    /**
     *
     * @param indexMonth
     * @param dayIndex
     * @return void - construction d'un DateButton de base
     */
    public void buildDateButton(int indexMonth, int dayIndex) {

        this.datePart = new DatePart();

        this.dateValue = this.datePart.getByFirstMondayOfMonthPage(indexMonth, dayIndex);    // *** format: YYYY-MM-DD - SI indexMonth = 0 (= mois actuel pour l'initialisation du calendrier)
        this.datePart.setDateValue(this.dateValue);

        // *** conversion de la date (Date) au format "dd/MM/yyyy" (String)
        this.reformatDate = new ReformatDate();
        this.formatedDate = reformatDate.formatDateToString(this.dateValue);

        this.dateJButton = new JButton(this.formatedDate);

        this.dateJButton.addActionListener(this);

        // *** si le JPanel du bouton ne correspond pas au mois de la page, il est désactivé
        this.setButtonToGray(this.datePart, indexMonth);  // 0 = today

        this.setDateButton(this.dateJButton);
    }

    /**
     *
     * @param connection
     * @return DateActivityItem - recherche des données (en BDD) correspondantes à la date du DateButton de base
     */
    public DateActivityItem searchDatasForButton(Connection connection) {

        DateActivityDAO dateActivityDAO = new DateActivityDAO(connection);

        DateActivityItem dateActivityItem;

        dateActivityItem = dateActivityDAO.findByDate(this.dateValue, connection);

        return dateActivityItem;
    }


    /**
     * @param dateActivityItem
     * @param indexMonth
     * @param dayIndex
     * @return void - re-construction du DateButton avec les données récupérées en BDD, si présentes, sinon, un bouton de base est de nouveau créé
     */
    public void rebuildButtonWithDatas(DateActivityItem dateActivityItem, int indexMonth, int dayIndex) {

            this.activityDescription = dateActivityItem.getDateActivityDescription();

            StringBuilder newActivityButtonData = new StringBuilder();
            newActivityButtonData.append(activityDescription);

            this.dateJButton = new JButton(String.valueOf(newActivityButtonData));
            this.dateJButton.addActionListener(this);

            if(dateActivityItem.getDateActivityStatus() != null) {
                if (dateActivityItem.getDateActivityStatus().equals("\"En définition\"")) {
                    this.dateJButton.setBackground(ActivityColor.ORANGE);
                } else if (dateActivityItem.getDateActivityStatus().equals("\"En cours\"")) {
                    this.dateJButton.setBackground(ActivityColor.BLUE);
                } else if (dateActivityItem.getDateActivityStatus().equals("\"En test\"")) {
                    this.dateJButton.setBackground(ActivityColor.RED);
                } else if (dateActivityItem.getDateActivityStatus().equals("\"Terminée\"")) {
                    this.dateJButton.setBackground(ActivityColor.GREEN);
                }
            }
            else {
                // **** reset du bouton ses données sont nulles (après suppression... par ex)
                this.buildDateButton(indexMonth, dayIndex);
            }

            this.setDateButton(this.dateJButton);
    }


    /**
     *
     *      * @param dateJButton
     *      return void
     */
    public void setDateButton(JButton dateJButton) {
        this.dateJButton = dateJButton;
    }


    /**
     * @param newFirstDay
     * @param monthIndex
     * @return void - passe le bouton au status inactif (s'il ne correspond pas au mois de la page affichée)
     */
    public void setButtonToGray(DatePart newFirstDay, int monthIndex) {

        this.datePart = newFirstDay;

        java.sql.Date newFirstDayTemp = newFirstDay.getDateValue();

        java.sql.Date dateToCompare = this.datePart.getOneMonthInterval(monthIndex);

        this.reformatDate = new ReformatDate();
        String formatedReferenceDate = this.reformatDate.formatMonthToString(dateToCompare);
        String formatedSelectedDate = this.reformatDate.formatMonthToString(newFirstDayTemp);

        if(!formatedReferenceDate.equals(formatedSelectedDate)) {
            this.dateJButton.setBackground(Color.LIGHT_GRAY);
            this.dateJButton.setEnabled(false);
        }
    }


    /**
     * @return String
     */
    public String getActivityDescription() {
        return this.activityDescription;
    }


    /**
     * @param activityDescription
     * @return void
     */
    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }


    /**
     * @return String
     */
    public String getActivityStatus() {
        return this.activityStatus;
    }


    /**
     * @param activityStatus
     * @return void
     */
    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }


    @Override
    /**
     * @return void
     */
    public void displayDateButton() {
        this.logger.log(Level.INFO, () -> "info (displayDateButton): "+ this.dateJButton); }

}