package fr.cnam.pcalendarapp;

import org.junit.*;

import java.sql.SQLException;

import static org.junit.Assert.*;


public class RunCalendarAppTest {


    /**
     * RunCalendarApp
     */
    private RunCalendarApp runCalendarApp;


    /**
     * Constructeur (tests)
     */
    public RunCalendarAppTest() {
        super();
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
        Assert.assertEquals("fr.cnam.pcalendarapp.RunCalendarApp[frame4,0,0,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]", this.runCalendarApp.toString());
    }

    @Test
    public void runCalendarNotEqualsTest() {
        Assert.assertNotEquals("", this.runCalendarApp.toString());
    }


    @Test
    public void mainEquals() throws SQLException, ClassNotFoundException {
        this.runCalendarApp = new RunCalendarApp();
        Assert.assertEquals("fr.cnam.pcalendarapp.RunCalendarApp[frame3,0,0,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]", this.runCalendarApp.toString());
    }

    @Test
    public void mainNotEmpty() throws SQLException, ClassNotFoundException {
        this.runCalendarApp = new RunCalendarApp();
        Assert.assertNotEquals("", this.runCalendarApp.toString());
    }

}