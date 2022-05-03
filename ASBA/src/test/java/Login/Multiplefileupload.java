package Login;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
public class Multiplefileupload {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\97798\\eclipse-workspace\\ASBA\\Drivers\\chromedriver.exe");
	    
	    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
	    driver = new ChromeDriver();
 		
		//go to asba site
		
				driver.get("http://10.13.194.204/");
				//Mazimize current window
				driver.manage().window().maximize();
		File src=new File("C:\\Users\\97798\\Documents\\Test.xlsx");
		FileInputStream fis= new FileInputStream(src);
		
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		int rowcount=sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		
		for(int i=1;i<=rowcount;i++)
		{
			
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("password")).clear();
			Thread.sleep(1500);
			String data0=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Data from Row"+i+" is "+data0);
			driver.findElement(By.id("username")).sendKeys(sheet1.getRow(i).getCell(0).getStringCellValue());
			Thread.sleep(1500);
			driver.findElement(By.id("password")).sendKeys(sheet1.getRow(i).getCell(1).getStringCellValue());
			Thread.sleep(1500);
			driver.findElement(By.id("login")).click();
			Thread.sleep(1800);
		}

		
		wb.close();
		Thread.sleep(5000);
		driver.close();
		}
	}




