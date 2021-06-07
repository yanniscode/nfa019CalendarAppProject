package fr.cnam.pactivity;

import jdk.swing.interop.SwingInterOpUtils;

import java.text.DateFormatSymbols;
import java.util.*;

import static java.util.Calendar.MONDAY;

/**
 * @author Yannis Guéguen
 */
public class DatePart {

    /**
     * Default constructor
     */
    public DatePart() {

//        this.today = new Date();
//        System.out.println(this.today);
//
//        this.cacheCalendar = Calendar.getInstance();  // pas ici sinon irrégularités !!!
//
//        this.cacheCalendar.setTime(this.today);

//        this.cal = Calendar.getInstance();  // date du jour instanciée
    }

    /**
     * 
     */
    private Date dateValue;

    // ajout:
//    public static Date getToday() {
//        Date today = new Date();
//
//        return today;
//    }


    // AJOUTS:

    private Calendar cal;

    private Calendar cacheCalendar;
//    private Calendar cacheCalendar = Calendar.getInstance();

    private Date today;
    private Date newDayRef;
    private Date newMonthRef;

    private Calendar newCalendarRef;

    // *** add indexes because of date reinitialisation at every methods call:
    private int incr = 1;

    private int monthIndex = 0;

    private void resetMonthIndex(){
        this.monthIndex = 0;
    }


//    private int daysIndex = 0;

//    public void resetDaysIndex(){
//        this.daysIndex = 0;
//    }

    public Date getIndexedDay(int dayIndex) {


        this.cacheCalendar = Calendar.getInstance();
//        this.cacheCalendar.set(Calendar.DAY_OF_MONTH, 1);
//        System.out.println("||||"+this.cacheCalendar.getTime());

        this.cacheCalendar.set(Calendar.DATE, dayIndex);   // si 1:
        System.out.println("||||"+this.cacheCalendar.getTime());

//        this.cacheCalendar.add(Calendar.DATE, daysIndex); // PREMIER JOUR DU MOIS (ex: 'Tue Jun 01...')
//        this.cacheCalendar.add(Calendar.MONTH, 0); // si mois ACTUEL

        System.out.println("daysIndex: "+ dayIndex);
        dayIndex += incr;

        this.newDayRef = this.cacheCalendar.getTime();

        return this.newDayRef;

//        return this.cacheCalendar.getTime();
    }

//    public Date getNextDay() {
//        daysIndex += incr;
//
//        this.cacheCalendar = Calendar.getInstance();
//        this.cacheCalendar.add(Calendar.DATE, daysIndex);
//
//        return this.cacheCalendar.getTime();
//    }


// ajout:
    public Date getFirstMondayOfNextMonthPage() {

        this.cacheCalendar = Calendar.getInstance();


        System.out.println("standardIncr ++ "+monthIndex);
        monthIndex += incr;

//        System.out.println(this.cacheCalendar.getTime());
//    public int getFirstMonday(int year, int month) {
//        System.out.println(Calendar.DAY_OF_WEEK);
//        System.out.println( MONDAY);

        System.out.println("standardIncr ++ "+monthIndex);

        this.cacheCalendar.add(Calendar.MONTH, monthIndex);   // PASSAGE AU MOIS SUIVANT : 1

//        cacheCalendar.set(Calendar.DAY_OF_WEEK, MONDAY);
        this.cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 0);
//        cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
//        cacheCalendar.set(Calendar.MONTH, month);
//        cacheCalendar.set(Calendar.YEAR, 2021);
//        cacheCalendar.set(Calendar.YEAR, year);

//        this.newCalendarRef = this.cacheCalendar;
//        System.out.println(this.newCalendarRef);

//        this.newCalendarRef.getTime();

//        this.cacheCalendar.setTime(this.newDateRef);


        System.out.println("standardIncr ++ "+monthIndex);

        this.newMonthRef = this.cacheCalendar.getTime();
        return  this.newMonthRef;
//        return this.newCalendarRef.getTime();
    }


    // TEST: PREMIER LUNDI DU MOIS (CF: https://stackoverflow.com/questions/23971439/get-the-first-monday-of-a-month)


    public Date getFirstMondayOfActualMonthPage() {

        this.cacheCalendar = Calendar.getInstance();


//        this.cacheCalendar = Calendar.getInstance();

//    public int getFirstMonday(int year, int month) {
//        System.out.println(Calendar.DAY_OF_WEEK);
//        System.out.println( MONDAY);
//        cacheCalendar.set(Calendar.MONTH, 1);   // PASSAGE AU MOIS SUIVANT

//        cacheCalendar.set(Calendar.DAY_OF_WEEK, MONDAY);
        this.cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 0);
//        cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
//        cacheCalendar.set(Calendar.MONTH, month);
//        cacheCalendar.set(Calendar.YEAR, 2021);
//        cacheCalendar.set(Calendar.YEAR, year);

//        this.newDateRef = this.cacheCalendar.getTime();
//        System.out.println(this.newDateRef);

//        this.cacheCalendar.setTime(this.newDateRef);


          this.newMonthRef = this.cacheCalendar.getTime();

          return  this.newMonthRef;
