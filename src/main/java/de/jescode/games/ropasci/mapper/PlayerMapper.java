/**
 * 
 */
package de.jescode.games.ropasci.mapper;

import org.springframework.stereotype.Component;

import de.jescode.games.ropasci.logic.entity.Player;
import de.jescode.games.ropasci.service.swagger.model.PlayerDTO;

/**
 * @author jescode
 * Player mapping component
 */
@Component
public class PlayerMapper {
	
	/**
	 * Maps logic game player to PlayerDTO
	 * @param player
	 * @return PlayerDTO
	 */
	public PlayerDTO mapPlayer(final Player player) {
		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO.setDefeats(player.getDefeats());
		playerDTO.setWins(player.getWins());
		playerDTO.setDraws(player.getDraws());
		playerDTO.setName(player.getName());
		playerDTO.setStrategy(player.getStrategy());
		return playerDTO;	
	}
	
}
