
public class LongCompetitor extends HARCompetitor{

	public LongCompetitor(int compNum, String compName, String compLevel, String raceType, String compCountry,
			int[] scores) {
		super(compNum,compName,compLevel,raceType,compCountry,
				scores);
		// TODO Auto-generated constructor stub
	}

	public double  getOverallScore() {
		
		double score = 0.2 * (compScores[0] + compScores[1] + compScores[2] + compScores[3] + compScores[4]);
		return (double) Math.round(score * 100d) / 100d;
	}
}
