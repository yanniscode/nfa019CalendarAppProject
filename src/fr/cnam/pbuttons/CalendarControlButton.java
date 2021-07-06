package fr.cnam.pbuttons;

import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.putils.penums.ControlAction;
import fr.cnam.pmain.MainPanel;
import fr.cnam.putils.MonthPageIncrement;
import fr.cnam.putils.penums.ErrorMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static fr.cnam.pactivity.ActivityFormFrame.*;


/**
 * @author Yannis Guéguen
 */
public class CalendarControlButton extends JPanel implements CalendarControlButtonInterface, ActionListener {




    /**
     *  constructor 2: utilisé par ControlButtonsPanel pour le changement de mois (<, >)
     */
    public CalendarControlButton(String controlBtnValue, MainPanel mainPanel) {

        super();

        // ****** pour changer de mois (incrémentation de l'index de base (ControlButtonPanel) à chaque clic sur un des deux boutons
        this.mainPanel = mainPanel;

        this.controlButton = new JButton(controlBtnValue);
        this.controlButton.setPreferredSize(new Dimension(120, 60));

        this.controlButton.addActionListener(this);
        this.add(this.controlButton);
    }


    /**
     * constructor 1: (A FAIRE) utilisé par ControlButton 'EnterActivity' ??
     */
    public CalendarControlButton(String controlBtnValue) {

        super();

        this.controlButton = new JButton(controlBtnValue);
        this.controlButton.setPreferredSize(new Dimension(120, 60));

        this.controlButton.addActionListener(this);

        this.add(this.controlButton);
    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(CalendarControlButton.class.getSimpleName());

    /**
     * Connection - variable de connexion à MySql (indiquée 'transient' car variable non-sérializable)
     */
    private transient Connection connection;

    /**
     * MainPanel - mainPanel en param (à revoir si MainPanel = static -> nécessaire ??)
     */
    private MainPanel mainPanel;

    /**
     * Date - nouveau jour de référence (utilisé pour rendre inactif les boutons d'une page ne correspondant pas au mois)
     */
    private Date newReferenceDay;

    /**
     * MonthPageIncrement - renvoie un int (static) pour incrémenter ou décrémenter le mois affiché
     */
    private static MonthPageIncrement monthPageIncrement;


    /**
     * int - index du mois à afficher
     */
    private int indexMonth;


    // ********************

    /**
     * @param ev - méthode de déclenchement des évènements liés aux ControlButtons
     * @return void
     */
    public void actionPerformed(ActionEvent ev) {

        String activedButton;

        activedButton = ev.getActionCommand();


        if(activedButton.equals(ControlAction.LAST_MONTH)) {

            setLastMonthTitle();

            try {
                setLastMonthControl();
            } catch (SQLException | ClassNotFoundException e) {
                this.logger.log(Level.SEVERE, "Caught Exception: {0}", e.getStackTrace());
            }

        }
        else if(activedButton.equals(ControlAction.ADD_ACTIVITY)) {

            try {
                this.enterActivityMainFormPanel();
            }
            catch(Exception e) {
                this.logger.log(Level.SEVERE, ErrorMessage.BDD_CONNECT_ERROR, e.getStackTrace());
            }
        }
        else if(activedButton.equals(ControlAction.NEXT_MONTH)) {

            setNextMonthTitle();

            try {
                setNextMonthControl();
            } catch (SQLException | ClassNotFoundException e) {
                this.logger.log(Level.SEVERE, ErrorMessage.BDD_CONNECT_ERROR, e.getStackTrace());
            }
        }

    }




    /**
     * @return void - ouvrir une fenêtre (JFrame) d'édition d'une activité
     */
    public void enterActivityMainFormPanel() {

        // *** si une fenêtre 'activityFormPanel' est déjà visible, on ne peut en créer une nouvelle (la première est initialisée dans le constructeur)
        // *** ré-initialisation des champs de ActivityFormFrame (à chaque réouverture):
        activityFormFrame .initFormFields();

        activityFormFrame.setVisible(true);
    }


    /**
     * @return void - applique l'intitulé du mois suivant
     */
    public void setNextMonthTitle() {

        this.mainPanel.getCalendarPanel().removeAllDaysFromCalendarPanel();
        this.mainPanel.getCalendarPanel().removeAllFromDaysList();

        // *** ON RETROUVE LE JOUR DE RÉFÉRENCE DU MOIS PRÉCÉDENT: (UN MOIS AVANT DATE ACTUELLE)
        DatePart newDatePart;
        newDatePart = new DatePart();

        monthPageIncrement.pushIncrementValue(1);

        // *** appel du 'getter' de la classe MonthPageIncrement (putils)
        this.indexMonth = monthPageIncrement.getIncrementValue();


        this.newReferenceDay = newDatePart.getOneMonthInterval(this.indexMonth);

        // ******** Ajout  du titre du mois précédent au CalendarPanel (string):
        this.mainPanel.getCalendarPanel().buildNewMonthLabel(this.newReferenceDay);

        this.mainPanel.add( this.mainPanel.getCalendarPanel());
    }


    /**
     * @return void - applique les DateButtons du mois suivant
     */
    public void setNextMonthControl() throws SQLException, ClassNotFoundException {

        List<DateButton> newDatesList = new ArrayList<>();

        this.connection =  this.mainPanel.getCalendarPanel().getConnection();

        for(int i = 0; i < 41; i++) {

            // *** Recherche du premier lundi affiché dans une page de CalendarPanel
            DateButton newDateButton = new DateButton(this.indexMonth, i, this.connection);
            newDatesList.add(newDateButton);
        }

        // *** création de la liste de boutons avec les dates du mois actuel
        this.mainPanel.getCalendarPanel().buildDaysList(newDatesList);

        // *** update des boutons ayant une activité déjà enregistré avant l'affichage de la page
        this.mainPanel.add(this.mainPanel.getCalendarPanel());
    }


    /**
     * @return void - applique l'intitulé du mois dernier
     */
    public void setLastMonthTitle() {

        this.mainPanel.getCalendarPanel().removeAllDaysFromCalendarPanel();
        this.mainPanel.getCalendarPanel().removeAllFromDaysList();

        DatePart newDatePart;
        newDatePart= new DatePart();

        monthPageIncrement.pushIncrementValue(-1);

        this.indexMonth = monthPageIncrement.getIncrementValue();


        // *** ON RETROUVE UN JOUR DE RÉFÉRENCE DU MOIS PRÉCÉDENT: (UN MOIS AVANT AUJOURD'HUI)
        this.newReferenceDay = newDatePart.getOneMonthInterval(this.indexMonth);

        // ******** AJOUT DU MOIS AU CALENDAR PANEL (STRING)
        this.mainPanel.getCalendarPanel().buildNewMonthLabel(this.newReferenceDay);

        this.mainPanel.add(this.mainPanel.getCalendarPanel());
    }


    /**
     * @return void - applique les DateButtons du mois dernier
     */
    public void setLastMonthControl() throws SQLException, ClassNotFoundException {

        List<DateButton> newDatesList= new ArrayList<>();

        this.connection =  this.mainPanel.getCalendarPanel().getConnection();

        for(int i = 0; i < 41; i++) {

            DateButton newDateButton = new DateButton(this.indexMonth, i, this.connection);
            // *** méthode pour griser les jours qui ne sont pas du mois:
            newDatesList.add(newDateButton);

        }

        // *** Création de la liste de boutons avec les dates du mois actuel:
        this.mainPanel.getCalendarPanel().buildDaysList(newDatesList);
        this.mainPanel.add(this.mainPanel.getCalendarPanel());
    }


    /**
     * JButton - bouton de Contrôle ("Mois Précédent", "Editer une activité", "Mois Suivant")
     */
    private JButton controlButton;

    /**
     * String - Valeur du bouton
     */
    private String controlBtnValue;


    /**
     * @return JButton - bouton déclenché
     */
    public JButton getControlButton() {
        return this.controlButton;
    }

    /**
     * @param controlButton
     * @return void
     */
    public void setControlButton(JButton controlButton) {
        this.controlButton = controlButton;
    }

    /**
     * @return String - valeur du bouton déclenché
     */
    public String getControlBtnValue() {
        return this.controlBtnValue;
    }

    /**
     * @param controlBtnValue
     * @return void
     */
    public void setControlBtnValue(String controlBtnValue) {
        this.controlBtnValue = controlBtnValue;
    }

    /**
     * @return void
     */
    @Override
    public void displayCalendarControlButton() {
        this.logger.log(Level.INFO, () -> ErrorMessage.BDD_CONNECT_ERROR + this.controlBtnValue);
    }

}