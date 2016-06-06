package com.InterestDecisionEngine.model.domain;

import java.io.Serializable;

/**
 * Application class is the core class that stores metadata related to an application
 * The applications received will also contain metadata that is related to a particular release and hardware
 * The release and hardware metadata is critical to have related to the an application
 * @author JasonCanney
 *
 */

	public class Application implements Serializable
	{

		/**
		 * @param serialVersionUID
		 * The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
		 *  number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
		 *  then an InvalidClassException is thrown
		 */
		
		private static final long serialVersionUID = 1L;

		private static final int ID = 0;
		  
		/** variables for the class */
		
                  /** Application ID */
                  private int appID;
                
	 	  /** Application Name */
		  private String appName;
		  
		  /** Application vendor */
		  private String appVendor;
		  
		  /** Application type */
		  private String applicationType;
		  
		  /** Application Version */
		  private String appVers;
		  
		  /** Application State */
		  private String appState;
		  
		 /** Application Product Name */
		  private String appProdName;
		  
		  /** Application File Size */
		  private String appFileSize; 
		  
		  /** Application Checksum */
		  private String appCheckSum;
		  
		  /** Application Description */
		  private String appDescription;
		  
		  /** Application Source URL */
		  private String appURL;
		  
		  /** Application Contact Name */
		  private String appContactName;
		  
		  /** Application Contact Email */
		  private String appContactEmail;
		  
	   
		  /** Constructors for Application class */
		  
	/**
	 * Application Constructor
	 * Constructor takes in an object as an argument variable
	 * @param application a <code>Application</code> object
	 */
	public Application(Application application) 
	{
            this.appID = application.appID;
	    this.appName = application.appName;
		this.appVendor = application.appVendor;
	    this.applicationType = application.applicationType;
	    this.appVers = application.appVers;
		this.appState = application.appState;
		this.appProdName = application.appProdName;
	    this.appFileSize = application.appFileSize;
	    this.appCheckSum = application.appCheckSum;
	    this.appDescription = application.appDescription;
		this.appURL = application.appURL;   // fixed bug on 11/09 was pointing to application.appState
	    this.appContactName = application.appContactName;
	    this.appContactEmail = application.appContactEmail;
	}

	/**
	 * Constructor takes in all variable names as well as a hardware object
	 * @param appName
	 * @param appVendor
	 * @param applicationType
	 * @param appVers
	 * @param appState
	 * @param appMajor
	 * @param appMinor
	 * @param appProdName
	 * @param appFileSize
	 * @param appCheckSum
	 * @param appDescription
	 * @param appURL
	 * @param appContactName
	 * @param appContactEmail
	 * @param processorNumber 
	 */
	public Application(int appID, String appName, String appVendor, String applicationType, String appVers, 
			String appState, String appProdName, String appFileSize, 
			String appCheckSum, String appDescription, String appURL, String appContactName, 
			String appContactEmail)
	{
                this.appID = appID;
		this.appName = appName;
		this.appVendor = appVendor;
	    this.applicationType = applicationType;
	    this.appVers = appVers;
		this.appState = appState;
		this.appProdName = appProdName;
	    this.appFileSize = appFileSize;
	    this.appCheckSum = appCheckSum;
	    this.appDescription = appDescription;
		this.appURL = appURL;
	    this.appContactName = appContactName;
	    this.appContactEmail = appContactEmail;
	}	

	/** Default constructor */
		public Application() {
		// Auto-generated constructor stub
	}

		/** Setter and Getters */
		
                /**
		 * @return the appID
		 */
		public int getAppID() {
			return appID;
		}

		/**
		 * @param appID the appID to set
		 */
		public void setAppID(int appID) {
			this.appID = appID;
		}
                
                

		/**
		 * @return the applicationType
		 */
		public String getApplicationType() {
			return applicationType;
		}

		/**
		 * @param applicationType the applicationType to set
		 */
		public void setApplicationType(String applicationType) {
			this.applicationType = applicationType;
		}

		/**
		 * @return the appName
		 */
		public String getAppName() {
			return appName;
		}

		/**
		 * @param appName the appName to set
		 */
		public void setAppName(String appName) {
			this.appName = appName;
		}

		/**
		 * @return the appVendor
		 */
		public String getAppVendor() {
			return appVendor;
		}

		/**
		 * @param appVendor the appVendor to set
		 */
		public void setAppVendor(String appVendor) {
			this.appVendor = appVendor;
		}

		/**
		 * @return the appVers
		 */
		public String getAppVers() {
			return appVers;
		}

		/**
		 * @param appVers the appVers to set
		 */
		public void setAppVers(String appVers) {
			this.appVers = appVers;
		}

		/**
		 * @return the appState
		 */
		public String getAppState() {
			return appState;
		}

		/**
		 * @param appState the appState to set
		 */
		public void setAppState(String appState) {
			this.appState = appState;
		}


		/**
		 * @return the appProdName
		 */
		public String getAppProdName() {
			return appProdName;
		}

		/**
		 * @param appProdName the appProdName to set
		 */
		public void setAppProdName(String appProdName) {
			this.appProdName = appProdName;
		}

		/**
		 * @return the appFileSize
		 */
		public String getAppFileSize() {
			return appFileSize;
		}

		/**
		 * @param appFileSize the appFileSize to set
		 */
		public void setAppFileSize(String appFileSize) {
			this.appFileSize = appFileSize;
		}

		/**
		 * @return the appCheckSum
		 */
		public String getAppCheckSum() {
			return appCheckSum;
		}

		/**
		 * @param appCheckSum the appCheckSum to set
		 */
		public void setAppCheckSum(String appCheckSum) {
			this.appCheckSum = appCheckSum;
		}

		/**
		 * @return the appDescription
		 */
		public String getAppDescription() {
			return appDescription;
		}

		/**
		 * @param appDescription the appDescription to set
		 */
		public void setAppDescription(String appDescription) {
			this.appDescription = appDescription;
		}

		/**
		 * @return the appURL
		 */
		public String getAppURL() {
			return appURL;
		}

		/**
		 * @param appURL the appURL to set
		 */
		public void setAppURL(String appURL) {
			this.appURL = appURL;
		}

		/**
		 * @return the appContactName
		 */
		public String getAppContactName() {
			return appContactName;
		}

		/**
		 * @param appContactName the appContactName to set
		 */
		public void setAppContactName(String appContactName) {
			this.appContactName = appContactName;
		}

		/**
		 * @return the appContactEmail
		 */
		public String getAppContactEmail() {
			return appContactEmail;
		}

		/**
		 * @param appContactEmail the appContactEmail to set
		 */
		public void setAppContactEmail(String appContactEmail) {
			this.appContactEmail = appContactEmail;
		}	
		
	
	/**
	 * 
	 * @return boolean true/false value
	 */
	public boolean validate () 
	{
		if (appID == -1) return false;
                if (appName == null) return false;
		if (appVendor == null) return false;
		if (applicationType == null) return false;
		if (appVers == null) return false;
		if (appState == null) return false;
		if (appProdName == null) return false;
		if (appFileSize == null) return false;
		if (appCheckSum == null) return false;
		if (appDescription == null) return false;
		if (appURL == null) return false;
		if (appContactName == null) return false;
		if (appContactEmail == null) return false;
	
		return true;
	}

	/**
	 * 
	 * @param Application
	 * @return boolean true/false value
	 */
	public boolean equals(Application application) 
	{
		// if (!appID.equals(application.getAppID())) return false;
                if (!appName.equals(application.getAppName())) return false;
		if (!appVendor.equals(application.getAppVendor())) return false;
		if (!applicationType.equals(application.getApplicationType())) return false;
		if (!appVers.equals(application.getAppVers())) return false;
		if (!appState.equals(application.getAppState())) return false;
		if (!appProdName.equals(application.getAppVendor())) return false;
		if (!appFileSize.equals(application.getAppFileSize())) return false;
		if (!appCheckSum.equals(application.getAppCheckSum())) return false;
		if (!appDescription.equals(application.getAppDescription())) return false;
		if (!appURL.equals(application.getAppURL())) return false;
		if (!appContactName.equals(application.getAppContactName())) return false;
		if (!appContactEmail.equals(application.getAppContactEmail())) return false;
		
		return true;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	@Override
	public String toString()
	{
	    final String TAB = "    ";
	    
	    String retValue = "";
	    
	    retValue = "Application ( "
	        + super.toString() + TAB
                + "appID = " + this.appID + TAB
	        + "appName = " + this.appName + TAB
	        + "appVendor = " + this.appVendor + TAB
	        + "applicationType = " + this.applicationType + TAB
	        + "appVers = " + this.appVers + TAB
	        + "appState = " + this.appState + TAB
	        + "appProdName = " + this.appProdName + TAB
	        + "appFileSize = " + this.appFileSize + TAB
	        + "appCheckSum = " + this.appCheckSum + TAB
	        + "appDescription = " + this.appDescription + TAB
	        + "appURL = " + this.appURL + TAB
	        + "appContactName = " + this.appContactName + TAB
	        + "appContactEmail = " + this.appContactEmail + TAB 
	        + " )";
	
	    return retValue;
	}
	/** 
	 * @param obj The object being compared
	 * @return true if the objects are the same; since IDs should always be unique, no two Applications should ever be equal
	 */
	@Override
	public boolean equals(Object obj) {
		return (this == obj);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		return result;
	}
	
	
} // end of Application class
	
	
	
