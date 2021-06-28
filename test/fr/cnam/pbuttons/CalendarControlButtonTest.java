package fr.cnam.pbuttons;

import fr.cnam.pmain.MainPanel;
import fr.cnam.putils.penums.ControlAction;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;


import static fr.cnam.pactivity.ActivityFormFrame.activityFormFrame;
import static org.junit.Assert.*;



@RunWith(Parameterized.class)
public class CalendarControlButtonTest extends JPanel {


    /**
     * CalendarControlButtonsPanel
     */
    private CalendarControlButtonsPanel controlButtonsPanel;

    /**
     * JButton
     */
    private JButton controlBtnIn;

    /**
     * JButton
     */
    private JButton controlBtnExpected;

    /**
     * ControlButton
     */
    private CalendarControlButton controlButton;

    /**
     * MainPanel - mainPanel en param (à revoir si MainPanel = static -> nécessaire ??)
     */
    private MainPanel mainPanel;

    /**
     * String - valeur du bouton activé
     */
    private String activedBtnValueIn;

    /**
     * String - valeur du bouton activé
     */
    private String activedBtnValueExpected;


    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() {
        return Arrays.asList(new Object[][] {
                {
                        ControlAction.LAST_MONTH, ControlAction.LAST_MONTH, new JButton(), new JButton()
                },
        });
    }

    public CalendarControlButtonTest(String activedBtnValueIn, String activedBtnValueExpected, JButton controlBtnIn, JButton controlBtnExpected) {

        super();

        this.activedBtnValueIn = activedBtnValueIn;
        this.activedBtnValueExpected = activedBtnValueExpected;
        this.controlBtnIn = controlBtnIn;
        this.controlBtnExpected = controlBtnExpected;
    }

    @Before
    public void initialize() throws SQLException, ClassNotFoundException {

        this.mainPanel = new MainPanel();

        this.controlButtonsPanel = new CalendarControlButtonsPanel(this.mainPanel);

        // *** instanciation de la classe liée pour les tests:
        this.controlButton = new CalendarControlButton(this.activedBtnValueIn, this.mainPanel);

        this.controlButtonsPanel.setBtn(this.controlButton);
    }

    @After
    public void tearDown() throws Exception {
        // TODO implement here
    }

    @Test
    public void actionPerformedEquals() {
        // pas réussi à récupérer la valeur (cause : comment récupérer le param, dans 'actionPerformed(ActionEvent ev)' ??)
        // TODO implement here
    }

    @Test
    public void getButtonValueFromControlPanelEquals() {
        assertEquals(this.activedBtnValueExpected, this.controlButtonsPanel.getBtn().getControlButton().getActionCommand());
    }

    @Test
    public void getButtonValuePanelEquals() {
        assertEquals(this.controlBtnExpected.getActionCommand(), this.controlBtnIn.getActionCommand());
    }

    @Test
    public void setNextMonthTitle() {
        this.controlButton.setNextMonthTitle();
    }

    @Test
    public void getControlButtonNotNull() {
        // *** instanciation dans le Constructeur, par ex...)
        this.controlBtnExpected = this.controlButton.getControlButton();
        assertNotNull(this.controlBtnExpected);
    }

    @Test
    public void setToGetControlButtonEquals() {
        // **** test 'get' de JButton avec 'setter':
        this.controlButton.setControlButton(this.controlBtnIn);
        assertEquals(this.controlBtnExpected.toString(), this.controlButton.getControlButton().toString());
    }

    @Test
    public void getControlBtnValueNull() {
        // **** test 'get' de JButton sans 'setter' = null
        // *** un 'get' sans 'set' = null, ici (pas d'instanciation dans le Constructeur, par ex...)
        this.activedBtnValueExpected = this.controlButton.getControlBtnValue();
        assertNull(this.activedBtnValueExpected);
    }

    @Test
    public void setToGetControlBtnValueEquals() {
        // **** test 'get' de texte d'un JButton avec 'setter':
        this.controlButton.setControlBtnValue(this.activedBtnValueIn);
        assertEquals(this.activedBtnValueExpected.toString(), this.controlButton.getControlBtnValue().toString());
    }

    @Test
    public void enterActivityMainFormPanelNotNull() {
        assertNotNull(activityFormFrame.toString());
    }

}