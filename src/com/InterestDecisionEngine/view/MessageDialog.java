/*
 * MessageDialog.java
 */

package com.voyage.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * <p>Title: MessageDialog.java</p>
 *
 * Ideally, this class should be in a package under com.voyage.view
 * @version 1.0
 */
public class MessageDialog
    extends JDialog implements ActionListener {
        /**
        * 
        */
        private static final long serialVersionUID = 6160978126409187537L;
        JButton okBtn = new JButton("OK");
        JLabel label = new JLabel();

  
  /**
   * Message Dialog box 
   * @param title
   * @param msg
   */
  public MessageDialog(String title, String msg) {
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setTitle(title);
    label.setText(msg);
    jbInit();
    okBtn.addActionListener(this);
  }

  /**
   * Component initialization.
   * @return void
   */
  private void jbInit() {
    label.setBounds(new Rectangle(56, 15, 197, 40));      
    okBtn.setBounds(new Rectangle(114, 70, 68, 23));
    this.getContentPane().add(label);
    this.getContentPane().add(okBtn);
    getContentPane().setLayout(null);
    setSize(300,150);
  }

  /**
   * Close the dialog on a button event.
   *
   * @param actionEvent ActionEvent
   * @return void
   */
  public void actionPerformed(ActionEvent actionEvent) {
    if (actionEvent.getSource() == okBtn) {
      dispose();
    }
  }
}

