package fr.cnam.pbuttons;

import fr.cnam.pinterfaces.ControlButtonsPanelInterface;
import fr.cnam.pmain.MainPanel;
<<<<<<< HEAD
import javax.swing.*;
=======

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
>>>>>>> da73c17c4b89f8dd508c2c33a5f1591aeed88bf9

import javax.swing.*;

/**
 * @author Yannis Guéguen
 */
public class ControlButtonsPanel extends JPanel implements ControlButtonsPanelInterface {

    private String activedButton;
    private MainPanel mainPanel;

    /**
     * Default constructor
     */
    public ControlButtonsPanel(MainPanel mainPanel) {

        super();
        
//        this.setIncrementIndex(0);

        this.mainPanel = mainPanel;

        this.leftBtn = new ControlButton("<", this.mainPanel, -1);
        this.enterActivityBtn = new ControlButton("Nouvelle Activité");
        this.rightBtn = new ControlButton(">", this.mainPanel, 1);

        add(this.leftBtn);
        add(this.enterActivityBtn);
        add(this.rightBtn);

    }



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
     * 
     */
    protected ControlButton leftBtn;

    /**
     * 
     */
    protected ControlButton enterActivityBtn;

    /**
     * 
     */
    protected ControlButton rightBtn;

    /**
     * 
     */
    protected ControlButton exitAppButton;



    // *********** AJOUTS:

    public void incrOnClickEvent() {

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

    }


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

    public ControlButton getLeftBtn(){
        return this.leftBtn;
    }

    public ControlButton setLeftBtn(ControlButton leftBtn){
        return this.leftBtn = leftBtn;
    }

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