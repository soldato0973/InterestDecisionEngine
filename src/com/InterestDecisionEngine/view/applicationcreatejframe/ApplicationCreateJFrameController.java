package com.voyage.view.applicationcreatejframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.voyage.model.business.manager.MetadataManager;
import com.voyage.model.domain.*;
import com.voyage.view.MessageDialog;
import com.voyage.view.Utils;

/**
 * ApplicationJFrameController.java
 *
 * Listens and handles actions generated from ApplicationJFrame.java
 * 
 * @author Jason Canney
 */

public class ApplicationCreateJFrameController implements ActionListener 
{

	private ApplicationCreateJFrame applicationCreateJFrame;
	
    /** Creates a new instance of ApplicationCreateJFrameController 
     * Default Constructor
     */
    public ApplicationCreateJFrameController() {
    }
     
  /*
   * Copy constructor
   * Takes in ApplicationCreateJFrame object
   * implements listeners for catching GUI actions
   */
    
  public ApplicationCreateJFrameController (ApplicationCreateJFrame applicationCreateJFrame)
  {
    this.applicationCreateJFrame = applicationCreateJFrame;
   
    // put listeners here    
    applicationCreateJFrame.getAddButton().addActionListener(this);
    applicationCreateJFrame.getResetButton().addActionListener(this);
    applicationCreateJFrame.getExitButton().addActionListener(this); 
    
    // center the frame
    Utils.centerWindow(applicationCreateJFrame);
    applicationCreateJFrame.setVisible(true);
  
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

    System.out.println ("Inside ApplicationCreateJFrameController::actionPerformed");
    
    if (event.getSource().equals(applicationCreateJFrame.getAddButton()))
     add_actionPerformed(event);
    else if (event.getSource().equals(applicationCreateJFrame.getResetButton()))
    	reset_actionPerformed(event);
    else if (event.getSource().equals(applicationCreateJFrame.getExitButton()))
      exit_actionPerformed(event);
  }

  /**
   * What to do when the user presses the exit button
   * @param event
   * @return void
   */
  private void exit_actionPerformed(ActionEvent event) {
  applicationCreateJFrame.setVisible(false);
  applicationCreateJFrame.dispose();
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
  Application application1 = applicationCreateJFrame.getSelectedData();
     
 	//  MetadataManager metadataManager = MetadataManager.getInstance();
        MetadataManager metadataManager = (MetadataManager)context.getBean("MetadataManager");                
         if (metadataManager != null)
 	 {	 
	 	 boolean action = metadataManager.setMetadata("setApp", application1);
	
	     if (action)
	     {	 
	    		
	       MessageDialog dlg = new MessageDialog( "Application Confirmation" , "Submission Success");
                System.out.println(application1.toString());
	       Utils.centerWindow(dlg);
	       dlg.setModal(true);
	       // dlg.show();
	       
	       // tear down registration dialog
	       applicationCreateJFrame.setVisible(false);
	       applicationCreateJFrame.dispose();
	
	     } 
	     else
	     {
	         MessageDialog dlg = new MessageDialog( "Application Confirmation" , "Application Submission Failed. Please try back later!");    
	         Utils.centerWindow(dlg);
	         dlg.setModal(true);
	         // dlg.show();
	    	 
	     }
 	 }
     else
     {
         MessageDialog dlg = new MessageDialog( "Internal Error" , "Application Submission Failed. Please try back later!");    
         Utils.centerWindow(dlg);
         dlg.setModal(true);
         // dlg.show();
    	 
     }
 	 
 }

} //end class
  