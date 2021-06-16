package fr.cnam.pactivity;

import fr.cnam.pcalendarpanel.DateButton;
import org.junit.*;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class DatePartTest {


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() {
        return Arrays.asList(new Object[][] {
//                {
//                        new Date() , null, new DatePart(), null
//                },
                {
                       new Date(), new Date(), 0, 0
                },
                {
                        new Date(), new Date(), -1, 0
                },
                {
                        new Date(), new Date(), 1, 0
                }
        });
    }

    public DatePartTest(Date dateValueIn, Date dateValueExpected, int indexMonthIn, int indexDayIn) {
        super();
//        this.datePart = datePart;
        this.dateValueIn = dateValueIn;
        this.dateValueExpected = dateValueExpected;
        this.indexMonthIn = indexMonthIn;
        this.indexDayIn = indexDayIn;
//        this.monthIndex = monthIndex;
//        System.out.println(daysListIn.hashCode());
//        this.daysListIn = daysListIn;
//        this.daysListExpected = daysListExpected;
//        this.newMonthIn = newMonthIn;
//        this.newMonthExpected = newMonthExpected;
    }


    private DatePart datePart;
    private Date dateValueIn;
    private Date dateValueExpected;
    private int indexMonthIn;
    private int indexDayIn;

//    private Calendar calendarIn;
//    private Calendar calendarExpected;


    // *** initialisation (ici ou dans le Constructeur)
    @Before
    public void initialize() {
        this.datePart = new DatePart();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDatePartEquals() {
        // *** Attention: daysList = pas instanciée dans le Constructeur ici:
        this.datePart.setDateValue(this.dateValueIn);

        assertEquals(this.dateValueExpected.toString(), this.datePart.getDateValue().toString());
    }


    @Test
    public void getDatePartEqualsNotNull() {
        // *** Attention: dateValue = pas instanciée dans le Constructeur de base:
//        this.datePart.setDateValue(this.dateValueIn);

        assertNotNull(this.datePart);
    }

    @Test
    public void getDatePartNull() {
        // *** Attention: dateValue = pas instanciée dans le Constructeur de base:
//        this.datePart.setDateValue(this.dateValueIn);

        assertNull(this.datePart.getDateValue());
    }

    @Test
    public void setToGetDatePartEquals() {
        // *** Attention: dateValue = pas instanciée dans le Constructeur de base: Mais ajout de 'setter' ici:
        this.datePart.setDateValue(this.dateValueIn);

        assertEquals(this.dateValueExpected, this.datePart.getDateValue());
    }

    @Test
    public void getIndexDayNotNull() {
         this.dateValueExpected = this.datePart.getIndexedDay(this.indexDayIn);
         assertNotNull(this.dateValueExpected);
    }

    @Test
    public void getByFirstMondayOfMonthPageNotNull() {
        // *** A REVOIR POUR CHECKER SI LE JOUR EST BIEN UN 'LUNDI':
        this.dateValueExpected = this.datePart.getByFirstMondayOfMonthPage(this.indexMonthIn, this.indexDayIn);
        System.out.println(this.dateValueExpected);
        assertNotNull(this.dateValueExpected);
    }

    @Test
    public void getOneMonthIntervalEquals() {
//        System.out.println(this.dateValueIn.getTime());
        this.dateValueExpected = this.datePart.getOneMonthInterval(this.indexMonthIn);
//        System.out.println(this.dateValueExpected);
//        System.out.println(this.dateValueExpected.getTime());
//        Long monthInterval = this.dateValueIn.getTime() - this.dateValueExpected.getTime();
//        System.out.println(monthInterval);
//        System.out.println(this.dateValueExpected);
//        assertEquals(Long.valueOf(-2592000327L), monthInterval);
        assertNotNull(this.dateValueExpected);
    }

//    @Test
//    public void getWeekdaysNotNull(){
//        // *** StringBuilder = seulement pour test, ici:
//        StringBuilder weekDaysListExpected  = this.datePart.getWeekDays();
//        System.out.println(weekDaysListExpected);
//        assertNotNull(weekDaysListExpected);
//    }
//
//    @Test
//    public void getWeekDays() {
//    }
//
//    @Test
//    public void getCalendarValue() {
//    }
//
//    @Test
//    public void setCalendarValue() {
//    }

}