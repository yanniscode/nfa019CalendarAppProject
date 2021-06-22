package fr.cnam.pactivity;

import fr.cnam.pbuttons.ControlButton;
import fr.cnam.pdatabase.managment.model.DatePart;
import fr.cnam.penums.FormControlAction;
import fr.cnam.putils.ReformatDate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;



/**
 * @author Yannis Guéguen
 */
public class ActivityFormPanel extends JFrame implements ActivityFormPanelInterface, ActionListener {

    /**
     *
     */
//    private JFrame activityFormDialog;
    /**
     *
     */
    private Container activityForm;
    /**
     * JLabel
     */
    private JLabel activityPanelLabel = new JLabel();
    /**
     *
     */
    private String activityPanelTitle;


    //    private JPanel activityForm;
    private JTextField dateTextField;
    private JTextArea activityDescriptionText;
    private JComboBox<String> activityStatusText;

    private ControlButton validateButton;
    public ControlButton getValidateButton() {
        return this.validateButton;
    }
    public void setValidateButton(ControlButton validateButton ) {
        this.validateButton = validateButton;
        return;
    }

    private ControlButton suppressButton;
    private ControlButton annulateButton;

    /**
     * Default constructor
     */
    public ActivityFormPanel() {

        GridLayout glActivityMainFormPanel = new GridLayout(0,1, 20, 80);    // *** ligne = 0, sinon, pas de prise en compte des colonnes
//        FlowLayout glActivityMainFormPanel = new FlowLayout(FlowLayout.CENTER,1000,50);
        this.setLayout(glActivityMainFormPanel);

        this.setSize(960, 540);
        this.setLocation(480,270);
        String activityFormTitle = "Ajout d'une Activité";
        this.setTitle(activityFormTitle);

        // ****************

        Container activityFormTitleContainer = this.buildActivityFormTitle();
        this.add(activityFormTitleContainer);

        Container activityFormContainer = this.buildActivityForm();
        this.add(activityFormContainer);

        Container validationContainer = this.buildValidationContainer();
        this.add(validationContainer);

//        Container activityFormContainer = this.getContentPane();

//        Container activityFormTitleContainer = new Container();
//        activityFormTitleContainer.setBackground(Color.BLUE);
//        activityFormTitleContainer.add(this.activityFormDialog);
//        activityFormTitleContainer.setVisible(true);


//        WindowListener l = new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            };
//        };
//
//        this.addWindowListener(l);

//        this.activityFormFrame.setVisible(true);
//        this.activityFormFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    // ******************************************

//    /**
//     * JLabel
//     */
//    private JLabel activityPanelLabel = new JLabel();



    // *+*****************************************

    // pas ici, dans le mainformpanel:
//    /**
//     *
//     */
//    private String activityPanelTitle;

    /**
     * Date de format: dd
     */
    private Date daySelect;

    /**
     * Date de format: MM
     */
    private Date monthSelect;

    /**
     * Date de format: yyyy
     */
    private Date yearSelect;

    /**
     * Date
     */
    private Date newAggregatedDate;

    /**
     * String
     */
    private String newActivityDescription;

    /**
     * String
     */
    private String newActivityStatus;

    /**
     * int - utilisé pour gérer le temps de connexion au formulaire de saisie
     */
    private int timeOut;


    // ***********************

//    /**
//     * @return JLabel
//     */
//    public JLabel getActivityPanelLabel() {
//        return this.activityPanelLabel;
//    }
//
//    /**
//     * @param activityPanelLabel
//     * @return void
//     */
//    public void setActivityPanelLabel(JLabel activityPanelLabel) {
//        this.activityPanelLabel = activityPanelLabel;
//        return;
//    }

    // *******************

//    public ActivityForm getActivityForm() {
//        return this.activityForm;
//    }
//
//    public void setActivityFormFrame(ActivityForm activityForm) {
//        this.activityForm = activityForm;
//        return;
//    }


//    public JFrame getActivityFormFrame() {
//        return this.activityFormDialog;
//    }
//
//    public void setActivityFormFrame(JFrame activityFormFrame) {
//        this.activityFormDialog = activityFormFrame;
//        return;
//    }


    public Container buildActivityFormTitle() {

        Container activityFormTitle = new Container();

//        GridLayout glActivityFormTitle = new GridLayout(0, 1, 20, 80);
        FlowLayout glActivityFormTitle = new FlowLayout(FlowLayout.CENTER,1000,50);
        activityFormTitle.setLayout(glActivityFormTitle);

//        activityFormTitle.setSize(860, 440);
//        activityFormTitle.setLocation(480,270);
//        String activityFormTitleString = "Ajout d'une Activité";
//        activityFormDialog.setTitle(activityFormTitleString);

        this.activityPanelTitle = "Ajout d'une Activité";
        this.activityPanelLabel = new JLabel(this.activityPanelTitle);
        this.activityPanelLabel.setFont(new Font("Serif", 0, 20));
        this.activityPanelLabel.setBackground(Color.BLUE);
//        this.activityPanelLabel.setHorizontalTextPosition(JLabel.CENTER);

        activityFormTitle.add(this.activityPanelLabel);

//        this.activityForm = new ActivityForm();
//        this.activityFormDialog.add(activityForm);
        return activityFormTitle;
    }


    // **** POURRAIT ÊTRE UTILISÉ, SI LAYOUT DIFFÉRENT MAIS A OPTIMISER (À VOIR)
//    public Container buildActivityFormMainContainer() {
//
//        Container mainFormContainer = new Container();
//        GridLayout mainFormLayout = new GridLayout(0,1);    // *** ligne = 0, sinon, pas de prise en compte des colonnes
//        mainFormContainer.setLayout(mainFormLayout);
//        mainFormContainer.setSize(860, 440);
//        mainFormContainer.setLocation(480,270);
//
//
//        // *** ajout des containers (partie titre, partie formulaire et partie boutons de validation) au container principal
//        Container activityFormTitleContainer = this.buildActivityFormTitle();
//        mainFormContainer.add(activityFormTitleContainer);
//
//        Container activityFormContainer = this.buildActivityForm();
//        mainFormContainer.add(activityFormContainer);
//
//        Container validationContainer = this.buildValidationContainer();
//        mainFormContainer.add(validationContainer);
//
//
//        return mainFormContainer;
//
//    }


    public Container buildActivityForm() {

        Container activityFormContainer = new Container();
        GridLayout glActivityForm = new GridLayout(0,2, 70, 20);    // *** ligne = 0, sinon, pas de prise en compte des colonnes
//        FlowLayout glActivityForm = new FlowLayout(FlowLayout.CENTER,1000,50);
//        FlowLayout glActivityForm = new FlowLayout(CENTER, 1000, 50);
        activityFormContainer.setLayout(glActivityForm);

//        this.activityForm.setSize(760, 340);
//        this.activityForm.setLocation(380,170);

//        this.activityPanelTitle = "Ajout d'une Activité";
//        this.activityPanelLabel = new JLabel(this.activityPanelTitle);
//        this.activityPanelLabel.setFont(new Font("Serif", 0, 20));
//        this.activityPanelLabel.setBackground(Color.BLUE);
////        this.activityPanelLabel.setHorizontalTextPosition(JLabel.CENTER);
//
//        this.activityFormDialog.add(this.activityPanelLabel);


        JLabel dateChoiceLabel = new JLabel("Saisir une date: ");
        JLabel activityDescriptionLabel = new JLabel("Saisir une activité: ");
        JLabel activityStatusLabel = new JLabel("Saisir le status de l'activité: ");

        dateChoiceLabel.setFont(new Font("Serif", 0, 20));
        activityDescriptionLabel.setFont(new Font("Serif", 0, 20));
        activityStatusLabel.setFont(new Font("Serif", 0, 20));


        this.dateTextField = new JTextField();
        this.activityDescriptionText = new JTextArea();
        // *** tableau de valeurs en dur, pour l'instant (à revoir avec appels à la BDD)
        String[] statusTab = { "En définition", "En cours", "En test", "Terminée" };
        this.activityStatusText = new JComboBox<String>(statusTab);

        // pré-initialisation des données du formulaire
        this.initFormFields();

        this.dateTextField.setHorizontalAlignment(JTextField.CENTER);
//        this.dateTextField.addActionListener( this); // utile ici ?? -> plus pour bouton de validation


        activityFormContainer.add(dateChoiceLabel);
        activityFormContainer.add(this.dateTextField);

        activityFormContainer.add(activityDescriptionLabel);
        activityFormContainer.add(this.activityDescriptionText);

        activityFormContainer.add(activityStatusLabel);
        activityFormContainer.add(this.activityStatusText);


        return activityFormContainer;
    }


    public Container buildValidationContainer() {

        Container validationContainer = new Container();
        GridLayout ValidateActivityLayout = new GridLayout(0,3  , 0, 0);    // *** ligne = 0, sinon, pas de prise en compte des colonnes
        validationContainer.setLayout(ValidateActivityLayout);

        // ****** partie boutons (validation, suppression, annulation)

//        glActivityForm.setColumns(3);

        this.annulateButton = new ControlButton(FormControlAction.ANNULATION);
        this.annulateButton.setBackground(Color.LIGHT_GRAY);

        // ***********

        this.validateButton = new ControlButton(FormControlAction.VALIDATION);
        this.validateButton.setBackground(Color.ORANGE);
        // ***********

        this.suppressButton = new ControlButton(FormControlAction.SUPPRESSION);
        this.suppressButton.setBackground(Color.LIGHT_GRAY);


        // ***********

        validationContainer.add(this.annulateButton);
        validationContainer.add(this.validateButton);
        validationContainer.add(this.suppressButton);

        return validationContainer;
    }



    /**
     * @return void - réinitialise les champs du formulaire
     */
    public void initFormFields() {

        this.daySelect = new java.sql.Date(System.currentTimeMillis());
        ReformatDate reformatDate = new ReformatDate();
        String formatedDate = reformatDate.formatDateToString(this.daySelect);
        this.dateTextField.setText(formatedDate);
        this.activityDescriptionText.setText("");

        // *** pré-sélection de l'élément 0 de la liste (JComboBox)
        this.activityStatusText.setSelectedIndex(0);

        return;
    }


    /**
     * @return JTextField
     */
    public JTextField getDateTextField() {
        return dateTextField;
    }
    public void setDateTextField(JTextField dateTextField) {
        this.dateTextField = dateTextField;
        return;
    }


    /**
     * @return Date
     */
    public Date getDayAsDate() {
        return this.daySelect;
    }

    /**
     * @param daySelect
     * @return void
     */
    public void setDayAsDate(Date daySelect) {
        this.daySelect = daySelect;
        return;
    }


//    public JPanel getActivityForm() {
//        return this.activityForm;
//    }
//
//    public void setActivityFormFrame(JPanel activityForm) {
//        this.activityForm = activityForm;
//        return;
//    }


    // ***********************

    /**
     * @return DatePart
     */
    public DatePart getNewDay() {
        // TODO implement here
        return null;
    }

    /**
     * @param selectedDay
     * @return void
     */
    public void setNewDay(DatePart selectedDay) {
        // TODO implement here
        return;
    }

    /**
     * @return DatePart
     */
    public DatePart getNewMonth() {
        // TODO implement here
        return null;
    }

    /**
     * @param selectedMonth
     * @return void
     */
    public void setNewMonth(DatePart selectedMonth) {
        // TODO implement here
        return;
    }

    /**
     * @return DatePart
     */
    public DatePart getNewYear() {
        // TODO implement here
        return null;
    }

    /**
     * @param selectedYear
     * @return void
     */
    public void setNewYear(Date selectedYear) {
        // TODO implement here
        return;
    }

    /**
     * @return String
     */
    public String getNewActivityDescription() {
        // TODO implement here
        return "";
    }

    /**
     * @param newActivityText
     * @return void
     */
    public void setNewActivityDescription(String newActivityText) {
        // TODO implement here
        return;
    }

    /**
     * @param selectedStatus
     * @return void
     */
    public void setNewActivityStatus(String selectedStatus) {
        // TODO implement here
        return;
    }

    /**
     * @return String
     */
    public String getNewActivityStatus() {
        // TODO implement here
        return "";
    }

    /**
     * @param newAggregatedDate
     * @param newActivityDescription
     * @param newActivityStatus
     * @return void
     */
    public void setDateActivityItem(Date newAggregatedDate, String newActivityDescription, String newActivityStatus) {
        // TODO implement here
        return;
    }


    @Override
    public void displayActivityForm() {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
