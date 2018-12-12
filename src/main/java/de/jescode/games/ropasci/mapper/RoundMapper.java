/**
 * 
 */
package de.jescode.games.ropasci.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import de.jescode.games.ropasci.logic.entity.Round;
import de.jescode.games.ropasci.service.swagger.model.RoundDTO;

/**
 * @author jescode
 * Round mapping component
 */
@Component
public class RoundMapper {
	
	/**
	 * Maps game logic round to RoundDTO
	 * @param round
	 * @return RoundDTO
	 */
	public RoundDTO mapRound(final Round round) {
		RoundDTO roundDTO = new RoundDTO();
		roundDTO.setIndex(round.getIndex());
		roundDTO.setStrategyOne(round.getStrategyOne());
		roundDTO.setStrategyTwo(round.getStrategyTwo());
		roundDTO.setWinner(round.getWinner());
		return roundDTO;	
	}
	
	/**
	 * Maps game logic roundList to List of RoundDTO
	 * @param rounds
	 * @return List of RoundDTO
	 */
	public List<RoundDTO> mapRounds(final List<Round> rounds) {
		List<RoundDTO> roundsDTO = new ArrayList<>();
		rounds.forEach(round -> {
			RoundDTO roundDTO = mapRound(round);
			roundsDTO.add(roundDTO);
		});
		
		return roundsDTO;
	}
	
}
