package com.InterestDecisionEngine.model.domain;

import java.io.Serializable;

/**
 * Hardware class that contains hardware specific metadata related to a particular application
 * @author JasonCanney
 *
 */

	public class Hardware implements Serializable
	{

		/**
		 * @param serialVersionUID
		 * The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses this
		 *  number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found,
		 *  then an InvalidClassException is thrown
		 */
		
		private static final long serialVersionUID = 1L;

		private static final int ID = 0;
		  
		  /** Processor that application is targeted towards */
		  private String platformProcessor;
		  
		  /** Processor Vendor */
		  private String processorVendor;
		  
		  /** Processor Number */
		  private String processorNumber;
		  
		  /** Platform Memory */
		  private String platformMemory;
		  
		  /** Platform */
		  private String platform;
	   
	/**
	 * Copy Constructor
	 *
	 * @param hardware a <code>Hardware</code> object
	 */
	public Hardware(Hardware hardware) 
	{
	    this.platformProcessor = hardware.platformProcessor;
		this.processorVendor = hardware.processorVendor;
	    this.processorNumber = hardware.processorNumber;
	    this.platformMemory = hardware.platformMemory;
		this.platform = hardware.platform;
	}

	/**
	 * @param platformProcessor
	 * @param processorVendor
	 * @param processorNumber
	 * @param platformMemory
	 * @param platform
	 * @param processorNumber 
	 */
	public Hardware(String platformProcessor, String processorVendor, String processorNumber, String platformMemory, 
			String platform)
	{
	    this.platformProcessor = platformProcessor;
		this.processorVendor = processorVendor;
	    this.processorNumber = processorNumber;
	    this.platformMemory = platformMemory;
		this.platform = platform;
	}	

		/**
		 * @return the platformProcessor
		 */
		public String getPlatformProcessor() {
			return platformProcessor;
		}

		/**
		 * @param platformProcessor the platformProcessor to set
		 */
		public void setPlatformProcessor(String platformProcessor) {
			this.platformProcessor = platformProcessor;
		}

		/**
		 * @return the processorVendor
		 */
		public String getProcessorVendor() {
			return processorVendor;
		}

		/**
		 * @param processorVendor the processorVendor to set
		 */
		public void setProcessorVendor(String processorVendor) {
			this.processorVendor = processorVendor;
		}

		/**
		 * @return the processorNumber
		 */
		public String getProcessorNumber() {
			return processorNumber;
		}

		/**
		 * @param processorNumber the processorNumber to set
		 */
		public void setProcessorNumber(String processorNumber) {
			this.processorNumber = processorNumber;
		}

		/**
		 * @return the platformMemory
		 */
		public String getPlatformMemory() {
			return platformMemory;
		}

		/**
		 * @param platformMemory the platformMemory to set
		 */
		public void setPlatformMemory(String platformMemory) {
			this.platformMemory = platformMemory;
		}

		/**
		 * @return the platform
		 */
		public String getPlatform() {
			return platform;
		}

		/**
		 * @param platform the platform to set
		 */
		public void setPlatform(String platform) {
			this.platform = platform;
		}

	
	/**
	 * 
	 * @return boolean true/false
	 */
	public boolean validate () 
	{
		if (platformProcessor == null) return false;
		if (processorVendor == null) return false;
		if (processorNumber == null) return false;
		if (platformMemory == null) return false;
		if (platform ==null) return false;
	
		return true;
	}

	/**
	 * 
	 * @param Application
	 * @return boolean true/false
	 */
	public boolean equals(Hardware hardware) 
	{
		if (!platformProcessor.equals(hardware.getPlatformProcessor())) return false;
		if (!processorVendor.equals(hardware.getProcessorVendor())) return false;
		if (!processorNumber.equals(hardware.getProcessorNumber())) return false;
		if (!platformMemory.equals(hardware.getPlatformMemory())) return false;
		if (!platform.equals(hardware.getPlatform())) return false;
		
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
	    
	    retValue = "Application ( "
	        + super.toString() + TAB
	        + "platformProcessor = " + this.platformProcessor + TAB
	        + "processorVendor = " + this.processorVendor + TAB
	        + "processorNumber = " + this.processorNumber + TAB        
	        + "platformMemory = " + this.platformMemory + TAB
	        + "platform = " + this.platform + TAB
	        + " )";
	
	    return retValue;
	}
	
	/** 
	 * @param obj The object being compared
	 * @return true if the objects are the same; since IDs should always be unique, no two Hardware should ever be equal
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
	
	
}
	
	
	
