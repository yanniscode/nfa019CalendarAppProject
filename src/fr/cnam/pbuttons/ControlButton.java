package fr.cnam.pbuttons;

//import fr.cnam.pactivity.DateActivityItem;
import fr.cnam.pactivity.DatePart;
import fr.cnam.pcalendarapp.RunCalendarApp;
import fr.cnam.pcalendarpanel.CalendarPanel;
import fr.cnam.pcalendarpanel.DateButton;
import fr.cnam.pmain.MainPanel;
//import fr.cnam.putils.IncrementClass;
import fr.cnam.putils.ReformatDate;
import org.joda.time.DateTime;  // import manuel : localisation sur ordi: bureau/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.*;
import java.util.spi.CalendarNameProvider;


/**
 * @author Yannis Guéguen
 */
public class ControlButton extends JPanel implements ActionListener {

    /**
     * MainPanel - mainPanel en param (à revoir si MainPanel = static -> nécessaire ??)
     */
    private static MainPanel mainPanel;


    /**
     *  constructor 2: utilisé par ControlButtons de changement de mois (<, >)
     */
//    public ControlButton(String controlBtnValue, int incrementIndex) {
    public ControlButton(String controlBtnValue, MainPanel mainPanel, int incrementIndex) {

        super();

//        mainPanel = RunCalendarApp.getMainPanel();
//        System.out.println(RunCalendarApp.mainPanel);

        // ****** pour changer de mois (incrémentation de l'index de base (ControlButtonPanel) à chaque clic sur un des deux boutons
        System.out.println(this.monthIndex);
        //  System.out.println("CONSTRUCTEUR INDEX MONTH "+ this.monthIndex);

//        mainPanel = mainPanel;

        this.controlButton = new JButton(controlBtnValue);
//        this.controlBtnValue = controlBtnValue;
        this.add(this.controlButton);

        this.controlButton.addActionListener(this);
    }

    /**
     * Default constructor: utilisé par ControlButton 'EnterActivity'
     */
    public ControlButton(String controlBtnValue) {
        super();

        this.controlButton = new JButton(controlBtnValue);
//        this.controlBtnValue = controlBtnValue;
        this.add(this.controlButton);

        this.controlButton.addActionListener(this);
    }


    // ajouts:

    /**
     * String - valeur du bouton activé
     */
    private String activedButton;


    /**
     * Date - nouveau mois de référence
     */
    private Date newMonthRef;

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





    /**
     * @param ev - méthode de déclenchement des évènements liés aux ControlButtons
     */
    public void actionPerformed(ActionEvent ev)
    {
        this.activedButton = ev.getActionCommand();

        System.out.println(mainPanel);

        CalendarPanel calendarPanel = mainPanel.getCalendarPanel();

        if(this.activedButton.equals("<")) {

                this.setLastMonthTitle(calendarPanel);
                this.setLastMonthControl(calendarPanel);

        }
        else if(this.activedButton.equals("Nouvelle Activité")) {
            System.out.println("Nouvelle Activité");
        }
        else if(this.activedButton.equals(">")) {

//            System.out.println(">");
//            System.out.println("++ MONTH INDEX: "+ this.monthIndex);

            this.setNextMonthTitle(calendarPanel);
            this.setNextMonthControl(calendarPanel);
        }

    }


    /**
     * @param calendarPanel - applique l'intitulé du mois suivant
     */
    public static void setNextMonthTitle(CalendarPanel calendarPanel) {

        mainPanel.getCalendarPanel().removeAllFromDaysList();

//        CalendarPanel calendarPanel = this.mainPanel.getCalendarPanel();
        calendarPanel.setVisible(false);  // NÉCESSAIRE
        mainPanel.remove(calendarPanel); // LE CALENDARPANEL EST ENLEVÉ MAIS L'OBJET NON SUPPRIMÉ !

        DatePart newDatePart;
        newDatePart= new DatePart();

//        System.out.println(this.monthIndex);
//        System.out.println(">");
        monthIndex += 1;
//        System.out.println(this.monthIndex);


        // *** ON RETROUVE LE JOUR DE RÉFÉRENCE DU MOIS PRÉCÉDENT: (UN MOIS AVANT DATE ACTUELLE)
        newReferenceDay = newDatePart.oneMonthInterval(monthIndex);
//        System.out.println("NWRefDAY: "+ newFirstMonday);

        // ******** Ajout  du titre du mois précédent au CalendarPanel (string):
        calendarPanel.setNewMonthLabel(newReferenceDay);

        mainPanel.add(calendarPanel);

        return;
    }


