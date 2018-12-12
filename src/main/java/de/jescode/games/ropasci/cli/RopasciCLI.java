package de.jescode.games.ropasci.cli;

import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import de.jescode.games.ropasci.logic.GameManager;
import de.jescode.games.ropasci.logic.entity.Strategy;
import de.jescode.games.ropasci.logic.entity.UnknownStrategyException;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;

/**
 * @author jescode
 * ShellComponent to handle the CLI
 */
@ShellComponent
public class RopasciCLI {
	
	private static final Logger LOG = LoggerFactory.getLogger(RopasciCLI.class);

	@Autowired
	GameManager gameManager;

	@ShellMethod(value = "Set name of the players")
	public String setPlayernames(@ShellOption(defaultValue = "Player1", value = { "-1",
			"--first" }, help = "\"-1\", \"--first\" for the first player -  \"-2\", \"--second\"  for the second player") String playerOne,
			@ShellOption(defaultValue = "Player2", value = { "-2", "--second" }) String playerTwo) {

		gameManager.setPlayerNames(playerOne, playerTwo);
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Names successfully set");
		}

		return gameManager.getPlayerOne().getName() + " and " + gameManager.getPlayerTwo().getName()
				+ " will play against each other";
	}

	@ShellMethod(value = "Set name of the players - default value is random")
	public String setStrategy(@ShellOption(defaultValue = "random", value = { "-1",
			"--first" }, help = "\"-1\", \"--first\" for the first player -  \"-2\", \"--second\"  for the second player") String strategy1,
			@ShellOption(defaultValue = "random", value = { "-2", "--second" }) String strategy2) {

		try {
			gameManager.setStrategy(Strategy.getStrategyByName(strategy1.toLowerCase(Locale.ENGLISH)),
					Strategy.getStrategyByName(strategy2.toLowerCase(Locale.ENGLISH)));
		} catch (UnknownStrategyException e) {
			return e.getMessage();
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Strategy successfully set");
		}
		
		return "Strategy for the players successfully set" + System.lineSeparator()
				+ gameManager.getPlayerOne().getName() + ": " + gameManager.getPlayerOne().getStrategy()
				+ System.lineSeparator() + gameManager.getPlayerTwo().getName() + ": "
				+ gameManager.getPlayerTwo().getStrategy();
	}

	@ShellMethod(value = "Start the game with n rounds - default value is one")
	public String startGame(@ShellOption(defaultValue = "1") int rounds) {
		gameManager.setRounds(rounds);
		return gameManager.startGame();
	}

	@ShellMethod(value = "Reset the game to default values")
	public String resetGame() {
		gameManager.initGameSettings();
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("Game was successfully reseted");
		}
		
		return "Game was successfully reseted!";
	}

}
