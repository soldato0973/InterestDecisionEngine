/*
 * Author: Jason Canney
 */
package com.voyage.model.services.exception;

public class DaoLoadException extends Exception {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public DaoLoadException(final String inMessage, final Throwable inNestedException)
		{
							super(inMessage, inNestedException);
		}
}
