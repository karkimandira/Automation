package Login;
import java.util.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class AdminLoginMultipleBrowser {
	WebDriver driver;

	@Parameters("browserName")
	@Test

	public void setup( String browserName) {
		
	  System.out.println("Browser name is :"+browserName);
	  System.out.println("Thread id: "+Thread.currentThread().getId());
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\97798\\eclipse-workspace\\Automation\\Drivers\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\97798\\eclipse-workspace\\Automation\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
		
				driver.get("http://10.13.194.204/");
				driver.manage().window().maximize();
				driver.findElement(By.id("username")).sendKeys("admin");
				driver.findElement(By.id("password")).sendKeys(decodedBytes("YWRtaW4="));
				driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
				
			
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				driver.quit();
	}
			
	static String decodedBytes(String encodedBytes)
			{
				byte[] decodedBytes = Base64.getDecoder().decode((encodedBytes));  
				return (new String (decodedBytes));
				
				}
		

}
