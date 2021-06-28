package fr.cnam.pactivity;

import fr.cnam.putils.ReformatDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class ActivityFormFrameTest {


    /**
     * ActivityFormFrame - Frame de Création d'Activité (static)
     */
    private static ActivityFormFrame activityFormFrame;

    /**
     * JLabel
     */
    private JLabel activityPanelLabel = new JLabel();

    /**
     * java.sql.Date - pour tests à la date actuelle
     */
    private java.sql.Date daySelectIn;

    /**
     * ReformatDate - pour le formatage de la date (java.sql.Date)
     */
    private ReformatDate reformatDate;

    /**
     * String - valeur de date au format 'DD/MM/YYYY'
     */
    private String dateValueIn;

    /**
     * String - valeur de date au format 'DD/MM/YYYY'
     */
    private String dateValueExpected;

    /**
     * java.sql.Date - pour tests à la date attendue
     */
    private java.sql.Date daySelectExpected;

    /**
     * String - description de l'activité
     */
    private String activityDescriptionIn;

    /**
     * String - description de l'activité
     */
    private String activityDescriptionExpected;

    /**
     * String - status de l'activité
     */
    private String activityStatusIn;

    /**
     * String - status de l'activité
     */
    private String activityStatusExpected;

    /**
     * Container
     */
    private Container activityFormContainer;


    /**
     * @return Collection - static
     */
    @Parameterized.Parameters
    public static Collection variable() throws SQLException, ClassNotFoundException {
        return Arrays.asList(new Object[][] {
                {
                        new java.sql.Date(System.currentTimeMillis()), new java.sql.Date(System.currentTimeMillis()), "26/06/2021", "26/06/2021", "", "", "En définition", "En définition"
                },
        });
    }


    /**
     * Constructeur (tests)
     * @param dateValueIn
     * @param dateValueExpected
     * @param activityDescriptionIn
     * @param activityDescriptionExpected
     * @param activityStatusIn
     * @param activityStatusExpected
     */
    public ActivityFormFrameTest(java.sql.Date daySelectIn, java.sql.Date daySelectExpected, String dateValueIn, String dateValueExpected, String activityDescriptionIn, String activityDescriptionExpected, String activityStatusIn, String activityStatusExpected) {

        activityFormFrame = new ActivityFormFrame();


        this.daySelectIn = daySelectIn;
        this.daySelectExpected = daySelectExpected;
        this.dateValueIn = dateValueIn;
        this.dateValueExpected = dateValueExpected;
        this.activityDescriptionIn = activityDescriptionIn;
        this.activityDescriptionExpected = activityDescriptionExpected;
        this.activityStatusIn = activityStatusIn;
        this.activityStatusExpected = activityStatusExpected;
    }


    @Before
    public void initialize() throws Exception {
        this.reformatDate = new ReformatDate();
    }


    @After
    public void tearDown() throws Exception {
        // TODO implement here
    }


    @Test
    public void buildActivityFormNotNull() {
        this.activityFormContainer = activityFormFrame.buildActivityForm();

        assertNotNull(this.activityFormContainer);
        assertNotNull(activityFormFrame.getActivityDescriptionText());
    }


    @Test
    public void buildActivityFormEquals() {
        this.activityFormContainer = activityFormFrame.buildActivityForm();

        assertEquals(new StringBuilder().append("java.awt.Container[,0,0,0x0,invalid,layout=java.awt.GridLayout]").toString(), this.activityFormContainer.toString());
    }


    @Test
    public void initFormFieldsWithDatasNotNull() {
        activityFormFrame.initFormFieldsWithDatas(this.dateValueIn, this.activityDescriptionIn, this.activityStatusIn);

        assertNotNull(activityFormFrame.getDateTextField());
        assertNotNull(activityFormFrame.getActivityDescriptionText());
    }


    @Test
    public void initFormFieldsWithDatasEquals() {
        activityFormFrame.initFormFields();

        this.dateValueIn = activityFormFrame.getDateTextField().getText();
        this.activityDescriptionIn = activityFormFrame.getActivityDescriptionText().getText();
        this.activityStatusIn = activityFormFrame.getActivityStatusText().getSelectedItem().toString();

        this.dateValueExpected = this.reformatDate.formatDateToString(this.daySelectIn);

        assertEquals(this.dateValueExpected, this.dateValueIn);
        assertEquals(this.activityDescriptionExpected, this.activityDescriptionIn);
        assertEquals(this.activityStatusExpected, this.activityStatusIn);
    }


    @Test
    public void initFormFieldsNotNull() {
        activityFormFrame.initFormFields();

        assertNotNull(activityFormFrame.getDateTextField());
    }

    @Test
    public void initFormFieldsEquals() {
        activityFormFrame.initFormFields();

        this.dateValueExpected = this.reformatDate.formatDateToString(this.daySelectIn);

        this.dateValueIn = activityFormFrame.getDateTextField().getText();
        this.activityDescriptionIn = activityFormFrame.getActivityDescriptionText().getText();
        this.activityStatusIn = activityFormFrame.getActivityStatusText().getSelectedItem().toString();

        assertEquals(this.dateValueExpected, this.dateValueIn);
        assertEquals(this.activityDescriptionExpected, this.activityDescriptionIn);
        assertEquals(this.activityStatusExpected, this.activityStatusIn);
    }




    @Test
    public void getActivityDescriptionText() {
        // TODO implement here
    }

    @Test
    public void setActivityDescriptionText() {
        // TODO implement here
    }

    @Test
    public void getActivityStatusText() {
        // TODO implement here
    }

    @Test
    public void setActivityStatusText() {
        // TODO implement here
    }

    @Test
    public void buildActivityFormTitle() {
        // TODO implement here
    }

    @Test
    public void getDateTextField() {
        // TODO implement here
    }

    @Test
    public void setDateTextField() {
        // TODO implement here
    }

    @Test
    public void displayActivityForm() {
        // TODO implement here
    }

    @Test
    public void actionPerformed() {
        // TODO implement here
    }
}