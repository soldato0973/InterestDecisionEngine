package com.voyage.view.releasecreatejframe;

import com.voyage.view.releasecreatejframe.ReleaseCreateJFrameController;
import com.voyage.model.domain.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;

/**
 * This is the class that defines the GUI that a user uses for Use Case #1 to create an release metadata definition
 * @author JasonCanney
 */
public class ReleaseCreateJFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
    /**
	 * Variable declarations 
	 */
	private JPanel jPanel1;						// Create west panel
	
    private JTextField relNameField;
    private JTextField relNumField;
    private JTextField relTypeField;
    
    private JButton addButton;
    private JButton resetButton;
    private JButton exitButton;

    // Create domain object release
    
	public Release release;
	
	// Create presentation layer controller object
	
	private ReleaseCreateJFrameController releaseCreateJFrameController;

    /**
     * Creates new form NewJFrame
     */
    public ReleaseCreateJFrame() {
        
    	initComponents();

        releaseCreateJFrameController = new ReleaseCreateJFrameController(this);

        this.setSize(350,240); 
        pack();
        setVisible(true); 
        this.setResizable(false);
        
    }
    
    /**
     * initComponents - defines fields and labels of class
     */
    private void initComponents() {
    	
    	  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    	  setTitle("Metadata Release Management");
    	  setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
          setBounds(0,0,200,200);
          BorderLayout layout = new BorderLayout(5,5);    	  
    	  getContentPane().setLayout(layout);

    	  JPanel jPanel1 = new JPanel();

    	  /**
           * Panel for Summary App Info
           */

          JLabel relNameLabel = new JLabel();
          relNameLabel.setFont(new Font("Arial", Font.BOLD,12));
          relNameLabel.setText("Name ");
          relNameField = new JTextField(20);
          jPanel1.add(relNameLabel);
          jPanel1.add(relNameField);
          
          JLabel relNumLabel = new JLabel();
          relNumLabel.setFont(new Font("Arial", Font.BOLD,12));
          relNumLabel.setText("Number ");
          relNumField = new JTextField(20);
          jPanel1.add(relNumLabel);
          jPanel1.add(relNumField);
          
          JLabel relTypeLabel = new JLabel();
          relTypeLabel.setFont(new Font("Arial", Font.BOLD,12));
          relTypeLabel.setText("    Type ");
          relTypeField = new JTextField(20);
          jPanel1.add(relTypeLabel);
          jPanel1.add(relTypeField);
          
          add(jPanel1, BorderLayout.WEST);        // add the panel to the frame on the west side
          
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
     * Returns an Release domain object populated with user entered
     * data.
     * @return Release object
     */
    public Release getSelectedData()
    {

        Release release = new Release ( relNameField.getText(),
        											relNumField.getText(),
        											relTypeField.getText()
                                             		);
        return release;
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
     * @param ReleaseCreateJFrame
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        new ReleaseCreateJFrame();
        
        /*
         * Create and display the form
         */
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ReleaseCreateJFrame().setVisible(true);
            }
        });
    }
}






