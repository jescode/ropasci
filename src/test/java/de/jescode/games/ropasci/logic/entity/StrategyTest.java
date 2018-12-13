package de.jescode.games.ropasci.logic.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrategyTest {

	@Test
	public final void testGetStrategyByName() throws UnknownStrategyException {
		assertEquals(Strategy.RANDOM, Strategy.getStrategyByName("random"));
		assertEquals(Strategy.ROCK, Strategy.getStrategyByName("rock"));
		assertEquals(Strategy.PAPER, Strategy.getStrategyByName("paper"));
		assertEquals(Strategy.SCISSOR, Strategy.getStrategyByName("scissor"));
	}
	
	@Test(expected=UnknownStrategyException.class)
	public final void testGetStrategyByNameNegative() throws UnknownStrategyException {
		Strategy.getStrategyByName("wrongStrategy");
	}

}
