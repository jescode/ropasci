package de.jescode.games.ropasci.service.swagger.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import de.jescode.games.ropasci.logic.entity.Strategy;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * Round
 */
@Validated
public class RoundDTO {

	@JsonProperty("Index")
	private  int index;
	
	@JsonProperty("StrategyOfPlayerOne")
	private  Strategy strategyOne;
	
	@JsonProperty("StratefyOfPlayerTwo")
	private  Strategy strategyTwo;
	
	@JsonProperty("WinnerOfRound")
	private  String winner;

	

	/**
	 * @return the index
	 */
	@ApiModelProperty(example = "34", required = true, value = "")
	@NotNull
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the strategyOne
	 */
	@ApiModelProperty(example = "ROCK", required = true, value = "")
	@NotNull
	public Strategy getStrategyOne() {
		return strategyOne;
	}

	/**
	 * @param strategyOne the strategyOne to set
	 */
	public void setStrategyOne(Strategy strategyOne) {
		this.strategyOne = strategyOne;
	}

	/**
	 * @return the strategyTwo
	 */
	@ApiModelProperty(example = "PAPER", required = true, value = "")
	@NotNull
	public Strategy getStrategyTwo() {
		return strategyTwo;
	}

	/**
	 * @param strategyTwo the strategyTwo to set
	 */
	public void setStrategyTwo(Strategy strategyTwo) {
		this.strategyTwo = strategyTwo;
	}



	/**
	 * @return the winner
	 */
	@ApiModelProperty(example = "PlayerOne", required = true, value = "")
	@NotNull
	public String getWinner() {
		return winner;
	}

	/**
	 * @param winner the winner to set
	 */
	public void setWinner(String winner) {
		this.winner = winner;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + ((strategyOne == null) ? 0 : strategyOne.hashCode());
		result = prime * result + ((strategyTwo == null) ? 0 : strategyTwo.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
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
		RoundDTO other = (RoundDTO) obj;
		if (index != other.index)
			return false;
		if (strategyOne != other.strategyOne)
			return false;
		if (strategyTwo != other.strategyTwo)
			return false;
		if (winner == null) {
			if (other.winner != null)
				return false;
		} else if (!winner.equals(other.winner))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Round {\n");
		sb.append("    index: ").append(toIndentedString(index)).append("\n");
		sb.append("    strategyOne: ").append(toIndentedString(strategyOne)).append("\n");
		sb.append("    strategyTwo: ").append(toIndentedString(strategyTwo)).append("\n");
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
