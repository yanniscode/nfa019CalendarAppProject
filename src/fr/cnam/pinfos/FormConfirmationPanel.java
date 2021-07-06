package fr.cnam.pinfos;


import fr.cnam.pactivity.ActivityFormFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yannis Guéguen
 */
public class FormConfirmationPanel implements FormErrorPanelInterface {

    /**
     * Default constructor
     */
    public FormConfirmationPanel() {
        super();
    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(ActivityFormFrame.class.getSimpleName());

    /**
     * String
     */
    private String confirmationMessage;


    /**
     * @return String
     */
    public String getConfirmationMessage() {
        return this.confirmationMessage;
    }


    /**
     * @param confirmationMessage
     * @return void
     */
    public void setConfirmationMessage(String confirmationMessage) {
        this.confirmationMessage = confirmationMessage;
    }


    /**
     * @return void
     */
    public void displayFormConfirmationPanel() {
        this.logger.log(Level.INFO, () -> "info (displayFormConfirmationPanel): "+ this.confirmationMessage);
    }


    /**
     * @return void
     */
    public void displayErrorPanel() {
        this.logger.log(Level.INFO, () -> "info (displayErrorPanel): "+ this.confirmationMessage);
    }

}