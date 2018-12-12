/**
 * 
 */
package de.jescode.games.ropasci.logic;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import de.jescode.games.ropasci.logic.entity.Player;
import de.jescode.games.ropasci.logic.entity.Round;
import de.jescode.games.ropasci.logic.entity.Strategy;


/**
 * @author jescode
 * Central component to process the game logic 
 */
@Component
public final class GameManager {

	private final static Logger LOG = LoggerFactory.getLogger(GameManager.class);


	private Player playerOne;
	private Player playerTwo;
	private int rounds;
	private List<Round> roundHistory;
	
	
	@PostConstruct
    private void init() {
        initGameSettings();
        if (LOG.isDebugEnabled()) {
			LOG.debug("Game settings initialized");
		}
    }

	/**
	 * Evaluates the game with the current game settings
	 */
	public void evalGame() {
		
		//loop over the round history
		for (int move = 1; move <= this.rounds; move++) {
			final Strategy moveOfOne = this.playerOne.getMove();
			final Strategy moveOfTwo = this.playerTwo.getMove();
			final Round round = new Round(moveOfOne, moveOfTwo, move, this.playerOne, this.playerTwo);
			int roundResult;
			try {
				roundResult = RuleLogicUtility.evalMove(moveOfOne, moveOfTwo);
				if (RuleLogicUtility.VICTORY == roundResult) {
					playerOne.incWins();
					playerTwo.incDefeats();
					round.setWinner(RuleLogicUtility.PLAYERONE);
				} else if (RuleLogicUtility.DEFEAT == roundResult) {
					playerTwo.incWins();
					playerOne.incDefeats();
					round.setWinner(RuleLogicUtility.PLAYERTWO);
				} else {
					playerTwo.incDraws();
					playerOne.incDraws();
				}
				this.roundHistory.add(round);
			} catch (WrongStrategyException e) {
				if (LOG.isDebugEnabled()) {
					LOG.debug(e.getMessage());
				}
			}
			
		}
		
        if (LOG.isDebugEnabled()) {
			LOG.debug("Game evaluated");
		}
	}

	/**
	 * Prints the evalueted game
	 * @return String - The output
	 */
	public String printGame() {
		final StringBuilder str = new StringBuilder();
		str.append("====== " + playerOne.getName() + " vs. " + playerTwo.getName() + " ====== Rounds:"
				+ rounds + System.lineSeparator());
		this.roundHistory.forEach(round -> {
			str.append(round.toString());
		});
		
		str.append(printGameResult());
		return str.toString();
	}

	/**
	 * Prints the result of the game
	 * @return String - The output
	 */
	public String printGameResult() {
		final StringBuilder str = new StringBuilder();
		str.append("======== Result ========" + System.lineSeparator())
			.append(this.playerOne.toString())
			.append(this.playerTwo.toString()).append("======== Result ========" + System.lineSeparator());
		return str.toString();
	}
	
	
	/**
	 * Evaluates the game and does a print of the game
	 * @return String - The game print
	 */
	public String startGame() {	
		evalGame();
		return printGame();
	}

	
	/**
	 * Sets the PlayerNames of PlayerOne and PlayerTwo
	 * @param playerOne - The name of playerOne
	 * @param playerTwo - The name of playerTwo
	 */
	public void setPlayerNames(final String playerOne, final String playerTwo) {
		this.playerOne.setName(playerOne);
		this.playerTwo.setName(playerTwo);

		if (LOG.isDebugEnabled()) {
			LOG.debug(this.playerOne.getName() + " and " + this.playerTwo.getName() + " have been set");
		}
	}

	/**
	 * Sets the Stratefy of PlayerOne and PlayerTwo
	 * @param strategyOne - The strategy of playerOne
	 * @param strategyTwo - The strategy of playerTwo
	 */
	public void setStrategy(final Strategy strategyOne, final Strategy strategyTwo) {
		this.playerOne.setStrategy(strategyOne);
		this.playerTwo.setStrategy(strategyTwo);

		if (LOG.isDebugEnabled()) {
			LOG.debug(this.playerOne.getStrategy() + " and " + this.playerTwo.getStrategy() + " have been set");
		}
	}

	/**
	 * Initialize the game to default values
	 */
	public void initGameSettings() {
		final Player playerOne = new Player();
		final Player playerTwo = new Player();
		playerOne.setName(RuleLogicUtility.PLAYERONE);
		playerTwo.setName(RuleLogicUtility.PLAYERTWO);
		playerOne.setStrategy(Strategy.RANDOM);
		playerTwo.setStrategy(Strategy.RANDOM);
		this.setPlayerOne(playerOne);
		this.setPlayerTwo(playerTwo);
		this.setRounds(1);
		this.roundHistory = new ArrayList<Round>();

		if (LOG.isDebugEnabled()) {
			LOG.debug("Game is reseted");
		}
	}

	/**
	 * @return the player1
	 */
	public Player getPlayeOne() {
		return playerOne;
	}

	/**
	 * @param player1 the player1 to set
	 */
	public void setPlayerOne(final Player player1) {
		this.playerOne = player1;
	}

	/**
	 * @return the player2
	 */
	public Player getPlayerTwo() {
		return playerTwo;
	}

	/**
	 * @param player2 the player2 to set
	 */
	public void setPlayerTwo(final Player player2) {
		this.playerTwo = player2;
	}

	/**
	 * @return the rounds
	 */
	public int getRounds() {
		return rounds;
	}

	/**
	 * @param rounds the rounds to set
	 */
	public void setRounds(final int rounds) {
		this.rounds = rounds;
	}

	/**
	 * @return the roundHistory
	 */
	public List<Round> getRoundHistory() {
		return roundHistory;
	}

}
