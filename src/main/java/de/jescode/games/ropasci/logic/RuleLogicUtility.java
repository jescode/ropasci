package de.jescode.games.ropasci.logic;

import de.jescode.games.ropasci.logic.entity.Strategy;

public final class RuleLogicUtility {
	
	public final static int DRAW = 0;
	public final static int VICTORY = 1;
	public final static int DEFEAT = 2;
	

	public final static String PLAYERONE = "Player1";
	public final static String PLAYERTWO = "Player2";

	
	/**
	 * @param strategyOne - First Strategy (primary)
	 * @param strategyTwo - Second Strategy (enemy)
	 * @return int - 0 = Draw, 1 = Victory, 2 = Defeat
	 * @throws WrongStrategyException - Random is a not allowed strategy param
	 */
	public static int evalMove (Strategy strategyOne, Strategy strategyTwo) throws WrongStrategyException {
		
		if (strategyOne.equals(Strategy.RANDOM) || strategyTwo.equals(Strategy.RANDOM)) {
			throw new WrongStrategyException(Strategy.RANDOM);
		}
		
		if (strategyOne.equals(Strategy.ROCK)) {
			if (strategyTwo.equals(Strategy.PAPER)) {
				return DEFEAT;
			} else if (strategyTwo.equals(Strategy.SCISSOR)) {
				return VICTORY;
			} else {
				return DRAW;
			}
		} 
		
		if (strategyOne.equals(Strategy.PAPER)) {
			if (strategyTwo.equals(Strategy.SCISSOR)) {
				return DEFEAT;
			} else if (strategyTwo.equals(Strategy.ROCK)) {
				return VICTORY;
			} else {
				return DRAW;
			}
		}
		
		if (strategyOne.equals(Strategy.SCISSOR)) {
			if (strategyTwo.equals(Strategy.ROCK)) {
				return DEFEAT;
			} else if (strategyTwo.equals(Strategy.PAPER)) {
				return VICTORY;
			} else {
				return DRAW;
			}
		}
		return 0;	
	}
	
	
}
