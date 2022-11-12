import java.util.Arrays;

public class OtherCompetitor extends HARCompetitor{

	public OtherCompetitor(int compNum, String compName, String compLevel, String raceType, String compCountry,
			int[] scores) {
		super(compNum,compName,compLevel,raceType,compCountry,
				scores);
		// TODO Auto-generated constructor stub
	}
	public double  getOverallScore() {
		
		double sum = compScores[0] + compScores[1] + compScores[2] + compScores[3] + compScores[4];
		return (double) Math.round(sum / 5 * 100d) / 100d;
		
	}

}
