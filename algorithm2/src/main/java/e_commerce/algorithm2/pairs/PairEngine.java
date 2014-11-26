package e_commerce.algorithm2.pairs;

import java.util.ArrayList;
import java.util.List;

public class PairEngine implements IPair {
	
	private List<IPair> pairs = new ArrayList<IPair>();

	public boolean pair(String first, String second) {
		
		boolean rtn = false;
		for(int i=0; i<pairs.size() && !rtn; i++)
			rtn = pairs.get(i).pair(first, second);
		return rtn;
	}
	
	private static PairEngine pairEngine;
	static{
		pairEngine = new PairEngine();
		pairEngine.pairs.add(new PairInstance(new String[]{"AAAA","AAAA"}));
		pairEngine.pairs.add(new PairInstance(new String[]{"BBBB","BBBB"}));
		pairEngine.pairs.add(new PairInstance(new String[]{"BAAB","ABBA"}));
		pairEngine.pairs.add(new PairInstance(new String[]{"ABAB","ABAB"}));
		pairEngine.pairs.add(new PairInstance(new String[]{"AABB","BBAA"}));
		pairEngine.pairs.add(new PairInstance(new String[]{"BABA","BABA"}));
		pairEngine.pairs.add(new PairInstance(new String[]{"BBAA","AABB"}));
	}
	public static IPair getInstance(){
		return pairEngine;
	}
}
