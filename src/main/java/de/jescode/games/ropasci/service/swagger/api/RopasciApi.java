package de.jescode.games.ropasci.service.swagger.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import de.jescode.games.ropasci.service.swagger.model.GameDTO;
import de.jescode.games.ropasci.service.swagger.model.PlayerDTO;
import de.jescode.games.ropasci.service.swagger.model.RoundDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Ropasci")
public interface RopasciApi {

	public final static String RESSOURCE_PATH = "/ropasci";

	@ApiOperation(value = "get player with requested number", nickname = "getPlayer", notes = "By passing in the the appropriate number ( 1 or 2), you'll receive the player ", response = PlayerDTO.class, tags = {
			"Player", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "search result matching criteria", response = PlayerDTO.class),
			@ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Ressource not found") })
	@RequestMapping(value = "/player/{number}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<PlayerDTO> getPlayer(
			@ApiParam(value = "pass the number of the requested player", required = true) @PathVariable("number") String number);
	
	@ApiOperation(value = "get round with requested index", nickname = "getRound", notes = "By passing in the the appropriate index, you'll receive the round ", response = RoundDTO.class, tags = {
			"Round", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "search result matching criteria", response = RoundDTO.class),
			@ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Ressource not found") })
	@RequestMapping(value = "/round/{index}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<RoundDTO> getRound(
			@ApiParam(value = "pass the index of the requested round", required = true) @PathVariable("index") String index);
	
	
	@ApiOperation(value = "get the actual state of game", nickname = "getGame", notes = "You'll get the actual state of the fame", response = GameDTO.class, tags = {
			"Game", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "search result matching criteria", response = GameDTO.class),
			@ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Ressource not found") })
	@RequestMapping(value = "/game", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<GameDTO> getGame();


	@ApiOperation(value = "Sets the strategy of a given player", nickname = "setStrategyOfPlayer", notes = "", tags = { "Player", })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid number supplied"),
			@ApiResponse(code = 404, message = "Invalid strategy")})
	@RequestMapping(value = "/player/{number}/strategy/{strategy}", produces = { "application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> setStrategy(
			@ApiParam(value = "Player number to set", required = true) @PathVariable("number") String playernumber,
			@ApiParam(value = "Type of the strategy (Rock, Paper, Scissor, Random)", required = true) @PathVariable("strategy") String strategy);
	
	
	@ApiOperation(value = "Sets the name of a given player", nickname = "setNameOfPlayer", notes = "", tags = { "Player", })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid number supplied")})
	@RequestMapping(value = "/player/{number}/{name}", produces = { "application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Void> setPlayername(
			@ApiParam(value = "Player number to set", required = true) @PathVariable("number") String playernumber,
			@ApiParam(value = "Name of the player", required = true) @PathVariable("name") String name);
	
	@ApiOperation(value = "Start game with n rounds", nickname = "startGame", notes = "Start game with n rounds, default is one", tags = {
			"Game", })
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input") })
	@RequestMapping(value = "/game/{rounds}", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> startGame(
			@ApiParam(value = "pass the count of the requested rounds", required = true) @PathVariable("rounds") String rounds);

	
	
	

}