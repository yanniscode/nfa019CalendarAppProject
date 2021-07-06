package fr.cnam.pcalendarpanel;

import fr.cnam.pbuttons.CalendarControlButton;
import fr.cnam.pbuttons.DateButton;
import fr.cnam.pmain.MainPanel;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class CalendarPanelTest {


    private MainPanel mainPanel;


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());

    /**
     * CalendarPanel
     */
    private CalendarPanel calendarPanel;

    /**
     * ArrayList<DateButton> - liste des boutons (item d'un jour)
     */
    private List<DateButton> daysListIn;

    /**
     * ArrayList<DateButton> - liste des boutons (item d'un jour)
     */
    private List<DateButton> daysListExpected;

    /**
     * java.sql.Date
     */
    private java.sql.Date newMonthIn;

    /**
     * DateButton
     */
    private DateButton dateButton;


    /**
     * @return Collection - static
     */
    @Parameterized.Parameters
    public static Collection<Object[]> variable() throws SQLException, ClassNotFoundException {
        Collection<Object[]> params = new ArrayList<>();
        // load the external params here
        // this is an example
        params.add(new Object[] { new MainPanel(), new CalendarPanel(), new ArrayList<DateButton>(), new ArrayList<>(), new java.sql.Date(System.currentTimeMillis()), new DateButton() });

        return params;
    }


    /**
     * Constructeur (tests)
     * @param calendarPanel
     * @param daysListIn
     * @param daysListExpected
     * @param newMonthIn
     * @param dateButton
     */
    public CalendarPanelTest(MainPanel mainPanel, CalendarPanel calendarPanel, List<DateButton> daysListIn, List<DateButton> daysListExpected, java.sql.Date newMonthIn, DateButton dateButton) {

        super();

        this.mainPanel = mainPanel;
        this.calendarPanel = calendarPanel;
        this.daysListIn = daysListIn;
        this.daysListExpected = daysListExpected;
        this.newMonthIn = newMonthIn;
        this.dateButton = dateButton;
    }


    // *** initialisation d'une connection à chaque test
    @Before
    public void initialize() {
        this.mainPanel.setCalendarPanel(this.calendarPanel);
        this.mainPanel.getCalendarPanel().buildNewDatesInList(this.daysListIn);
    }

    @Test
    public void setToGetDaysList() {
        this.calendarPanel.setDaysList(this.daysListIn);
        assertNotNull(this.calendarPanel.getDaysList().toString());
    }

    @Test
    public void buildDaysList() throws SQLException, ClassNotFoundException {
        // *** "calendarPanel" = initialisé avec des valeurs (42 éléments)
        this.calendarPanel = new CalendarPanel();
        this.calendarPanel.buildDaysList(this.daysListIn);
        assertEquals(83, this.calendarPanel.getComponents().length);
    }

    @Test
    public void removeAllFromDaysList() {
        // *** Attention: daysList = déjà instanciée dans le Constructeur de CalendarPanel
        this.mainPanel.getCalendarPanel().removeAllFromDaysList();
        assertEquals( "[]", this.calendarPanel.getDaysList().toString());
    }

    @Test
    public void removeAllFromCalendarPanel() {
        // *** test A: la liste des jours n'est pas vide:
        assertFalse( this.mainPanel.getCalendarPanel().getDaysList().isEmpty());

        this.mainPanel.getCalendarPanel().removeAllFromDaysList();

        // *** test B: la liste des jours doit être vide, à présent:
        assertTrue( this.mainPanel.getCalendarPanel().getDaysList().isEmpty());
    }

    @Test
    public void setToGetCalendarPanelEquals() {
        this.calendarPanel.setDaysList(this.daysListIn);
        this.daysListExpected = this.daysListIn;
        assertEquals(this.daysListExpected.toString(), this.calendarPanel.getDaysList().toString());
    }

    @Test
    public void buildToGetNewDatesInListNotNull() throws SQLException, ClassNotFoundException {
        this.calendarPanel.buildNewDatesInList(this.daysListIn);
        assertNotNull(this.calendarPanel.getNewDatesInList());
    }

    @Test
    public void buildToGetNewDatesInListEquals() throws SQLException, ClassNotFoundException {
        this.calendarPanel.buildNewDatesInList(this.daysListIn);
        assertEquals(this.daysListIn, this.calendarPanel.getNewDatesInList());
    }

    @Test
    public void buildToGetNewMonthLabelNotNull() {
        this.calendarPanel.buildNewMonthLabel(this.newMonthIn);
        assertNotNull(this.calendarPanel.getNewMonthLabel());
    }

    @Test
    public void buildToGetNewMonthLabelEquals() {
        this.calendarPanel.buildNewMonthLabel(this.newMonthIn);
        assertEquals(new StringBuilder().append("javax.swing.JLabel[,0,0,0x0,invalid,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=,disabledIcon=,horizontalAlignment=CENTER,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=juil.,verticalAlignment=CENTER,verticalTextPosition=CENTER]").toString(), calendarPanel.getNewMonthLabel().toString());
    }

    @Test
    public void setToGetDateButtonNotNull() {
        this.calendarPanel.setDateButton(this.dateButton);
        assertNotNull(this.calendarPanel.getDateButton());
    }

    @Test
    public void setToGetDateButtonEquals() {
        this.calendarPanel.setDateButton(this.dateButton);
        assertEquals(this.dateButton, this.calendarPanel.getDateButton());
    }

    @Test
    public void displayCalendar() {
        this.logger.log(Level.INFO, () -> "displayCalendar");
    }

}