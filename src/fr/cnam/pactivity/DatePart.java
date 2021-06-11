package fr.cnam.pactivity;

import java.text.DateFormatSymbols;
import java.util.*;

/**
 * @author Yannis Guéguen
 */
public class DatePart {

    /**
     * Default constructor
     */
    public DatePart() {
        this.cacheCalendar = Calendar.getInstance();
    }



    // AJOUTS:

    /**
     * Calendar - nouvelle instance du calendrier
     */
    private Calendar newCalendar;



    /**
     * Date - valeur de la date (représentée par la classe DatePart) - actuellement, date = non découpée mais devrait être, au choix: le jour, le mois ou l'année
     */
    private Date dateValue;

    /**
     * Calendar
     */
    private Calendar cacheCalendar;

    /**
     * Date - nouveau mois de référence
     */
    private Date newMonthRef;

    /**
     * int - Ajout d'un index à cause de sa réinitialisation à chaque appel de méthode
     */
    private int incr = 1;

    /**
     * int - index du mois en cours - 0 = mois actuel
     */
    private int monthIndex = 0;


    /**
     *
     * @param dayIndex
     * @param newCalendar
     * @return Date - Pour la ré-init du Calendar: renvoie le jour selon le mois choisi et l'index passé avec pour référence 0 le Lundi (pour création de la liste de jours)
     */
    public Date getIndexedDay(int dayIndex, Calendar newCalendar) {

        this.cacheCalendar = newCalendar;
//        System.out.println(this.cacheCalendar.getTime());
//        System.out.println("i i i i î "+ dayIndex);

        this.cacheCalendar.set(cacheCalendar.get(Calendar.MONDAY), dayIndex);   // SI 0, pas de modif de place de MONDAY, SI -1, MONDAY DEVIENT SUNDAY - 31 MAY OK!!!!

//        this.cacheCalendar.add(Calendar.DATE, daysIndex); // PREMIER JOUR DU MOIS (ex: 'Tue Jun 01...')
//        this.cacheCalendar.add(Calendar.MONTH, 0); // si mois ACTUEL

        this.dateValue = this.cacheCalendar.getTime();

        return this.dateValue;
    }

<<<<<<< HEAD


=======


>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
    /**
     *
     * @param dayIndex
     * @return Date - Pour l'init du Calendar: renvoie le jour selon le mois actuel et l'index passé avec pour référence 0 le Lundi (pour création de la liste de jours)
     */
    public Date getIndexedDay(int dayIndex) {

//        System.out.println("i i i i î "+ dayIndex);
        this.cacheCalendar.set(this.cacheCalendar.get(Calendar.MONDAY), dayIndex);   // SI 0, pas de modif de place de MONDAY, SI -1, MONDAY DEVIENT SUNDAY - 31 MAY OK!!!!

//        this.cacheCalendar.add(Calendar.DATE, daysIndex); // PREMIER JOUR DU MOIS (ex: 'Tue Jun 01...')
//        this.cacheCalendar.add(Calendar.MONTH, 0); // si mois ACTUEL

        this.dateValue = this.cacheCalendar.getTime();
        System.out.println("## ## |||| : "+this.dateValue);

        return this.dateValue;
    }




    // *** Recherche du premier lundi affiché dans une page de CalendarPanel:

