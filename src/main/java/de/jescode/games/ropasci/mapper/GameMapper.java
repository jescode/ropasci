/**
 * 
 */
package de.jescode.games.ropasci.mapper;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.jescode.games.ropasci.logic.entity.Player;
import de.jescode.games.ropasci.logic.entity.Round;
import de.jescode.games.ropasci.service.swagger.model.GameDTO;
import de.jescode.games.ropasci.service.swagger.model.PlayerDTO;
import de.jescode.games.ropasci.service.swagger.model.RoundDTO;

/**
 * @author jescode
 * Game Mapping Component
 */
@Component
public class GameMapper {
	
	@Autowired
	PlayerMapper playerMapper;
	
	@Autowired
	RoundMapper roundMapper;
	
	/**
	 * Maps logic Game state to GameDTO
	 * @param playerOne
	 * @param playerTwo
	 * @param roundCount
	 * @param roundHistory
	 * @return GameDTO
	 */
	public GameDTO mapGame(Player playerOne, Player playerTwo, int roundCount, List<Round> roundHistory) {
		GameDTO gameDTO = new GameDTO();
	
		PlayerDTO playerOneDTO = playerMapper.mapPlayer(playerOne);
		PlayerDTO playerTwoDTO = playerMapper.mapPlayer(playerTwo);
		List<RoundDTO> roundsDTO = roundMapper.mapRounds(roundHistory);
		
		gameDTO.setPlayerOne(playerOneDTO);
		gameDTO.setPlayerTwo(playerTwoDTO);
		gameDTO.setRounds(roundCount);
		gameDTO.setRoundHistory(roundsDTO);
		return gameDTO;
		
	}
	
}
