package com.voyage.view.releasecreatejframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.voyage.model.business.manager.MetadataManager;
import com.voyage.model.domain.*;
import com.voyage.view.MessageDialog;
import com.voyage.view.Utils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ReleaseJFrameController.java
 *
 * Listens and handles actions generated from ReleaseJFrame.java
 * 
 * @author Jason Canney
 */

public class ReleaseCreateJFrameController implements ActionListener 
{

	private ReleaseCreateJFrame releaseCreateJFrame;
	
    /** Creates a new instance of ApplicationCreateJFrameController 
     * Default Constructor
     */
    public ReleaseCreateJFrameController() {
    }
     
  /*
   * Copy constructor
   * Takes in ReleaseCreateJFrame object
   * implements listeners for catching GUI actions
   */
    
  public ReleaseCreateJFrameController (ReleaseCreateJFrame releaseCreateJFrame)
  {
    this.releaseCreateJFrame = releaseCreateJFrame;
   
    // put listeners here    
    releaseCreateJFrame.getAddButton().addActionListener(this);
    releaseCreateJFrame.getResetButton().addActionListener(this);
    releaseCreateJFrame.getExitButton().addActionListener(this); 
    
    // center the frame
    Utils.centerWindow(releaseCreateJFrame);
    releaseCreateJFrame.setVisible(true);
  
  }
  
  // pull in the spring config file
  ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
  
  /**
   * actionPerformed
   * if then logic to catch what button was pressed and take specific action per button
   * @return void
   */
  public void actionPerformed(ActionEvent event) 
  {

    System.out.println ("Inside ReleaseCreateJFrameController::actionPerformed");
    
    if (event.getSource().equals(releaseCreateJFrame.getAddButton()))
     add_actionPerformed(event);
    else if (event.getSource().equals(releaseCreateJFrame.getResetButton()))
    	reset_actionPerformed(event);
    else if (event.getSource().equals(releaseCreateJFrame.getExitButton()))
      exit_actionPerformed(event);
  }

  /**
   * What to do when the user presses the exit button
   * @param event
   * @return void
   */
  private void exit_actionPerformed(ActionEvent event) {
  releaseCreateJFrame.setVisible(false);
  releaseCreateJFrame.dispose();
 }
  /**
   * What to do when the user presses the reset button
   * @param event
   * @return void
   */
 private void reset_actionPerformed(ActionEvent event) {
	  //todo put reset logic in
	 }
 
 /** 
  * What to do when the user presses the add button
  * @param event
  * @return void
  */
 private void add_actionPerformed(ActionEvent event) {
        Release release1 = releaseCreateJFrame.getSelectedData();
     
 	 // MetadataManager metadataManager = MetadataManager.getInstance();
 	MetadataManager metadataManager = (MetadataManager)context.getBean("MetadataManager");                 
        if (metadataManager != null)
 	 {	 
	 	 boolean action = metadataManager.setMetadata("setRel", release1);
	
	     if (action)
	     {	 
	    		
	       MessageDialog dlg = new MessageDialog( "Release Confirmation" , "Submission Success");
           System.out.println(release1.toString());
	       Utils.centerWindow(dlg);
	       dlg.setModal(true);
	       dlg.show();
	       
	       // tear down registration dialog
	       releaseCreateJFrame.setVisible(false);
	       releaseCreateJFrame.dispose();
	
	     } 
	     else
	     {
	         MessageDialog dlg = new MessageDialog( "Release Confirmation" , "Release Submission Failed. Please try back later!");    
	         Utils.centerWindow(dlg);
	         dlg.setModal(true);
	         dlg.show();
	    	 
	     }
 	 }
     else
     {
         MessageDialog dlg = new MessageDialog( "Internal Error" , "Release Submission Failed. Please try back later!");    
         Utils.centerWindow(dlg);
         dlg.setModal(true);
         dlg.show();
    	 
     }
 	 
 }

} //end class
  