    /**
     * @param calendarPanel - applique les DateButtons du mois suivant
     */
    public void setNextMonthControl(CalendarPanel calendarPanel) {

        DatePart newDatePart = new DatePart();

        Date newFirstDay;

        ArrayList<DateButton> newDatesList= new ArrayList<DateButton>();


        for(int i = 0; i < 41; i++) {

            // *** Recherche du premier lundi affiché dans une page de CalendarPanel:
            newFirstDay = newDatePart.getByFirstMondayOfMonthPage(monthIndex, i);

            DateButton newDateButton = new DateButton(newFirstDay);

            // *** méthode pour griser les jours qui ne sont pas du mois:
            newDateButton.setButtonToGray(newFirstDay, this.monthIndex);


            newDatesList.add(newDateButton);

        }


        this.mainPanel.getCalendarPanel().buildDaysList(newDatesList);    // création de la liste de boutons avec les dates du mois actuel

        calendarPanel.setVisible(true); // NÉCESSAIRE

        this.mainPanel.add(calendarPanel);

        return;
    }


    /**
     * @param calendarPanel - applique l'intitulé du mois dernier
     */
    public void setLastMonthTitle(CalendarPanel calendarPanel) {

        this.mainPanel.getCalendarPanel().removeAllFromDaysList();

        calendarPanel.setVisible(false);  // NÉCESSAIRE
        this.mainPanel.remove(calendarPanel); // LE CALENDARPANEL EST ENLEVÉ MAIS L'OBJET NON SUPPRIMÉ !

        DatePart newDatePart;
        newDatePart= new DatePart();

        this.monthIndex -= 1;
        System.out.println(this.monthIndex);

        // *** ON RETROUVE UN JOUR DE RÉFÉRENCE DU MOIS PRÉCÉDENT: (UN MOIS AVANT AUJOURD'HUI)
        this.newReferenceDay = newDatePart.oneMonthInterval(this.monthIndex);

        // ******** AJOUT DU MOIS AU CALENDAR PANEL (STRING)
        calendarPanel.setNewMonthLabel(this.newReferenceDay);

        this.mainPanel.add(calendarPanel);

        return;
    }


    /**
     * @param calendarPanel - applique les DateButtons du mois dernier
     */
//        public void setLastMonthControl() throws InterruptedException {
    public void setLastMonthControl(CalendarPanel calendarPanel) {

        DatePart newDatePart = new DatePart();

        Date newFirstDay;

        ArrayList<DateButton> newDatesList= new ArrayList<DateButton>();

        for(int i = 0; i < 41; i++) {

            newFirstDay = newDatePart.getByFirstMondayOfMonthPage(monthIndex, i);

            System.out.println("newFirstDay ########################## "+ newFirstDay);
            DateButton newDateButton = new DateButton(newFirstDay);

            // *** méthode pour griser les jours qui ne sont pas du mois:
            newDateButton.setButtonToGray(newFirstDay, monthIndex);

            newDatesList.add(newDateButton);

        }

        // *** Création de la liste de boutons avec les dates du mois actuel:
        this.mainPanel.getCalendarPanel().buildDaysList(newDatesList);

        calendarPanel.setVisible(true); // NÉCESSAIRE

        this.mainPanel.add(calendarPanel);

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
     * @return String - valeur du bouton déclenché
     */
    public String getControlBtnValue() {
        // TODO implement here
        return this.controlBtnValue;
    }

    /**
     * @param controlValue 
     * @return void
     */
    public void setControlBtnValue(String controlValue) {
        // TODO implement here
        return;
    }

}