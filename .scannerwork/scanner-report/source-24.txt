package fr.cnam.putils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class MonthPageIncrementTest {


    /**
     * MonthPageIncrement
     */
    private MonthPageIncrement monthPageIncrement;

    /**
     * int (static)
     */
    private static int monthIndexIn;

    /**
     * int (static)
     */
    private static int monthIndexExpected;

    /**
     * int (static)
     */
    private int incrementIndexIn;


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() {
        return Arrays.asList(new Object[][] {
                {
                        1, 1, 1
                },
                {
                        -1, -1, -1
                },
        });
    }

    /**
     * Constructeur
     */
    public MonthPageIncrementTest(int monthIndexIn, int monthIndexExpected, int incrementIndexIn) {
        this.monthIndexIn = monthIndexIn;
        this.monthIndexExpected = monthIndexExpected;
        this.incrementIndexIn = incrementIndexIn;
    }


    @Before
    public void initialize() {
        this.monthPageIncrement = new MonthPageIncrement();
    }

    @Test
    public void getIncrementValue() {
        // TODO implement here
    }

    @Test
    public void setIncrementValue() {
        // TODO implement here
    }

    @Test
    public void pushIncrementValueEquals() {
        // *** test de modification du monthIndex de base de 1, après un push
        MonthPageIncrement.pushIncrementValue(this.incrementIndexIn);
        assertEquals(monthIndexExpected, MonthPageIncrement.getIncrementValue());
    }

    @Test
    public void setToGetIncrementValueEquals() {
        MonthPageIncrement.setIncrementValue(monthIndexIn);
        assertEquals(monthIndexExpected, MonthPageIncrement.getIncrementValue());
    }

}