package fr.cnam.perrors;

import fr.cnam.pbuttons.FormControlButtonInterface;

/**
 * @author Yannis Guéguen
 */
public class ReturnButton implements FormControlButtonInterface {

    /**
     * Default constructor
     */
    public ReturnButton() {
    }

    /**
     * String - valeur du bouton de sortie du formulaire sans modification apportée
     */
    protected String returnButtonValue = "Retour";


    @Override
    /**
     * @return void
     */
    public void displayFormControlBtn() {
        // TODO implement here
        return;
    }

}