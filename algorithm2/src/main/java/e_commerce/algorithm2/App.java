package e_commerce.algorithm2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws IOException {

		if(args.length != 1){
			logger.error("params:file path required!\r\n");
			return;
		}
		
		String filePath = args[0];
		logger.info("----------------------------------------\r\n");
		logger.info("now start scanning {} ...\r\n", filePath);
		logger.info("----------------------------------------\r\n");
		InputStreamReader read = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = null;
		while ((lineTxt = bufferedReader.readLine()) != null) {

			String source = lineTxt.trim();
			if(source.length() == 0){
				logger.info("skip row : {}\r\n", source);
				continue;
			}

			logger.info("{}\r\n", source);
			logger.debug("Execute step 1\r\n");
			Matrix matrix0 = new Matrix();
			Matrix matrix1 = new Matrix();
			int length = 0;
			for(;length<source.length();){
				char[] array = source.substring(length).toCharArray();
				Row row = step1(array);
				length += row.getMaxColumn();
				if(row.getType() == 0)
					matrix0.append(row);
				else
					matrix1.append(row);
			}
			
			logger.debug("Execute step 2\r\n");
			matrix0.println();
			TrueAndFalse result0 = matrix0.run();
			result0.println();
			logger.debug("Execute step 3\r\n");
			result0.run(0);

			logger.debug("Execute step 2\r\n");
			matrix1.println();
			TrueAndFalse result1 = matrix1.run();
			result1.println();
			logger.debug("Execute step 3\r\n");
			result1.run(0);
			
			logger.info("---- END -----");
		}
		bufferedReader.close();
	}
	
	public static Row step1(char[] source){

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
		
		return new Row(
				source[0]==source[1]?1:0,
				source, 0, index-1);
	}
}
