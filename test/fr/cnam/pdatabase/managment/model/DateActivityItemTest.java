package fr.cnam.pdatabase.managment.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class DateActivityItemTest {


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
    public DateActivityItemTest() {
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
    public void getDatePart() {
        // TODO implement here
    }

    @Test
    public void setDatePart() {
        // TODO implement here
    }

    @Test
    public void getDateActivityId() {
        // TODO implement here
    }

    @Test
    public void setDateActivityId() {
        // TODO implement here
    }

    @Test
    public void getDateActivityDescription() {
        // TODO implement here
    }

    @Test
    public void setDateActivityDescription() {
        // TODO implement here
    }

    @Test
    public void getDateActivityStatus() {
        // TODO implement here
    }

    @Test
    public void setDateActivityStatus() {
        // TODO implement here
    }

    @Test
    public void displayActivity() {
        // TODO implement here
    }

}