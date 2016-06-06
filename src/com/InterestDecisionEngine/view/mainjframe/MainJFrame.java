package com.voyage.view.mainjframe;

import java.awt.*;

import javax.swing.*;

import com.voyage.view.applicationcreatejframe.ApplicationCreateJFrame;
import com.voyage.view.releasecreatejframe.ReleaseCreateJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.log4j.Logger;


/**
 * MainJFrame.java
 *
 * Build one of the GUIs (View) for the Voyage application.
 * This is a main window which the Application and Release CreateJFrame GUIs run within.
 * The ApplicationCreateJFrame and ReleaseCreateJFrame GUI classes have been changed to extend JInternalFrame instead of JFrame 
 * to allow them to run within the MainJFrame GUI window
 *
 * @author  Jason Canney
 */
public class MainJFrame extends JFrame {
    
    /**
	 * unique ID and DesktopPane
	 */
	private static final long serialVersionUID = 3320197207777135961L;
	
	private JDesktopPane theDesktop = new JDesktopPane();
        
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(MainJFrame.class);
        
	    
	/** Creates new form MainJFrame and runs init method */
    public MainJFrame() {
        initComponents();
    }
    
	private void initComponents() {
		
		
	  /** setup menu bar */
	  jMenuBar = new JMenuBar();
	  setJMenuBar(jMenuBar);
	  // jMenuBar.setNextFocusableComponent(jMetaMenu);
	  jMenuBar.setOpaque(true);
	  
	  jMetaMenu = new JMenu();
	
	  /* Release Menu definition
	   * Included actionlistener to execute ReleaseCreateJFrame class per class instructions
	   */
	  jRelMenuItem = new JMenuItem();
	  jRelMenuItem.setMnemonic('r');
	  jRelMenuItem.addActionListener ( new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				  
			      log.info ("testing within Relmenu");

			      ReleaseCreateJFrame UC2 = new ReleaseCreateJFrame();
			      UC2.setVisible(true);
				  theDesktop.add(UC2);
				  }
	  });
	  
	  /* Application Menu definition
	   * Included actionlistener to execute ApplicationCreateJFrame class per class instructions
	   */
	  
	  jAppMenuItem = new JMenuItem();
	  jAppMenuItem.setMnemonic('a');
	  jAppMenuItem.addActionListener ( new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				  
			      log.info("testing within Appmenu");

			      ApplicationCreateJFrame UC1 = new ApplicationCreateJFrame();
			      UC1.setVisible(true);
				  theDesktop.add(UC1);
			}
			});
	  
	  /* Exit Menu Definition
	   * Included actionlistener to execute system exit function per class instructions
	   */
	  
	  jExitMenuItem	= new JMenuItem();
	  jExitMenuItem.setMnemonic('x');
	  jExitMenuItem.addActionListener ( new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
		}
	  });
	  
	  /* Setup text and font for all menu options */
	  
	  jMetaMenu.setText("Metadata");
	  jMetaMenu.setFont(new java.awt.Font("Arial", 1, 13));
	
	  jRelMenuItem.setText("Create a Release");
	  jRelMenuItem.setFont(new java.awt.Font("Arial", 1, 13));
	  
	  jAppMenuItem.setText("Create an Application");
	  jAppMenuItem.setFont(new java.awt.Font("Arial", 1, 13));
	
	  jExitMenuItem.setText("Exit");
	  jExitMenuItem.setFont(new java.awt.Font("Arial", 1, 13));
	 
	  /* Add the menu options to the menu */
	  
	  jMetaMenu.add(jRelMenuItem);
	  jMetaMenu.add(jAppMenuItem);
	  jMetaMenu.add(jExitMenuItem);
	
	  /* Add the menu to the menu bar */
	  
	  jMenuBar.add(jMetaMenu);
	
	  /* setup overall window functions
	   * Add the desktop pane to the main window to hold sub windows
	   * pack()
	   */
	  
	  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	  setTitle("Voyage Metadata Manager");
	  setFont(new java.awt.Font("Arial", 0, 10));
  	  setContentPane(theDesktop);
	  getContentPane().setLayout(null);
	  pack();
	  setSize(1200,900);                
      setVisible(true); 
	  
	 }
	
	    /**
	     * Returns jRelMenuItem 
	     */
	    public JMenuItem getRelMenuItem()
	    {
	        return jRelMenuItem;
	    }    
	
	    /**
	     * Returns jAppMenuItem 
	     */
	    public JMenuItem getAppMenuItem()
	    {
	        return jAppMenuItem;
	    }    
	    
	   /**
	    * 
	    * @returns jExitMenuItem
	    */
	    public JMenuItem getExitMenuItem()
	    {
	    	return jExitMenuItem;
	    }
	    
	    
	    public static void main(String args[]) {
	        
	    	 // new MainJFrame();
	         
	         /*
	          * Create and display the form
	          */
	         EventQueue.invokeLater(new Runnable() {
	
	             public void run() {
	            	 
	                 new MainJFrame().setVisible(true);
	             }
	        });
	    }
	    
	 // Variables declaration - do not modify//GEN-BEGIN:variables
	 private JMenu jMetaMenu;
	 private JMenuItem jRelMenuItem;
	 private JMenuItem jAppMenuItem;
	 private JMenuItem jExitMenuItem;
	 private JMenuBar jMenuBar;
	    
	}
