package fr.cnam.pbuttons;

import fr.cnam.penums.ControlAction;
import fr.cnam.pinterfaces.ControlButtonsPanelInterface;
import fr.cnam.pmain.MainPanel;

import javax.swing.*;

/**
 * @author Yannis Guéguen
 */
public class ControlButtonsPanel extends JPanel implements ControlButtonsPanelInterface {


    /**
     * Default constructor
     */
    public ControlButtonsPanel(MainPanel mainPanel) {

        super();
        
//        this.setIncrementIndex(0);

        this.mainPanel = mainPanel;
//        System.out.println("this.mainPanel ################################# : "+ mainPanel);

        // *** note: le MainPanel est passé en paramètre aux ControlButtons directionnels car c'est par lui qu'on accède aux propriétés de 'CalendarPanel()' sur lequel agissent les ControlButtons:
        this.leftBtn = new ControlButton(ControlAction.LAST_MONTH, this.mainPanel);
        this.enterActivityBtn = new ControlButton(ControlAction.ADD_ACTIVITY);
        this.rightBtn = new ControlButton(ControlAction.NEXT_MONTH, this.mainPanel);

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
    private static ControlButton leftBtn;

    /**
     * ControlButton
     */
    private static ControlButton enterActivityBtn;

    /**
     * ControlButton
     */
    private static ControlButton rightBtn;

    /**
     * ControlButton
     */
    private static ControlButton exitAppButton;



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

    private ControlButton button;

    // *** pour les tests:
    public ControlButton getBtn(){
        return this.button;
    }

    public ControlButton setBtn(ControlButton button){
        return this.button = button;
    }

    // ****************

    public ControlButton getEnterActivityBtn(){
        return this.enterActivityBtn;
    }

    public ControlButton setEnterActivityBtn(ControlButton enterActivityBtn){
        return this.enterActivityBtn = enterActivityBtn;
    }

    public ControlButton getRightBtn(){
        return this.rightBtn;
    }

    public ControlButton setRightBtn(ControlButton rightBtn){
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