package com.voyage.model.business.manager;

import java.util.Set;
/**
 * Used as an abstract class for the managers in the business layer
 * Static code below is executed anytime any of the managers in the 
 * business layer are executed that inherit this abstract class
 * 
 * @author Jason Canney
 *       
 */       
public abstract class ManagerSuperType {

    	
	public abstract boolean setMetadata(String commandString, Object object) throws ClassNotFoundException; 
	
	
	public abstract Set<?> getMetadata(String commandString, int id) throws ClassNotFoundException; 
	
}
