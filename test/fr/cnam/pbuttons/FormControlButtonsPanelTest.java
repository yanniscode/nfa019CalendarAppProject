package fr.cnam.pbuttons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FormControlButtonsPanelTest {

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
    public FormControlButtonsPanelTest() {
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
    public void displayControlButtons() {
        // TODO implement here
    }

}