package fr.cnam.pdatabase.managment.dao;

import fr.cnam.pbuttons.CalendarControlButton;
import fr.cnam.pdatabase.MysqlConnection;
import fr.cnam.pdatabase.managment.model.DateActivityItem;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.putils.ReformatDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class DateActivityDAOTest {


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());

    /**
     * DateActivityDAO
     */
    private DateActivityDAO dateActivityDAO;

    /**
     * Connection
     */
    private Connection connection;

    /**
     * java.sql.Date - pour tests à la date actuelle
     */
    private java.sql.Date newDayIn;


    /**
     * Long - conversion de Date (String) en Long (pour tests)
     */
    private Long newDayStringToLong;

    private DateActivityItem dateActivityItemIn;
    private DateActivityItem dateActivityItemExpected;


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> variable() throws SQLException, ClassNotFoundException {
        Collection<Object[]> params = new ArrayList<>();
        // load the external params here
        // this is an example
        params.add(new Object[] { new java.sql.Date(System.currentTimeMillis()), new DateActivityItem(), new DateActivityItem() });

        return params;
    }


    /**
     * Constructeur (tests)
     * @param newDayIn
     */
    public DateActivityDAOTest(java.sql.Date newDayIn, DateActivityItem dateActivityItemIn, DateActivityItem dateActivityItemExpected) {
        this.newDayIn = newDayIn;
        this.dateActivityItemIn = dateActivityItemIn;
        this.dateActivityItemExpected = dateActivityItemExpected;
    }


    @Before
    public void initialize() throws ClassNotFoundException, SQLException, ParseException {

        MysqlConnection mysqlConnection = new MysqlConnection();
        mysqlConnection.connection();
        this.connection = mysqlConnection.getConnection();

        this.dateActivityDAO = new DateActivityDAO(this.connection);

        ReformatDate reformatDate;
        reformatDate = new ReformatDate();

        // convertion de la date en String avec perte des milli-secondes, secondes = souhaité ici
        String newDayInToString;
        newDayInToString = reformatDate.formatDateToString(this.newDayIn);
        // *** date redéfinie ici pour être adaptée aux valeurs sans les secondes, millisecondes (ex: 1624744800000) entrées en BDD
        this.newDayIn = reformatDate.formatStringToDate(newDayInToString);

        // *** valeur au format Long nécessaire aussi pour l'insert en BDD
        this.newDayStringToLong = reformatDate.formatStringToLong(newDayInToString);

    // *** Création d'un objet 'DateActivityItem' factice
        DatePart newDatePart;
        newDatePart = new DatePart();
        newDatePart.setDateValue(this.newDayIn);
        newDatePart.setDatePartValue(newDayStringToLong);

        this.dateActivityItemIn.setDatePart(newDatePart);
        this.dateActivityItemIn.setDateActivityDescription("Description Test");
        this.dateActivityItemIn.setDateActivityStatus("\"En test\"");

        this.logger.log(Level.INFO, () -> "connection ouverte, object DAO créé !"+ this.connection);
    }

    @After
    public void tearDown() throws SQLException {
        this.connection.close();

        this.logger.log(Level.INFO, () -> "connection fermée !"+ this.connection);
    }

    @Test
    public void findByDateNotNull() {

        this.dateActivityItemExpected = this.dateActivityDAO.findByDate(this.newDayIn, this.connection);

        // *** même si aucune donnée ne correspond au jour recherché, un objet 'dateActivityItem' est retourné par la classe DAO (avec des propriétés vides, sauf les champs 'id' = 0)
        assertNotNull(this.dateActivityItemExpected);
    }

    @Test
    public void findByDateEquals() {

        this.dateActivityItemExpected = this.dateActivityDAO.findByDate(this.newDayIn, this.connection);

        // *** même si aucune donnée ne correspond, un objet 'dateActivityItem' est retourné par la classe DAO
        // *** test des id renvoyés par un objet 'dateActivityItem' de la classe DAO (si aucune donnée correspondante au jour recherché, id = 0
        assertEquals(this.dateActivityItemExpected.getDatePart().getDatePartValue(), this.dateActivityItemExpected.getDatePart().getDatePartValue());
        assertEquals(this.dateActivityItemExpected.getDateActivityDescription(), this.dateActivityItemExpected.getDateActivityDescription());
        assertEquals(this.dateActivityItemExpected.getDateActivityStatus(), this.dateActivityItemExpected.getDateActivityStatus());
    }

    @Test
    public void createTrue() {
        assertTrue(this.dateActivityDAO.create(this.dateActivityItemIn));
    }

    @Test
    public void updateTrue() {
        this.dateActivityDAO.create(this.dateActivityItemIn);
        this.dateActivityItemIn = this.dateActivityDAO.findByDate(this.newDayIn, this.connection);
        assertTrue(this.dateActivityDAO.update(this.dateActivityItemIn));
    }

    @Test
    public void deleteTrue() {
        assertTrue(this.dateActivityDAO.delete(this.newDayStringToLong));
    }

    @Test
    public void find() {
        // méthode nécessaire ici (implémentation d'interface)
        this.logger.log(Level.INFO, () -> "find");
    }

}