package de.jescode.games.ropasci.service.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.jescode.games.ropasci.logic.entity.Strategy;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * Player
 */
@Validated

public class PlayerDTO {

	@JsonProperty("Name")
	private String name = null;
	
	@JsonProperty("Wins")
	private int wins;
	
	@JsonProperty("Defeats")
	private int defeats;
	
	@JsonProperty("Draws")
	private int draws;
	
	@JsonProperty("Strategy")
	private Strategy strategy;



	public PlayerDTO name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(example = "Jesko", required = true, value = "")
	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerDTO wins(int wins) {
		this.wins = wins;
		return this;
	}

	/**
	 * Get wins
	 * 
	 * @return wins
	 **/
	@ApiModelProperty(example = "34", required = true, value = "")
	@NotNull

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public PlayerDTO defeats(int defeats) {
		this.defeats = defeats;
		return this;
	}

	/**
	 * Get defeats
	 * 
	 * @return defeats
	 **/
	@ApiModelProperty(example = "12", required = true, value = "")
	@NotNull

	public int getDefeats() {
		return defeats;
	}

	public void setDefeats(int defeats) {
		this.defeats = defeats;
	}

	public PlayerDTO draws(int draws) {
		this.draws = draws;
		return this;
	}

	/**
	 * Get draws
	 * 
	 * @return draws
	 **/
	@ApiModelProperty(example = "13", required = true, value = "")
	@NotNull
	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}
	

	public PlayerDTO strategy(Strategy strategy) {
		this.strategy = strategy;
		return this;
	}

	/**
	 * Get strategy
	 * 
	 * @return strategy
	 **/
	@ApiModelProperty(example = "ROCK", required = true, value = "")
	@NotNull
	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PlayerDTO player = (PlayerDTO) o;
		return Objects.equals(this.name, player.name) && Objects.equals(this.wins, player.wins)
				&& Objects.equals(this.draws, player.draws) && Objects.equals(this.defeats, player.defeats)
				&& Objects.equals(this.strategy, player.strategy);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, wins, defeats, draws, strategy);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Player {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    wins: ").append(toIndentedString(wins)).append("\n");
		sb.append("    defeats: ").append(toIndentedString(defeats)).append("\n");
		sb.append("    draws: ").append(toIndentedString(draws)).append("\n");
		sb.append("    strategy: ").append(toIndentedString(strategy)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
