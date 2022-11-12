import java.util.Arrays;

public class ShortCompetitor extends HARCompetitor{

	public ShortCompetitor(int compNum, String compName, String compLevel, String raceType, String compCountry,
			int[] scores) {
		super(compNum,compName,compLevel,raceType,compCountry,
				scores);
		
		// TODO Auto-generated constructor stub
	}
	
	public double  getOverallScore() {
		
		int[] a = compScores;
		Arrays.sort(a);
		double score = (a[2] + a[3] + a[4]) / 3.0;
		return (double) Math.round(score * 100d) / 100d;
	}

}
