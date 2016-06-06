package com.voyage.view.applicationcreatejframe;

import com.voyage.view.applicationcreatejframe.ApplicationCreateJFrameController;
import com.voyage.model.domain.*;
import java.util.Random;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import org.apache.log4j.Logger;

/**
 * This is the class that defines the GUI that a user uses for Use Case #1 to create an application metadata definition
 * @author JasonCanney
 */
public class ApplicationCreateJFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	Random randomNumbers = new Random();  // object to create for a new random number for the appID
	int randomnum; // stores the random number
        static int MINVALUE = 1;
        static int MAXVALUE = 100000;
        
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(ApplicationCreateJFrame.class);
        
    /**
	 * Variable declarations 
	 */
	private JPanel jPanel1;						// Create west panel
	
    private JTextField appNameField;
    private JTextField appVendorField;
    private JTextField appTypeField;
    private JTextField appVersField;
    private JTextField appStateField;
    
    private JTextField appProdNameField;
    private JTextField appCheckSumField;
    private JTextField appFileSizeField;
    private JTextField appDescriptionField;
    private JTextField appURLField;
    
    private JTextField appContactNameField;
    private JTextField appContactEmailField;
    
    private JButton addButton;
    private JButton resetButton;
    private JButton exitButton;

    // Create domain object application
    
	public Application application;
	
	// Create presentation layer controller object
	
	private ApplicationCreateJFrameController applicationCreateJFrameController;

    /**
     * Creates new form NewJFrame
     */
    public ApplicationCreateJFrame() {
        
    	initComponents();

        applicationCreateJFrameController = new ApplicationCreateJFrameController(this);

        this.setSize(350,480);
        pack();
        setVisible(true); 
        this.setResizable(false);
        
    }
    
    /**
     * initComponents - defines fields and labels of class
     */
    private void initComponents() {
    	
    	  setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    	  setTitle("Application Management");
    	  setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
          setBounds(0,0,200,200);
          BorderLayout layout = new BorderLayout(5,5);    	  
    	  getContentPane().setLayout(layout);

    	  JPanel jPanel1 = new JPanel();

    	  /**
           * Panel for Summary App Info
           */

          JLabel appNameLabel = new JLabel();
          appNameLabel.setFont(new Font("Arial", Font.BOLD,12));
          appNameLabel.setText("Name ");
          appNameField = new JTextField(20);
          jPanel1.add(appNameLabel);
          jPanel1.add(appNameField);
          
          JLabel appVersLabel = new JLabel();
          appVersLabel.setFont(new Font("Arial", Font.BOLD,12));
          appVersLabel.setText("Version ");
          appVersField = new JTextField(20);
          jPanel1.add(appVersLabel);
          jPanel1.add(appVersField);
          
          JLabel appVendorLabel = new JLabel();
          appVendorLabel.setFont(new Font("Arial", Font.BOLD,12));
          appVendorLabel.setText("    Vendor ");
          appVendorField = new JTextField(20);
          jPanel1.add(appVendorLabel);
          jPanel1.add(appVendorField);
          
          JLabel appStateLabel = new JLabel();
          appStateLabel.setFont(new Font("Arial", Font.BOLD,12));
          appStateLabel.setText("        State ");
          appStateField = new JTextField(20);
          jPanel1.add(appStateLabel);
          jPanel1.add(appStateField);
          
          JLabel appTypeLabel = new JLabel();
          appTypeLabel.setFont(new Font("Arial", Font.BOLD,12));
          appTypeLabel.setText("    Type ");
          appTypeField = new JTextField(20);
          jPanel1.add(appTypeLabel);
          jPanel1.add(appTypeField);
      
          JLabel appProdNameLabel = new JLabel();
          appProdNameLabel.setFont(new Font("Arial", Font.BOLD,12));
          appProdNameLabel.setText("Product Name ");
          appProdNameField = new JTextField(20);
          jPanel1.add(appProdNameLabel);
          jPanel1.add(appProdNameField);
          
          JLabel appFileSizeLabel = new JLabel();
          appFileSizeLabel.setFont(new Font("Arial", Font.BOLD,12));
          appFileSizeLabel.setText("File Size ");
          appFileSizeField = new JTextField(20);
          jPanel1.add(appFileSizeLabel);
          jPanel1.add(appFileSizeField);
          
          JLabel appCheckSumLabel = new JLabel();
          appCheckSumLabel.setFont(new Font("Arial", Font.BOLD,12));
          appCheckSumLabel.setText("CheckSum ");
          appCheckSumField = new JTextField(20);
          jPanel1.add(appCheckSumLabel);
          jPanel1.add(appCheckSumField);
          
          JLabel appDescriptionLabel = new JLabel();
          appDescriptionLabel.setFont(new Font("Arial", Font.BOLD,12));
          appDescriptionLabel.setText("Description ");
          appDescriptionField = new JTextField(20);
          jPanel1.add(appDescriptionLabel);
          jPanel1.add(appDescriptionField);
          
          JLabel appURLLabel = new JLabel();
          appURLLabel.setFont(new Font("Arial", Font.BOLD,12));
          appURLLabel.setText("URL ");
          appURLField = new JTextField(20);
          jPanel1.add(appURLLabel);
          jPanel1.add(appURLField);
        
          JLabel appContactNameLabel = new JLabel();
          appContactNameLabel.setFont(new Font("Arial", Font.BOLD,12));
          appContactNameLabel.setText("Contact Name ");
          appContactNameField = new JTextField(20);
          jPanel1.add(appContactNameLabel);
          jPanel1.add(appContactNameField);
          
          JLabel appContactEmailLabel = new JLabel();
          appContactEmailLabel.setFont(new Font("Arial", Font.BOLD,12));
          appContactEmailLabel.setText("Contact Email ");
          appContactEmailField = new JTextField(20);
          jPanel1.add(appContactEmailLabel);
          jPanel1.add(appContactEmailField);  
          
          add(jPanel1, BorderLayout.CENTER);        // add the panel to the frame on the west side
          
          // add three buttons to the bottom of the frame
          
          JPanel buttonPanel = new JPanel();          // holds the buttons
          addButton = new JButton("Add");       // calculates
          resetButton = new JButton("Reset");           // ends the application
          exitButton = new JButton("Exit");         // clears all fields
          buttonPanel.add(addButton);              // add buttons to the buttonPanel
          buttonPanel.add(resetButton);
          buttonPanel.add(exitButton);
          add(buttonPanel, BorderLayout.SOUTH);       // add buttonPanel to bottom of frame  	

    	  getContentPane().add(jPanel1);
    	  jPanel1.setBounds(0, 0, 370, 300);

    	  pack();
    }

    /**
     * Returns an Application domain object populated with user entered
     * data.
     * @return Application object
     */
    public Application getSelectedData()
    {

        Application application = new Application ( 
                                                    randomnum= MINVALUE + randomNumbers.nextInt(MAXVALUE),
                                                    appNameField.getText(),
                                                    appVendorField.getText(),
        					    appTypeField.getText(),
                                                    appVersField.getText(), 
                                                    appStateField.getText(), 
                                                    appProdNameField.getText(), 
                                                    appFileSizeField.getText(), 
                                                    appCheckSumField.getText(), 
                                                    appDescriptionField.getText(),
                                                    appURLField.getText(), 
                                                    appContactNameField.getText(), 
                                                    appContactEmailField.getText()
                                             		);
        log.info ("Application object built from user input");
        return application;
    }
    
    /**
     * getExitButton - Supports encapsulation
     * @return exitButton
     */
    public JButton getExitButton()
    {
        return exitButton;
    }

    /**
     * getResetButton - supports encapsulation
     * @return resetButton
     */
     public JButton getResetButton()
    {
        return resetButton;
    }
     
     /**
      * getAddButton - supports encapsulation
      * @return addButton
      */
     public JButton getAddButton()
     {
         return addButton;
     } 
     
 
    /**
     * main point of entry for application
     * @return void
     * @param ApplicationCreateJFrame
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        new ApplicationCreateJFrame();
        
        /*
         * Create and display the form
         */
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ApplicationCreateJFrame().setVisible(true);
            }
        });
    }
}






