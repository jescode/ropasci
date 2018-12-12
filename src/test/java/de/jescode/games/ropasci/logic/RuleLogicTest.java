/**
 * 
 */
package de.jescode.games.ropasci.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.jescode.games.ropasci.logic.entity.Strategy;

/**
 * @author jescode
 *
 */
public class RuleLogicTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link de.jescode.games.ropasci.logic.RuleLogicUtility#evalMove(de.jescode.games.ropasci.logic.entity.Strategy, de.jescode.games.ropasci.logic.entity.Strategy)}.
	 */
	@Test
	public final void testEvalMovePositive() throws WrongStrategyException {
		
			// Rock check
			assertEquals(RuleLogicUtility.evalMove(Strategy.ROCK, Strategy.PAPER), RuleLogicUtility.DEFEAT);
			assertEquals(RuleLogicUtility.evalMove(Strategy.ROCK, Strategy.SCISSOR), RuleLogicUtility.VICTORY);
			assertEquals(RuleLogicUtility.evalMove(Strategy.ROCK, Strategy.ROCK), RuleLogicUtility.DRAW);
			// Paper check
			assertEquals(RuleLogicUtility.evalMove(Strategy.PAPER, Strategy.PAPER), RuleLogicUtility.DRAW);
			assertEquals(RuleLogicUtility.evalMove(Strategy.PAPER, Strategy.SCISSOR), RuleLogicUtility.DEFEAT);
			assertEquals(RuleLogicUtility.evalMove(Strategy.PAPER, Strategy.ROCK), RuleLogicUtility.VICTORY);
			// Scissor check
			assertEquals(RuleLogicUtility.evalMove(Strategy.SCISSOR, Strategy.PAPER), RuleLogicUtility.VICTORY);
			assertEquals(RuleLogicUtility.evalMove(Strategy.SCISSOR, Strategy.SCISSOR), RuleLogicUtility.DRAW);
			assertEquals(RuleLogicUtility.evalMove(Strategy.SCISSOR, Strategy.ROCK), RuleLogicUtility.DEFEAT);

	}
	
	@Test(expected=WrongStrategyException.class)
	public final void testEvalMoveNegative() throws WrongStrategyException {
		RuleLogicUtility.evalMove(Strategy.RANDOM, Strategy.RANDOM);
	}

}
