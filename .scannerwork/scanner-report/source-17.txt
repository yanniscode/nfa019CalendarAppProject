package fr.cnam.penums;

import fr.cnam.perrors.FormErrorPanel;

import java.util.*;

/**
 * @author Yannis Guéguen
 */
public class ErrorMessage {

    /**
     * Default constructor
     */
    public ErrorMessage() {
    }

    /**
     * 
     */
    protected String DATA_ERROR = "Données saisies erronées";

    /**
     * 
     */
    protected String BDD_CONNECT_ERROR = "Erreur de connexion à la BDD";

    /**
     * 
     */
    public String BDD_TIMEOUT_RECORD = "Durée de connexion à la BDD dépassée";

    /**
     * 
     */
    public FormErrorPanel compose;


}