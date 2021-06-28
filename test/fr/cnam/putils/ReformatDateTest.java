package fr.cnam.putils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class ReformatDateTest {


    /**
     * java.sql.Date
     */
    private java.sql.Date formatedDateExpected;

    /**
     * String
     */
    private String stringDateExpected;


    /**
     * String
     */
    private String formatedMonthExpected;

    /**
     * ReformatDate
     */
    private ReformatDate reformatDate;

    /**
     * Date - import java.sql.Date - formatage selon le pays souhaité
     */
    private java.sql.Date newDateIn;

    /**
     * DateFormat - import java.text.DateFormat
     */
    private DateFormat dateFormatIn;

    /**
     * Long - Date au format Long
     */
    private Long dateLongFormatIn;

    /**
     * Long - date au format Long
     */
    private Long dateFromLongFormatExpected;


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() {
        return Arrays.asList(new Object[][] {
                {
                        new java.sql.Date(System.currentTimeMillis()), new java.sql.Date(System.currentTimeMillis()), "juin", 1624658400000L
                },
        });
    }


    /**
     * Constructeur (tests)
     * @param newDateIn
     * @param formatedDateExpected
     * @param formatedMonthExpected
     * @param dateFromLongFormatExpected
     */
    public ReformatDateTest(java.sql.Date newDateIn, java.sql.Date formatedDateExpected, String formatedMonthExpected, Long dateFromLongFormatExpected) {
        super();
        this.newDateIn = newDateIn;
        this.formatedMonthExpected = formatedMonthExpected;
        this.formatedDateExpected = formatedDateExpected;
        this.dateFromLongFormatExpected = dateFromLongFormatExpected;
    }


    @Before
    public void initialize() {
        this.reformatDate = new ReformatDate();
        this.stringDateExpected = this.reformatDate.formatDateToString(this.newDateIn);
    }

    @Test
    public void formatMonthToStringNotNull() {
        this.formatedMonthExpected = this.reformatDate.formatMonthToString(this.newDateIn);
        assertNotNull(this.formatedMonthExpected);
    }

    @Test
    public void formatMonthToStringEquals() {
        String formatedMonthIn;
        formatedMonthIn = this.reformatDate.formatMonthToString(this.newDateIn);
        assertEquals(this.formatedMonthExpected, formatedMonthIn);
    }

    @Test
    public void formatDateToStringEquals() {
        String formatedDateIn;
        formatedDateIn = this.reformatDate.formatDateToString(this.newDateIn);
        assertEquals(this.stringDateExpected, formatedDateIn);
    }

    @Test
    public void displayReformatDate() {
        assertTrue(this.reformatDate.displayReformatDate());
    }

    @Test
    public void formatStringToLong() throws ParseException {
        this.dateFromLongFormatExpected = this.reformatDate.formatStringToLong(this.stringDateExpected);
        assertEquals(this.dateFromLongFormatExpected, this.dateFromLongFormatExpected);
    }

}