package utilityFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import globalVariable.Global_Variable;

public class ExcelReader {


	public static void main(String[] args) throws Exception {
		ExcelReader er=new ExcelReader();
		er.readAndGetDataFromExcel();
	}

	public void readAndGetDataFromExcel() throws Exception {
		
		HashMap<String, String> testDataHashMap=new HashMap<String, String>();
		
		FileInputStream fis=new FileInputStream("C:\\Users\\vigne\\OneDrive\\Documents\\DataLoad.xlsx");
		XSSFWorkbook xssfWorkBook=new XSSFWorkbook(fis);
		XSSFSheet xssfSheet=xssfWorkBook.getSheet("TestData");

		int rowCount=xssfSheet.getPhysicalNumberOfRows();
		System.out.println("The row count: "+rowCount);
		int reqColumnIndex=0;
		int reqRowIndex=0;

		String testCaseColumnName="TestCaseName";
		String testCaseName="Sample Test 2";

		Row rowObj1=xssfSheet.getRow(0);
		int columnCount=rowObj1.getPhysicalNumberOfCells();
		System.out.println("The column count: "+columnCount);
		for(int j=0;j<columnCount;j++) {
			if(rowObj1.getCell(j).toString().equals(testCaseColumnName)) {
				reqColumnIndex=j;
				System.out.println("The index of TestCaseName column: "+reqColumnIndex);
				break;
			}
		}

		for(int i=0;i<rowCount;i++) {
			Row rowObj2=xssfSheet.getRow(i);
			String temp=rowObj2.getCell(reqColumnIndex).toString();
			if(temp.equals(testCaseName)) {
				reqRowIndex=i;
				System.out.println("The index of TestCase row: "+reqRowIndex);
				break;
			}
		}
		
		Row rowObj3=xssfSheet.getRow(reqRowIndex);
		int reqColumnCount=rowObj3.getPhysicalNumberOfCells();
		for(int i=0;i<reqColumnCount;i++) {
			String key=rowObj1.getCell(i).toString();
			String value=rowObj3.getCell(i).toString();
			System.out.println("Key: "+key);
			System.out.println("Value: "+value);
			testDataHashMap.put(key, value);
		}
		
		Global_Variable.setTestData(testDataHashMap);
		
		System.out.println(testDataHashMap);
	}
}
