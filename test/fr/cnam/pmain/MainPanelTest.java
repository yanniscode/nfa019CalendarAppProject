package fr.cnam.pmain;

import fr.cnam.pbuttons.CalendarControlButtonsPanel;
import fr.cnam.pcalendarpanel.CalendarPanel;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class MainPanelTest {


    /**
     * MainPanel
     */
    private MainPanel mainPanel;

    /**
     * JLabel - Titre principal
     */
    private static JLabel mainLabelIn;

    /**
     * JLabel - Titre principal
     */
    private static JLabel mainLabelExpected;

    /**
     * String - Titre principal
     */
    private static String calendarMainTitleIn;

    /**
     * String - Titre principal
     */
    private static String calendarMainTitleExpected;

    /**
     * CalendarPanel - Container du Calendrier (= liste de DateButtons)
     */
    private static CalendarPanel calendarPanelIn;

    /**
     * CalendarPanel - Container du Calendrier (= liste de DateButtons)
     */
    private static CalendarPanel calendarPanelExpected;

    /**
     * ControlButtonsPanel - Container du Panneau de ControlButton
     */
    private static CalendarControlButtonsPanel controlBtnPanelIn;

    /**
     * CalendarControlButtonsPanel (static)
     */
    private static CalendarControlButtonsPanel controlBtnPanelExpected;


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() throws SQLException, ClassNotFoundException {
        return Arrays.asList(new Object[][] {
                {
                        new CalendarControlButtonsPanel(new MainPanel()), new CalendarControlButtonsPanel(new MainPanel()), new CalendarPanel(),  new CalendarPanel(), new JLabel(), new JLabel(), "Le Calendrier des Lunaires\n", "Le Calendrier des Lunaires\n"
                },
        });
    }


    /**
     * Constructeur (tests)
     * @param controlBtnPanelExpected
     * @param controlBtnPanelIn
     * @param calendarPanelExpected
     * @param calendarPanelIn
     * @param mainLabelExpected
     * @param mainLabelIn
     * @param calendarMainTitleExpected
     * @param calendarMainTitleIn
     */
    public MainPanelTest(CalendarControlButtonsPanel controlBtnPanelExpected, CalendarControlButtonsPanel controlBtnPanelIn, CalendarPanel calendarPanelExpected, CalendarPanel calendarPanelIn, JLabel mainLabelExpected, JLabel mainLabelIn, String calendarMainTitleExpected, String calendarMainTitleIn) {
        super();
        this.controlBtnPanelExpected = controlBtnPanelExpected;
        this.controlBtnPanelIn = controlBtnPanelIn;
        this.calendarPanelExpected = calendarPanelExpected;
        this.calendarPanelIn = calendarPanelIn;
        this.mainLabelExpected = mainLabelExpected;
        this.mainLabelIn = mainLabelIn;
        this.calendarMainTitleExpected = calendarMainTitleExpected;
        this.calendarMainTitleIn =calendarMainTitleIn;
    }


    // *** initialisation (ici ou dans le Constructeur)
    @Before
    public void initialize() throws SQLException, ClassNotFoundException {
        mainPanel = new MainPanel();
    }

    @Test
    public void setCalendarPanelNotNull() {
        this.mainPanel.setCalendarPanel(this.calendarPanelIn);
        assertNotNull(this.mainPanel.getCalendarPanel());
    }

    @Test
    public void setToGetCalendarPanelEquals() {
        this.mainPanel.setCalendarPanel(this.calendarPanelIn);
        assertEquals(this.calendarPanelExpected.toString(), this.mainPanel.getCalendarPanel().toString());
    }

    @Test
    public void displayMainPanel() {
        // TODO implement here
    }

}