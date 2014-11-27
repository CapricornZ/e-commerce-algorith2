package e_commerce.algorithm2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Row {
	
	private static final Logger logger = LoggerFactory.getLogger(Row.class);
	
	private int type;
	private char[] data;
	
	public Row(int type, char[] data, int offset, int length){
		this.type = type;
		this.data = String.valueOf(data, offset, length).toCharArray();
	}
	
	public int getMaxColumn(){
		return this.data.length;
	}
	
	public String getData(int offset, int length){
		return String.valueOf(this.data).substring(offset, offset+length);
	}
	
	public int getType(){
		return this.type;
	}
	
	public void print(){
		logger.debug("\t{ type:{}, data:'{}' }\r\n", this.type, String.valueOf(data));
	}
}
