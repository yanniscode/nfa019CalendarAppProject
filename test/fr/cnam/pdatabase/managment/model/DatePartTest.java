package fr.cnam.pdatabase.managment.model;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.sql.Date;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class DatePartTest {

    /**
     * DatePart
     */
    private DatePart datePart;

    /**
     * java.sql.Date
     */
    private java.sql.Date dateValueIn;

    /**
     * java.sql.Date
     */
    private java.sql.Date dateValueExpected;

    /**
     * int
     */
    private int indexMonthIn;

    /**
     * int
     */
    private int indexDayIn;



    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() {
        return Arrays.asList(new Object[][] {
                {
                        new  java.sql.Date(System.currentTimeMillis()), new  java.sql.Date(System.currentTimeMillis()), 0, 0
                },
                {
                        new  java.sql.Date(System.currentTimeMillis()), new  java.sql.Date(System.currentTimeMillis()), -1, 0
                },
                {
                        new  java.sql.Date(System.currentTimeMillis()), new  java.sql.Date(System.currentTimeMillis()), 1, 0
                }
        });
    }


    /**
     * Constructeur (tests)
     * @param dateValueIn
     * @param dateValueExpected
     * @param indexMonthIn
     * @param indexDayIn
     */
    public DatePartTest(Date dateValueIn, Date dateValueExpected, int indexMonthIn, int indexDayIn) {

        super();

        this.dateValueIn = dateValueIn;
        this.dateValueExpected = dateValueExpected;
        this.indexMonthIn = indexMonthIn;
        this.indexDayIn = indexDayIn;
    }


    // *** initialisation (ici ou dans le Constructeur)
    @Before
    public void initialize() {
        this.datePart = new DatePart();
    }

    @After
    public void tearDown() throws Exception {
        // TODO implement here
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
        assertNotNull(this.datePart);
    }

    @Test
    public void getDatePartNull() {
        // *** Attention: dateValue = pas instanciée dans le Constructeur de base:
        assertNull(this.datePart.getDateValue());
    }

    @Test
    public void setToGetDatePartEquals() {
        // *** Attention: dateValue = pas instanciée dans le Constructeur de base: Mais ajout de 'setter' ici:
        this.datePart.setDateValue(this.dateValueIn);

        assertEquals(this.dateValueExpected, this.datePart.getDateValue());
    }

    @Test
    public void getByFirstMondayOfMonthPageNotNull() {
        this.dateValueExpected = this.datePart.getByFirstMondayOfMonthPage(this.indexMonthIn, this.indexDayIn);
        assertNotNull(this.dateValueExpected);
    }

    @Test
    public void getOneMonthIntervalNotNull() {
        this.dateValueExpected = this.datePart.getOneMonthInterval(this.indexMonthIn);
        assertNotNull(this.dateValueExpected);
    }

    @Test
    public void getWeekdaysNotNull(){
        // *** StringBuilder = seulement pour test d'une méthode pas utilisée, ici:
        StringBuilder weekDaysListExpected  = this.datePart.getWeekDays();
        assertNotNull(weekDaysListExpected);
    }

    @Test
    public void getWeekDaysEquals() {
        // *** StringBuilder = seulement pour test d'une méthode pas utilisée, ici:
        StringBuilder weekDaysListExpected  = this.datePart.getWeekDays();
        assertEquals("En-Tête - Jours FR  : dimanche : lundi : mardi : mercredi : jeudi : vendredi : samedi", weekDaysListExpected.toString());
    }

    @Test
    public void getDatePartId() {
        // TODO implement here
    }

    @Test
    public void setDatePartId() {
        // TODO implement here
    }

    @Test
    public void getDatePartValue() {
        // TODO implement here
    }

    @Test
    public void setDatePartValue() {
        // TODO implement here
    }

    @Test
    public void getCalendarValue() {
        // TODO implement here
    }

    @Test
    public void setCalendarValue() {
        // TODO implement here
    }

}
