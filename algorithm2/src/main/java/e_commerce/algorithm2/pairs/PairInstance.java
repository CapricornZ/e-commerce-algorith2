package e_commerce.algorithm2.pairs;

public class PairInstance implements IPair {
	
	private String[] pairPattern;
	public PairInstance(String[] array){
		this.pairPattern = array;
	}

	public boolean pair(String first, String second) {
		
		String source = first+second;
		boolean rtn = pairPattern[0].equals(source) || pairPattern[1].equals(source);
		return rtn;
	}
}
