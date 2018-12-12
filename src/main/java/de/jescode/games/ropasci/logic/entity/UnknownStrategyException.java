/**
 * 
 */
package de.jescode.games.ropasci.logic.entity;

/**
 * @author jescode
 * Exception for unknown Strategies
 */
public final class UnknownStrategyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnknownStrategyException(final String typeName) {
		super("Strategy: " + typeName + " not found");
	}

}
