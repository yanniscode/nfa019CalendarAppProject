package fr.cnam.pcalendarpanel;

//import fr.cnam.pdatabase.managment.dao.model.DateActivityItem;
import fr.cnam.pdatabase.MysqlConnexion;
import fr.cnam.putils.ReformatDate;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;
//import java.util.*;


/**
 * @author Yannis Guéguen
 */
public class CalendarPanel extends JPanel implements CalendarPanelInterface {

    MysqlConnexion mysqlConnection;
    Connection connection;

    /**
     * Default constructor: création du calendrier (= liste de DateButtons)
     */
    public CalendarPanel() throws SQLException, ClassNotFoundException {

        super();

        MysqlConnexion mysqlConnection = new MysqlConnexion();
//        Class.forName("com.mysql.cj.jdbc.Driver");
        // *** ouverture de la connection:

        boolean connectResponse = mysqlConnection.connection();

        if(connectResponse == true) {

            System.out.println("connexion ok!");

            this.connection = mysqlConnection.getConnection();

//        this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NFA019_CALENDAR_APP?allowMultiQueries=true", "root", "test");
            System.out.println("***** CAL CONNECTION *************** : ");

            this.calendarLabel = new JLabel("", SwingConstants.CENTER);
            this.calendarLabel.setFont(new Font("Serif", 0, 25));
            this.setNewMonthLabel(new java.sql.Date(System.currentTimeMillis()));

            // *** création d'une liste de jours (mois actuel)
            this.daysList = new ArrayList<DateButton>();

            // *** création de la liste de boutons (avant affichage) avec les dates du mois actuel
            this.setNewDatesInList(this.daysList);

            // *** ajout de la liste de boutons à l'affichage avec les dates du mois actuel
            this.buildDaysList(this.daysList);

            // *** update des boutons ayant une activité déjà enregistré avant l'affichage de la page   // PAS RÉUSSI ENCORE
            this.buildActivitiesList(this.daysList, 0);

            GridLayout gl = new GridLayout(0, 7, 0, 0);   // cols définit en priorité à 7
            this.setLayout(gl);

            this.setSize(800, 300);

        } else {
            System.out.println("erreur de connexion...");
        }
    }


    /**
     * DateButton
     */
    private DateButton dateButton;


    /**
     * Date - nouveau mois (pour l'affichage en toutes lettres sur chaque page)
     */
    private Date newMonth;

    /**
     * Calendar - Calendrier
     */
    private Calendar calendar;

    /**
     * JLabel - titre du Calendrier (Container)
     */
    private JLabel calendarLabel;



    //     *************


    /**
     *
     * @return Date
     */
    public Date getNewMonth() {
        return newMonth;
    }

    /**
     *
     * @param newMonth
     */
    public void setNewDate(Date newMonth) {
        this.newMonth = newMonth;
    }

    /**
     * @return void
     */
    private Set<DateButton> yearList;

    /**
     * @return void
     */
    private Set<DateButton> monthList;

    /**
     * ArrayList<DateButton> - liste des boutons (item d'un jour)
     */
    private ArrayList<DateButton> daysList;



    // ************** AJOUTS:



    /**
     * Création des boutons = liste des jours (pas encore ajoutée au CalendarPanel)
     * @return ArrayList<DateButton>
     */
    public ArrayList<DateButton> setNewDatesInList(ArrayList<DateButton> daysList) throws SQLException, ClassNotFoundException {
        this.daysList = daysList;

        for(int i = 0; i < 41; i ++) {
            this.dateButton = new DateButton(i, this.connection);
            this.daysList.add(this.dateButton);
        }

        return this.daysList;
    }


    /**
     * Ajout des jours au CalendarPanel:
     * @return void
     */
    public void buildDaysList(ArrayList<DateButton> daysList) {

        this.daysList = daysList;

        for(int i = 0; i < 41; i ++) {

            this.dateButton = this.daysList.get(i);
            // *** ajout à l'affichage (au CalendarPanel)
            this.add(this.dateButton);
        }
//        System.out.println("eeeeeeeeeeeeeeeee       ddddddddddddddddddday dddddddddddddddddddddddddddddd "+ this.daysList.size());

        return;
    }

