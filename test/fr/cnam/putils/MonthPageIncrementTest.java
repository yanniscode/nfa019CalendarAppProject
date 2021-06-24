package fr.cnam.putils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MonthPageIncrementTest {

    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() {
        return Arrays.asList(new Object[][] {
//                {
//                    null, null, null
//                },
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

    private MonthPageIncrement monthPageIncrement;

    private static int monthIndexIn;
    private static int monthIndexExpected;
    private int incrementIndexIn;

    @Before
    public void initialize() {
        this.monthPageIncrement = new MonthPageIncrement();
    }

//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void getIncrementValue() {

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