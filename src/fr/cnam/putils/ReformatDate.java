package fr.cnam.putils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ReformatDate {

    /**
     * Constructeur:
     */
    public ReformatDate() {
        // *** type deformatage de date choisi = français
        this.dfsFR = new DateFormatSymbols(Locale.FRENCH);
    }

    /**
     * DateFormatSymbols - formatage selon le pays souhaité
     */
    private DateFormatSymbols dfsFR;

    /**
     * DateFormat - import java.text.DateFormat
     */
    private DateFormat dateFormat;


    private static final String DATEPATTERN = "dd/MM/yyyy";


    /**
     *
     * @param newDate
     * @return String - passage d'une date (complète) au format mois en toutes lettres (ex: "juin")
     */
    public String formatMonthToString(java.sql.Date newDate) {

        this.dateFormat = new SimpleDateFormat("MMM", dfsFR);

        String formatedDate = this.dateFormat.format(newDate);

        return formatedDate;
    }

    /**
     * @return String - Date au format String ("dd/MM/yyyy") en sortie - Attention : la convertion de la date en String fait ici perdre les infos sur les secondes, milli-secondes, ce qui est souhaité ici
     */
    public String formatDateToString(java.sql.Date newDate) {
        this.dateFormat = new SimpleDateFormat(DATEPATTERN);

        String formatedDate = this.dateFormat.format(newDate);

        return formatedDate;
    }

    /**
     * @return Long - Date au format Long en sortie
     */
    public Long formatStringToLong(String newStringDate) throws ParseException {
        System.out.println(newStringDate);

        // *** date en entrée = String au format local ("dd/MM/yyyy")
        this.dateFormat = new SimpleDateFormat(DATEPATTERN);

        // *** date au format java.util.Date (seulement ici...)
        java.util.Date date = this.dateFormat.parse(newStringDate);

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Long longDate = sqlDate.getTime();

        return longDate;
    }

    /**
     * @return Date - Date au format java.sql.Date en sortie
     */
    public java.sql.Date formatStringToDate(String newStringDate) throws ParseException {
        System.out.println(newStringDate);

        // *** date en entrée = String au format local ("dd/MM/yyyy")
        this.dateFormat = new SimpleDateFormat(DATEPATTERN);

        // *** date au format java.util.Date (seulement ici...)
        java.util.Date date = this.dateFormat.parse(newStringDate);

        return new java.sql.Date(date.getTime());
    }


    /**
     * @return void
     */
    public boolean displayReformatDate() {
        // TODO implement here
        return true;
    }

}
