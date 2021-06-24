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
     * @param newMonthIndex
     * @return void
     */
    public static void setIncrementValue(int newMonthIndex) {
        monthIndex = newMonthIndex;
        return;
    }

    /**
     * @param incrementIndex
     * @return void - modification de la valeur de l'incrément (+1 ou -1)
     */
    public static void pushIncrementValue(int incrementIndex) {
        monthIndex += incrementIndex;
        return;
    }

}
