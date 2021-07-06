package fr.cnam.putils;

import fr.cnam.pactivity.ActivityFormFrame;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReformatDate {

    /**
     * Constructeur:
     */
    public ReformatDate() {
        // *** type deformatage de date choisi = français
        this.dfsFR = new DateFormatSymbols(Locale.FRENCH);
    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private Logger logger = Logger.getLogger(ActivityFormFrame.class.getSimpleName());

    /**
     * DateFormatSymbols - formatage selon le pays souhaité
     */
    private DateFormatSymbols dfsFR;

    /**
     * DateFormat - import java.text.DateFormat
     */
    private DateFormat dateFormat;

    /**
     * String (static final)
     */
    private static final String DATEPATTERN = "dd/MM/yyyy";


    /**
     *
     * @param newDate
     * @return String - passage d'une date (complète) au format mois en toutes lettres (ex: "juin")
     */
    public String formatMonthToString(java.sql.Date newDate) {

        this.dateFormat = new SimpleDateFormat("MMM", dfsFR);

        return this.dateFormat.format(newDate);
    }

    /**
     * @return String - Date au format String ("dd/MM/yyyy") en sortie - Attention : la convertion de la date en String fait ici perdre les infos sur les secondes, milli-secondes, ce qui est souhaité ici
     */
    public String formatDateToString(java.sql.Date newDate) {
        this.dateFormat = new SimpleDateFormat(DATEPATTERN);

        return this.dateFormat.format(newDate);
    }

    /**
     * @return Long - Date au format Long en sortie
     */
    public Long formatStringToLong(String newStringDate) throws ParseException {

        // *** date en entrée = String au format local ("dd/MM/yyyy")
        this.dateFormat = new SimpleDateFormat(DATEPATTERN);

        // *** date au format java.util.Date (seulement ici...)
        java.util.Date date = this.dateFormat.parse(newStringDate);

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        return sqlDate.getTime();
    }

    /**
     * @return Date - Date au format java.sql.Date en sortie
     */
    public java.sql.Date formatStringToDate(String newStringDate) throws ParseException {

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
        this.logger.log(Level.INFO, () -> "info (displayReformatDate): "+ this.dateFormat);
        return true;
    }

}
