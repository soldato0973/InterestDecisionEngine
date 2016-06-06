/**
 * 
 */
package com.InterestDecisionEngine.model.domain;

import java.io.Serializable;

/**
 * @author Jason canney
 *
 */

public class User implements Serializable
{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 7661657477853633935L;


        /** User Name */
        private String userName;
        
	/** User last name */
	private String lastName;
	  
	/** User first name */
	private String firstName;
	  
	/** User email address */
	private String emailAddress;
	  
	/** User password */
	private String password;
	  
	/** User day phone */
	private String dayTimePhone;
	  
	/** User evening phone */
	private String eveningTimePhone;

	/* Default Constructor
         * @param user object
         */  
        public User(){
            
        }
	  
	/**
	 * Copy Constructor
	 *
	 * @param user a <code>User</code> object
	 */
	public User(User user) 
	{
	    this.userName = user.userName;
            this.lastName = user.lastName;
	    this.firstName = user.firstName;
	    this.emailAddress = user.emailAddress;
	    this.password = user.password;
	    this.dayTimePhone = user.dayTimePhone;
	    this.eveningTimePhone = user.eveningTimePhone;
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param emailAddress
	 */
	public User(String userName, String lastName, String firstName, String emailAddress, String password, String dayTimePhone, String eveningTimePhone)
	{
		this.userName = userName;
                this.lastName = lastName;
		this.firstName = firstName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.dayTimePhone = dayTimePhone;
		this.eveningTimePhone = eveningTimePhone;
	}


	/**
	 * @return the lastName
	 */
	public String getUserName() {
		return userName;
	}



	/**
	 * @param lastName the lastName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

        
        
        /**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}



	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the dayTimePhone
	 */
	public String getDayTimePhone() {
		return dayTimePhone;
	}



	/**
	 * @param dayTimePhone the dayTimePhone to set
	 */
	public void setDayTimePhone(String dayTimePhone) {
		this.dayTimePhone = dayTimePhone;
	}



	/**
	 * @return the eveningTimePhone
	 */
	public String getEveningTimePhone() {
		return eveningTimePhone;
	}



	/**
	 * @param eveningTimePhone the eveningTimePhone to set
	 */
	public void setEveningTimePhone(String eveningTimePhone) {
		this.eveningTimePhone = eveningTimePhone;
	}

	/**
	 * 
	 * @return
	 */
	public boolean validate () 
	{
		if (userName == null) return false;
                if (lastName == null) return false;
		if (firstName == null) return false;
		if (emailAddress == null) return false;
		if (password == null) return false;
		if (dayTimePhone == null) return false;
		if (eveningTimePhone == null) return false;
	   
		return true;
	}

	/**
	 * 
	 * @param Customer
	 * @return
	 */
	public boolean equals(User user) 
	{
		if (!userName.equals(user.getUserName())) return false;
                if (!lastName.equals(user.getLastName())) return false;
		if (!firstName.equals(user.getFirstName())) return false;
		if (!emailAddress.equals(user.getEmailAddress())) return false;
		if (!password.equals(user.getPassword())) return false;
		if (!dayTimePhone.equals(user.getDayTimePhone())) return false;
		if (!eveningTimePhone.equals(user.getEveningTimePhone())) return false;

		return true;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	    
	    String retValue = "";
	    
	    retValue = "User ( "
	        + super.toString() + TAB
                + "userName = " + this.userName + TAB
	        + "lastName = " + this.lastName + TAB
	        + "firstName = " + this.firstName + TAB
	        + "emailAddress = " + this.emailAddress + TAB
	        + "password = " + this.password + TAB
	        + "dayTimePhone = " + this.dayTimePhone + TAB
	        + "eveningTimePhone = " + this.eveningTimePhone + TAB
	        + " )";
	
	    return retValue;
	}

}
