package e_commerce.algorithm2;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import e_commerce.algorithm2.pairs.PairEngine;

public class Matrix {
	
	private static final Logger logger = LoggerFactory.getLogger(Matrix.class);
	
	private List<Row> rows = new ArrayList<Row>();
	
	public void append(Row row){
		this.rows.add(row);
	}
	
	public void print(){
		logger.debug("[\r\n");
		for(Row row:this.rows)
			row.print();
		logger.debug("]\r\n");
	}
	
	public TrueAndFalse run(){
		
		List<Boolean> result = new ArrayList<Boolean>();
		for(int rowIndex=0; rowIndex<this.rows.size()-1; rowIndex++){
			final int STEP = 2;
			Row row0 = this.rows.get(rowIndex);
			Row row1 = this.rows.get(rowIndex+1);
			int minColumn = row0.getMaxColumn() > row1.getMaxColumn() ? row1.getMaxColumn() : row0.getMaxColumn();
			for(int columnIndex=1; columnIndex<minColumn-1; columnIndex++){

				String first = row0.getData(columnIndex, STEP);
				String second = row1.getData(columnIndex, STEP);
				
				result.add(PairEngine.getInstance().pair(first, second));
			}
			
			if(rowIndex < this.rows.size()-2 && row0.getMaxColumn() > row1.getMaxColumn()){//需要增加附加字符
				
				String first = row0.getData(minColumn-1, STEP);
				String second = row1.getData(minColumn-1, STEP-1);
				if(second.equals("A"))
					second = "AB";
				else
					second = "BA";
				
				result.add(PairEngine.getInstance().pair(first, second));
				
			}
		}
		return new TrueAndFalse(result);
	}
}