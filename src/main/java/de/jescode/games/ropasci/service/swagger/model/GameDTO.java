package de.jescode.games.ropasci.service.swagger.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

@Validated
public class GameDTO {
	
	@JsonProperty("PlayerOne")
	private PlayerDTO playerOne;
	
	@JsonProperty("PlayerTwo")
	private PlayerDTO playerTwo;
	
	@JsonProperty("CountOfRounds")
	private int rounds;
	
	@JsonProperty("ListOfRounds")
	private List<RoundDTO> roundHistory;

	/**
	 * @return the playerOne
	 */
	@ApiModelProperty(required = true, value = "")
	@NotNull
	public PlayerDTO getPlayerOne() {
		return playerOne;
	}

	/**
	 * @param playerOne the playerOne to set
	 */
	public void setPlayerOne(PlayerDTO playerOne) {
		this.playerOne = playerOne;
	}

	/**
	 * @return the playerTwo
	 */
	@ApiModelProperty(required = true, value = "")
	@NotNull
	public PlayerDTO getPlayerTwo() {
		return playerTwo;
	}

	/**
	 * @param playerTwo the playerTwo to set
	 */
	public void setPlayerTwo(PlayerDTO playerTwo) {
		this.playerTwo = playerTwo;
	}

	/**
	 * @return the rounds
	 */
	@ApiModelProperty(example = "23", required = true, value = "")
	@NotNull
	public int getRounds() {
		return rounds;
	}

	/**
	 * @param rounds the rounds to set
	 */
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	/**
	 * @return the roundHistory
	 */
	 @ApiModelProperty(required = true, value = "")
	 @NotNull
	public List<RoundDTO> getRoundHistory() {
		return roundHistory;
	}

	/**
	 * @param roundHistory the roundHistory to set
	 */
	public void setRoundHistory(List<RoundDTO> roundHistory) {
		this.roundHistory = roundHistory;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerOne == null) ? 0 : playerOne.hashCode());
		result = prime * result + ((playerTwo == null) ? 0 : playerTwo.hashCode());
		result = prime * result + ((roundHistory == null) ? 0 : roundHistory.hashCode());
		result = prime * result + rounds;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameDTO other = (GameDTO) obj;
		if (playerOne == null) {
			if (other.playerOne != null)
				return false;
		} else if (!playerOne.equals(other.playerOne))
			return false;
		if (playerTwo == null) {
			if (other.playerTwo != null)
				return false;
		} else if (!playerTwo.equals(other.playerTwo))
			return false;
		if (roundHistory == null) {
			if (other.roundHistory != null)
				return false;
		} else if (!roundHistory.equals(other.roundHistory))
			return false;
		if (rounds != other.rounds)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Game {\n");
		sb.append("    rounds: ").append(toIndentedString(rounds)).append("\n");
		sb.append("    playerOne: ").append(toIndentedString(playerOne)).append("\n");
		sb.append("    playerTwo: ").append(toIndentedString(playerTwo)).append("\n");
		sb.append("    roundList: ").append(toIndentedString(rounds)).append("\n");
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
