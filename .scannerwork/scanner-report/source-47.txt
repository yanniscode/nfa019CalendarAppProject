package fr.cnam.perrors;



/**
 * @author Yannis Guéguen
 */
public class FormErrorPanel implements FormErrorPanelInterface {

    /**
     * Default constructor
     */
    public FormErrorPanel() {
        // TODO implement here
    }


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
        // TODO implement here
        return "";
    }

    /**
     * @param errorMessage 
     * @return void
     */
    public void setErrorMessage(String errorMessage) {
        // TODO implement here
    }

    @Override
    /**
     * @return void
     */
    public void displayErrorPanel() {
        // TODO implement here
    }

}