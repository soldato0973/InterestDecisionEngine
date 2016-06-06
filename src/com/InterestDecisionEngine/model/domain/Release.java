package com.InterestDecisionEngine.model.domain;

import java.io.Serializable;


/**
 * Release class which stores release specific information
 * Releases can be related to many different applications and hardware
 * @author JasonCanney
 *
 */

	public class Release implements Serializable
	{

		/** Exception class stub */
		public class InvalidReleaseException {

	}

		/**
		 * @param serialVersionUID
		 * The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
		 *  number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
		 *  then an InvalidClassException is thrown
		 */
		
		private static final long serialVersionUID = 1L;

		private static final int ID = 0;

			/** Release Name Application is associated with */
			private String releaseName;	
	
			/** Release Number Application is associated with */
			private String releaseNumber;
		  
			/** Type of release that application is associated with */
			private String releaseType;
		
		/**
		 * Copy Constructor
		 *
		 * @param release a <code>Release</code> object
		 */
		public Release(Release release) 
		{
		    this.releaseName = release.releaseName;
			this.releaseNumber = release.releaseNumber;
		    this.releaseType = release.releaseType;
		}

		/**
		 * @param releaseName
		 * @param releaseNumber
		 * @param releaseType
		 * @param application
		 */
		public Release(String releaseName, String releaseNumber, String releaseType)
		{
			this.releaseName = releaseName;
			this.releaseNumber = releaseNumber;
			this.releaseType = releaseType;
		}
	
	
		  
			public Release() {
			// Auto-generated constructor stub
		}

			/**
			 * @return the releaseName
			 */
			public String getReleaseName() {
				return releaseName;
			}

			/**
			 * @param releaseName the releaseName to set
			 */
			public void setReleaseName(String releaseName) {
				this.releaseName = releaseName;
			}
					
			/**
			 * @return the release number
			 */
			public String getReleaseNumber() {
				return releaseNumber;
			}

			/**
			 * @param releaseNumber to set release number
			 */
			public void setReleaseNumber(String releaseNumber) {
				this.releaseNumber = releaseNumber;
			}
	
			/**
			 * @return the releaseType
			 */
			public String getReleaseType() {
				return releaseType;
			}
	
			/**
			 * @param releaseType the releaseType to set
			 */
			public void setReleaseType(String releaseType) {
				this.releaseType = releaseType;
			}

			
			/**
			 * 
			 * @return boolean true/false
			 */
			public boolean validate () 
			{
				if (releaseName == null) return false;
				// if (releaseNumber == null) return false;
				if (releaseType == null) return false;
			
				return true;
			}

			/**
			 * 
			 * @param Application
			 * @return boolean true/false
			 */
			public boolean equals(Release release) 
			{
				if (!releaseName.equals(release.getReleaseName())) return false;
				// if (!releaseNumber.equals(release.getreleaseNumber())) return false;
				if (!releaseType.equals(release.getReleaseType())) return false;
				
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
			    
			    retValue = "Release ( "
			        + super.toString() + TAB
			        + "releaseName = " + this.releaseName + TAB
			        + "releaseNumber = " + this.releaseNumber + TAB
			        + "releaseType = " + this.releaseType + TAB
			        + " )";
			
			    return retValue;
			}

			/** 
			 * @param obj The object being compared
			 * @return true if the objects are the same; since IDs should always be unique, no two Releases should ever be equal
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
			
			
			
	}	// end of Release class