    /**
     * Ajout des jours au CalendarPanel:
     * @return void
     */
    public void buildActivitiesList(ArrayList<DateButton> daysList, int indexMonth) throws ClassNotFoundException, SQLException {

        //  ************************** GET DATE DAO
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NFA019_CALENDAR_APP?allowMultiQueries=true", "root", "test");
        System.out.println("***** CAL CONNECTION *************** : ");

        this.daysList = daysList;

        for(int i = 0; i < 41; i ++) {

            this.dateButton = this.daysList.get(i);
            System.out.println("this.datebutton #### "+ this.dateButton);
            JButton updateButton = this.dateButton.getActivityDatas(this.connection, indexMonth, i);
            // *** ajout à l'affichage (au CalendarPanel)
            this.dateButton.setDateButton(updateButton);

            this.add(this.dateButton);
        }
//        System.out.println("eeeeeeeeeeeeeeeee       ddddddddddddddddddday dddddddddddddddddddddddddddddd "+ this.daysList.size());

        return;
    }


    // ******** Ajout du titre du mois précédent au CalendarPanel (string):
    /**
     * @param newMonth
     */
    public void setNewMonthLabel(Date newMonth) {

        this.newMonth = newMonth;

        System.out.println("newMonth: setNewMonth() - "+ this.newMonth);

        ReformatDate reformatDate = new ReformatDate();

        String formatedDate = reformatDate.formatMonthToString(this.newMonth);
        System.out.println(formatedDate);
        System.out.println(formatedDate);
        //      this.calendarLabel = new JLabel(formatedDate, SwingConstants.CENTER);

        System.out.println(this.calendarLabel);

        this.calendarLabel.setText(formatedDate);


        this.calendarLabel.setFont(new Font("Serif", 0, 45));

        // create a line border with the specified color and width
        // CF: https://examples.javacodegeeks.com/desktop-java/swing/jlabel/create-jlabel-with-border/
//        Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
//        this.calendarLabel.setBorder(border);
//        System.out.println(calendarlabel.getHorizontalAlignment());

        super.add(this.calendarLabel);
        System.out.println(this.calendarLabel);

        return;
    }

    /**
     * @return void - retire les boutons du CalendarPanelde DateButtons
     */
    public void removeAllDaysFromCalendarPanel() {
        for(int i = 0; i < 41; i ++) {
            this.dateButton = this.daysList.get(i);
            this.remove(this.dateButton);
        }
        return;
    }

    /**
     * @return void - vide la liste des DateButtons
     */
    public void removeAllFromDaysList() {
        this.daysList.clear();
        System.out.println("Size : "+ this.daysList.size());
        return;
    }


//    public void addDayToList(DateButton dateItem) {
//        this.daysList.add(dateItem);
//
//        return;
//    }

    /**
     *
     * @return Connection
     */
    public Connection getConnection() {
        return this.connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
        return;
    }


    // ***********************


    /**
     * @return DateButton
     */
    public DateButton getDateButton() {
        return this.dateButton;
    }

    public void setDateButton(DateButton dateButton) {
        this.dateButton = dateButton;
        return;
    }

    /**
     * @return ArrayList<DateButton>
     */
    public ArrayList<DateButton> getDaysList() {
        return this.daysList;
    }

    /**
     * @param daysList
     * @return void
     */
    public void setDaysList(ArrayList<DateButton> daysList) {
        this.daysList = daysList;
        return;
    }

    /**
     * @return JLabel
     */
    public JLabel getCalendarLabel() {
        return this.calendarLabel;
    }

    /**
     * @param calendarLabel
     * @return void
     */
    public void setCalendarLabel(JLabel calendarLabel) {
        this.calendarLabel = calendarLabel;
        return;
    }

//    /**
//     *
//     * @return ArrayList<DateButton>
//     */
//    public ArrayList<DateButton> getLastMonth() {
//        // TODO implement here
//        return null;
//    }

//    /**
//     * @return
//     */
//    public Set<DateButton> getNextMonth() {
//        // TODO implement here
//        return null;
//    }




//    /**
//     * @param controlBtn
//     * @return
//     */
//    public void setDaysList(ControlButton controlBtn) {
//        // TODO implement here
//        return;
//    }

    @Override
    /**
     * @return
     */
    public void displayCalendar() {
        System.out.println(this);
        return;
    }

}