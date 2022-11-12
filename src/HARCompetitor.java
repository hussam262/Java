
import java.util.Arrays;

/**
 * This class contains details for each Competitor
 */

public abstract class HARCompetitor {
	protected int compNum;
	protected Name compName;
	protected String compLevel;
	protected String raceType;
	protected String compCountry;
	protected int[] compScores;

	/**
	 * Constructor for creating a competitor with all parameters existing
	 * 
	 * @param compNum
	 * @param compName
	 * @param compLevel
	 * @param raceType
	 * @param compCountry
	 * @param scores
	 */
	public HARCompetitor(int compNum, String compName, String compLevel, String raceType, String compCountry,
			int[] scores) {
		this.compNum = compNum;
		this.compName = new Name(compName);

		this.compLevel = compLevel;
		this.raceType = raceType;
		this.compCountry = compCountry;
		this.compScores = new int[5];
		this.compScores = scores;
	}

	/**
	 * This method returns the array of scores
	 * 
	 * @return
	 */
	public int[] getScoreArray() {
		return compScores;
	}

	/**
	 * This method calculate the overall score depending on the raceType
	 * 
	 * @return
	 */
	public abstract double  getOverallScore();

	/**
	 * This method returns a string with full details of the competitor
	 * 
	 * @return
	 */
	public String getFullDetails() {

		return "Competitor no is " + compNum + " ,Competitor name is " + compName.getFullName() + " from " + compCountry
				+ " ,his level is " + compLevel + " ,he runs in " + raceType + " races and received these scores "
				+ Arrays.toString(compScores) + " and his overall score is " + getOverallScore();
	}

	/**
	 * This method returns a string with short details of the competitor
	 * 
	 * @return
	 */
	public String getShortDetails() {

		if (compName.getMiddleName() == "") {

			return "CN " + compNum + " (" + compName.getFirstName().charAt(0) + compName.getLastName().charAt(0)
					+ ")  has overall score " + getOverallScore();
		} else
			return "CN " + compNum + " (" + compName.getFirstName().charAt(0) + compName.getMiddleName().charAt(0)
					+ compName.getLastName().charAt(0) + ")  has overall score " + getOverallScore();
	}

	/**
	 * This method returns the score frequency for each competitor
	 * 
	 * @return
	 */
	public int[] getScoreFrequency() {
		int maxScore = 5;
		int[] freqScores = new int[maxScore];
		for (int i = 0; i < compScores.length; i++) {

			freqScores[compScores[i] - 1]++;
		}

		return freqScores;
	}

	/**
	 * This method returns the competitor number
	 * 
	 * @return
	 */
	public int getCompNum() {
		return compNum;
	}

	/**
	 * This method sets the competitor number
	 * 
	 * @param compNum
	 */
	public void setCompNum(int compNum) {
		this.compNum = compNum;
	}

	/**
	 * This method returns the competitor name
	 * 
	 * @return
	 */
	public String getCompName() {
		return compName.getFullName();
	}

	/**
	 * This method sets the competitor name
	 * 
	 * @param compName
	 */
	public void setCompName(Name compName) {
		this.compName = compName;
	}

	/**
	 * This method returns the competitor level
	 * 
	 * @return
	 */
	public String getCompLevel() {
		return compLevel;
	}

	/**
	 * This method sets the competitor level
	 * 
	 * @param compLevel
	 */
	public void setCompLevel(String compLevel) {
		this.compLevel = compLevel;
	}

	/**
	 * This method returns the race type
	 * 
	 * @return
	 */
	public String getRaceType() {
		return raceType;
	}

	/**
	 * This method sets the race type
	 * 
	 * @param raceType
	 */
	public void setRaceType(String raceType) {
		this.raceType = raceType;
	}

	/**
	 * This method returns the competitor country
	 * 
	 * @return
	 */
	public String getCompCountry() {
		return compCountry;
	}

	/**
	 * This method sets the competitor country
	 * 
	 * @param compCountry
	 */
	public void setCompCountry(String compCountry) {
		this.compCountry = compCountry;
	}

}
