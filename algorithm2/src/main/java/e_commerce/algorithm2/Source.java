package e_commerce.algorithm2;

import java.util.ArrayList;
import java.util.List;

public class Source {
	
	private String source;
	public Source(String source){
		this.source = source;
	}
	
	public List<Row> run(){
		
		List<Row> rtn = new ArrayList<Row>();
		int length = 0;
		for(;length<source.length();){
			char[] array = source.substring(length).toCharArray();
			Row row = this.step1(array);
			length += row.getMaxColumn();
			rtn.add(row);
		}
		return rtn;
	}
	
	private Row step1(char[] source){

		int column = 0;
		int COLUMN = 4;
		char last = source[0];

		int index = 1;
		for(index=1; column < COLUMN; index++){
			
			if(index >= source.length){
				column ++;
				index ++;
				break;
			}
			
			if(source[index] != last){
				last = source[index];
				column ++;
			}
		}
		if(source.length == 1)
			return new Row(0, source, 0, index-1);
		else
			return new Row(
				source[0]==source[1]?1:0,
				source, 0, index-1);
	}

}
