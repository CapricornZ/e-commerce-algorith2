package e_commerce.algorithm2;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrueAndFalseList extends TrueAndFalse {
	
	private static final Logger logger = LoggerFactory.getLogger(TrueAndFalseList.class);
	
	private List<TrueAndFalseRow> tafs;
	public TrueAndFalseList(List<TrueAndFalseRow> tafs){
		this.tafs = tafs;
		this.result = new ArrayList<Boolean>();
		for(TrueAndFalseRow row : tafs)
			this.result.addAll(row.getResult());
	}
	@Override
	public int getCountOfItem() {
		return tafs.size();
	}
}
