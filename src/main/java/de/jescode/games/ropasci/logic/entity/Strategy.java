/**
 * 
 */
package de.jescode.games.ropasci.logic.entity;

import java.util.Random;


/**
 * @author jescode
 * Enum for all available strategies
 */
public enum Strategy {
	
	ROCK("rock"), PAPER("paper"), SCISSOR("scissor"), RANDOM("random");
	
	private final String typeName;

	
	private static final Random RANDOMIZER = new Random();
	
	private Strategy(final String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	public static Strategy getStrategyByName(final String typeName) throws UnknownStrategyException {
		for (Strategy s : Strategy.values()) {
			if (s.typeName.equals(typeName)) {
				return s;
			}
		}
		throw new UnknownStrategyException(typeName);
	}
	
	public static Strategy getRandomStrategy() {
		return Strategy.values()[(RANDOMIZER.nextInt(Strategy.values().length - 1))];
	}

}
