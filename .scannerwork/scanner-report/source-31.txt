package fr.cnam.pcalendarpanel;

import fr.cnam.pactivity.ActivityFormFrame;
import fr.cnam.pbuttons.DateButton;
import fr.cnam.pdatabase.MysqlConnection;
import fr.cnam.putils.ReformatDate;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Yannis Guéguen
 */
public class CalendarPanel extends JPanel implements CalendarPanelInterface {


    /**
     * Default constructor: création du calendrier (= liste de DateButtons)
     */
    public CalendarPanel() throws SQLException, ClassNotFoundException {

        super();

        MysqlConnection mysqlConnection = new MysqlConnection();

        // *** ouverture de la connection:
        mysqlConnection.connection();

        this.connection = mysqlConnection.getConnection();
        this.calendarLabel = new JLabel("", SwingConstants.CENTER);
        this.calendarLabel.setFont(new Font(TEXTFONT, 0, 25));

        this.buildNewMonthLabel(new java.sql.Date(System.currentTimeMillis()));

        // *** création d'une liste de jours (mois actuel)
        this.daysList = new ArrayList<>();

        // *** création de la liste de boutons (avant affichage) avec les dates du mois actuel
        this.buildNewDatesInList(this.daysList);

        // *** ajout de la liste de boutons à l'affichage avec les dates du mois actuel
        this.buildDaysList(this.daysList);

        // *** update des boutons ayant une activité déjà enregistré avant l'affichage de la page   // Utile ici ??

        GridLayout gl = new GridLayout(0, 7, 0, 0);   // cols définit en priorité à 7
        this.setLayout(gl);

        this.setSize(800, 300);

    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(ActivityFormFrame.class.getSimpleName());

    /**
     * Connection - variable de connexion à MySql (indiquée 'transient' car variable non-sérializable)
     */
    private transient Connection connection;

    /**
     * DateButton
     */
    private DateButton dateButton;

    /**
     * JLabel - titre du Calendrier (Container)
     */
    private JLabel calendarLabel;

    /**
     * ArrayList<DateButton> - liste des boutons (item d'un jour)
     */
    private List<DateButton> daysList;

    /**
     * String (static final)
     */
    private static final String TEXTFONT = "Serif";


    /**
     * @return ArrayList<DateButton> - liste de boutons d'activités - jours
     */
    public List<DateButton> getNewDatesInList() {
        return this.daysList;
    }

    /**
     * @return void - Création des boutons = liste des boutons d'activités / jours (pas encore ajoutée au CalendarPanel)
     */
    public void buildNewDatesInList(List<DateButton> daysList) {

        this.daysList = daysList;

        for(int i = 0; i < 41; i ++) {
            this.dateButton = new DateButton(i, this.connection);
            this.daysList.add(this.dateButton);
        }

    }

    /**
     * Ajout des jours au CalendarPanel:
     * @return void
     */
    public void buildDaysList(List<DateButton> daysList) {

        this.daysList = daysList;

        for(int i = 0; i < 41; i ++) {

            this.dateButton = this.daysList.get(i);

            // *** ajout à l'affichage (au CalendarPanel)
            this.add(this.dateButton);
        }

    }

    /**
     * @return JLabel - intitulé du mois (en toutes lettres en en-tête de page)
     */
    public JLabel getNewMonthLabel() {
        return this.calendarLabel;
    }

    /**
     * @param newMonth
     * @return void - Ajout du titre du mois précédent au CalendarPanel (string)
     */
    public void buildNewMonthLabel(java.sql.Date newMonth) {

        ReformatDate reformatDate = new ReformatDate();

        String formatedDate = reformatDate.formatMonthToString(newMonth);

        this.calendarLabel.setText(formatedDate);
        this.calendarLabel.setFont(new Font(TEXTFONT, 0, 45));
        this.add(this.calendarLabel);
    }

    /**
     * @return void - retire les boutons du CalendarPanel de DateButtons
     */
    public void removeAllDaysFromCalendarPanel() {

        for(int i = 0; i < 41; i ++) {
            this.dateButton = this.daysList.get(i);
            this.remove(this.dateButton);
            this.validate();
        }

    }

    /**
     * @return void - vide la liste des DateButtons
     */
    public void removeAllFromDaysList() {
        this.daysList.clear();
    }

    /**
     *
     * @return Connection
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     *
     * @param connection
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return DateButton
     */
    public DateButton getDateButton() {
        return this.dateButton;
    }

    /**
     * @param dateButton
     * @return void
     */
    public void setDateButton(DateButton dateButton) {
        this.dateButton = dateButton;
    }

    /**
     * @return HashSet<DateButton>
     */
    public List<DateButton> getDaysList() {
        return this.daysList;
    }

    /**
     * @param daysList
     * @return void
     */
    public void setDaysList(List<DateButton> daysList) {
        this.daysList = daysList;
    }

    @Override
    /**
     * @return
     */
    public void displayCalendar() {
        this.logger.log(Level.INFO, () -> "info (displayCalendar): "+ this.calendarLabel +" - "+ this.daysList);
    }

}