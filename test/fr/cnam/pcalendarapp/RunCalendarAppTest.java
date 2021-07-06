package fr.cnam.pcalendarapp;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class RunCalendarAppTest {


    /**
     * RunCalendarApp
     */
    private RunCalendarApp runCalendarApp;


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> variable() {
        Collection<Object[]> params = new ArrayList<>();
        // load the external params here
        // this is an example
        params.add(new Object[] { new RunCalendarApp() });

        return params;
    }


    /**
     * Constructeur (tests)
     */
    public RunCalendarAppTest(RunCalendarApp runCalendarApp) {
        super();
        this.runCalendarApp = runCalendarApp;
    }


    // *** initialisation (ici ou dans le Constructeur)
    @Before
    public void initialize() throws SQLException, ClassNotFoundException {
        this.runCalendarApp = new RunCalendarApp();
    }

    @Test
    public void runCalendarNotNullTest() {
        assertNotNull(this.runCalendarApp);
    }

    @Test
    public void runCalendarEqualsTest() {
        Assert.assertEquals("fr.cnam.pcalendarapp.RunCalendarApp[frame2,0,0,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]", this.runCalendarApp.toString());
    }

    @Test
    public void runCalendarNotEqualsTest() {
        Assert.assertNotEquals("", this.runCalendarApp.toString());
    }

}