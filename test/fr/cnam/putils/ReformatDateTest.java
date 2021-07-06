package fr.cnam.putils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class ReformatDateTest {

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
     * Long - date au format Long
     */
    private Long dateFromLongFormatExpected;


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> variable() {
        Collection<Object[]> params = new ArrayList<>();
        // load the external params here
        // this is an example
        params.add(new Object[] { new java.sql.Date(System.currentTimeMillis()), 1624658400000L });

        return params;
    }


    /**
     * Constructeur (tests)
     * @param newDateIn
     * @param dateFromLongFormatExpected
     */
    public ReformatDateTest(java.sql.Date newDateIn, Long dateFromLongFormatExpected) {
        super();
        this.newDateIn = newDateIn;
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
        this.formatedMonthExpected = this.reformatDate.formatMonthToString(this.newDateIn);

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