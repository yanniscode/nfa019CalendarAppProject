package fr.cnam.pdatabase.managment.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class DAOTest {

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
    public DAOTest() {
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
    public void create() {
        // TODO implement here
    }

    @Test
    public void update() {
        // TODO implement here
    }

    @Test
    public void delete() {
        // TODO implement here
    }

    @Test
    public void find() {
        // TODO implement here
    }
}