package fr.cnam.pinfos;


import fr.cnam.pactivity.ActivityFormFrame;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yannis Guéguen
 */
public class FormErrorPanel implements FormErrorPanelInterface {

    /**
     * Default constructor
     */
    public FormErrorPanel() {
        super();
    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(ActivityFormFrame.class.getSimpleName());

    /**
     * String
     */
    private String errorMessage;

    /**
     * ReturnButton
     */
    protected ReturnButton returnButton;



    /**
     * @return String
     */
    public String getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * @param errorMessage 
     * @return void
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    /**
     * @return void
     */
    public void displayErrorPanel() {
        this.logger.log(Level.INFO, () -> "info (displayErrorPanel): "+ this.errorMessage);
    }

}