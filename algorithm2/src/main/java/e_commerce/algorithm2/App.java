package e_commerce.algorithm2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws IOException {

		if(args.length != 1){
			logger.error("params:file path required!\r\n");
			return;
		}
		
		String filePath = args[0];
		logger.info("----------------------------------------\r\n");
		logger.info("---start scanning {} ... ---\r\n", filePath);
		logger.info("----------------------------------------\r\n");
		InputStreamReader read = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = null;
		List<TrueAndFalse> totalResult0 = new ArrayList<TrueAndFalse>();
		List<TrueAndFalse> totalResult1 = new ArrayList<TrueAndFalse>();
		int maxRowOfResult0=0, maxRowOfResult1=0;
		while ((lineTxt = bufferedReader.readLine()) != null) {

			String source = lineTxt.trim();
			if(source.length() == 0){
				logger.info("skip row : {}\r\n", source);
				continue;
			}

			logger.info("{}\r\n", source);
			logger.debug("Execute step 1\r\n");
			Source sourceLine = new Source(source);
			List<Row> rows = sourceLine.run();
			
			//根据第一列个数是否大于1，分类
			Matrix matrix0 = new Matrix();
			Matrix matrix1 = new Matrix();
			
			for(Row row : rows){
				if(row.getType() == 0)
					matrix0.append(row);
				else
					matrix1.append(row);
			}
			
			logger.debug("Execute step 2\r\n");
			matrix0.print();
			TrueAndFalse result0 = matrix0.run();
			result0.print();
			logger.debug("Execute step 3\r\n");
			result0.run(0);
			totalResult0.add(result0);
			maxRowOfResult0 = maxRowOfResult0>result0.getCountOfItem()?maxRowOfResult0:result0.getCountOfItem();

			logger.debug("Execute step 2\r\n");
			matrix1.print();
			TrueAndFalse result1 = matrix1.run();
			result1.print();
			logger.debug("Execute step 3\r\n");
			result1.run(0);
			totalResult1.add(result1);
			maxRowOfResult1 = maxRowOfResult1>result1.getCountOfItem()?maxRowOfResult1:result1.getCountOfItem();
			
			logger.info("---- END -----\r\n");
		}
		bufferedReader.close();
		
		logger.info("----------------------------------------------\r\n");
		logger.info("---------------------文件汇总-------------------\r\n");
		for(int i=0; i<maxRowOfResult0; i++){
			
		}
		
		for(int i=0; i<maxRowOfResult0; i++){
			
		}
	}
}
