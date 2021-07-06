package fr.cnam.putils;

public class MonthPageIncrement {

    /**
     * Constructeur ('private', ici...)
     */
    private MonthPageIncrement() {
        super();
    }


    /**
     * int - index (static) pour retrouver le mois suivant ou précédent, relatif à la date du jour
     */
    private static int monthIndex = 0;

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
    }

    /**
     * @param incrementIndex
     * @return void - modification de la valeur de l'incrément (+1 ou -1)
     */
    public static void pushIncrementValue(int incrementIndex) {
        monthIndex += incrementIndex;
    }

}
