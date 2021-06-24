package fr.cnam.pbuttons;

import fr.cnam.pactivity.ActivityFormFrame;
import fr.cnam.pdatabase.managment.dao.DateActivityDAO;
import fr.cnam.pdatabase.managment.model.DateActivityItem;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.putils.penums.ActivityColor;
import fr.cnam.putils.penums.FormControlAction;
import fr.cnam.putils.ReformatDate;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.util.Calendar;

import static fr.cnam.pactivity.ActivityFormFrame.*;


/**
 * @author Yannis Guéguen
 */
public class DateButton extends JPanel implements DateButtonInterface, ActionListener {


    /**
     * constructor 2: pour création des boutons des pages précédentes ou suivantes (par le param Date = du mois précédent ou suivant)
     * @param monthIndex, dayIndex, connection
     */
    public DateButton(int monthIndex, int dayIndex, Connection connection) throws ClassNotFoundException, SQLException {

        super();

        // *** Appel des données (JDBC) des boutons ayant une activité déjà enregistré avant l'affichage de la page
        this.dateButton = this.getActivityDatas(connection, monthIndex, dayIndex);
        this.dateButton.setPreferredSize(new Dimension(120, 100));

        this.add(this.dateButton);
    }


    /**
     * Constructor 1: pour création des boutons de base (date = actuelle)
     * @param dayIndex, connection
     */
    public DateButton(int dayIndex, Connection connection) throws ClassNotFoundException, SQLException {

        super();

        // *** Appel des données (JDBC) des boutons ayant une activité déjà enregistré avant l'affichage de la page
        this.dateButton = this.getActivityDatas(connection, 0, dayIndex);
        this.dateButton.setPreferredSize(new Dimension(120, 100));

        this.add(this.dateButton);
    }

    // AJOUTS:

    /**
     * DatePart - date considérée (au sens générique)
     */
    private DatePart datePart;

    /**
     * Date - nouvelle date sélectionnée
     */
    private java.sql.Date dateValue;


