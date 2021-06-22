package fr.cnam.putils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ReformatDateTest {

    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() {
        return Arrays.asList(new Object[][] {
//                {
//                    null, "Juin"
//                },
                {
                        new Date(), "juin", "20/06/2021"
                },
        });
    }

    public ReformatDateTest(Date newDateIn, String formatedMonthExpected, String formatedDateExpected) {
        super();
        this.newDateIn = newDateIn;
        this.formatedMonthExpected = formatedMonthExpected;
        this.formatedDateExpected = formatedDateExpected;
    }

    /**
     * String
     */
    private String formatedDateExpected;

    /**
     * String
     */
    private String formatedMonthExpected;

    /**
     * ReformatDate
     */
    private ReformatDate reformatDate;

    /**
     * DateFormatSymbols - formatage selon le pays souhaité
     */
    private Date newDateIn;
//    private Date newDateExpected;

    /**
     * DateFormat - import java.text.DateFormat
     */
    private DateFormat dateFormatIn;



    @Before
    public void initialize() {
        this.reformatDate = new ReformatDate();
    }


//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void formatMonthToStringNotNull() {
        this.formatedMonthExpected = this.reformatDate.formatMonthToString(this.newDateIn);
        assertNotNull(this.formatedMonthExpected);
    }

    @Test
    public void formatMonthToStringEquals() {
        String formatedMonthIn;
        formatedMonthIn = this.reformatDate.formatMonthToString(this.newDateIn);
//        System.out.println(this.formatedDateIn);
        assertEquals(this.formatedMonthExpected, formatedMonthIn);
    }

    @Test
    public void formatDateToStringEquals() {
        String formatedDateIn;
        formatedDateIn = this.reformatDate.formatDateToString(this.newDateIn);
//        System.out.println(this.formatedDateIn);
        assertEquals(this.formatedDateExpected, formatedDateIn);
    }

    @Test
    public void displayReformatDate() {
        assertTrue(this.reformatDate.displayReformatDate());
    }
}