//        return this.cacheCalendar.getTime();
//        return this.newDateRef;
//        return cacheCalendar.get(Calendar.DATE);
    }

    public Date getFirstMondayOfLastMonthPage() {

        this.cacheCalendar = Calendar.getInstance();


        System.out.println("standardIncr -- "+monthIndex);
        monthIndex -= incr;
//        System.out.println("standardIncr -- "+standardIncr);


        System.out.println(this.cacheCalendar.getTime());

//    public int getFirstMonday(int year, int month) {
//        System.out.println(Calendar.DAY_OF_WEEK);
//        System.out.println( MONDAY);
        this.cacheCalendar.add(Calendar.MONTH, monthIndex);   // PASSAGE AU MOIS PRÉCÉDENT: -1

//        cacheCalendar.set(Calendar.DAY_OF_WEEK, MONDAY);
        this.cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 0);
//        cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
//        cacheCalendar.set(Calendar.MONTH, month);
//        cacheCalendar.set(Calendar.YEAR, 2021);
//        cacheCalendar.set(Calendar.YEAR, year);



//        this.newDateRef = this.cacheCalendar.getTime();
//        System.out.println(this.newDateRef);
//
//        this.cacheCalendar.setTime(this.newDateRef);


        System.out.println("standardIncr -- "+monthIndex);

        this.newMonthRef = this.cacheCalendar.getTime();

        return  this.newMonthRef;

//        return this.cacheCalendar.getTime();
//        return this.newDateRef;
    }



//    public Date getFirstDayOfMonth() {
//
//    //    public static Date getpremierJourMois(Date date) {
//
////        Date today = this.getToday(); // pas nécessaire, mais à voir...
//
//        Calendar cal = Calendar.getInstance();  // date du jour instanciée
////        cal.setTime(today);
//
//        cal.add(Calendar.MONTH, 0); // si mois ACTUEL
//
////        System.out.println(cal.getTime());
////        System.out.println(cal.getActualMinimum(Calendar.DAY_OF_WEEK_IN_MONTH));
//
//        System.out.println(cal.getFirstDayOfWeek());    // ex: 2 si un mardi, 1 si lundi
//
////        int decrementDay = 2 - cal.getFirstDayOfWeek();    // si lundi:
////        System.out.println(decrementDay);
//        cal.set(Calendar.DAY_OF_MONTH, 0); // *** ??? Renvoie le premier lundi du mois - EX: 31/05/2021 si c'est le lundi (1 = RÉFÉRENCE du premier jour du mois)
//
//        Date firstDayOfMonth = cal.getTime();
////        System.out.println(firstDayOfMonth);
//
//        return firstDayOfMonth;
//    }








    // PAS UTILE:
//    public Date getFirstMonday() {
//
//        Date firstMonday = null;
//        Date firstDayOfMonth = this.getFirstDayOfMonth();
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(firstDayOfMonth);  // marche pas avec: date.getTime() : erreur de passage de type 'long' -> 'date' ("The method setTime(Date) in the type Calendar is not applicable for the arguments (long)Java(67108979)")
//        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
//
//        cal.add(Calendar.DAY_OF_MONTH, 0);  // TEST: ajout d'un jour au premier jour
//        System.out.println("### ### "+ cal.getTime());
//
//        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
////        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
//
//        int dayNumberInWeek = cal.get(Calendar.DAY_OF_WEEK);
//
//        if(dayNumberInWeek == 2) {  // 1 = dimanche, lundi = 2
//            firstMonday = cal.getTime();
//            System.out.println("### ### "+ cal.getTime());
//            System.out.println("#### ok - this is monday !");
//        }
//        else {
//            for(int i = 0; i <= 6; i++){
//                cal.add(Calendar.DAY_OF_MONTH, 1);  // TEST: ajout d'un jour au premier jour
//                System.out.println("### "+ cal.getTime());
//                System.out.println("### "+ cal.get(Calendar.DAY_OF_WEEK));
//
//                dayNumberInWeek = cal.get(Calendar.DAY_OF_WEEK);
//
//                if(dayNumberInWeek == 2) {
//                    firstMonday = cal.getTime();
//                    System.out.println("### ### "+ cal.getTime());
//                    System.out.println("#### ok - this is monday !");
//                    break;
//                }
//            }
//        }

//        DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);


//        String[] joursSemaineFR = dfsFR.getWeekdays();
//
//        String firstMonday = "";
//
//        for (int i = 1; i < joursSemaineFR.length; i++) {
//
//            if(joursSemaineFR[i].equals("lundi")){
//                firstMonday = joursSemaineFR[i];
//                break;
//            }
//        }
//        System.out.println(firstMonday);

//        return firstMonday;
//    }

    public static StringBuffer getWeekDays() {

        DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);


        String[] joursSemaineFR = dfsFR.getWeekdays();

        StringBuffer joursListeFR = new StringBuffer("En-Tête - Jours FR ");

        for (int i = 1; i < joursSemaineFR.length; i++) {
            joursListeFR.append(" : ");
            joursListeFR.append(joursSemaineFR[i]);
        }
        System.out.println(joursListeFR);

        return joursListeFR;
    }


}