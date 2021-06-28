package fr.cnam.pdatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class MysqlConnectionTest {


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() throws SQLException, ClassNotFoundException {
        return Arrays.asList(new Object[][] {
        });
    }


    /**
     * Constructeur (tests)
     */
    public MysqlConnectionTest() {
        // TODO implement here
    }







    @Before
    public void setUp() throws Exception {
        // TODO implement here
    }

    @After
    public void tearDown() throws Exception {
        // TODO implement here
    }

    @Test
    public void connection() {
        // TODO implement here
    }

    @Test
    public void getConnection() {
        // TODO implement here
    }

    @Test
    public void setConnection() {
        // TODO implement here
    }

    @Test
    public void getMysqlConnexionInstance() {
        // TODO implement here
    }

}