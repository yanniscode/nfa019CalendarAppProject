package fr.cnam.putils;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    /**
     *
     * @param newDate
     * @return String - passage d'une date (complète) au format mois en toutes lettres (ex: "juin")
     */
    public String formatMonthToString(Date newDate) {

        this.dateFormat = new SimpleDateFormat("MMM", dfsFR);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", dfsFR);

        String formatedDate = this.dateFormat.format(newDate);

        return formatedDate;
    }

    /**
     * @return String - Date au format String ("dd/MM/yyyy")
     */
    public String formatDateToString(Date newDate) {
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatedDate = this.dateFormat.format(newDate);
        return formatedDate;
    }

    /**
     * @return void
     */
    public boolean displayReformatDate() {
        System.out.println("ReformatDate Test: "+ this.formatMonthToString(new Date()));
        return true;
    }

}
