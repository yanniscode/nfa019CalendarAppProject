package fr.cnam.pcalendarpanel;

import fr.cnam.pbuttons.DateButton;
import fr.cnam.pdatabase.MysqlConnection;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class CalendarPanelTest {


    /**
     * CalendarPanel
     */
    private static CalendarPanel calendarPanel;

    /**
     * ArrayList<DateButton> - liste des boutons (item d'un jour)
     */
    private ArrayList<DateButton> daysListIn;

    /**
     * ArrayList<DateButton> - liste des boutons (item d'un jour)
     */
    private ArrayList<DateButton> daysListExpected;

    /**
     * java.sql.Date
     */
    private java.sql.Date newMonthIn;

    /**
     * java.sql.Date
     */
    private java.sql.Date newMonthExpected;

    /**
     * Connection
     */
    private Connection connection;

    /**
     * DateButton
     */
    private DateButton dateButton;


    /**
     * @return Collection - static
     */
    @Parameterized.Parameters
    public static Collection variable() throws SQLException, ClassNotFoundException {
        return Arrays.asList(new Object[][] {
                {
                        new ArrayList<DateButton>(), new ArrayList<DateButton>(), new java.sql.Date(System.currentTimeMillis()), new java.sql.Date(System.currentTimeMillis()), new DateButton()
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
    public CalendarPanelTest(ArrayList<DateButton> daysListIn, ArrayList<DateButton> daysListExpected, java.sql.Date newMonthIn, java.sql.Date newMonthExpected, DateButton dateButton) throws SQLException, ClassNotFoundException {

        super();

        this.calendarPanel = new CalendarPanel();

        this.daysListIn = daysListIn;
        this.daysListExpected = daysListExpected;
        this.newMonthIn = newMonthIn;
        this.newMonthExpected = newMonthExpected;
        this.dateButton = dateButton;
    }



    // *** initialisation d'une connection à chaque test
    @Before
    public void initialize() throws SQLException, ClassNotFoundException {
        MysqlConnection mysqlConnection = new MysqlConnection();
        mysqlConnection.connection();
        this.connection = mysqlConnection.getConnection();

        System.out.println("connection ouverte !");
    }


    // *** fermeture de la connection à la fin de chaque test
    @After
    public void tearDown() throws Exception {
        this.connection.close();

        System.out.println("connection fermée !");
    }

    @Test
    public void setToGetEmptyDaysList() {
        this.calendarPanel.setDaysList(this.daysListIn);
        assertEquals("[]", this.calendarPanel.getDaysList().toString());
    }

    @Test
    public void daysListNotNull() {

        // *** Attention: daysList = déjà instanciée dans le Constructeur de CalendarPanel:
        assertNotNull(this.calendarPanel.getDaysList());
    }

    @Test
    public void buildDaysList() {
        // *** Attention: ré-instanciation de la variable 'daysListIn' = nécessaire par appel de getDaysList())

        this.daysListIn = this.calendarPanel.getDaysList();
        this.calendarPanel.buildDaysList(this.daysListIn);
        assertEquals(42, this.calendarPanel.getComponents().length);
    }

    @Test
    public void removeAllFromDaysList() {
        // *** Attention: daysList = déjà instanciée dans le Constructeur de CalendarPanel:

        this.calendarPanel.removeAllFromDaysList();
        assertEquals( "[]", this.calendarPanel.getDaysList().toString());
    }

    @Test
    public void removeAllFromCalendarPanel() {
        // *** Attention: daysList = déjà instanciée dans le Constructeur de CalendarPanel:
        this.calendarPanel.removeAllDaysFromCalendarPanel();

        // *** on retrouve le nombre decomposants actuels de 'CalendarPanel': 1, au lieu de 42 = attendu, si les boutons ont bien été supprimé:
        assertEquals( 1, this.calendarPanel.getComponents().length);
    }

    @Test
    public void setToGetCalendarPanelEquals() {
        this.calendarPanel.setDaysList(this.daysListIn);
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
        assertEquals(new StringBuilder().append("javax.swing.JLabel[,0,0,0x0,invalid,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=,disabledIcon=,horizontalAlignment=CENTER,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=juin,verticalAlignment=CENTER,verticalTextPosition=CENTER]").toString(), this.calendarPanel.getNewMonthLabel().toString());
    }

    @Test
    public void setToGetConnectionNotNull() {
        this.calendarPanel.setConnection(this.connection);
        assertNotNull(this.calendarPanel.getConnection());
    }

    @Test
    public void setToGetConnectionEquals() {
        this.calendarPanel.setConnection(this.connection);
        assertEquals(this.connection, this.calendarPanel.getConnection());
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
        // TODO implement here
    }

}