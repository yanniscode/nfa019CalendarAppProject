package fr.cnam.pcalendarapptest;

// *** si JUnit V. 4
import fr.cnam.pcalendarapp.RunCalendarApp;
import fr.cnam.pmain.MainPanel;
import org.junit.*;
import static org.junit.Assert.*;

// *** JUnit V. 5.7.0:
//import org.junit.jupiter.api.*;
//import static org.junit.jupiter.api.Assertions.*;

public class RunCalendarAppTest {

    /**
     * Constructeur (tests)
     */
    public RunCalendarAppTest() {
        super();
//        this.runCalendarApp = new RunCalendarApp();
    }

    private static RunCalendarApp runCalendarApp;

    // *** initialisation (ici ou dans le Constructeur)
    @Before
    public void initialize() {
        this.runCalendarApp = new RunCalendarApp();
    }

//    @Before
//    public void setUp() {
//    }

    @Test
    public void runCalendarNotNullTest() {
        assertNotNull(this.runCalendarApp);
//        int num = 4;
//        assert num > 4 : "num < 4";
    }

    @Test
    public void runCalendarEqualsTest() {
        Assert.assertEquals("fr.cnam.pcalendarapptest.RunCalendarApp[frame3,0,0,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]", this.runCalendarApp.toString());
    }

    @Test
    public void runCalendarNotEqualsTest() {
        System.out.println(this.runCalendarApp.toString());
        Assert.assertNotEquals("", this.runCalendarApp.toString());
    }

    @Test
    public void mainEquals() {
        this.runCalendarApp = new RunCalendarApp();
        Assert.assertEquals("fr.cnam.pcalendarapptest.RunCalendarApp[frame2,0,0,0x0,invalid,hidden,layout=java.awt.BorderLayout,title=,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,0,0x0,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]", this.runCalendarApp.toString());
    }

    @Test
    public void mainNotEmpty() {
        this.runCalendarApp = new RunCalendarApp();
        Assert.assertNotEquals("", this.runCalendarApp.toString());
    }

    @After
    public void leaveApp() {
        System.out.println("Good Bye Calendar Test !");
//        assertEquals("", this.runCalendarApp.toString());
    }

//    public String toString() {
//        String runCalendarAppToString = this.runCalendarApp.toString();
//        return runCalendarAppToString;
//    }

}