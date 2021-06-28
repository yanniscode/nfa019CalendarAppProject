package fr.cnam.pbuttons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FormControlButtonTest {


    /**
     * FormControlButton
     */
    private FormControlButton formControlButton;


    /**
     * boolean - pour les tests de connexion
     */
    private boolean connectResponse;


    /**
     * @return Collection - static
     */
    @Parameterized.Parameters
    public static Collection variable() throws SQLException, ClassNotFoundException {
        return Arrays.asList(new Object[][] {
        });
    }


    /**
     * Constructeur (tests)
     */
    public FormControlButtonTest() {
        this.formControlButton =  new FormControlButton();
    }



    @Before
    public void initialize() throws Exception {
        // TODO implement here
    }

    @After
    public void tearDown() throws Exception {
        // TODO implement here
    }

    @Test
    public void actionPerformed() {
        // TODO implement here
    }


    // ***
    @Test
    public void onSuppressionFunction() throws SQLException, ParseException, ClassNotFoundException {
        this.connectResponse = this.formControlButton.onSuppressionFunction();
        assertTrue(connectResponse);
    }


    // ***
    @Test
    public void onValidateFunction() throws SQLException, ParseException, ClassNotFoundException {
        this.connectResponse = this.formControlButton.onValidateFunction();
        assertTrue(connectResponse);
    }


    @Test
    public void setMainPanel() {
        // TODO implement here
    }

    @Test
    public void getFormControlBtnIcon() {
        // TODO implement here
    }

    @Test
    public void setFormControlBtnIcon() {
        // TODO implement here
    }


    @Test
    public void displayFormControlBtn() {
        // TODO implement here
    }

}