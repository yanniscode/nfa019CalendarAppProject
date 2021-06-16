package fr.cnam.pcalendarpanel;

import fr.cnam.pbuttons.ControlButtonsPanel;
import fr.cnam.pmain.MainPanel;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;



@RunWith(Parameterized.class)
public class CalendarPanelTest {

    private static CalendarPanel calendarPanel;

    /**
     * ArrayList<DateButton> - liste des boutons (item d'un jour)
     */
    private ArrayList<DateButton> daysListIn;
    private ArrayList<DateButton> daysListExpected;

    private DateButton newDateButtonIn;
    private DateButton newDateButtonExpected;

    private Date newMonthIn;
    private Date newMonthExpected;

    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() {
        return Arrays.asList(new Object[][] {
//                {
//                      null , null, null, null
//                },
                {
                        new ArrayList<DateButton>(), new ArrayList<DateButton>(), new Date(), new Date()
                },
        });
    }

    /**
     * Constructeur (tests)
     * @param daysListIn
     * @param daysListExpected
     * @param newMonthIn
     * @param newMonthExpected
     */
    public CalendarPanelTest(ArrayList<DateButton> daysListIn, ArrayList<DateButton> daysListExpected, Date newMonthIn, Date newMonthExpected) {
        super();

//        System.out.println(daysListIn.hashCode());
        this.daysListIn = daysListIn;
        this.daysListExpected = daysListExpected;
        this.newMonthIn = newMonthIn;
        this.newMonthExpected = newMonthExpected;
    }



    // *** initialisation (ici ou dans le Constructeur)
    @Before
    public void initialize() {
        this.calendarPanel = new CalendarPanel();
    }

    @Test
    public void setToGetEmptyDaysList() {
//        this.daysListIn = new ArrayList<DateButton>();
        this.calendarPanel.setDaysList(this.daysListIn);
        assertEquals("[]", calendarPanel.getDaysList().toString());
    }

    @Test
    public void daysListNotNull() {

        // *** Attention: daysList = déjà instanciée dans le Constructeur de CalendarPanel:

//        this.calendarPanel.setNewDatesInList(this.daysListIn);
//        System.out.println("test: DateButton = "+ calendarPanel.getDaysList());
        assertNotNull(calendarPanel.getDaysList());
    }

    @Test
    public void buildDaysList() {
        // *** Attention: ré-instanciation de la variable 'daysListIn' = nécessaire par appel de getDaysList())

        this.daysListIn = this.calendarPanel.getDaysList();
//        this.calendarPanel.setNewDatesInList(this.daysListIn);
        this.calendarPanel.buildDaysList(this.daysListIn);
        assertEquals(42, this.calendarPanel.getComponents().length);
    }

    @Test
    public void setNewMonthLabelEquals() {
        this.calendarPanel.setNewMonthLabel(this.newMonthIn);
        assertEquals("juin", this.calendarPanel.getCalendarLabel().getText().toString());
    }

    @Test
    public void removeAllFromDaysList() {
        // *** Attention: daysList = déjà instanciée dans le Constructeur de CalendarPanel:

//        this.daysListIn = new ArrayList<DateButton>();
//        this.calendarPanel.setNewDatesInList();
        this.calendarPanel.removeAllFromDaysList();
        System.out.println("button text 2: "+ calendarPanel.getDateButton());
//        System.out.println(calendarPanel.getDaysList().get(0));
        assertEquals( "[]", calendarPanel.getDaysList().toString());
    }

    @Test
    public void removeAllFromCalendarPanel() {
        // *** Attention: daysList = déjà instanciée dans le Constructeur de CalendarPanel:

//        System.out.println("calendarPtest hashcode: "+ this.calendarPanel.hashCode());

//        this.daysListIn = new ArrayList<DateButton>();
//        this.calendarPanel.setNewDatesInList(this.daysListIn);
//        this.daysListExpected = this.calendarPanel.getDaysList();
//        System.out.println("size = "+ this.daysListExpected.size());
//        this.calendarPanel.buildDaysList(this.daysListExpected);
        this.calendarPanel.removeAllDaysFromCalendarPanel();
        // *** on retrouve le nombre decomposants actuels de 'CalendarPanel': 1, au lieu de 42 = attendu, si les boutons ont bien été supprimé:
        assertEquals( 1, calendarPanel.getComponents().length);
    }



    // ***********


    @Test
    public void setToGetCalendarPanelEquals() {
        this.calendarPanel.setDaysList(this.daysListIn);
        assertEquals(this.daysListExpected.toString(), this.calendarPanel.getDaysList().toString());
    }


//
//    @After
//    public void tearDown() throws Exception {
//    }
}