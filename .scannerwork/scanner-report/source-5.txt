//package fr.cnam.pcalendarpanel;
//
//import fr.cnam.pdatabase.managment.model.DatePart;
//import fr.cnam.penums.ActivityColor;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import static org.junit.Assert.*;
//
//import java.util.*;
//
//import static org.junit.Assert.*;
//
//
//@RunWith(Parameterized.class)
//public class DateButtonTest {
//
//    private DatePart datePart;
//    private Date dateValueIn;
//    private Date dateValueExpected;
//    private int monthIndex;
//
//    // *******
//    private DateButton dateButton;
//
//    private Calendar newCalendarIn;
//    private Date aggregatedDateIn;
//    private DatePart yearSelectIn;
//    private DatePart monthSelectIn;
//    private DatePart daySelectIn;
//    private String activityDescriptionIn;
//    private String activityStatusIn;
//    private ActivityColor activityColorIn;
//
//    /**
//     * @return
//     */
//    @Parameterized.Parameters
//    public static Collection variable() {
//        return Arrays.asList(new Object[][] {
////                {
////                      null , null, null, null
////                },
//                {
//                        new Date(), new Date(), new DatePart(), 0
//                },
//        });
//    }
//
//    public DateButtonTest(Date dateValueIn, Date dateValueExpected, DatePart datePart, int monthIndex) {
//        super();
//        this.dateValueIn = dateValueIn;
//        this.dateValueExpected = dateValueExpected;
//        this.datePart = datePart;
//        this.monthIndex = monthIndex;
////        System.out.println(daysListIn.hashCode());
////        this.daysListIn = daysListIn;
////        this.daysListExpected = daysListExpected;
////        this.newMonthIn = newMonthIn;
////        this.newMonthExpected = newMonthExpected;
//    }
//
//    // *** initialisation (ici ou dans le Constructeur)
//    @Before
//    public void initialize() {
//         this.dateButton = new DateButton(0);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
////    @Test
////    public Date getDateValue() {
////        return this.dateValueExpected;
////    }
//
//    @Test
//    public void getDateValueNotNull() {
//        // *** Attention: daysList = déjà instanciée dans le Constructeur:
////        this.dateButton.getDateValue();
////        System.out.println(this.dateButton.getDateValue());
//        assertNotNull(this.dateButton.getDateValue());
//    }
//
////    @Test
////    public void getDateValueNotEquals() {
////        // *** NotEquals (pour test), mais Equals souhaitable,mais compliqué à comparer exactement, car date = de type CEST = 'Central European Summer Time', avec les secondes...
////        assertNotEquals("Mon May 31 18:55:20 CEST 2021", this.dateButtonIn.getDateValue().toString());
////    }
//
//    @Test
//    public void setToGetDateValueEquals() {
//        // *** Attention: daysList = déjà instanciée dans le Constructeur:
//        this.dateButton.setDateValue(this.dateValueIn);
////        System.out.println(this.dateButton.getDateValue());
//        assertEquals(this.dateValueExpected, this.dateButton.getDateValue());
//    }
//
//    @Test
//    public void setButtonToGray(){
//        this.datePart.setDateValue(this.dateValueIn);
//        this.dateButton.setButtonToGray(this.datePart, this.monthIndex);
//        // *** note: code couleur RGB ici: -1118482 = Color.LIGHT_GRAY (lorsque la date n'est pas du mois de la page)
//        assertEquals(-1118482, this.dateButton.getBackground().getRGB());
//    }
//
//
////    @Test
////    public void setToGetCalendarPanelEquals() {
////        this.calendarPanel.setDaysList(this.daysListIn);
////        assertEquals(this.daysListExpected.toString(), this.calendarPanel.getDaysList().toString());
////    }
//
////    @Test
////    public DateButton getDateButton() {
////        return this.dateButton;
////    }
////
////    @Test
////    public void setDateButton() {
////    }
//
//
//
////    @Test
////    public void setButtonToGray() {
////    }
//
//
//
////    @Test
////    public Date getAggregatedDate() {
////        return this.aggregatedDate;
////    }
////
////    @Test
////    public void setAggregatedDate() {
////    }
//
////    @Test
////    public DatePart getYearSelect() {
////        return this.yearSelect;
////    }
////
////    @Test
////    public void setYearSelect() {
////    }
//
////    @Test
////    public DatePart getMonthSelect() {
////        return this.monthSelect;
////    }
////
////    @Test
////    public void setMonthSelect() {
////    }
//
////    @Test
////    public DatePart getDaySelect() {
////        return this.daySelect;
////    }
////
////    @Test
////    public void setDaySelect() {
////    }
//
////    @Test
////    public Calendar getNewCalendar() {
////        return newCalendar;
////    }
////
////    @Test
////    public void setNewCalendar() {
////    }
//
////    @Test
////    public String getActivityDescription() {
////        return this.getActivityDescription();
////    }
////
////    @Test
////    public void setActivityDescription() {
////    }
//
////    @Test
////    public String getActivityStatus() {
////        return this.activityStatus;
////    }
////
////    @Test
////    public void setActivityStatus() {
////    }
////
////    @Test
////    public ActivityColor getActivityColor() {
////        return this.activityColor;
////    }
//
////    @Test
////    public void setActivityColor() {
////    }
////
////    @Test
////    public void displayActivity() {
////    }
////
////    @Test
////    public void displayDateButton() {
////    }
//}