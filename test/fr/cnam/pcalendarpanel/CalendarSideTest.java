package fr.cnam.pcalendarpanel;

import fr.cnam.pbuttons.CalendarControlButton;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;


@RunWith(Parameterized.class)
public class CalendarSideTest {


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> variable() {
        Collection<Object[]> params = new ArrayList<>();
        // load the external params here
        // this is an example
        params.add(new Object[] {});

        return params;
    }

    /**
     * Constructeur (tests)
     */
    public CalendarSideTest() {
        super();
    }


    @Test
    public void displayCalendarSide() {
        this.logger.log(Level.INFO, () -> "displayCalendar");
    }

}