package de.jescode.games.ropasci.service.swagger.api;



import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import de.jescode.games.ropasci.logic.GameManager;
import de.jescode.games.ropasci.logic.entity.Strategy;
import de.jescode.games.ropasci.logic.entity.UnknownStrategyException;
import de.jescode.games.ropasci.mapper.GameMapper;
import de.jescode.games.ropasci.mapper.PlayerMapper;
import de.jescode.games.ropasci.mapper.RoundMapper;
import de.jescode.games.ropasci.service.swagger.model.GameDTO;
import de.jescode.games.ropasci.service.swagger.model.PlayerDTO;
import de.jescode.games.ropasci.service.swagger.model.RoundDTO;
import io.swagger.annotations.ApiParam;

/**
 * @author jescode
 * Controller to handle all request/responses of RopasciApi
 */
@RestController
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE })
public class RopasciApiController implements RopasciApi {
	
	private final static Logger LOG = LoggerFactory.getLogger(RopasciApiController.class);

	private final static String PLAYERONE = "1";
	private final static String PLAYERTWO = "2";

	private final HttpServletRequest request;

	@Autowired
	GameManager gameManager;

	@Autowired
	GameMapper gameMapper;

	@Autowired
	PlayerMapper playerMapper;

	@Autowired
	RoundMapper roundMapper;

	@Autowired
	public RopasciApiController(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public ResponseEntity<PlayerDTO> getPlayer(
			@ApiParam(value = "pass the number of the requested player", required = true) @PathVariable("number") String number) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			PlayerDTO player;
			if (number.equals(PLAYERONE)) {
				player = playerMapper.mapPlayer(gameManager.getPlayeOne());
			} else if (number.equals(PLAYERTWO)) {
				player = playerMapper.mapPlayer(gameManager.getPlayerTwo());
			} else {
				return new ResponseEntity<PlayerDTO>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<PlayerDTO>(player, HttpStatus.OK);
		}
		return new ResponseEntity<PlayerDTO>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<RoundDTO> getRound(
			@ApiParam(value = "pass the index of the requested round", required = true) @PathVariable("index") String index) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {

			int indexReq = Integer.valueOf(index);

			if ((indexReq >= 1) && (indexReq <= gameManager.getRoundHistory().size())) {
				RoundDTO roundDTO = roundMapper.mapRound(gameManager.getRoundHistory().get(indexReq - 1));
				return new ResponseEntity<RoundDTO>(roundDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<RoundDTO>(HttpStatus.NOT_FOUND);
			}
		}

		return new ResponseEntity<RoundDTO>(HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<GameDTO> getGame() {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			GameDTO game = gameMapper.mapGame(gameManager.getPlayeOne(), gameManager.getPlayerTwo(),
					gameManager.getRounds(), gameManager.getRoundHistory());
			return new ResponseEntity<GameDTO>(game, HttpStatus.OK);
		}

		return new ResponseEntity<GameDTO>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Void> setStrategy(
			@ApiParam(value = "Player number to set", required = true) @PathVariable("number") String playernumber,
			@ApiParam(value = "Type of the strategy (Rock, Paper, Scissor, Random)", required = true) @PathVariable("strategy") String strategy) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				Strategy strategyReq = Strategy.getStrategyByName(strategy);
				if (playernumber.equals(PLAYERONE)) {
					gameManager.getPlayeOne().setStrategy(strategyReq);
					return new ResponseEntity<Void>(HttpStatus.OK);
				} else if (playernumber.equals(PLAYERTWO)) {
					gameManager.getPlayerTwo().setStrategy(strategyReq);
					return new ResponseEntity<Void>(HttpStatus.OK);
				} else {
					return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
				}

			} catch (UnknownStrategyException e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
		}
		
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

	}

	@Override
	public ResponseEntity<Void> setPlayername(
			@ApiParam(value = "Player number to set", required = true) @PathVariable("number") String playernumber,
			@ApiParam(value = "Name of the player", required = true) @PathVariable("name") String name) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
				if (playernumber.equals(PLAYERONE)) {
					gameManager.getPlayeOne().setName(name);
					return new ResponseEntity<Void>(HttpStatus.OK);
				} else if (playernumber.equals(PLAYERTWO)) {
					gameManager.getPlayerTwo().setName(name);
					return new ResponseEntity<Void>(HttpStatus.OK);
				} else {
					return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
				}
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Void> startGame(
			@ApiParam(value = "pass the count of the requested rounds", required = true) @PathVariable("rounds") String rounds) {
		
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				int roundsReq = Integer.valueOf(rounds);
				gameManager.setRounds(roundsReq);
				gameManager.startGame();
				return new ResponseEntity<Void>(HttpStatus.OK);
			} catch (NumberFormatException e) {
				LOG.error(e.getMessage());
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
			
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

}
