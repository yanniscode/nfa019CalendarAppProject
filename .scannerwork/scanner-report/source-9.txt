package fr.cnam.pbuttons;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
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
    public static Collection<Object[]> variable() {
        Collection<Object[]> params = new ArrayList<>();
        // load the external params here
        // this is an example
        params.add(new Object[] {});

        return params;
    }


    /**
     * Constructeur (tests)
     */
    public FormControlButtonTest() {
        this.formControlButton =  new FormControlButton();
    }


    @Test
    public void onSuppressionFunction() throws SQLException, ParseException, ClassNotFoundException {
        this.connectResponse = this.formControlButton.onSuppressionFunction();
        assertTrue(connectResponse);
    }

    @Test
    public void onValidateFunction() throws SQLException, ParseException, ClassNotFoundException {
        this.connectResponse = this.formControlButton.onValidateFunction();
        assertTrue(connectResponse);
    }

}