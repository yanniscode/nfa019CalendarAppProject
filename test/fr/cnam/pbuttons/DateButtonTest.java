package fr.cnam.pbuttons;

import fr.cnam.pbuttons.DateButton;
import fr.cnam.pdatabase.MysqlConnection;
import fr.cnam.pdatabase.managment.dao.DateActivityDAO;
import fr.cnam.pdatabase.managment.model.DateActivityItem;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.putils.penums.ActivityColor;
import fr.cnam.putils.penums.ActivityStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;

import static fr.cnam.pactivity.ActivityFormFrame.activityFormFrame;
import static org.junit.Assert.*;



@RunWith(Parameterized.class)
public class DateButtonTest {

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
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() throws SQLException, ClassNotFoundException {
        return Arrays.asList(new Object[][] {
                {
                        new java.sql.Date(System.currentTimeMillis()), new java.sql.Date(System.currentTimeMillis()), new DatePart(), new DateActivityItem(), 0, new DateButton()
                },
        });
    }


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
        System.out.println("connection ouverte !");
    }

    // *** fermeture de la connection à la fin de chaque test
    @After
    public void tearDown() throws Exception {

        connection.close();
        System.out.println("connection fermée !");
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
    public void actionPerformed() {
        // *** semble pas possible par JUnit
        // TODO implement here
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
        this.dateButton.rebuildActivityDatas(this.connection, 0 , 0);
        assertEquals("31/05/2021", this.dateButton.getDateButton().getText());
    }

    @Test
    public void buildDateButtonNotNull() {
        this.dateButton.buildDateButton(0, 0);
        assertNotNull(this.dateButton.getDateButton());
    }

    @Test
    public void buildDateButtonEquals() {
        this.dateButton.buildDateButton(0, 0);
        assertEquals("31/05/2021", this.dateButton.getDateButton().getText());
    }



    // searchDatasForButton()
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



    // rebuildButtonWithDatas()
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

    @Test
    public void getDateButton() {
        // TODO implement here
    }

    @Test
    public void setDateButton() {
        // TODO implement here
    }

    @Test
    public void getActivityDescription() {
        // TODO implement here
    }

    @Test
    public void setActivityDescription() {
        // TODO implement here
    }

    @Test
    public void getActivityStatus() {
        // TODO implement here
    }

    @Test
    public void setActivityStatus() {
        // TODO implement here
    }

    @Test
    public void displayDateButton() {
        // TODO implement here
    }

}