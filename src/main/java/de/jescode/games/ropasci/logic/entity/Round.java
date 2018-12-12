/**
 * 
 */
package de.jescode.games.ropasci.logic.entity;

import de.jescode.games.ropasci.logic.RuleLogicUtility;

/**
 * @author jescode
 * Round of a Game
 */
public class Round {
	
	private final int index;
	private final Strategy strategyOne;
	private final Strategy strategyTwo;
	private final Player playerOne;
	private final Player playerTwo;
	private String winner;
	
	
	public Round (final Strategy strategyOne, final Strategy strategyTwo, final int index, final Player playerOne, final Player playerTwo) {
		this.strategyOne = strategyOne;
		this.strategyTwo = strategyTwo;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.index = index;
	}


	/**
	 * @return the strategyOne
	 */
	public Strategy getStrategyOne() {
		return strategyOne;
	}


	/**
	 * @return the strategyTwo
	 */
	public Strategy getStrategyTwo() {
		return strategyTwo;
	}


	/**
	 * @return the winner
	 */
	public String getWinner() {
		return winner;
	}


	/**
	 * @param winner the winner to set
	 */
	public void setWinner(final String winner) {
		this.winner = winner;
	}


	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}


	/**
	 * @return the playerOne
	 */
	public Player getPlayerOne() {
		return playerOne;
	}


	/**
	 * @return the playerTwo
	 */
	public Player getPlayerTwo() {
		return playerTwo;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(" -- Round " + getIndex() + " -- " + System.lineSeparator())
			.append(playerOne.getName() + " with " + getStrategyOne() + " x " + playerTwo.getName() + " with "
				+ getStrategyTwo() + System.lineSeparator());
		
		if (getWinner() == RuleLogicUtility.PLAYERONE) {
			str.append(playerOne.getName() + " wins this round!");
		} else if (getWinner() == RuleLogicUtility.PLAYERTWO) {
			str.append(playerTwo.getName() + " wins this round!");
		} else {
			str.append("It's a draw!");
		}
		str.append(System.lineSeparator());
		
		return str.toString();
	}

}
