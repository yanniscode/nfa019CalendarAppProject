package fr.cnam.pcalendarpanel;

import fr.cnam.pactivity.DateActivityItem;
import fr.cnam.pbuttons.ControlButton;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Yannis Guéguen
 */
public class CalendarPanel extends JPanel implements CalendarPanelInterface {

    /**
     * Default constructor
     */
    public CalendarPanel() {

        super();

//        System.out.println("test calendar panel");

        // pour obtenir une date type mois: 'Juin' (String à partir de Date)
        Date newDateTest = new Date();
        System.out.println(newDateTest);

        DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);


        DateFormat dateFormat = new SimpleDateFormat("MMM", dfsFR);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", dfsFR);
        String formatedDate = dateFormat.format(newDateTest);

        JLabel calendarlabel = new JLabel(formatedDate, SwingConstants.CENTER);
        calendarlabel.setFont(new Font("Serif", 0, 25));
//        System.out.println(calendarlabel.getHorizontalAlignment());
        add(calendarlabel);


//        JFrame calendarFrame = new JFrame();
//        Container calendarContainer = new CalendarPanel();

        GridLayout gl = new GridLayout(0, 7, 10, 10);   // cols définit en priorité à 7
        setLayout(gl);

//        for(int i = 1; i < 35; i ++) {
//            System.out.println("i: "+ i);
//            nextDay = datePart.getIndexedDay();
//            System.out.println("day ++"+ nextDay);
//
//            formatedDate = dateFormat.format(nextDay);
//
//            dateItemButton = new JButton(formatedDate);
//
//            super.add(dateItemButton);
//            dateItemButton.setPreferredSize(new Dimension(120,100));
//        }

          DateActivityItem newDateActivityItem;
        for(int i = 0; i < 35; i++) {

//           super.add(new JButton());
            newDateActivityItem = new DateActivityItem();

            newDateActivityItem.setAggregatedDate(i);

            super.add(newDateActivityItem);
        }
//            JButton b2 = new JButton();
//            JButton b3 = new JButton();
//
//            JButton b4 = new JButton();
//            JButton b5 = new JButton();
//            JButton b6 = new JButton();
//            JButton b7 = new JButton();
//            JButton b8 = new JButton();
//    //        JButton b9 = new JButton();


//            super.add(b1);
//            super.add(b2);
//            super. add(b3);
//            super.add(b4);
//            super.add(b5);
//            super.add(b6);
//            super.add(b7);
//            super.add(b8);

        super.setSize(800, 400);


//        calendarContainer.add(b9);

//        calendarContainer.add(calendarFrame);
    }

    /**
     * 
     */
    private Set<DateActivityItem> yearList;

    /**
     * 
     */
    private Set<DateActivityItem> monthList;

    /**
     * 
     */
    private Set<DateActivityItem> daysList;



    /**
     * @return
     */
    public Set<DateActivityItem> getLastMonth() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<DateActivityItem> getNextMonth() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<DateActivityItem> getDaysList() {
        // TODO implement here
        return null;
    }

    /**
     * @param controlBtn 
     * @return
     */
    public void setDaysList(ControlButton controlBtn) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void displayCalendar() {
        // TODO implement here
        return;
    }

}