package fr.cnam.pbuttons;

import fr.cnam.pdatabase.MysqlConnection;
import fr.cnam.pdatabase.managment.model.DateActivityItem;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.putils.ReformatDate;
import fr.cnam.putils.penums.ActivityStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static fr.cnam.pactivity.ActivityFormFrame.activityFormFrame;
import static org.junit.Assert.*;



@RunWith(Parameterized.class)
public class DateButtonTest {

    /**
     * Logger - messages d'erreur ou informatifs
     */
    private Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());

    /**
     * DatePart
     */
    private DatePart datePart;

    /**
     * java.sql.Date
     */
    private java.sql.Date dateValueIn;

    /**
     * java.sql.Date
     */
    private java.sql.Date dateValueExpected;

    /**
     * int
     */
    private int monthIndex;

    /**
     * Connection
     */
    private Connection connection;

    /**
     * Connection
     */
    private DateButton dateButton;

    /**
     * DateActivityItem
     */
    private DateActivityItem dateActivityItemIn;

    /**
     * ReformatDate
     */
    private ReformatDate reformatDate;


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> variable() throws SQLException, ClassNotFoundException {
        Collection<Object[]> params = new ArrayList<>();
        // load the external params here
        // this is an example
        params.add(new Object[] { new java.sql.Date(System.currentTimeMillis()), new java.sql.Date(System.currentTimeMillis()), new DatePart(), new DateActivityItem(), 0, new DateButton() });

        return params;
    }

    /**
     * Constructeur (tests)
     * @param dateValueIn
     * @param dateValueExpected
     * @param datePart
     * @param dateActivityItemIn
     * @param monthIndex
     * @param dateButton
     */
    public DateButtonTest(Date dateValueIn, Date dateValueExpected, DatePart datePart, DateActivityItem dateActivityItemIn, int monthIndex, DateButton dateButton) {

        super();

        this.dateValueIn = dateValueIn;
        this.dateValueExpected = dateValueExpected;
        this.datePart = datePart;
        this.monthIndex = monthIndex;
        this.dateButton = dateButton;
        this.dateActivityItemIn = dateActivityItemIn;

    }

    // *** initialisation d'une connection à chaque test
    @Before
    public void initialize() throws SQLException, ClassNotFoundException {
        MysqlConnection mysqlConnection = new MysqlConnection();
        mysqlConnection.connection();
        this.connection = mysqlConnection.getConnection();

        this.logger.log(Level.INFO, () -> "connection ouverte !"+ this.connection);

        this.reformatDate = new ReformatDate();
    }

    // *** fermeture de la connection à la fin de chaque test
    @After
    public void tearDown() throws SQLException {

        connection.close();

        this.logger.log(Level.INFO, () -> "connection fermée ! "+ this.connection);
    }

    @Test
    public void getDateValueNotNull() throws ClassNotFoundException, SQLException {

        this.dateButton = new DateButton(0, this.connection);

        this.datePart.setDateValue(this.dateValueIn);

        // *** Attention: daysList = déjà instanciée dans le Constructeur:
        assertNotNull(this.dateButton.getDateValue());
    }

    @Test
    public void setToGetDateValueEquals() throws ClassNotFoundException, SQLException {

        this.dateButton = new DateButton(0, this.connection);
        // *** Attention: daysList = déjà instanciée dans le Constructeur:
        this.dateButton.setDateValue(this.dateValueIn);

        assertEquals(this.dateValueExpected, this.dateButton.getDateValue());
    }

    @Test
    public void setButtonToGray() throws ClassNotFoundException, SQLException {

        this.dateButton = new DateButton(0, this.connection);

        this.datePart.setDateValue(this.dateValueIn);
        this.dateButton.setButtonToGray(this.datePart, this.monthIndex);

        // *** note: code couleur RGB ici: -1118482 = Color.LIGHT_GRAY (lorsque la date n'est pas du mois de la page)
        assertEquals(-1118482, this.dateButton.getBackground().getRGB());
    }

    @Test
    public void openActivityDateFormPanelNotNull() {

        // *** test en 2 fois: ouverture de 'activityFormFrame'
        assertFalse(activityFormFrame.isVisible());
        this.dateButton.openActivityDateFormPanel();
        assertTrue(activityFormFrame.isVisible());
    }

    @Test
    public void rebuildActivityDatasNotNull() {
        this.dateButton.rebuildActivityDatas(this.connection, 0 , 0);
        assertNotNull(this.dateButton.getDateButton());
    }

    @Test
    public void rebuildActivityDatasEmptyEquals() {
        java.sql.Date firstMondayOfPage = this.datePart.getByFirstMondayOfMonthPage(0, 0);
        String firstMondayToString = this.reformatDate.formatDateToString(firstMondayOfPage);

        this.dateButton.rebuildActivityDatas(this.connection, 0 , 0);

        assertEquals(firstMondayToString, this.dateButton.getDateButton().getText());
    }

    @Test
    public void buildDateButtonNotNull() {
        this.dateButton.buildDateButton(0, 0);
        assertNotNull(this.dateButton.getDateButton());
    }

    @Test
    public void buildDateButtonEquals() {
        java.sql.Date firstMondayOfPage = this.datePart.getByFirstMondayOfMonthPage(0, 0);
        String firstMondayToString = this.reformatDate.formatDateToString(firstMondayOfPage);

        this.dateButton.buildDateButton(0, 0);

        assertEquals(firstMondayToString, this.dateButton.getDateButton().getText());
    }

    @Test
    public void searchDatasForButtonNotNull() {
        // *** la méthode searchDatasForButton() renvoie toujours un objet, même lorsqu'il n'y a pas de donnée correspondante en BDD
        assertNotNull(this.dateButton.searchDatasForButton(this.connection));
    }

    // *** Attention: Test ayant des erreurs si des données sont déjà présentes en BDD (id différente)
    @Test
    public void searchDatasForButtonIdEquals() {
        // *** la méthode searchDatasForButton() renvoie toujours un objet, même lorsqu'il n'y a pas de donnée correspondante en BDD
        DateActivityItem dateActivityItemExpected = this.dateButton.searchDatasForButton(this.connection);

        // *** test de l'égalité entre l'id de l'objet (unique) 'dateActivityItem' créé et l'id de l'objet créé par DateActivityDao (méthode 'findByDate(Date dateValue, Connection connection)' ) -> ici: id = 0 et 0 en retour
        assertEquals(this.dateActivityItemIn.getDatePart().getDatePartId(), dateActivityItemExpected.getDatePart().getDatePartId());
    }

    @Test
    public void rebuildButtonWithDatasNotNull() {
        this.dateActivityItemIn.setDatePart(this.datePart);
        this.dateActivityItemIn.setDateActivityDescription("Description Test");
        this.dateActivityItemIn.setDateActivityStatus(ActivityStatus.IN_TEST);
        this.dateButton.rebuildButtonWithDatas( this.dateActivityItemIn, 0,0);
        assertNotNull(this.dateButton.getDateButton());
    }

    @Test
    public void rebuildButtonWithDatasEquals() {

        this.dateActivityItemIn.setDatePart(this.datePart);
        this.dateActivityItemIn.setDateActivityDescription("Description Test");
        this.dateActivityItemIn.setDateActivityStatus(ActivityStatus.IN_TEST);
        this.dateButton.rebuildButtonWithDatas( this.dateActivityItemIn, 0,0);

        // *** test de l'égalité entre objet 'dateActivityItem' créé et la valeur du bouton (getText())
        assertEquals(this.dateActivityItemIn.getDateActivityDescription(), this.dateButton.getDateButton().getText());
    }

}