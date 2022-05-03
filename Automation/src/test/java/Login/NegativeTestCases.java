package Login;




import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class NegativeTestCases  {
	WebDriver driver;
	
	@DataProvider(name = "data-set")
    public static Object[][] DataSet(){
        //read the jason or excel data
        Object[][] obj = {
                {"valid", "admin", "admin"},
           
                {"invalid", "admin1", "admin"},
                };
        return obj;
    }
	
	
	@Test(dataProvider = "data-set")
    public void DataProvSampleTest(String type, String username, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\97798\\eclipse-workspace\\Automation\\Drivers\\chromedriver.exe");
        System.out.println(type + " " + username + " " + password);
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("http://10.13.194.204/");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        
        if(type.equals("valid")){
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//app-header/div[1]/a[1]/app-logo[1]/img[1]")));
        }else
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.cssSelector("body.nb-theme-default:nth-child(2) nb-toast")));
        Thread.sleep(2000);
        driver.quit();
	}
}
	
	
		 
		 
		
		
				
	
	


