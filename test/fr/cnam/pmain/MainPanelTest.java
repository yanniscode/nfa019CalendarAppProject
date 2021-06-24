//package fr.cnam.pmain;
//
//// *** JUnit V. 5.7.0:
////import org.junit.jupiter.api.*;
////import org.junit.jupiter.params.ParameterizedTest;
////import org.junit.jupiter.params.provider.ValueSource;
//
//import fr.cnam.pbuttons.ControlButtonsPanel;
//import fr.cnam.pcalendarpanel.CalendarPanel;
//
//
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
////import static org.junit.Assert.*;
//import static org.junit.Assert.*;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.Arrays;
//import java.util.Collection;
//
//
//
//
//@RunWith(Parameterized.class)
//public class MainPanelTest {
//
//    /**
//     * MainPanel
//     */
//    private static MainPanel mainPanel;
//
//
//    /**
//     * String - Titre principal
//     */
//    private static JLabel mainLabelIn;
//    private static JLabel mainLabelExpected;
////
////    /**
////     * Container - container du Calendrier
////     */
////    private static Container calendarContainer;
//
//    /**
//     * String - Titre principal
//     */
//    private static String calendarMainTitleIn;
//    private static String calendarMainTitleExpected;
//
////
//    /**
//     * CalendarPanel - Container du Calendrier (= liste de DateButtons)
//     */
//    private static CalendarPanel calendarPanelIn;
//    private static CalendarPanel calendarPanelExpected;
//
//    /**
//     * ControlButtonsPanel - Container du Panneau de ControlButton
//     */
//    private static ControlButtonsPanel controlBtnPanelIn;
//    private static ControlButtonsPanel controlBtnPanelExpected;
//
////    private static MainPanel mainPanel;
//
//
//    /**
//     * @return
//     */
//    @Parameterized.Parameters
//    public static Collection variable() {
//        return Arrays.asList(new Object[][] {
//                {
//                        new ControlButtonsPanel(), new ControlButtonsPanel(), new CalendarPanel(),  new CalendarPanel(), new JLabel(), new JLabel(), "Le Calendrier des Lunaires\n", "Le Calendrier des Lunaires\n"
//                },
////                {
////                    new ControlButtonsPanel(), null, new CalendarPanel(), null
////                },
////                {
////                    new ControlButtonsPanel(), "", new CalendarPanel(),  ""
////                }
//        });
//    }
//
//    // ********
//
////    @Parameterized.Parameters
////    public static Collection variable() {
////        return Arrays.asList(new Object[][] {
////                {
////                    new ControlButtonsPanel(), new ControlButtonsPanel(), new CalendarPanel(),  new CalendarPanel(), new JLabel(), new JLabel(), "Le Calendrier des Lunaires\n", "Le Calendrier des Lunaires\n"
////                },
//////                {
//////                    new ControlButtonsPanel(), null, new CalendarPanel(), null
//////                },
//////                {
//////                    new ControlButtonsPanel(), "", new CalendarPanel(),  ""
//////                }
////        });
////    }
//
//    // ***********
//
//    // *** initialisation (ici ou dans le Constructeur)
//    @Before
//    public void initialize() {
//        this.mainPanel = new MainPanel();
//    }
//
//
//    /**
//     * Constructeur (tests)
//     * @param controlBtnPanelExpected
//     * @param controlBtnPanelIn
//     * @param calendarPanelExpected
//     * @param calendarPanelIn
//     * @param mainLabelExpected
//     * @param mainLabelIn
//     * @param calendarMainTitleExpected
//     * @param calendarMainTitleIn
//     */
//    public MainPanelTest(ControlButtonsPanel controlBtnPanelExpected, ControlButtonsPanel controlBtnPanelIn, CalendarPanel calendarPanelExpected, CalendarPanel calendarPanelIn, JLabel mainLabelExpected, JLabel mainLabelIn, String calendarMainTitleExpected, String calendarMainTitleIn) {
//        super();
//        this.controlBtnPanelExpected = controlBtnPanelExpected;
//        this.controlBtnPanelIn = controlBtnPanelIn;
//        this.calendarPanelExpected = calendarPanelExpected;
//        this.calendarPanelIn = calendarPanelIn;
//        this.mainLabelExpected = mainLabelExpected;
//        this.mainLabelIn = mainLabelIn;
//        this.calendarMainTitleExpected = calendarMainTitleExpected;
//        this.calendarMainTitleIn =calendarMainTitleIn;
//    }
//
//    // *******
//
//    // constructeur pour enregistrer les données Test:
////    public MainPanelTest(ControlButtonsPanel controlBtnPanelExpected, ControlButtonsPanel controlBtnPanelIn, CalendarPanel calendarPanelExpected, CalendarPanel calendarPanelIn, JLabel mainLabelExpected, JLabel mainLabelIn, String calendarMainTitleExpected, String calendarMainTitleIn) {
////        super();
////        this.controlBtnPanelExpected = controlBtnPanelExpected;
////        this.controlBtnPanelIn = controlBtnPanelIn;
////        this.calendarPanelExpected = calendarPanelExpected;
////        this.calendarPanelIn = calendarPanelIn;
////        this.mainLabelExpected = mainLabelExpected;
////        this.mainLabelIn = mainLabelIn;
////        this.calendarMainTitleExpected = calendarMainTitleExpected;
////        this.calendarMainTitleIn = calendarMainTitleIn;
////    }
//
//
//
//
//    // *******************
//
////    @Test
////    public void methodeTest() {
////        System.out.println(this.dataIn);
//////        this.dataIn = 4;
////        assert this.dataIn < 4 : "num < 4";
////        System.out.println("Méthode test: dataIn = "+ this.dataIn);
////    }
//
//    // *******************
//
//
////    @Test
////    void getControlBtnPanel() {
////    }
//
//
//    @Test
//    public void setControlBtnPanelNotNull() {
//        this.mainPanel.setControlBtnPanel(this.controlBtnPanelIn);
//        assertNotNull(this.mainPanel.getControlBtnPanel());
//    }
//
//
//    @Test
//    public void setToGetControlBtnPanelEquals() {
//        System.out.println(this.controlBtnPanelIn);
//        System.out.println(this.mainPanel.getControlBtnPanel());
//
//        this.mainPanel.setControlBtnPanel(this.controlBtnPanelIn);
//        assertEquals(this.controlBtnPanelExpected.toString(), this.mainPanel.getControlBtnPanel().toString());
//    }
//
//    @Test
//    public void setCalendarPanelNotNull() {
//        this.mainPanel.setCalendarPanel(this.calendarPanelIn);
//        assertNotNull(this.mainPanel.getCalendarPanel());
//    }
//
//
//    @Test
//    public void setToGetCalendarPanelEquals() {
//        this.mainPanel.setCalendarPanel(this.calendarPanelIn);
//        assertEquals(this.calendarPanelExpected.toString(), this.mainPanel.getCalendarPanel().toString());
//    }
//
//    @Test
//    public void getMainLabelNotNull() {
//        this.mainPanel.setMainLabel(this.mainLabelIn);
//        assertNotNull(this.mainPanel.getMainLabel());
//    }
//
//    @Test
//    public void setToGetMainLabelEquals() {
//        this.mainPanel.setMainLabel(this.mainLabelIn);
//        assertEquals(this.mainLabelExpected.toString(), this.mainPanel.getMainLabel().toString());
//    }
//
//    @Test
//    public void getCalendarPanelMainTitleNotNull() {
//        this.mainPanel.setCalendarMainTitle(this.calendarMainTitleIn);
//        assertNotNull(this.mainPanel.getCalendarMainTitle());
//    }
//
//    @Test
//    public void setToGetCalendarPanelMainTitleEquals() {
//        this.mainPanel.setCalendarMainTitle(this.calendarMainTitleIn);
//        assertEquals(this.calendarMainTitleExpected.toString(), this.mainPanel.getCalendarMainTitle().toString());
//
//    }
////
////    @Test
////    public void displayMainPanel() {
////    }
////
////    @After
////    public void tearDown() {
////    }
//
//}