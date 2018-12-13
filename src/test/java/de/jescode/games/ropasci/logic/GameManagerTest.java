/**
 * 
 */
package de.jescode.games.ropasci.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import de.jescode.games.ropasci.logic.entity.Player;
import de.jescode.games.ropasci.logic.entity.Strategy;

/**
 * @author jescode
 *
 */
public class GameManagerTest {

	private static final String PLAYER_ONE = "Jesko";
	private static final String PLAYER_TWO = "Celina";

	GameManager gameManager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		gameManager = GameManager.getInstance();
	}

	/**
	 * Test method for
	 * {@link de.jescode.games.ropasci.logic.GameManager#setPlayerNames(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testSetPlayerNames() {
		gameManager.setPlayerNames(PLAYER_ONE, PLAYER_TWO);
		assertEquals(PLAYER_ONE, gameManager.getPlayerOne().getName());
		assertEquals(PLAYER_TWO, gameManager.getPlayerTwo().getName());
	}

	/**
	 * Test method for
	 * {@link de.jescode.games.ropasci.logic.GameManager#setStrategy(de.jescode.games.ropasci.logic.entity.Strategy, de.jescode.games.ropasci.logic.entity.Strategy)}.
	 */
	@Test
	public final void testSetStrategy() {
		gameManager.setStrategy(Strategy.ROCK, Strategy.SCISSOR);
		assertEquals(Strategy.ROCK, gameManager.getPlayerOne().getStrategy());
		assertEquals(Strategy.SCISSOR, gameManager.getPlayerTwo().getStrategy());
	}

	/**
	 * Test method for
	 * {@link de.jescode.games.ropasci.logic.GameManager#evalGame()}.
	 */
	@Test
	public final void testEvalGame() throws GameProcessException {
		gameManager.setStrategy(Strategy.ROCK, Strategy.SCISSOR);
		gameManager.setRounds(2);
		gameManager.evalGame();
		Player playerOne = gameManager.getPlayerOne();
		Player playerTwo = gameManager.getPlayerTwo();

		assertEquals(2, playerOne.getWins());
		assertEquals(0, playerOne.getDraws());
		assertEquals(0, playerOne.getDefeats());

		assertEquals(0, playerTwo.getWins());
		assertEquals(0, playerTwo.getDraws());
		assertEquals(2, playerTwo.getDefeats());

		assertEquals(2, gameManager.getRoundHistory().size());
	}

	/**
	 * Test method for
	 * {@link de.jescode.games.ropasci.logic.GameManager#initGameSettings()}.
	 */
	@Test
	public final void testInitGameSettings() throws GameProcessException {
		
		gameManager.setStrategy(Strategy.ROCK, Strategy.SCISSOR);
		gameManager.setRounds(2);
		gameManager.evalGame();
		
		gameManager.initGameSettings();

		assertEquals(1, gameManager.getRounds());
		assertEquals(0, gameManager.getRoundHistory().size());
		assertEquals(RuleLogicUtility.PLAYERONE, gameManager.getPlayerOne().getName());
		assertEquals(RuleLogicUtility.PLAYERTWO, gameManager.getPlayerTwo().getName());
	}

}
