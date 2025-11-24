package api.store.Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class XLDataProvider {
	@DataProvider(name ="Data1")
       public String[][] dataSet() throws Exception{
    	   FileInputStream fis =new FileInputStream("C:\\Users\\Fleek IT\\eclipse-workspace\\StorePetStoreAutomation\\TestData\\StoreData.xlsx");
    	       Workbook wb = WorkbookFactory.create(fis);
    	      Sheet sh= wb.getSheet("PetStoreSheet");
    	        int rows= sh.getPhysicalNumberOfRows();
    	        int cols= sh.getRow(0).getLastCellNum();
    	        
    	        String [][]data =new String[rows-1][cols];
    	        
    	        for(int i=1;i<rows;i++) {
    	        Row row=	sh.getRow(i);
    	        for(int j=0;j<cols;j++) {
    	        Cell cell=	row.getCell(j);
    	        if (cell ==null)
    	        	data[i-1][j]="";
    	        else
    	        	data[i-1][j]=cell.toString();
    	        }
    	        }
    	        return data;
    	       }
}
