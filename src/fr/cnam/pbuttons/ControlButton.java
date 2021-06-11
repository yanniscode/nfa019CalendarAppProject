package fr.cnam.pbuttons;

<<<<<<< HEAD
=======
//import fr.cnam.pactivity.DateActivityItem;
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
import fr.cnam.pactivity.DatePart;
import fr.cnam.pcalendarpanel.CalendarPanel;
import fr.cnam.pcalendarpanel.DateButton;
import fr.cnam.pmain.MainPanel;
<<<<<<< HEAD
import fr.cnam.putils.MonthPageIncrement;
import fr.cnam.putils.ReformatDate;
//import org.joda.time.DateTime;  // import manuel : localisation sur ordi: bureau/
=======
//import fr.cnam.putils.IncrementClass;
import fr.cnam.putils.ReformatDate;
import org.joda.time.DateTime;  // import manuel : localisation sur ordi: bureau/
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

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


<<<<<<< HEAD
    private MonthPageIncrement monthPageIncrement;
=======
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

    /**
     *  constructor 2: utilisé par ControlButtons de changement de mois (<, >)
     */
    public ControlButton(String controlBtnValue, MainPanel mainPanel, int incrementIndex) {

        super();

<<<<<<< HEAD
        monthPageIncrement = new MonthPageIncrement();

        // ****** pour changer de mois (incrémentation de l'index de base (ControlButtonPanel) à chaque clic sur un des deux boutons
        System.out.println(ControlButton.monthIndex);
        //  System.out.println("CONSTRUCTEUR INDEX MONTH "+ ControlButton.monthIndex);
=======
        // ****** pour changer de mois (incrémentation de l'index de base (ControlButtonPanel) à chaque clic sur un des deux boutons
        System.out.println(this.monthIndex);
        //  System.out.println("CONSTRUCTEUR INDEX MONTH "+ this.monthIndex);
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

        this.mainPanel = mainPanel;

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

<<<<<<< HEAD

    /**
     * int (static) - index du mois (varie selon les boutons directionnels)
     */
    private static int monthIndex; // *** index 'static' - 1 = mois actuel

=======
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
    /**
     * String - valeur du bouton activé
     */
    private String activedButton;

    /**
     * MainPanel - mainPanel en param (à revoir si MainPanel = static -> nécessaire ??)
     */
    private MainPanel mainPanel;

    /**
     * Date - nouveau mois de référence
     */
    private Date newMonthRef;

    /**
     * Calendar - nouveau calendrier
     */
    private Calendar newCalendar;

<<<<<<< HEAD
=======
    /**
     * int (static) - index du mois (varie selon les boutons directionnels)
     */
    private static int monthIndex; // *** index 'static' - 1 = mois actuel
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

    /**
     * Date - nouveau jour de référence (utilisé pour rendre inactif les boutons d'une page ne correspondant pas au mois
     */
    private Date newReferenceDay;





    /**
     * @param ev - méthode de déclenchement des évènements liés aux ControlButtons
     */
    public void actionPerformed(ActionEvent ev)
    {
        this.activedButton = ev.getActionCommand();

        CalendarPanel calendarPanel = this.mainPanel.getCalendarPanel();


        if(this.activedButton.equals("<")) {

                this.setLastMonthTitle(calendarPanel);
                this.setLastMonthControl(calendarPanel);

        }
        else if(this.activedButton.equals("Nouvelle Activité")) {
            System.out.println("Nouvelle Activité");
        }
        else if(this.activedButton.equals(">")) {

//            System.out.println(">");
<<<<<<< HEAD
//            System.out.println("++ MONTH INDEX: "+ ControlButton.monthIndex);
=======
//            System.out.println("++ MONTH INDEX: "+ this.monthIndex);
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

            this.setNextMonthTitle(calendarPanel);
            this.setNextMonthControl(calendarPanel);
        }

    }

<<<<<<< HEAD
//    public static int getStaticIncrementValue(int monthIncrement) {
//        monthIndex += monthIncrement;
//        return monthIndex;
//    }
=======
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

    /**
     * @param calendarPanel - applique l'intitulé du mois suivant
     */
    public void setNextMonthTitle(CalendarPanel calendarPanel) {

        this.mainPanel.getCalendarPanel().removeAllFromDaysList();

//        CalendarPanel calendarPanel = this.mainPanel.getCalendarPanel();
        calendarPanel.setVisible(false);  // NÉCESSAIRE
        this.mainPanel.remove(calendarPanel); // LE CALENDARPANEL EST ENLEVÉ MAIS L'OBJET NON SUPPRIMÉ !

        DatePart newDatePart;
        newDatePart= new DatePart();

<<<<<<< HEAD
//        System.out.println(ControlButton.monthIndex);
//        System.out.println(">");

        this.monthPageIncrement.setIncrementValue(1);
        this.newIncrement = this.monthPageIncrement.getIncrementValue();
//        int newIncrement = this.getStaticIncrementValue(1);
//        ControlButton.monthIndex += 1;
//        System.out.println(ControlButton.monthIndex);


        // *** ON RETROUVE LE JOUR DE RÉFÉRENCE DU MOIS PRÉCÉDENT: (UN MOIS AVANT DATE ACTUELLE)
        this.newReferenceDay = newDatePart.oneMonthInterval(this.newIncrement);
=======
//        System.out.println(this.monthIndex);
//        System.out.println(">");
        this.monthIndex += 1;
//        System.out.println(this.monthIndex);


        // *** ON RETROUVE LE JOUR DE RÉFÉRENCE DU MOIS PRÉCÉDENT: (UN MOIS AVANT DATE ACTUELLE)
        this.newReferenceDay = newDatePart.oneMonthInterval(this.monthIndex);
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
//        System.out.println("NWRefDAY: "+ newFirstMonday);

        // ******** Ajout  du titre du mois précédent au CalendarPanel (string):
        calendarPanel.setNewMonthLabel(this.newReferenceDay);

        this.mainPanel.add(calendarPanel);

        return;
    }

<<<<<<< HEAD



=======
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

    /**
     * @param calendarPanel - applique les DateButtons du mois suivant
     */
    public void setNextMonthControl(CalendarPanel calendarPanel) {

        DatePart newDatePart = new DatePart();

        Date newFirstDay;

        ArrayList<DateButton> newDatesList= new ArrayList<DateButton>();


        for(int i = 0; i < 41; i++) {

            // *** Recherche du premier lundi affiché dans une page de CalendarPanel:
<<<<<<< HEAD
            newFirstDay = newDatePart.getByFirstMondayOfMonthPage(this.newIncrement, i);
=======
            newFirstDay = newDatePart.getByFirstMondayOfMonthPage(monthIndex, i);
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

            DateButton newDateButton = new DateButton(newFirstDay);

            // *** méthode pour griser les jours qui ne sont pas du mois:
<<<<<<< HEAD
            newDateButton.setButtonToGray(newFirstDay, this.newIncrement);
=======
            newDateButton.setButtonToGray(newFirstDay, this.monthIndex);
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9


            newDatesList.add(newDateButton);

        }


        this.mainPanel.getCalendarPanel().buildDaysList(newDatesList);    // création de la liste de boutons avec les dates du mois actuel

        calendarPanel.setVisible(true); // NÉCESSAIRE

        this.mainPanel.add(calendarPanel);

        return;
    }

<<<<<<< HEAD
    private int newIncrement;
=======
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

    /**
     * @param calendarPanel - applique l'intitulé du mois dernier
     */
    public void setLastMonthTitle(CalendarPanel calendarPanel) {

        this.mainPanel.getCalendarPanel().removeAllFromDaysList();

        calendarPanel.setVisible(false);  // NÉCESSAIRE
        this.mainPanel.remove(calendarPanel); // LE CALENDARPANEL EST ENLEVÉ MAIS L'OBJET NON SUPPRIMÉ !

        DatePart newDatePart;
        newDatePart= new DatePart();

<<<<<<< HEAD
//        MonthPageIncrement monthPageIncrement = new MonthPageIncrement();
        this.monthPageIncrement.setIncrementValue(-1);
        this.newIncrement = this.monthPageIncrement.getIncrementValue();
//        ControlButton.monthIndex = this.staticDecrement(ControlButton.monthIndex);

//        ControlButton.monthIndex -= 1;
//        System.out.println(ControlButton.monthIndex);

        // *** ON RETROUVE UN JOUR DE RÉFÉRENCE DU MOIS PRÉCÉDENT: (UN MOIS AVANT AUJOURD'HUI)
        this.newReferenceDay = newDatePart.oneMonthInterval(this.newIncrement);
=======
        this.monthIndex -= 1;
        System.out.println(this.monthIndex);

        // *** ON RETROUVE UN JOUR DE RÉFÉRENCE DU MOIS PRÉCÉDENT: (UN MOIS AVANT AUJOURD'HUI)
        this.newReferenceDay = newDatePart.oneMonthInterval(this.monthIndex);
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

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

<<<<<<< HEAD
            newFirstDay = newDatePart.getByFirstMondayOfMonthPage(this.newIncrement, i);
=======
            newFirstDay = newDatePart.getByFirstMondayOfMonthPage(monthIndex, i);
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

            System.out.println("newFirstDay ########################## "+ newFirstDay);
            DateButton newDateButton = new DateButton(newFirstDay);

            // *** méthode pour griser les jours qui ne sont pas du mois:
<<<<<<< HEAD
            newDateButton.setButtonToGray(newFirstDay, this.newIncrement);
=======
            newDateButton.setButtonToGray(newFirstDay, monthIndex);
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

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
<<<<<<< HEAD
        return this.controlBtnValue;
=======
        return this.activedButton;
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
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