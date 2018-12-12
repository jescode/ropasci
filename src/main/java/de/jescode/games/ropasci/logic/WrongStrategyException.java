/**
 * 
 */
package de.jescode.games.ropasci.logic;

import de.jescode.games.ropasci.logic.entity.Strategy;

/**
 * @author jescode
 * Exception for wrong used strategies
 */
public final class WrongStrategyException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongStrategyException(final Strategy strategy) {
		super("Strategy: " + strategy + " not able to use here");
	}

}
