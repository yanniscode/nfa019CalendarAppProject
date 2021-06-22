package fr.cnam.pbuttons;

import fr.cnam.pactivity.ActivityFormPanel;
//import fr.cnam.pactivity.ActivityMainFormPanel;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.pcalendarpanel.DateButton;
import fr.cnam.penums.ControlAction;
import fr.cnam.penums.FormControlAction;
import fr.cnam.pmain.MainPanel;
import fr.cnam.putils.MonthPageIncrement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.*;


/**
 * @author Yannis Guéguen
 */
public class ControlButton extends JPanel implements ActionListener {


    /**
     *  constructor 2: utilisé par ControlButtonsPanel pour le changement de mois (<, >)
     */
    public ControlButton(String controlBtnValue, MainPanel mainPanel) {

        super();

        this.activityForm = new ActivityFormPanel();
//        this.activityMainFormPanel = new ActivityMainFormPanel(); // si ici, une seule instance créée

//        mainPanel = RunCalendarApp.getMainPanel();
//        System.out.println(RunCalendarApp.mainPanel);

        // ****** pour changer de mois (incrémentation de l'index de base (ControlButtonPanel) à chaque clic sur un des deux boutons
        System.out.println(monthIndex);
        //  System.out.println("CONSTRUCTEUR INDEX MONTH "+ this.monthIndex);

        this.mainPanel = mainPanel;
        System.out.println(this.mainPanel);
        System.out.println("################################## "+this.mainPanel.getCalendarPanel());

        this.controlButton = new JButton(controlBtnValue);
        this.controlButton.setPreferredSize(new Dimension(120, 60));

        this.controlButton.addActionListener(this);
//        this.controlBtnValue = controlBtnValue;
        this.add(this.controlButton);

    }

    /**
     * constructor 1: (A FAIRE) utilisé par ControlButton 'EnterActivity' ??
     */
    public ControlButton(String controlBtnValue) {

        super();

//        this.activityMainFormPanel = new ActivityMainFormPanel(); // si ici, une seule instance créée

        this.controlButton = new JButton(controlBtnValue);
        this.controlButton.setPreferredSize(new Dimension(120, 60));

//        this.controlBtnValue = controlBtnValue;

        this.controlButton.addActionListener(this);

        this.add(this.controlButton);
    }


    // ajouts:

    /**
     * Connection - variable de connexion à MySql
     */
    private Connection connection;


    private static ActivityFormPanel activityForm =  new ActivityFormPanel();

    /**
     * ActivityMainFormPanel - note: initialisé en dehors du constructeur
     */
//    private static ActivityMainFormPanel activityMainFormPanel =  new ActivityMainFormPanel();

    /**
     * MainPanel - mainPanel en param (à revoir si MainPanel = static -> nécessaire ??)
     */
    private static MainPanel mainPanel;

    /**
     * String - valeur du bouton activé
     */
    private String activedButton;


    /**
     * Date - nouveau mois de référence
     */
    private static Date newMonthRef;

    /**
     * Calendar - nouveau calendrier
     */
    private Calendar newCalendar;

    /**
     * int (static) - index du mois (varie selon les boutons directionnels)
     */
    private static int monthIndex; // *** index 'static' - 1 = mois actuel

    /**
     * Date - nouveau jour de référence (utilisé pour rendre inactif les boutons d'une page ne correspondant pas au mois
     */
    private static Date newReferenceDay;



    // ********************

