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
public class ReleaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1123523456523L;
	private static Throwable inNestedException;
	private static String inMessage;

	/**
	 * 
	 * @param string
	 * @param ioeinMessage
	 */
	public ReleaseException(String string, IOException ioeinMessage)
    {
        super(inMessage, inNestedException);
    }

	/**
	 * 
	 * @param string
	 * @param fnfe
	 */
	public ReleaseException(String string, FileNotFoundException fnfe) {
        super(inMessage, inNestedException);
	}

	/**
	 * 
	 * @param string
	 */
	public ReleaseException(String string) {
        super(inMessage, inNestedException);
	}

	/**
	 * 
	 * @param string
	 * @param cnfe
	 */
	public ReleaseException(String string, ClassNotFoundException cnfe) {
        super(inMessage, inNestedException);
	}
}
