package fr.cnam.pdatabase.managment.model;

import fr.cnam.pdatabase.managment.dao.DateActivityDAO;
import java.sql.Date;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Yannis Guéguen
 */
public class DatePart {

    /**
     * Default constructor
     */
    public DatePart() {
        super();
        this.mainCalendar = Calendar.getInstance();
    }

    /**
     * Logger - messages d'erreur ou informatifs
     */
    private Logger logger = Logger.getLogger(DateActivityDAO.class.getSimpleName());

    /**
     * Calendar - nouvelle instance du calendrier
     */
    private Calendar mainCalendar;

    // *** variable pour DAO:
    /**
     * int - id de l'objet créé à partir des données de la BDD
     */
    private int datePartId;

    /**
     * Long - date récupérée en BDD (format Long)
     */
    private Long datePartValue;

    /**
     * Date - valeur de la date (représentée par la classe DatePart) - actuellement, date = non découpée mais devrait être, au choix: le jour, le mois ou l'année
     */
    private Date dateValue;


    // méthodes liées au DAO:

    /**
     * @return int
     */
    public int getDatePartId() {
        return this.datePartId;
    }

    /**
     * @param datePartId
     * @return void
     */
    public void setDatePartId(int datePartId) {
        this.datePartId = datePartId;
    }

    /**
      * @return Long
     */
    public Long getDatePartValue() {
        return this.datePartValue;
    }

    /**
     * @param datePartValue
     * @return void
     */
    public void setDatePartValue(Long datePartValue) {
        this.datePartValue = datePartValue;
    }


    // *** Recherche du premier lundi affiché dans une page de CalendarPanel:

    /**
     * @link - https://coderanch.com/t/382459/java/day-week-month -> MERCI !
     * @param idMonth
     * @param idDayAdd
     * @return Date - algorithme pour retrouver le premier lundi d'une page d'un mois (peut être le dernier lundi du mois précédent !)
     */
    public java.sql.Date getByFirstMondayOfMonthPage(int idMonth, int idDayAdd) {

        this.mainCalendar = Calendar.getInstance();

        // ***pour modifier le mois:
        this.mainCalendar.add(Calendar.MONTH, idMonth);

        // *** initialisation des dates = séparée, car Calendrier Gregorien utilisé...
        int iMonth = this.mainCalendar.get(Calendar.MONTH);
        int iYear = this.mainCalendar.get(Calendar.YEAR);

        // *** Samedi = ref, sinon, décalage non souhaité des jours - ex: le lundi devient le dimanche
        int iFirstDayOfWeek = Calendar.SATURDAY;

        // définit l'index premier jour de la première semaine:
        int indexDay = 1;

        // *** Définit un calendrier 'grégorien' local avec le lundi comme premier jour de semaine:
        Calendar cacheCalendar = new GregorianCalendar(iYear,iMonth,7);

        cacheCalendar.setFirstDayOfWeek(iFirstDayOfWeek);

        // ** un mois avant = 0
        cacheCalendar.add(Calendar.MONTH, 0);

        // *** jour actuel en 'int':
        int iCurrentDay = cacheCalendar.get(Calendar.DAY_OF_WEEK);

        // *** retrait d'un jour à la position actuelle: ?? pour calculer: indexDay - absolue(offset)
        int offset = iCurrentDay - 1;

        if(iCurrentDay < Calendar.MONDAY) {
            // *** si le jour actuel (int) est avant lundi (dimanche = 1...)
            offset = iCurrentDay - 8;
        }

        // *** sinon, si le jour actuel (int) est égal ou après lundi...
        indexDay = indexDay - Math.abs(offset);

        // *** positionne le jour du mois:
        if(cacheCalendar.getFirstDayOfWeek() == Calendar.MONDAY) {
            indexDay = indexDay + 1;
        }

        cacheCalendar.set(Calendar.DATE , indexDay);
        // *** si 0, pas de modif de la place de MONDAY, SI -1, MONDAY DEVIENT SUNDAY - 31 MAY > ok !!!

        // ajoute le premier lundi du mois au Calendar = 0
        cacheCalendar.add(Calendar.DATE, idDayAdd);

        return new java.sql.Date(cacheCalendar.getTimeInMillis());
    }


    // *** on retrouve un jour de ref du mois précédent (selon le nombre de mois avant aujourd'hui)
    /**
     *
     * @param monthIndex
     * @return Date - passage au mois suivant = 1, ou  précédent = -1
     */
    public Date getOneMonthInterval(int monthIndex) {

        this.mainCalendar = Calendar.getInstance();

        this.mainCalendar.add(Calendar.MONTH, monthIndex);

        return new java.sql.Date(mainCalendar.getTimeInMillis());
    }


    /**
     * @return StringBuilder - test - pour en-têtes (CalendarHeader) = nom des jours - String - à faire
     */
    public StringBuilder getWeekDays() {

        DateFormatSymbols dfsFR = new DateFormatSymbols(Locale.FRENCH);


        String[] joursSemaineFR = dfsFR.getWeekdays();

        // *** StringBuilder = seulement pour test, ici:
        StringBuilder joursListeFR = new StringBuilder("En-Tête - Jours FR ");

        for (int i = 1; i < joursSemaineFR.length; i++) {
            joursListeFR.append(" : ");
            joursListeFR.append(joursSemaineFR[i]);
        }

        this.logger.log(Level.INFO, () -> "Something went wrong: "+ joursListeFR);

        return joursListeFR;
    }


    /**
     *
     * @return Calendar
     */
    public Calendar getCalendarValue() {
        return this.mainCalendar;
    }


    /**
     *
     * @param mainCalendar
     *@return void
     */
    public void setCalendarValue(Calendar mainCalendar) {
        this.mainCalendar = mainCalendar;
    }


    /**
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
    }

}