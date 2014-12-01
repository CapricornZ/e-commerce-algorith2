package e_commerce.algorithm2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrueAndFalse {
	
	private static final Logger logger = LoggerFactory.getLogger(TrueAndFalse.class);
	private static int[] metaData = new int[] { 1, 2, 3, 5, 8, 13, 21, 34,
		55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946,
		17711, 28657, 46368 };
	
	private List<Boolean> result;
	public TrueAndFalse(List<Boolean> result){
		this.result = result;
	}
	
	private int sum, max;
	private int countTrue, countFalse;	
	public int getSum(){return sum;}
	public int getMax(){return max;}
	public int getCountTrue(){return countTrue;}
	public int getCountFalse(){return countFalse;}
	
	public void print(){
		
		this.countFalse = 0;
		this.countTrue = 0;
		StringBuilder sBuild = new StringBuilder();
		for(Boolean o:this.result){
			if(o){
				countTrue ++;
				sBuild.append("o");
			} else {
				countFalse ++;
				sBuild.append("x");
			}
		}
		logger.info("{}", sBuild);
		logger.info(" [ x:{} ({}%), o:{} ({}%) ]\r\n", 
				countFalse, ((float)countFalse*100/(float)(countFalse+countTrue)), 
				countTrue, ((float)countTrue*100/(float)(countFalse+countTrue)));
	}
	
	public void run(int offset){
		
		this.max = 0;
		this.sum = 0;
		
		int indexSourceStep3 = 0;
		for (int indexSource = offset; indexSource < result.size(); indexSource++) {
			
			int current = metaData[indexSourceStep3];
			if(max < current)
				max = current;
			
			if (result.get(indexSource)) {
				sum += metaData[indexSourceStep3];
				logger.info("+{}", metaData[indexSourceStep3]);
				if (indexSourceStep3 != 0)
					indexSourceStep3 -= 1;
			} else {
				sum -= metaData[indexSourceStep3];
				logger.info("-{}", metaData[indexSourceStep3]);
				indexSourceStep3 += 1;
			}
		}
		//logger.info(" = {} \r\n", sum);
		logger.info(" = {} [ MAX: {} ]\r\n", sum, max);
	}
}
