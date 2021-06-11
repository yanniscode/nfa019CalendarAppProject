package fr.cnam.pcalendarpanel;

import fr.cnam.pactivity.DateActivityItem;
import fr.cnam.pactivity.DatePart;
import fr.cnam.pbuttons.ControlButton;
import fr.cnam.putils.ReformatDate;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.logging.Logger;


/**
 * @author Yannis Guéguen
 */
public class CalendarPanel extends JPanel implements CalendarPanelInterface {


    /**
     * Default constructor: création du calendrier (= liste de DateButtons)
     */
    public CalendarPanel() {

        super();

        this.calendarLabel = new JLabel("", SwingConstants.CENTER);
        this.calendarLabel.setFont(new Font("Serif", 0, 25));
        this.setNewMonthLabel(new Date());

        // *** création d'une liste de jours (mois actuel)
        this.daysList = this.setNewDaysList();
        this.buildDaysList(this.daysList);    // *** création de la liste de boutons avec les dates du mois actuel

//        this.setDaysList(this.daysList);


        GridLayout gl = new GridLayout(0, 7, 0, 0);   // cols définit en priorité à 7
        setLayout(gl);

//        DateActivityItem newDateActivityItem;

//        this.daysList = new ArrayList<DateActivityItem>();

//        this.setDaysList();    // création de la liste de boutons avec les dates du mois actuel

        super.setSize(800, 300);


    }


    /**
     * Date - nouveau mois
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


    /**
     * @return ArrayList<DateButton>
     */
    public ArrayList<DateButton> getDatsList() {
        return this.daysList;
    }


    /**
     * Création des boutons = liste des jours (pas encore ajoutée au CalendarPanel)
     *
     */
    public ArrayList<DateButton> setNewDaysList() {
        this.daysList = new ArrayList<DateButton>();

        for(int i = 0; i < 41; i ++) {
            DateButton newDateButton = new DateButton(i);
            this.daysList.add(newDateButton);
        }

        return this.daysList;
    }




    // ******** Ajout du titre du mois précédent au CalendarPanel (string):

    /**
     *
     * @param newMonth
     */
    public void setNewMonthLabel(Date newMonth) {

        if(this.calendarLabel != null) {
            this.calendarLabel.setText("");
        }

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


    /**
     * @return void - vide la liste de DateButtons
     */
    public void removeAllFromDaysList() {

        for(int i = 0; i < 41; i ++) {
            DateButton newDateButton = this.daysList.get(i);
                remove(newDateButton);
        }

        return;
    }


//    public void addDayToList(DateButton dateItem) {
//        this.daysList.add(dateItem);
//
//        return;
//    }



    /**
     * @return ArrayList<DateButton>
     */
    public ArrayList<DateButton> getDaysList() {

        return this.daysList;

    }



    /**
     * Ajout des jours au CalendarPanel:
     * @return void
     */
    public void buildDaysList(ArrayList<DateButton> daysList) {

        this.daysList = daysList;
        Iterator iter = this.daysList.iterator();

        for(int i = 0; i < 41; i ++) {

            DateButton newDateButton = this.daysList.get(i);
            add(newDateButton);
        }
//        System.out.println("eeeeeeeeeeeeeeeee       ddddddddddddddddddday dddddddddddddddddddddddddddddd "+ this.daysList.size());


        return;
    }


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
        // TODO implement here
        return;
    }

}