package com.voyage.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.voyage.view.Utils;
import com.voyage.view.applicationcreatejframe.ApplicationCreateJFrame;
import com.voyage.view.releasecreatejframe.ReleaseCreateJFrame;


/* Action Listeners moved into MainJFrame.java per class instructions */

/**
 * MainJFrameController.java
 *
 * Listens and handles actions generated from MainJFrame.java
 * 
 * @author Jason Canney
 */

public class MainJFrameController implements ActionListener 
{

	private MainJFrame itineraryJFrame;
	
    /** Creates a new instance of ItineraryJFrameController */
    public MainJFrameController() {
    }
     

  /*
   * Copy constructor
   */
    
  public MainJFrameController (MainJFrame itineraryJFrame) 
  {
    this.itineraryJFrame = itineraryJFrame;

    //add all the action listeners here
    itineraryJFrame.getRelMenuItem().addActionListener(this);
    itineraryJFrame.getAppMenuItem().addActionListener(this);
    itineraryJFrame.getExitMenuItem().addActionListener(this);
          
    // center the frame
    Utils.centerWindow(itineraryJFrame);
    itineraryJFrame.setVisible(true);
  }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent event) 
  {

    System.out.println ("Inside ItineraryJFrameController::actionPerformed");
    
    if (event.getSource().equals(itineraryJFrame.getRelMenuItem()))
      menugetRelMenu_actionPerformed(event);
    else if (event.getSource().equals(itineraryJFrame.getAppMenuItem()))
    	menugetAppMenu_actionPerformed(event);
    else if (event.getSource().equals(itineraryJFrame.getExitMenuItem()))
    	menugetExitMenu_actionPerformed(event);
 }

  /**
   * Processes request for Creating Release Definition (UC #2)
   *
   * @param actionEvent ActionEvent
   */
  void menugetRelMenu_actionPerformed (ActionEvent actionEvent) 
  {
      System.out.println("testing within relmenu");
      
          new ReleaseCreateJFrame().setVisible(true);
          
      return;  
  } //end menugetRelMenu_actionPerformed
  
  /**
   * Processes request for Creating Application Definition (UC #1)
   *
   * @param actionEvent ActionEvent
   */
  void menugetAppMenu_actionPerformed (ActionEvent actionEvent) 
  {
   
	  new ApplicationCreateJFrame();
      new ApplicationCreateJFrame().setVisible(true);

      System.out.println("testing within Appmenu");

      ApplicationCreateJFrame UC1 = new ApplicationCreateJFrame();
      UC1.setVisible(true);
	  // theDesktop.add(UC1);

      return;  
  } //end menugetAppMenu_actionPerformed
  
  /**
   * What to do when the user presses the exit button
   * @param event
   * @return void
   */
  private void menugetExitMenu_actionPerformed(ActionEvent event) {
	  // MainJFrame.setVisible(false);
	  // MainJFrame.dispose();
	  System.exit(0);
 }
  
} //end class   