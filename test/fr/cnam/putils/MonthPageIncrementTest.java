package fr.cnam.putils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class MonthPageIncrementTest {


    /**
     * int (static)
     */
    private int monthIndexExpected;

    /**
     * int (static)
     */
    private int incrementIndexIn;


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> variable() {
        Collection<Object[]> params = new ArrayList<>();
        // load the external params here
        // this is an example
        params.add(new Object[] { 1, 1 });
        params.add(new Object[] { -1, -1 });

        return params;
    }

    /**
     * Constructeur
     */
    public MonthPageIncrementTest(int monthIndexExpected, int incrementIndexIn) {
        this.monthIndexExpected = monthIndexExpected;
        this.incrementIndexIn = incrementIndexIn;
    }

    @Test
    public void pushIncrementValueEquals() {
        // *** test de modification du monthIndex de base de 1, après un push

        MonthPageIncrement.pushIncrementValue(this.incrementIndexIn);
        this.monthIndexExpected += this.incrementIndexIn;
        assertEquals(this.monthIndexExpected, MonthPageIncrement.getIncrementValue());
    }

    @Test
    public void setToGetIncrementValueEquals() {
        MonthPageIncrement.setIncrementValue(incrementIndexIn);
        assertEquals(this.monthIndexExpected, MonthPageIncrement.getIncrementValue());
    }

}