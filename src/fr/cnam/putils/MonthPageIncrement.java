package fr.cnam.putils;

public class MonthPageIncrement {

    /**
     * Constructeur
     */
    public MonthPageIncrement() {
        monthIndex = 0;
    }

    /**
     * int - index (static) pour retrouver le mois suivant ou précédent, relatif à la date du jour
     */
    private static int monthIndex;

    /**
     * @return int
     */
    public static int getIncrementValue() {
        return monthIndex;
    }

    /**
     * @param incrementIndex
     * @return void
     */
    public static void setIncrementValue(int incrementIndex) {
        monthIndex += incrementIndex;
        return;
    }

}
