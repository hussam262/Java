import java.util.Arrays;

public class HurdleCompetitor extends HARCompetitor{

	public HurdleCompetitor(int compNum, String compName, String compLevel, String raceType, String compCountry,
			int[] scores) {
		super(compNum,compName,compLevel,raceType,compCountry,
				scores);
		// TODO Auto-generated constructor stub
	}

	public double  getOverallScore() {
		
		int[] a = compScores;
		Arrays.sort(a);
		return (double) Math.round(a[4] * 100d) / 100d;
		
	}
}
