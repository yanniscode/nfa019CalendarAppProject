package fr.cnam.pbuttons;

import fr.cnam.pactivity.ActivityFormFrame;
import fr.cnam.psharedinterfaces.ControlButtonsPanelInterface;
import fr.cnam.putils.penums.FormControlAction;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Yannis Guéguen
 */
public class FormControlButtonsPanel extends JPanel implements ControlButtonsPanelInterface {


    /**
     * Default constructor
     */
    public FormControlButtonsPanel() {

        Container validationContainer = new Container();
        GridLayout validateActivityLayout = new GridLayout(0,3  , 10, 0);    // *** ligne = 0, sinon, pas de prise en compte des colonnes
        validationContainer.setLayout(validateActivityLayout);

        // ****** partie boutons (validation, suppression, annulation)
        annulationButton = new FormControlButton(FormControlAction.ANNULATION);
        annulationButton.setBackground(Color.LIGHT_GRAY);

        validationButton = new FormControlButton(FormControlAction.VALIDATION);
        validationButton.setBackground(Color.ORANGE);

        suppressionButton = new FormControlButton(FormControlAction.SUPPRESSION);
        suppressionButton.setBackground(Color.LIGHT_GRAY);

        validationContainer.add(annulationButton);
        validationContainer.add(validationButton);
        validationContainer.add(suppressionButton);

        this.add(validationContainer);
    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(ActivityFormFrame.class.getSimpleName());

    /**
     * FormControlButton (static)
     */
    private FormControlButton annulationButton;


    /**
     * FormControlButton (static)
     */
    private FormControlButton validationButton;


    /**
     * FormControlButton (static)
     */
    private FormControlButton suppressionButton;


    @Override
    public void displayControlButtons() {
        this.logger.log(Level.INFO, () -> "info (displayControlButtons): "+ this.annulationButton +" - "+ this.validationButton +" - "+ this.suppressionButton);
    }

}