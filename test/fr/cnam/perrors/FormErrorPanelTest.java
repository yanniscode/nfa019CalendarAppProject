package fr.cnam.perrors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class FormErrorPanelTest {


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() {
        return Arrays.asList(new Object[][] {
        });
    }


    /**
     * Constructeur (tests)
     */
    public FormErrorPanelTest() {
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
    public void getErrorMessage() {
        // TODO implement here
    }

    @Test
    public void setErrorMessage() {
        // TODO implement here
    }

    @Test
    public void displayErrorPanel() {
        // TODO implement here
    }

}