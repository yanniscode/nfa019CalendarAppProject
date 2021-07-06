package fr.cnam.pmain;

import fr.cnam.pbuttons.CalendarControlButton;
import fr.cnam.pcalendarpanel.CalendarPanel;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(Parameterized.class)
public class MainPanelTest {


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());

    /**
     * MainPanel
     */
    private MainPanel mainPanelIn;

    /**
     * MainPanel
     */
    private MainPanel mainPanelExpected;

    /**
     * CalendarPanel - Container du Calendrier (= liste de DateButtons)
     */
    private CalendarPanel calendarPanelIn;

    /**
     * CalendarPanel - Container du Calendrier (= liste de DateButtons)
     */
    private CalendarPanel calendarPanelExpected;


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> variable() throws SQLException, ClassNotFoundException {
        Collection<Object[]> params = new ArrayList<>();
        // load the external params here
        // this is an example
        params.add(new Object[] { new MainPanel(), new MainPanel(), new CalendarPanel(), new CalendarPanel() });

        return params;
    }


    /**
     * Constructeur (tests)
     */
    public MainPanelTest(MainPanel mainPanelIn, MainPanel mainPanelExpected, CalendarPanel calendarPanelIn, CalendarPanel calendarPanelExpected) {
        super();
        this.mainPanelIn = mainPanelIn;
        this.mainPanelExpected = mainPanelExpected;
        this.calendarPanelIn = calendarPanelIn;
        this.calendarPanelExpected = calendarPanelExpected;
    }

    @Test
    public void setCalendarPanelNotNull() {
        this.mainPanelIn.setCalendarPanel(this.calendarPanelIn);
        assertNotNull(this.mainPanelIn.getCalendarPanel());
    }

    @Test
    public void setToGetCalendarPanelEquals() {
        this.mainPanelIn.setCalendarPanel(this.calendarPanelIn);
        this.mainPanelExpected.setCalendarPanel(this.calendarPanelIn);
        assertEquals(this.calendarPanelExpected.toString(), this.mainPanelIn.getCalendarPanel().toString());
    }

    @Test
    public void displayMainPanel() {
        this.logger.log(Level.INFO, () -> "displayErrorPanel");
    }

}