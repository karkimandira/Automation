package Login;
import java.util.Base64;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;




 public class AdminLogin {

	WebDriver driver;
	
	public WebDriver Login() {
		
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\97798\\eclipse-workspace\\ASBA\\Drivers\\chromedriver.exe");
	    
	    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
	    driver = new ChromeDriver();
 		
		//go to asba site
		
				driver.get("http://10.13.194.204/");
				//Mazimize current window
				driver.manage().window().maximize();
				
				driver.findElement(By.id("username")).sendKeys("admin");
				// here decode Bytes decodes the encoded values and send it in password field
				driver.findElement(By.id("password")).sendKeys(decodedBytes("YWRtaW4="));
				driver.findElement(By.id("login")).click();
				
				//Delay execution for 5 seconds to view the maximize operation
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return driver;
				
	
				
				
				
				
				
				
				
				//Close the browser
				//driver.quit();
	}
			
	
		static String decodedBytes(String encodedBytes)
			{
				byte[] decodedBytes = Base64.getDecoder().decode((encodedBytes));  
				return (new String (decodedBytes));
				
				}
		
		 
	}
	
	
	


