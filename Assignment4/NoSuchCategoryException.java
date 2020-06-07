 /**
 * NoSuchCategoryException.java
 * @author B. Bultena
 *
 * For use with Assignment #4, UVic CSC115 (Spring 2018)
 * University of Victoria.
 */

 /*
  * Name: Parm Johal
  * ID: V00787710
  * Date: April 9, 2018
  * Filename: NoSuchCategoryException.java
  * Details: \CSC 115\ Assignment 4
  */

/**
 * This exception indicates that the triage category for an ERPatient
 * not a valid category.
 * These categories are determined by the ERPatient class.
 */
public class NoSuchCategoryException extends RuntimeException {
	/**
	 * Creates a new exception.
	 * @param msg The error message.
	 */
	public NoSuchCategoryException(String msg) {
		super(msg);
	}
	/**
	 * Creates a new exception.
	 */
	public NoSuchCategoryException() {
		super();
	}
}
