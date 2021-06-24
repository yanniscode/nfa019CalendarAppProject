package fr.cnam.pactivity;

import fr.cnam.pbuttons.FormControlButton;
import fr.cnam.psharedinterfaces.ControlButtonsPanelInterface;
import fr.cnam.putils.penums.FormControlAction;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yannis Guéguen
 */
public class FormControlButtonsPanel extends JPanel implements ControlButtonsPanelInterface {


    /**
     * Default constructor
     */
    public FormControlButtonsPanel() {

        Container validationContainer = new Container();
        GridLayout ValidateActivityLayout = new GridLayout(0,3  , 10, 0);    // *** ligne = 0, sinon, pas de prise en compte des colonnes
        validationContainer.setLayout(ValidateActivityLayout);

        // ****** partie boutons (validation, suppression, annulation)

//        glActivityForm.setColumns(3);

        this.annulationButton = new FormControlButton(FormControlAction.ANNULATION);
        this.annulationButton.setBackground(Color.LIGHT_GRAY);

        // ***********

        this.validationButton = new FormControlButton(FormControlAction.VALIDATION);
        this.validationButton.setBackground(Color.ORANGE);
        // ***********

        this.suppressionButton = new FormControlButton(FormControlAction.SUPPRESSION);
        this.suppressionButton.setBackground(Color.LIGHT_GRAY);


        // ***********

        validationContainer.add(this.annulationButton);
        validationContainer.add(this.validationButton);
        validationContainer.add(this.suppressionButton);

        this.add(validationContainer);
    }



    /**
     *
     */
    private FormControlButton annulationButton;

    /**
     * 
     */
    private FormControlButton validationButton;

    /**
     *
     */
    private FormControlButton suppressionButton;


    @Override
    public void displayControlButtons() {
        // à voir
    }
}