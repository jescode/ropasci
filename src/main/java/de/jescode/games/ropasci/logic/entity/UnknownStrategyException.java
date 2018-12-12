/**
 * 
 */
package de.jescode.games.ropasci.logic.entity;

/**
 * @author jescode
 *
 */
public final class UnknownStrategyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnknownStrategyException(String typeName) {
		super("Strategy: " + typeName + " not found");
	}

}
