package fr.cnam.pdatabase.managment.dao;

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
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;



@RunWith(Parameterized.class)
public class DateActivityDAOTest {

    /**
     * DateActivityDAO
     */
    private DateActivityDAO dateActivityDAO;

    /**
     * Connection
     */
    private Connection connection;

    /**
     * ReformatDate
     */
    private ReformatDate reformatDate;

    /**
     * java.sql.Date - pour tests à la date actuelle
     */
    private java.sql.Date newDayIn;
    private java.sql.Date newDayExpected;
    private DatePart newDatePart;

    /**
     * String - conversion de java.sql.Date en String (pour tests)
     */
    private String newDayInToString;

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
    public static Collection variable() throws SQLException, ClassNotFoundException {
        return Arrays.asList(new Object[][] {
                {
                        new java.sql.Date(System.currentTimeMillis()), new java.sql.Date(System.currentTimeMillis()), new DateActivityItem(), new DateActivityItem()
                },
        });
    }


    /**
     * Constructeur (tests)
     * @param newDayIn
     * @param newDayExpected
     */
    public DateActivityDAOTest(java.sql.Date newDayIn, java.sql.Date newDayExpected, DateActivityItem dateActivityItemIn, DateActivityItem dateActivityItemExpected) {
        this.newDayIn = newDayIn;
        this.newDayExpected = newDayExpected;
        this.dateActivityItemIn = dateActivityItemIn;
        this.dateActivityItemExpected = dateActivityItemExpected;
    }


    @Before
    public void initialize() throws Exception {

        MysqlConnection mysqlConnection = new MysqlConnection();
        mysqlConnection.connection();
        this.connection = mysqlConnection.getConnection();

        this.dateActivityDAO = new DateActivityDAO(this.connection);

        this.reformatDate = new ReformatDate();

        // convertion de la date en String avec perte des milli-secondes, secondes = souhaité ici
        this.newDayInToString = this.reformatDate.formatDateToString(this.newDayIn);
        // *** date redéfinie ici pour être adaptée aux valeurs sans les secondes, millisecondes (ex: 1624744800000) entrées en BDD
        this.newDayIn = this.reformatDate.formatStringToDate(this.newDayInToString);

        // *** valeur au format Long nécessaire aussi pour l'insert en BDD
        this.newDayStringToLong = this.reformatDate.formatStringToLong(this.newDayInToString);

    // *** Création d'un objet 'DateActivityItem' factice
        this.newDatePart = new DatePart();
        this.newDatePart.setDateValue(this.newDayIn);
        this.newDatePart.setDatePartValue(newDayStringToLong);

        this.dateActivityItemIn.setDatePart(this.newDatePart);
        this.dateActivityItemIn.setDateActivityDescription("Description Test");
        this.dateActivityItemIn.setDateActivityStatus("\"En test\"");

        System.out.println("connection ouverte, object DAO créé !");
    }

    @After
    public void tearDown() throws Exception {
        this.connection.close();
        System.out.println("connection fermée !");
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
        // méthode nécessaire comme cela (implémentation d'interface)
        // TODO implement here
    }

}