package commonUtils;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;

public class ExcelUtilDriver {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		ExcelUtil ex = new ExcelUtil();
		String df = ex.getDataFromExcel("Sheet1", 0, 1);
		System.out.println(df);
		
		
	}

}
