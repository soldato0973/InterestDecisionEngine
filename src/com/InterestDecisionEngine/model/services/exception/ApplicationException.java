/**
 * 
 */
package com.voyage.model.services.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Jason L. Canney
 *
 */
public class ApplicationException extends Exception {

	/**
	 * @param serialVersionUID = unique identifier
	 * @param Throwable exception 
	 * @param inMessage is a string
	 */
	private static final long serialVersionUID = 1L;
	private static Throwable inNestedException;
	private static String inMessage;

	/**
	 * 
	 * @param string
	 * @param ioeinMessage
	 */
	public ApplicationException(String string, IOException ioeinMessage)
    {
        super(inMessage, inNestedException);
    }

	/**
	 * 
	 * @param string
	 * @param fnfe
	 */
	public ApplicationException(String string, FileNotFoundException fnfe) {
        super(inMessage, inNestedException);
	}

	/**
	 * 
	 * @param string
	 */
	public ApplicationException(String string) {
        super(inMessage);
	}

	/**
	 * 
	 * @param string
	 * @param cnfe
	 */
	public ApplicationException(String string, ClassNotFoundException cnfe) {
        super(inMessage, inNestedException);
	}
}
