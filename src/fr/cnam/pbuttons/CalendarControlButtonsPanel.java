package fr.cnam.pbuttons;

import fr.cnam.psharedinterfaces.ControlButtonsPanelInterface;
import fr.cnam.putils.penums.ControlAction;
import fr.cnam.pmain.MainPanel;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Yannis Guéguen
 */
public class CalendarControlButtonsPanel extends JPanel implements ControlButtonsPanelInterface {


    /**
     * Default constructor
     */
    public CalendarControlButtonsPanel(MainPanel mainPanel) {

        super();

        this.mainPanel = mainPanel;

        // *** note: le MainPanel est passé en paramètre aux ControlButtons directionnels car c'est par lui qu'on accède aux propriétés de 'CalendarPanel()' sur lequel agissent les ControlButtons:
        this.leftBtn = new CalendarControlButton(ControlAction.LAST_MONTH, this.mainPanel);
        this.enterActivityBtn = new CalendarControlButton(ControlAction.ADD_ACTIVITY);
        this.rightBtn = new CalendarControlButton(ControlAction.NEXT_MONTH, this.mainPanel);

        add(this.leftBtn);
        add(this.enterActivityBtn);
        add(this.rightBtn);
    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(CalendarControlButtonsPanel.class.getSimpleName());

    /**
     * MainPanel
     */
    private MainPanel mainPanel;

    /**
     * ControlButton
     */
    private CalendarControlButton leftBtn;

    /**
     * ControlButton
     */
    private CalendarControlButton enterActivityBtn;

    /**
     * ControlButton
     */
    private CalendarControlButton rightBtn;

    /**
     * CalendarControlButton
     */
    private CalendarControlButton button;

    /**
     *
     * @return CalendarControlButton - pour les tests
     */
    public CalendarControlButton getBtn(){
        return this.button;
    }

    /**
     * @param button
     * @return void - pour les tests
     */
    public void setBtn(CalendarControlButton button){
        this.button = button;
    }


    @Override
    /**
     * @return void
     */
    public void displayControlButtons() {
        this.logger.log(Level.INFO, () -> "info (displayControlButtons): "+ this.leftBtn +" "+ this.enterActivityBtn +" "+ this.rightBtn);
    }

}