package fr.cnam.pdatabase;

import fr.cnam.pbuttons.CalendarControlButton;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertNotNull;


@RunWith(Parameterized.class)
public class MysqlConnectionTest {

    /**
     * Logger - messages d'erreur ou informatifs
     */
    private Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());

    /**
     * Connection
     */
    private MysqlConnection mySqlConnection;

    /**
     * Connection
     */
    private Connection connection;

    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> variable() throws ClassNotFoundException {
        Collection<Object[]> params = new ArrayList<>();
        // load the external params here
        // this is an example
        params.add(new Object[] { new MysqlConnection() });

        return params;
    }


    /**
     * Constructeur (tests)
     */
    public MysqlConnectionTest(MysqlConnection mysqlConnection) {
        this.mySqlConnection = mysqlConnection;
    }


    // *** initialisation d'une connection à chaque test
    @Before
    public void initialize() throws SQLException, ClassNotFoundException {
        this.mySqlConnection = new MysqlConnection();
        this.mySqlConnection.connection();
        this.connection = mySqlConnection.getConnection();

        this.logger.log(Level.INFO, () -> "connection ouverte !"+ this.connection);
    }

    // *** fermeture de la connection à la fin de chaque test
    @After
    public void tearDown() throws SQLException {

        this.connection.close();

        this.logger.log(Level.INFO, () -> "connection fermée ! "+ this.connection);
    }

    @Test
    public void getMysqlConnexionInstanceNotNull() {
        assertNotNull(this.connection);
    }

}