    /**
     * @link - https://coderanch.com/t/382459/java/day-week-month -> MERCI !
     * @param idMonth
     * @param idDayAdd
     * @return Date - algorithme pour retrouver le premier lundi d'une page d'un mois (peut être le dernier lundi du mois précédent !)
     */
    public Date getByFirstMondayOfMonthPage(int idMonth, int idDayAdd) {

        Calendar mainCalendar = Calendar.getInstance();

        // ***pour modifier le mois:
        mainCalendar.add(Calendar.MONTH, idMonth);

        // *** initialisation des dates = séparée, car Calendrier Gregorien utilisé...
        int iMonth = mainCalendar.get(Calendar.MONTH);
        int iYear = mainCalendar.get(Calendar.YEAR);

        // *** Samedi = ref, sinon, décalage non souhaité des jours - ex: le lundi devient le dimanche
        int iFirstDayOfWeek = Calendar.SATURDAY;

        // définit l'index premier jour de la première semaine:
        int indexDay = 1;

        // *** Définit le lundi comme premier jour de semaine:
        Calendar cacheCalendar = new GregorianCalendar(iYear,iMonth,7);

        cacheCalendar.setFirstDayOfWeek(iFirstDayOfWeek);

        // ** un mois avant = 0
        cacheCalendar.add(Calendar.MONTH, 0);

        // *** jour actuel en 'int':
        int iCurrentDay = cacheCalendar.get(Calendar.DAY_OF_WEEK);
//        System.out.println(iCurrentDay);

        // *** retrait d'un jour à la position actuelle: ?? pour calculer: indexDay - absolue(offset)
        int offset = iCurrentDay - 1;

        if(iCurrentDay < Calendar.MONDAY) {
            // *** si le jour actuel (int) est avant lundi (dimanche = 1...)
            offset = iCurrentDay - 8;
        }

        // *** sinon, si le jour actuel (int) est égal ou après lundi...
        indexDay = indexDay - Math.abs(offset);
//        System.out.println(indexDay);

        // *** positionne le jour du mois:
        if(cacheCalendar.getFirstDayOfWeek() == Calendar.MONDAY) {
            indexDay = indexDay + 1;
        }

        cacheCalendar.set(Calendar.DATE , indexDay);
        // *** si 0, pas de modif de la place de MONDAY, SI -1, MONDAY DEVIENT SUNDAY - 31 MAY > ok !!!

        // ajoute le premier lundi du mois au Calendar = 0
        cacheCalendar.add(Calendar.DATE, idDayAdd);
//        System.out.println(cacheCalendar.getTime());
        // ou: (test String)
        System.out.println(cacheCalendar.get(Calendar.DATE)+"/"+(cacheCalendar.get(Calendar.MONTH)+1)+"/"+cacheCalendar.get(Calendar.YEAR));

        return cacheCalendar.getTime();

    }

<<<<<<< HEAD

=======
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9


    // *** on retrouve un jour de ref du mois précédeent (selon le nombre de mois avant aujourd'hui)

<<<<<<< HEAD
    /**
     *
     * @param monthIndex
     * @return Date - passage au mois suivant = 1, ou  précédent = -1
     */
    public Date oneMonthInterval(int monthIndex) {

=======
    // *** on retrouve un jour de ref du mois précédeent (selon le nombre de mois avant aujourd'hui)

    /**
     *
     * @param monthIndex
     * @return Date - passage au mois suivant = 1, ou  précédent = -1
     */
    public Date oneMonthInterval(int monthIndex) {

>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
        this.newCalendar = Calendar.getInstance();

        this.newCalendar.add(Calendar.MONTH, monthIndex);

        this.newMonthRef = newCalendar.getTime();

        return this.newMonthRef;

    }

    /**
     *
<<<<<<< HEAD
     * @return StringBuilder - test - pour en-têtes (CalendarHeader) = nom des jours - String - à faire
     */
    public static StringBuilder getWeekDays() {
=======
     * @return StringBuffer - test - pour en-têtes (CalendarHeader) = nom des jours - String - à faire
     */
    public static StringBuffer getWeekDays() {
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

        DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);


        String[] joursSemaineFR = dfsFR.getWeekdays();

        StringBuilder joursListeFR = new StringBuilder("En-Tête - Jours FR ");

        for (int i = 1; i < joursSemaineFR.length; i++) {
            joursListeFR.append(" : ");
            joursListeFR.append(joursSemaineFR[i]);
        }
        System.out.println(joursListeFR);

        return joursListeFR;
    }


    /**
     *
     * @return Calendar
     */
    public Calendar getCalendarValue() {
        return this.cacheCalendar;
    }

    public void setCalendarValue(Calendar cacheCalendar) {
        this.cacheCalendar = cacheCalendar;

        return;
    }


    /**
     *
     * @return Date
     */
    public Date getDateValue() {
        return this.dateValue;
    }

    /**
     * @param dateValue
     * @return void
     */
    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;

        return;
    }


}