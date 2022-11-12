import java.util.Arrays;

public class MiddleCompetitor extends HARCompetitor{

	public MiddleCompetitor(int compNum, String compName, String compLevel, String raceType, String compCountry,
			int[] scores) {
		super(compNum,compName,compLevel,raceType,compCountry,
				scores);
		// TODO Auto-generated constructor stub
	}
	
	public double  getOverallScore() {
		
		double score = 0.15 * (compScores[0] + compScores[1]) + 0.2 * (compScores[2] + compScores[3])
				+ 0.3 * compScores[4];
		return (double) Math.round(score * 100d) / 100d;
	}

}
