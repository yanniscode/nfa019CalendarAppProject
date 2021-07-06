package fr.cnam.putils.penums;

/**
 * @author Yannis Guéguen
 */
public class ErrorMessage {

    /**
     * Default constructor
     */
    private ErrorMessage() {
        super();
    }


    /**
     * String - valeur du message d'erreur
     */
    public static final String BDD_CONNECT_ERROR = "Caught Exception: {0} - Erreur de connexion à la BDD";

    /**
     * String - valeur du message d'erreur
     */
    public static final String BDD_TIMEOUT_RECORD = "Caught Exception: {1} - Durée de connexion à la BDD dépassée";

    /**
     * String - valeur du message d'erreur
     */
    public static final String DATA_ERROR = "Caught Exception: {2} - Données saisies erronées";

    /**
     * String - valeur du message d'erreur
     */
    public static final String CLICK_ERROR = "Caught Exception: {3} - Données saisies erronées";

}