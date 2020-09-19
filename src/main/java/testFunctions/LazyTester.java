package testFunctions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import globalVariable.Global_Variable;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilityFunctions.ExcelReader;

public class LazyTester {

	@Test
	public void launchBrowser() throws Exception{
		WebDriverManager.chromedriver().setup();

		WebDriver chromeDriver=new ChromeDriver();

		chromeDriver.get("http://outlook.com/");

		chromeDriver.manage().window().maximize();

		WebDriverWait driverWait=new WebDriverWait(chromeDriver, 10);

		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='i0281']/div/div/div[1]/div[2]/div[1]/img ")));

		WebElement logoEle=chromeDriver.findElement(By.xpath("//*[@id='i0281']/div/div/div[1]/div[2]/div[1]/img"));

		File srcImg=logoEle.getScreenshotAs(OutputType.FILE);

		File destFile=new File("logo.png");

		FileUtils.copyFile(srcImg, destFile);

		chromeDriver.quit();
	}

	@Test
	public void testDataCheck() throws Exception {
		ExcelReader er=new ExcelReader();
		er.readAndGetDataFromExcel();
		String orderID=Global_Variable.getTestData("Order ID");
		System.out.println("OrderID: "+orderID);
		String vehicleName=Global_Variable.getTestData("Vehicle Name");
		System.out.println("Vehicle name: "+vehicleName);
		String serialNumber=Global_Variable.getTestData("S.No");
		System.out.println("Serial number: "+serialNumber);
		String testCaseName=Global_Variable.getTestData("TestCaseName");
		System.out.println("Test case name: "+testCaseName);
	}

}
