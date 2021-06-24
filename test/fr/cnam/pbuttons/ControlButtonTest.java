package fr.cnam.pbuttons;

import fr.cnam.pmain.MainPanel;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;


import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ControlButtonTest extends JPanel{

    /**
     * @return
     */
    @Parameterized.Parameters
    public static Collection variable() {
        return Arrays.asList(new Object[][] {
//                {
//                        "<" , null
//                },
                {
                        "<", "<", new JButton(), new JButton()
                },
//                {
//                        ">", ">", new JButton(">"), new JButton("<")
//                }
        });
    }

    public ControlButtonTest(String activedBtnValueIn, String activedBtnValueExpected, JButton controlBtnIn, JButton controlBtnExpected) {
        super();

        this.activedBtnValueIn = activedBtnValueIn;
        this.activedBtnValueExpected = activedBtnValueExpected;
        this.controlBtnIn = controlBtnIn;
//        this.controlBtnIn.setText(this.activedButtonIn);
        this.controlBtnExpected = controlBtnExpected;
//        this.controlBtnExpected.setText(this.activedButtonExpected);

//        this.controlBtnIn.addActionListener(this.controlButton);  // PASSE PAS
    }



    // ******************* ajouts:
    // MARCHE PAS:
//    ActionEvent evIn = java.awt.event.ActionEvent[ACTION_PERFORMED,cmd=<,when=1623836628830,modifiers=Button1] on javax.swing.JButton[,5,5,44x25,alignmentX=0.0,alignmentY=0.5,border=javax.swing.plaf.BorderUIResource$CompoundBorderUIResource@3dc06754,flags=296,maximumSize=,minimumSize=,preferredSize=,defaultIcon=,disabledIcon=,disabledSelectedIcon=,margin=javax.swing.plaf.InsetsUIResource[top=2,left=14,bottom=2,right=14],paintBorder=true,paintFocus=true,pressedIcon=,rolloverEnabled=true,rolloverIcon=,rolloverSelectedIcon=,selectedIcon=,text=<,defaultCapable=true];

    private CalendarControlButtonsPanel controlButtonsPanel;

    /**
     * JButton
     */
    private JButton controlBtnIn;
    private JButton controlBtnExpected;

    /**
     * ActionEvent
     */
//    ActionEvent evIn = new ActionEvent();

    /**
     * ControlButton
     */
    private CalendarControlButton controlButton;

    /**
     * String
     */
//    private String controlBtnValue;

    /**
     * MainPanel - mainPanel en param (à revoir si MainPanel = static -> nécessaire ??)
     */
    private static MainPanel mainPanel;

    /**
     * String - valeur du bouton activé
     */
    private String activedBtnValueIn;
    private String activedBtnValueExpected;

    /**
     * Date - nouveau mois de référence
     */
    private static Date newMonthRef;

    /**
     * Calendar - nouveau calendrier
     */
    private Calendar newCalendar;

    /**
     * int (static) - index du mois (varie selon les boutons directionnels)
     */
    private static int monthIndex; // *** index 'static' - 1 = mois actuel

    /**
     * Date - nouveau jour de référence (utilisé pour rendre inactif les boutons d'une page ne correspondant pas au mois
     */
    private static Date newReferenceDay;

    @Before
    public void initialize() throws SQLException, ClassNotFoundException {

        this.mainPanel = new MainPanel();
        this.controlButtonsPanel = new CalendarControlButtonsPanel(this.mainPanel);
        // *** instanciation de la classe liée pour les tests:
        this.controlButton = new CalendarControlButton(this.activedBtnValueIn, this.mainPanel);

        this.controlButtonsPanel.setBtn(this.controlButton);

     //   this.controlBtnIn = new JButton(this.activedBtnValueIn);
       // this.controlBtnExpected = new JButton(this.activedBtnValueIn);

//        this.controlButton.setControlButton(this.controlBtnIn);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void actionPerformedEquals() {
        // pas réussi à récupérer la valeur (cause : comment récupérer le param, dans 'actionPerformed(ActionEvent ev)' ??)
    }

    @Test
    public void getButtonValueFromControlPanelEquals() {
//        System.out.println("activ #########################"+ this.controlButtonsPanel.getBtn().getControlButton().getActionCommand());
//        System.out.println("activ #########################"+ this.activedBtnValueExpected);
        assertEquals(this.activedBtnValueExpected, this.controlButtonsPanel.getBtn().getControlButton().getActionCommand());
    }

    @Test
    public void getButtonValuePanelEquals() {
//        System.out.println("activ #########################"+ this.controlBtnIn.getActionCommand());
//        System.out.println("activ #########################"+ this.activedBtnValueExpected);
        assertEquals(this.controlBtnExpected.getActionCommand(), this.controlBtnIn.getActionCommand());
    }

    // *** testable directement ??
    @Test
    public void setNextMonthTitle() {
        this.controlButton.setNextMonthTitle();
//        System.out.println("################# "+ this.controlBtnIn.getActionCommand());
//        assertThrows(this.controlButton.setNextMonthTitle());
    }

//    @Test
//    public void setNextMonthControl() {
//        this.controlButton.setNextMonthControl();
//    }
//
//    @Test
//    public void setLastMonthTitle() {
//        this.controlButton.setLastMonthTitle();
//    }
//
//    @Test
//    public void setLastMonthControl() {
//        this.controlButton.setLastMonthControl();
//    }

    @Test
    public void getControlButtonNotNull() {
        // *** instanciation dans le Constructeur, par ex...)
        this.controlBtnExpected = this.controlButton.getControlButton();
        assertNotNull(this.controlBtnExpected);
    }

    @Test
    public void setToGetControlButtonEquals() {
        // **** test 'get' de JButton avec 'setter':
//        System.out.println("controlbtnin = ********************** "+ this.controlBtnIn);
//        System.out.println(this.controlBtnExpected);
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

}