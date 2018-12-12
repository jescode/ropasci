/**
 * 
 */
package de.jescode.games.ropasci.logic.entity;

/**
 * @author jescode
 *
 */
public class Player {

	private String name;
	private int wins;
	private int defeats;
	private int draws;
	private Strategy strategy;

	public Player() {
		this.wins = 0;
		this.draws = 0;
		this.defeats = 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the strategy
	 */
	public Strategy getStrategy() {
		return strategy;
	}

	/**
	 * @param strategy the strategy to set
	 */
	public void setStrategy(final Strategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Returns the next strategy of the player
	 * @return Strategy - Returns the choosen Strategy of Player (Rock, Paper, Scissor if Random is set)
	 */
	public Strategy getMove() {
		if (this.strategy.equals(Strategy.RANDOM)) {
			return Strategy.getRandomStrategy();
		} else {
			return this.strategy;
		}

	}

	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * inc the wins
	 */
	public void incWins() {
		this.wins++;
	}

	/**
	 * inc the defeats
	 */
	public void incDefeats() {
		this.defeats++;
	}

	/**
	 * inc the draws
	 */
	public void incDraws() {
		this.draws++;
	}

	/**
	 * @param wins the wins to set
	 */
	public void setWins(final int wins) {
		this.wins = wins;
	}

	/**
	 * @return the defeats
	 */
	public int getDefeats() {
		return defeats;
	}

	/**
	 * @param defeats the defeats to set
	 */
	public void setDefeats(final int defeats) {
		this.defeats = defeats;
	}

	/**
	 * @return the draws
	 */
	public int getDraws() {
		return draws;
	}

	/**
	 * @param draws the draws to set
	 */
	public void setDraws(final int draws) {
		this.draws = draws;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name + " == Wins: " + String.valueOf(this.wins) + "  == Draws: "
				+ this.draws + " == Defeats: " + this.defeats + " ==" + System.lineSeparator();
	}

}
