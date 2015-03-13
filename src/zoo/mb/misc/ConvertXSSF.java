package zoo.mb.misc;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// from https://svn.apache.org/repos/asf/poi/trunk/src/examples/src/org/apache/poi/xssf/usermodel/examples/CreateCell.java
public class ConvertXSSF {
    public static void main(String[] args) throws IOException {
    	/*if (args.length != 1) {
    		System.err.println("please provide file path or file directory containing .csv or .txt files");
    		System.exit(-1);
    	}*/
    	//File file = new File(args[0]); //("/tmp/file.txt");
    	File file = new File("/tmp/");
    	
    	if (file.isDirectory()) {
    		String[] files = file.list();
    		for (String f : files) {
    			if (f.endsWith(".csv") || f.endsWith(".txt")) {
    				convert(new File(file.getAbsoluteFile() + File.separator + f));
    			}
    		}
    	} else {
        	convert(file);
    	}
    	
    }

	private static void convert(File file) throws FileNotFoundException,
			IOException {
		long start = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new FileReader(file));
    	String line;
    	int lineIndex = 0;
    	
    	Workbook wb = new XSSFWorkbook();
    	Sheet sheet = wb.createSheet("new sheet");

    	while ((line = br.readLine()) != null) {
    	   //System.out.println(line);
    	   
           Row row = sheet.createRow(lineIndex);
           
           String[] values = line.split(";");
           for (int i = 0; i < values.length; i++) {
               row.createCell(i).setCellValue(values[i]);
               if (values[i].startsWith("0")) {
            	   row.getCell(i).setCellType(HSSFCell.CELL_TYPE_STRING);
               }
           }

           lineIndex++;
    	}
    	br.close();

    	String newFilename = file.getAbsolutePath().substring(0, file.getAbsolutePath().length() - 4) + ".xls";
        FileOutputStream fileOut = new FileOutputStream(newFilename);
        wb.write(fileOut);
        wb.close();
        fileOut.close();
        
        System.out.println(file.getAbsolutePath() + ":  done processing " + lineIndex + " lines, took " + (System.currentTimeMillis() - start) + "ms.");
	}

}
