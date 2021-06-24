package fr.cnam.pbuttons;

import fr.cnam.psharedinterfaces.ControlButtonsPanelInterface;
import fr.cnam.putils.penums.ControlAction;
import fr.cnam.pmain.MainPanel;

import javax.swing.*;


/**
 * @author Yannis Guéguen
 */
public class CalendarControlButtonsPanel extends JPanel implements ControlButtonsPanelInterface {


    /**
     * Default constructor
     */
    public CalendarControlButtonsPanel(MainPanel mainPanel) {

        super();
        
//        this.setIncrementIndex(0);

        this.mainPanel = mainPanel;
//        System.out.println("this.mainPanel ################################# : "+ mainPanel);

        // *** note: le MainPanel est passé en paramètre aux ControlButtons directionnels car c'est par lui qu'on accède aux propriétés de 'CalendarPanel()' sur lequel agissent les ControlButtons:
        this.leftBtn = new CalendarControlButton(ControlAction.LAST_MONTH, this.mainPanel);
        this.enterActivityBtn = new CalendarControlButton(ControlAction.ADD_ACTIVITY);
        this.rightBtn = new CalendarControlButton(ControlAction.NEXT_MONTH, this.mainPanel);

        add(this.leftBtn);
        add(this.enterActivityBtn);
        add(this.rightBtn);

    }

//    /**
//     * Default Constructor
//     */
//    public ControlButtonsPanel() {
//        super();
//    }



//    /**
//     * Default constructor
//     */
//    public ControlButtonsPanel() {
//
//        super();
//
//        this.leftBtn = new ControlButton("<", this.mainPanel, 0);
////        this.enterActivityBtn = new ControlButton("Nouvelle Activité");
//        this.rightBtn = new ControlButton(">", this.mainPanel, 0);
//
//        super.add(this.leftBtn);
////        super.add(this.enterActivityBtn);
//        super.add(this.rightBtn);
//    }

    /**
     * String
     */
    private String activedButton;

    /**
     * MainPanel
     */
    private static MainPanel mainPanel;


    /**
     * ControlButton
     */
    private static CalendarControlButton leftBtn;

    /**
     * ControlButton
     */
    private static CalendarControlButton enterActivityBtn;

    /**
     * ControlButton
     */
    private static CalendarControlButton rightBtn;

    /**
     * ControlButton
     */
    private static CalendarControlButton exitAppButton;



    // *********** AJOUTS:

//    public void incrOnClickEvent() {

//        this.leftBtn.setVisible(false);
//        this.remove( this.leftBtn);
//        this.leftBtn = new ControlButton("<", this.mainPanel, this.getIncrementIndex());
////        this.leftBtn.setVisible(true);
//        this.add(this.leftBtn);
//        //        this.enterActivityBtn = new ControlButton("Nouvelle Activité");
//        this.rightBtn.setVisible(false);
//        this.remove( this.rightBtn);
//        this.rightBtn = new ControlButton(">", this.mainPanel, this.getIncrementIndex());
////        this.rightBtn.setVisible(true);
//        this.add(this.rightBtn);

//    }


//    public int getIncrementIndex() {
//       return this.incrementIndex;
//    }

//    public void setIncrementIndex(int incrementIndex) {
//        this.incrementIndex = incrementIndex;
//        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&& &&&&&&&&&&&&&&&&&&&&&&&&&&&& this.incrementindex = "+ this.incrementIndex);
//
//        return;
//    }


    // *****************

    private CalendarControlButton button;

    // *** pour les tests:
    public CalendarControlButton getBtn(){
        return this.button;
    }

    public CalendarControlButton setBtn(CalendarControlButton button){
        return this.button = button;
    }

    // ****************

    public CalendarControlButton getEnterActivityBtn(){
        return this.enterActivityBtn;
    }

    public CalendarControlButton setEnterActivityBtn(CalendarControlButton enterActivityBtn){
        return this.enterActivityBtn = enterActivityBtn;
    }

    public CalendarControlButton getRightBtn(){
        return this.rightBtn;
    }

    public CalendarControlButton setRightBtn(CalendarControlButton rightBtn){
        return this.rightBtn = rightBtn;
    }

    @Override
    /**
     * @return void
     */
    public void displayControlButtons() {
        // TODO implement here
        return;
    }

//    String activeButton;
//
//    @Override
//    public void actionPerformed(ActionEvent ev) {
////        activeButton = this.leftBtn.actionPerformed();
//        System.out.println("#|#| "+this.leftBtn.getControlBtnValue());
//    }

}