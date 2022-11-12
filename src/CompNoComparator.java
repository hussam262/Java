	import java.util.Comparator;
public class CompNoComparator implements Comparator<HARCompetitor>{


		public int compare(HARCompetitor s1, HARCompetitor s2) {
			return new Integer(s1.getCompNum()).compareTo(new Integer(s2.getCompNum()));
		}
	}


