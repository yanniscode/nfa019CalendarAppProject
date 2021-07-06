package fr.cnam.pinfos;

import fr.cnam.pactivity.ActivityFormFrame;
import fr.cnam.pbuttons.FormControlButtonInterface;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yannis Guéguen
 */
public class ReturnButton implements FormControlButtonInterface {

    /**
     * Default constructor
     */
    public ReturnButton() {
        super();
    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(ActivityFormFrame.class.getSimpleName());

    /**
     * String - valeur du bouton de sortie du formulaire sans modification apportée
     */
    protected String returnButtonValue = "Retour";


    @Override
    /**
     * @return void
     */
    public void displayFormControlBtn() {
        this.logger.log(Level.INFO, () -> "info (displayFormControlBtn): "+ this.returnButtonValue);
    }

}