    /**
     * @param ev - méthode de déclenchement des évènements liés aux ControlButtons
     */
    public void actionPerformed(ActionEvent ev)
    {
        String formControlAction = FormControlAction.VALIDATION;

        System.out.println("ev ############################### "+ ev);
        this.activedButton = ev.getActionCommand();

        System.out.println(this.mainPanel);

//        CalendarPanel calendarPanel = this.mainPanel.getCalendarPanel();

        if(this.activedButton.equals(ControlAction.LAST_MONTH)) {

            System.out.println("Click mois dernier Activité");

            this.setLastMonthTitle();

            try {
                this.setLastMonthControl();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        else if(this.activedButton.equals(ControlAction.ADD_ACTIVITY)) {

            System.out.println("Click Nouvelle Activité");

            try {
                this.enterActivityMainFormPanel();
            }
            catch(Exception e) {
                e.printStackTrace();
            }

        }
        else if(this.activedButton.equals(ControlAction.NEXT_MONTH)) {

            System.out.println("Click mois suivant");

//            System.out.println(">");
//            System.out.println("++ MONTH INDEX: "+ this.monthIndex);

            this.setNextMonthTitle();

            try {
                this.setNextMonthControl();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else if(this.activedButton.equals(FormControlAction.VALIDATION)) {
            System.out.println(FormControlAction.VALIDATION);
        }

        return;
    }


    /**
     * MonthPageIncrement - renvoie un int (static) pour incrémenter ou décrémenter le mois affiché
     */
    private static MonthPageIncrement monthPageIncrement = new MonthPageIncrement();


    /**
     * int
     */
    private static int indexMonth;


    // *********************


    /**
     *
     */
    boolean activityFormOpened = false;

    public boolean getActivityFormOpened() {
        return this.activityFormOpened;
    }
    public void setActivityFormOpened(boolean activityFormOpened) {
        this.activityFormOpened = activityFormOpened;
        return;
    }

    public void enterActivityMainFormPanel() {

//            this.activityMainFormPanel.getActivityForm().setDayAsDate(new java.sql.Date(System.currentTimeMillis()));

//            ActivityFormPanel activityFormPanel;
//            this.activityMainFormPanel = new ActivityMainFormPanel(); // si ici, nouvelle instance crée à chaque fois

        // *** si une fenêtre 'activityFormPanel' est déjà visible, on ne peut en créer une nouvelle (la première est initialisée dans le constructeur)

        System.out.println(this.activityForm);

//        if(this.activityFormOpened == false) {
//        if(this.activityMainFormPanel == null) {

//        this.activityMainFormPanel = new ActivityMainFormPanel(); // si ici, une seule instance créée
//        System.out.println(this.activityMainFormPanel.getComponents().length);

//            if(!this.activityMainFormPanel.getActivityFormFrame().isShowing()) {


                System.out.println("DATE TEXT FIELD: " + this.activityForm.getDateTextField().getText());
                this.activityForm.initFormFields();

//                System.out.println(this.activityMainFormPanel.getActivityFormFrame());
                this.activityForm.setVisible(true);

//            System.out.println(this.activityMainFormPanel.getActivityFormFrame().isShowing());
//            System.out.println(this.activityMainFormPanel.getActivityFormFrame().isVisible());

//            }

//        }
//        else {
//            System.out.println("erreur: fenêtre déjà ouverte..."+ this.activityFormOpened);
//        }

//        this.activityFormOpened = true;

    }


    /**
     * applique l'intitulé du mois suivant
     */
    public void setNextMonthTitle() {

        System.out.println("################################## "+this.mainPanel.getCalendarPanel());
        this.mainPanel.getCalendarPanel().removeAllDaysFromCalendarPanel();
        this.mainPanel.getCalendarPanel().removeAllFromDaysList();
//        CalendarPanel calendarPanel = this.mainPanel.getCalendarPanel();
//        this.mainPanel.getCalendarPanel().setVisible(false);  // NÉCESSAIRE ??
//        this.mainPanel.remove(this.mainPanel.getCalendarPanel()); // LE CALENDARPANEL EST ENLEVÉ MAIS L'OBJET NON SUPPRIMÉ !

        DatePart newDatePart;
        newDatePart = new DatePart();

//        System.out.println(this.monthIndex);
//        System.out.println(">");
        this.monthPageIncrement.pushIncrementValue(1);

        this.indexMonth = this.monthPageIncrement.getIncrementValue();

//        monthIndex += 1;
//        System.out.println(this.monthIndex);


        // *** ON RETROUVE LE JOUR DE RÉFÉRENCE DU MOIS PRÉCÉDENT: (UN MOIS AVANT DATE ACTUELLE)
        this.newReferenceDay = newDatePart.getOneMonthInterval(this.indexMonth);
//        System.out.println("NWRefDAY: "+ newFirstMonday);

        // ******** Ajout  du titre du mois précédent au CalendarPanel (string):
        this.mainPanel.getCalendarPanel().setNewMonthLabel(this.newReferenceDay);

        this.mainPanel.add(this.mainPanel.getCalendarPanel());

        return;
    }


    /**
     * applique les DateButtons du mois suivant
     */
    public void setNextMonthControl() throws SQLException, ClassNotFoundException {

        DatePart newDatePart = new DatePart();

        Date newFirstDay;

        ArrayList<DateButton> newDatesList= new ArrayList<DateButton>();

        this.connection = this.mainPanel.getCalendarPanel().getConnection();


        for(int i = 0; i < 41; i++) {

            // *** Recherche du premier lundi affiché dans une page de CalendarPanel:
//            newFirstDay = (Date) newDatePart.getByFirstMondayOfMonthPage(this.indexMonth, i);
//            newDatePart.setDateValue(newFirstDay);

            DateButton newDateButton = new DateButton(this.indexMonth, i, this.connection);

            // *** méthode pour griser les jours qui ne sont pas du mois:
//            newDateButton.setButtonToGray(newDatePart, this.indexMonth);

            newDatesList.add(newDateButton);

        }


        this.mainPanel.getCalendarPanel().buildDaysList(newDatesList);    // création de la liste de boutons avec les dates du mois actuel

        // *** update des boutons ayant une activité déjà enregistré avant l'affichage de la page   // PAS RÉUSSI ENCORE
        this.mainPanel.getCalendarPanel().buildActivitiesList(newDatesList, this.indexMonth);

//        this.mainPanel.getCalendarPanel().setVisible(true); // NÉCESSAIRE

        this.mainPanel.add(this.mainPanel.getCalendarPanel());

        return;
    }


    /**
     * applique l'intitulé du mois dernier
     */
    public void setLastMonthTitle() {

        this.mainPanel.getCalendarPanel().removeAllDaysFromCalendarPanel();
        this.mainPanel.getCalendarPanel().removeAllFromDaysList();

//        this.mainPanel.getCalendarPanel().setVisible(false);  // NÉCESSAIRE ??
//        this.mainPanel.remove(this.mainPanel.getCalendarPanel()); // LE CALENDARPANEL EST ENLEVÉ MAIS L'OBJET NON SUPPRIMÉ !

        DatePart newDatePart;
        newDatePart= new DatePart();

        this.monthPageIncrement.pushIncrementValue(-1);

        this.indexMonth = this.monthPageIncrement.getIncrementValue();


//        this.monthIndex -= 1;
//        System.out.println(this.monthIndex);

        // *** ON RETROUVE UN JOUR DE RÉFÉRENCE DU MOIS PRÉCÉDENT: (UN MOIS AVANT AUJOURD'HUI)
        this.newReferenceDay = newDatePart.getOneMonthInterval(this.indexMonth);

        // ******** AJOUT DU MOIS AU CALENDAR PANEL (STRING)
        this.mainPanel.getCalendarPanel().setNewMonthLabel(this.newReferenceDay);

        this.mainPanel.add(this.mainPanel.getCalendarPanel());

        return;
    }


    /**
     * applique les DateButtons du mois dernier
     */
//        public void setLastMonthControl() throws InterruptedException {
    public void setLastMonthControl() throws SQLException, ClassNotFoundException {

        DatePart newDatePart = new DatePart();

        Date newFirstDay;

        ArrayList<DateButton> newDatesList= new ArrayList<DateButton>();

        this.connection = this.mainPanel.getCalendarPanel().getConnection();
        for(int i = 0; i < 41; i++) {

//            newFirstDay = newDatePart.getByFirstMondayOfMonthPage(this.indexMonth, i);
//            System.out.println("newFirstDay ########################## "+ newFirstDay);
//            newDatePart.setDateValue(newFirstDay);

//            System.out.println("i = "+ i);
//            System.out.println("newDatePart = "+ newDatePart.getDateValue());
//            System.out.println(this.connection);

            DateButton newDateButton = new DateButton(this.indexMonth, i, this.connection);

            // *** méthode pour griser les jours qui ne sont pas du mois:
//            newDateButton.setButtonToGray(newDatePart, this.indexMonth);

            newDatesList.add(newDateButton);

        }

        System.out.println(" *********** LAST MONTH CONTROL ******************************* \n");

        // *** Création de la liste de boutons avec les dates du mois actuel:
        this.mainPanel.getCalendarPanel().buildDaysList(newDatesList);

        // *** update des boutons ayant une activité déjà enregistré avant l'affichage de la page   // PAS RÉUSSI ENCORE
        this.mainPanel.getCalendarPanel().buildActivitiesList(newDatesList, this.indexMonth);

//        this.mainPanel.getCalendarPanel().setVisible(true); // NÉCESSAIRE

        this.mainPanel.add(this.mainPanel.getCalendarPanel());

        return;
    }



// *******************************



    /**
     * JButton - bouton de Contrôle (<, Enter, >)
     */
    private JButton controlButton;

    /**
     * String - Valeur du bouton
     */
    private String controlBtnValue;

    /**
     * ImageIcon - logo du bouton
     */
    public ImageIcon controlBtnIcon;



    /**
     * @return JButton - bouton déclenché
     */
    public JButton getControlButton() {
        return this.controlButton;
    }

    /**
     * @param controlButton
     * @return void
     */
    public void setControlButton(JButton controlButton) {
        this.controlButton = controlButton;
        return;
    }


    /**
     * @return String - valeur du bouton déclenché
     */
    public String getControlBtnValue() {
        return this.controlBtnValue;
    }

    /**
     * @param controlBtnValue
     * @return void
     */
    public void setControlBtnValue(String controlBtnValue) {
        this.controlBtnValue =controlBtnValue;
        return;
    }

}