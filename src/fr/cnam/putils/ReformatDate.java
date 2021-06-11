package fr.cnam.putils;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

<<<<<<< HEAD

/**
 * @author Yannis Guéguen
 */
=======
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9
public class ReformatDate {

    /**
     * Constructeur:
     */
    public ReformatDate() {
        // *** type deformatage de date choisi = français
        this.dfsFR = new DateFormatSymbols((Locale.FRENCH));
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
     * @return String - permet le passage d'une date (complète) au format mois (en toutes lettres)
     */
    public String formatMonthToString(Date newDate) {

        this.dateFormat = new SimpleDateFormat("MMM", dfsFR);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", dfsFR);

        String formatedDate = this.dateFormat.format(newDate);

        return formatedDate;
    }


    /**
     * @return void
     */
    public void displayReformatDate() {
        return;
    }

}