    // *******************

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
        return;
    }


    private ReformatDate reformatDate;

    /**
     * DateFormat - pour le formatage d"une date
     */
    private DateFormat dateFormat;

    //        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", dfsFR);

    /**
     * String - date formatée
     */
    private String formatedDate;

    /**
     * JButton - bouton de date
     */
    private JButton dateButton;

    /**
     * Calendar - nouveau calendrier pour mise à jour selon le mois considéré
     */
    private Calendar newCalendar;




    // ***********************
    /**
     * Date - date agrégée (lors de création d'un formulaire avec des éléments d'une date séparé - Jour - Mois -Année)
     */
    private java.sql.Date aggregatedDate = null;

    /**
     * String - description de l'activité saisie dans le formulaire
     */
    private String activityDescription = null;

    /**
     * String - (enum) status d'une activité selectionné dans le formulaire
     */
    private String activityStatus = null;

    /**
     * ActivityColor - (enum) couleur du DateButton (selon le status de l'activité: à faire, en cours, en test, réalisée)
     */
    private ActivityColor activityColor;

    /**
     * DatePart - partie Année d'une date
     */
    private DatePart yearSelect = null;

    /**
     * DatePart - partie Mois d'une date
     */
    private DatePart monthSelect = null;

    /**
     * DatePart - partie jour d"une date
     */
    private DatePart daySelect = null;


    // **************

    /**
     *
     * @return JButton
     */
    public JButton getDateButton() {
        return this.dateButton;
    }


    // *********************

    private String DateButtonValue;

    @Override
    public void actionPerformed(ActionEvent ev) {

        System.out.println("ev ############################### "+ ev.getActionCommand());
        this.DateButtonValue = ev.getActionCommand();

        try {
            this.openActivityDateFormPanel();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

//        if(this.DateButtonValue.equals(FormControlAction.ANNULATION)) {
//            System.out.println("*** Click sur Annulation");
//            // *** fermeture de la fenêtre sans modification:
//
//            ControlButton.activityFormFrame.dispose();
//
//        }

        return;
    }


    // *** pb si utilisé (utilisation pour quitter la frame...)
//    protected static ActivityFormFrame activityFormFrame =  new ActivityFormFrame();


    /**
     * @return void - Ouverture d'ActivityFormFrame à partir du clic sur le DateButton
     */
    public void openActivityDateFormPanel() {

//            this.activityMainFormPanel.getActivityForm().setDayAsDate(new java.sql.Date(System.currentTimeMillis()));

//            ActivityFormPanel activityFormPanel;
//            this.activityMainFormPanel = new ActivityMainFormPanel(); // si ici, nouvelle instance crée à chaque fois

        // *** si une fenêtre 'activityFormPanel' est déjà visible, on ne peut en créer une nouvelle (la première est initialisée dans le constructeur)
        System.out.println(activityFormFrame);

        System.out.println("this.activityDescription = "+ this.activityDescription);
        System.out.println("this.activityStatus = "+ this.activityStatus);

        System.out.println("this.getActivityStatus = "+ this.getActivityStatus());
        System.out.println("this.getActivityDescription = "+ this.getActivityDescription());

        this.activityDescription = this.getActivityDescription();
        this.activityStatus = this.getActivityStatus();

        if(this.getActivityDescription() == null || this.getActivityStatus() == null) {
            System.out.println("NULL DATE BUTTON");
            activityFormFrame.initFormFields();
        }

        System.out.println("DATE TEXT FIELD: " + activityFormFrame.getDateTextField().getText());

        // *** initialisation des champs de ActivityFormFrame avec les données de l'Activité à la date correspondante
        System.out.println("this.dateValue = "+ this.dateValue);    // format: YYYY-MM-DD
        this.reformatDate = new ReformatDate();
        this.formatedDate = reformatDate.formatDateToString(this.dateValue);
        System.out.println("this.formatedDate = "+ this.formatedDate);    // format: YYYY-MM-DD

        System.out.println("this.activityDescription = "+ this.activityDescription);
        System.out.println("this.activityStatus = "+ this.activityStatus);

        activityFormFrame.initFormFieldsWithDatas(this.formatedDate, this.activityDescription, this.activityStatus);

//                System.out.println(this.activityMainFormPanel.getActivityFormFrame());
        activityFormFrame.setVisible(true);

    }


    /**
     *
     * @param connection
     * @param indexMonth
     * @param dayIndex
     * @return Jbutton - reconstruit le DateButton avec des données extraites de la BDD MySQL, si présentes, ou un bouton "vierge", sinon
     */
    private JButton getActivityDatas(Connection connection, int indexMonth, int dayIndex) {

        // **** création du bouton de base contenant une Date:
        this.buildDateButton(indexMonth, dayIndex);

        // *** recherche d'infos correspondant à cette date pour le bouton:
        DateActivityItem dateActivityItem = this.searchDatasForButton(connection);

        this.setActivityDescription(dateActivityItem.getDateActivityDescription());
        this.setActivityStatus(dateActivityItem.getDateActivityStatus());

        Long resLongDateFromBdd = dateActivityItem.getDatePart().getDatePartValue();
//        System.out.println("###### bdd date = " + resLongDateFromBdd); // date: format long - ex: 11111111111L


//        // *** si la bdd envoie une dateActivityItem correspondante au jour passé, ET si le bouton est actif (= correspond bien au mois affiché)
        if(resLongDateFromBdd != null && !this.dateButton.getBackground().toString().equals("java.awt.Color[r=192,g=192,b=192]")) {

            // *** le bouton est reconstruit avec les datas de la BDD:
            this.rebuildButtonWithDatas(dateActivityItem, indexMonth, dayIndex);

        }

        return this.dateButton;
    }



    /**
     *
     * @param indexMonth
     * @param dayIndex
     * @return void - construction d'un DateButton de base
     */
    private void buildDateButton(int indexMonth, int dayIndex) {
        this.datePart = new DatePart();

        this.dateValue = this.datePart.getByFirstMondayOfMonthPage(indexMonth, dayIndex);    // *** format: YYYY-MM-DD - SI indexMonth = 0 (= mois actuel pour l'initialisation du calendrier)
//        System.out.println("~~~~~~~~~~~~ ##################################  " + this.dateValue);
        this.datePart.setDateValue(this.dateValue);

        // *** conversion de la date (Date) au format "dd/MM/yyyy" (String)
        this.reformatDate = new ReformatDate();
        this.formatedDate = reformatDate.formatDateToString(this.dateValue);

        this.dateButton = new JButton(this.formatedDate);

        this.dateButton.addActionListener(this);

        // *** si le JPanel du bouton ne correspond pas au mois de la page, il est désactivé
        this.setButtonToGray(this.datePart, indexMonth);  // 0 = today

        return;
    }

    /**
     *
     * @param connection
     * @return DateActivityItem - recherche des données (en BDD) correspondantes à la date du DateButton de base
     */
    private DateActivityItem searchDatasForButton(Connection connection) {

        System.out.println(connection);
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
    private void rebuildButtonWithDatas(DateActivityItem dateActivityItem, int indexMonth, int dayIndex) {

//            System.out.println("STATUS ~~~~~~~~~~~~~~~~~~~~~~~~~~~ = " + dateActivityItem.getDateActivityStatus());

//            java.sql.Date ConvertedDateFromBDD = new java.sql.Date(resLongDateFromBdd);


            // ***  UTILE SI ON REMET LA DATE PLUTÔT QUE L'ACTIVITÉ SUR LE BOUTON AVEC DES DONNÉES
//            DatePart modifiedDatePart = new DatePart();
//            modifiedDatePart.setDateValue(ConvertedDateFromBDD);
//
//            // *** conversion de la date (String) au format "dd/MM/yyyy"
//            ReformatDate reformatDate = new ReformatDate();
//            this.formatedDate = reformatDate.formatDateToString(ConvertedDateFromBDD);
////            System.out.println("~~~~~~~~~~~~ ##################################" + this.formatedDate);

            // *******************

            String activityDescription = dateActivityItem.getDateActivityDescription();
//            String activityStatus = dateActivityItem.getDateActivityStatus();

            StringBuilder newActivityButtonData = new StringBuilder();
            newActivityButtonData.append(activityDescription);
//            newActivityButtonData.append(activityStatus +" ** "+ this.formatedDate +" ** "+ activityDescription);

            this.dateButton = new JButton(String.valueOf(newActivityButtonData));
            System.out.println(dateActivityItem.getDateActivityDescription());

            this.dateButton.addActionListener(this);

            this.activityColor = new ActivityColor();

            if(dateActivityItem.getDateActivityStatus() != null) {
                if (dateActivityItem.getDateActivityStatus().equals("\"En définition\"")) {
                    this.dateButton.setBackground(this.activityColor.ORANGE);
                } else if (dateActivityItem.getDateActivityStatus().equals("\"En cours\"")) {
                    this.dateButton.setBackground(this.activityColor.BLUE);
                } else if (dateActivityItem.getDateActivityStatus().equals("\"En test\"")) {
                    this.dateButton.setBackground(this.activityColor.RED);
                } else if (dateActivityItem.getDateActivityStatus().equals("\"Terminée\"")) {
                    this.dateButton.setBackground(this.activityColor.GREEN);
                }
            }
            else {
                // **** reset du bouton ses données sont nulles (après suppression... par ex)
                this.buildDateButton(indexMonth, dayIndex);
            }


        return;
    }





    // **************

    /**
     *
     *      * @param dateButton
     *      return void
     */
    public void setDateButton(JButton dateButton) {
        this.dateButton = dateButton;
        return;
    }


    /**
     * @param newFirstDay
     * @param monthIndex
     * @return void - passe le bouton au status inactif (s'il ne correspond pas au mois de la page affichée)
     */
    public void setButtonToGray(DatePart newFirstDay, int monthIndex) {

//        System.out.println(newFirstDay);
        this.datePart = newFirstDay;

//        System.out.println(newFirstDay.getDateValue());
        java.sql.Date newFirstDayTemp = newFirstDay.getDateValue();

//        System.out.println("{{{{{{{{{{{{{{{{{{ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ newFirstDayTemp);
        java.sql.Date dateToCompare = this.datePart.getOneMonthInterval(monthIndex);
//        System.out.println("{{{{{{{{{{{{{{{{{{ ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+ dateToCompare);

        ReformatDate reformatDate = new ReformatDate();
        String formatedReferenceDate = reformatDate.formatMonthToString(dateToCompare);
        String formatedSelectedDate = reformatDate.formatMonthToString(newFirstDayTemp);

//        System.out.println(formatedReferenceDate +" ------------- "+ formatedSelectedDate);
        if(!formatedReferenceDate.equals(formatedSelectedDate)) {
            this.dateButton.setBackground(Color.LIGHT_GRAY);
            this.dateButton.setEnabled(false);
        }

        return;
    }



    // **********


    /**
     * @return Date
     */
    public java.sql.Date getAggregatedDate() {
        return this.aggregatedDate;
    }


//    /**
//     * @return
//     */
//    public void setAggregatedDate(int dayIndex) {
//
//        this.nextDay = this.datePart.getIndexedDay(dayIndex);
//
//        System.out.println("day ++" + this.nextDay);
//
//        this.formatedDate = this.dateFormat.format(this.nextDay);
//
//        this.dateButton = new JButton(this.formatedDate);
//
//        this.dateButton.setPreferredSize(new Dimension(120, 100));
//
//        super.add(this.dateButton);
//
//        return;
//    }

    /**
     * définit une date agrégée (avec le formulaire - Jour, Mois, Année dans des champs séparés)
     * @param yearSelect
     * @param MonthSelect
     * @param DaySelect
     * @return void
     */
    public void setAggregatedDate(DatePart yearSelect, DatePart MonthSelect, DatePart DaySelect) {
        // TODO implement here
        return;
    }

    /**
     * @return DatePart
     */
    public DatePart getYearSelect() {
        return this.yearSelect;
    }

    /**
     * @param yearSelect
     * @return void
     */
    public void setYearSelect(DatePart yearSelect) {
        // TODO implement here
        return;
    }

    /**
     * @return DatePart
     */
    public DatePart getMonthSelect() {
        return this.monthSelect;
    }

    /**
     * @param monthSelect
     * @return void
     */
    public void setMonthSelect(DatePart monthSelect) {
        // TODO implement here
        return;
    }

    /**
     * @return DatePart
     */
    public DatePart getDaySelect() {
        return this.daySelect;
    }


    /**
     * @param daySelect
     * @return void
     */
    public void setDaySelect(DatePart daySelect) {
        this.daySelect = daySelect;
        return;
    }



    /**
     * @return Calendar
     */
    public Calendar getNewCalendar() {
        return this.newCalendar;
    }

    /**
     * @param newCalendar
     * @return void
     */
    public void setNewCalendar(Calendar newCalendar) {
        this.newCalendar = newCalendar;
        return;
    }



    /**
     * @return String
     */
    public String getActivityDescription() {
        // TODO implement here
        return this.activityDescription;
    }

    /**
     * @param activityDescription
     * @return void
     */
    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
        return;
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
        return;
    }

    /**
     * @return ActivityColor
     */
    public ActivityColor getActivityColor() {
        // TODO implement here
        return null;
    }

    /**
     * @param activityColor
     * @return void
     */
    public void setActivityColor(ActivityColor activityColor) {
        // TODO implement here
        return;
    }

    /**
     * @return void
     */
    public void displayActivity() {
        // TODO implement here
        return;
    }


    @Override
    /**
     * @return void
     */
    public void displayDateButton() {
        // TODO implement here
        return;
    }

}