package fr.cnam.pactivity;

import fr.cnam.pbuttons.FormControlButtonsPanel;
import fr.cnam.putils.ReformatDate;
import fr.cnam.putils.penums.ActivityStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Yannis Guéguen
 */
public class ActivityFormFrame extends JFrame implements ActivityFormPanelInterface, ActionListener {

    /**
     * Default constructor
     */
    public  ActivityFormFrame() {

        GridLayout glActivityMainFormPanel = new GridLayout(0,1, 20, 80); // *** lignes (rows) = 0, sinon, pas de prise en compte des colonnes


        this.setLayout(glActivityMainFormPanel);
        this.setSize(960, 540);
        this.setLocation(480,270);

        String activityFormTitle = "Edition d'une Activité";
        this.setTitle(activityFormTitle);

        Container activityFormTitleContainer = this.buildActivityFormTitle();
        this.add(activityFormTitleContainer);

        Container activityFormContainer = this.buildActivityForm();
        this.add(activityFormContainer);

        FormControlButtonsPanel formControlButtonsPanel = new FormControlButtonsPanel();
        this.add(formControlButtonsPanel);

    }


    /**
     * Logger - messages d'erreur ou informatifs
     */
    private transient Logger logger = Logger.getLogger(ActivityFormFrame.class.getSimpleName());

    /**
     * ActivityFormFrame - Frame de Création d'Activité (static)
     */
    public static final ActivityFormFrame activityFormFrame;

    /**
     * initialisation du la Frame de Création d'Activité (static)
     */
    static {
        activityFormFrame = new ActivityFormFrame();
    }


    /**
     * JTextField - champs de saisie de la date (JJ/MM/YYYY) - obligatoire
     */
    private JTextField dateTextField;

    /**
     * JTextArea - champs de saisie de la description de l'activité à enregistrer - obligatoire
     */
    private JTextField activityDescriptionText;

    private static final String TYPOGRAPHY = "Serif";

    /**
     * @return JTextField
     */
    public JTextField getActivityDescriptionText() {
        return this.activityDescriptionText;
    }

    /**
     * @param activityDescriptionText
     * @return void
     */
    public void setActivityDescriptionText(JTextField activityDescriptionText) {
        this.activityDescriptionText = activityDescriptionText;
    }

    /**
     * JComboBox<String> - liste des status possibles pour une activité - obligatoire
     */
    private JComboBox<String> activityStatusText;

    /**
     * @return JComboBox<String>
     */
    public JComboBox<String> getActivityStatusText() {
        return this.activityStatusText;
    }

    /**
     * @param activityStatus
     * @return void
     */
    public void setActivityStatusText(String activityStatus) {

        if (activityStatus.equals("\""+ ActivityStatus.TO_DO +"\"")) {
            this.activityStatusText.setSelectedIndex(0);
        } else if (activityStatus.equals("\""+ ActivityStatus.RUNNING +"\"")) {
            this.activityStatusText.setSelectedIndex(1);
        } else if (activityStatus.equals("\""+ ActivityStatus.IN_TEST +"\"")) {
            this.activityStatusText.setSelectedIndex(2);
        } else if (activityStatus.equals("\""+ ActivityStatus.DONE +"\"")) {
            this.activityStatusText.setSelectedIndex(3);
        }
    }


    /**
     * @return Container - construit Container contenant le JLabel de titre du formulaire
     */
    public Container buildActivityFormTitle() {

        String activityPanelTitle;

        JLabel activityPanelLabel;

        Container activityFormTitle = new Container();

        FlowLayout glActivityFormTitle = new FlowLayout(FlowLayout.CENTER,1000,50);
        activityFormTitle.setLayout(glActivityFormTitle);

        activityPanelTitle = "Edition d'une Activité";
        activityPanelLabel = new JLabel(activityPanelTitle);
        activityPanelLabel.setFont(new Font(TYPOGRAPHY, 0, 20));
        activityPanelLabel.setBackground(Color.BLUE);

        activityFormTitle.add(activityPanelLabel);

        return activityFormTitle;
    }


    /**
     * @return Container - construit le Container contenant le formulaire d'édition d'Activité
     */
    public Container buildActivityForm() {

        Container activityFormContainer = new Container();
        GridLayout glActivityForm = new GridLayout(0,2, 70, 20);
        activityFormContainer.setLayout(glActivityForm);

        JLabel dateChoiceLabel = new JLabel("Saisir une date: ");
        JLabel activityDescriptionLabel = new JLabel("Saisir une activité: ");
        JLabel activityStatusLabel = new JLabel("Saisir le status de l'activité: ");

        dateChoiceLabel.setFont(new Font(TYPOGRAPHY, 0, 20));
        activityDescriptionLabel.setFont(new Font(TYPOGRAPHY, 0, 20));
        activityStatusLabel.setFont(new Font(TYPOGRAPHY, 0, 20));


        this.dateTextField = new JTextField();
        this.dateTextField.setHorizontalAlignment(0);
        this.activityDescriptionText = new JTextField();

        // *** tableau de valeurs en dur, pour l'instant (à revoir avec appels à la BDD, si nécessaire)
        String[] statusTab = { ActivityStatus.TO_DO, ActivityStatus.RUNNING, ActivityStatus.IN_TEST, ActivityStatus.DONE };
        this.activityStatusText = new JComboBox<>(statusTab);

        // pré-initialisation des données du formulaire
        this.initFormFields();


        activityFormContainer.add(dateChoiceLabel);
        activityFormContainer.add(this.dateTextField);

        activityFormContainer.add(activityDescriptionLabel);
        activityFormContainer.add(this.activityDescriptionText);

        activityFormContainer.add(activityStatusLabel);
        activityFormContainer.add(this.activityStatusText);

        return activityFormContainer;
    }


    /**
     * @param dateValue
     * @param activityDescription
     * @param activityStatus
     * @return void - initialise les données du formulaire d'activité, si elles existent en BDD
     */
    public void initFormFieldsWithDatas (String dateValue, String activityDescription, String activityStatus) {

        // *** Date au format 'DD/MM/YYYY'
        this.dateTextField.setText(dateValue);
        this.activityDescriptionText.setText(activityDescription);

        if(activityStatus != null) {
            this.setActivityStatusText(activityStatus);
        }
    }


    /**
     * @return void - réinitialise les champs du formulaire
     */
    public void initFormFields() {

        Date daySelect;

        daySelect = new java.sql.Date(System.currentTimeMillis());
        ReformatDate reformatDate = new ReformatDate();
        String formatedDate = reformatDate.formatDateToString(daySelect);

        this.dateTextField.setText(formatedDate);
        this.activityDescriptionText.setText("");

        // *** pré-sélection de l'élément 0 de la liste (JComboBox)
        this.activityStatusText.setSelectedIndex(0);
    }


    /**
     * @return JTextField
     */
    public JTextField getDateTextField() {
        return this.dateTextField;
    }


    public void setDateTextField(JTextField dateTextField) {
        this.dateTextField = dateTextField;
    }


    @Override
    public void displayActivityForm() {
        this.logger.log(Level.INFO, () -> "info (displayActivityForm): "+ this.dateTextField +" - "+ this.activityDescriptionText +" - "+ this.activityStatusText);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.logger.log(Level.INFO, () -> "info (actionPerformed): "+ actionEvent);
    }

}
