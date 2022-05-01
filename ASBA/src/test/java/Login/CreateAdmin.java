package Login;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class CreateAdmin extends AdminLogin {
	
@Test
	public void createadmin() throws InterruptedException {
		WebDriver driver = Login();
        Thread.sleep(5);
		 driver.findElement(By.id("Admin")).click();
		 Thread.sleep(5);
		 
		 
		 driver.findElement(By.cssSelector("body")).click();
		 driver.findElement(By.cssSelector("body.nb-theme-default:nth-child(2) div.layout app-page-header.page-header:nth-child(1) #createAdmin")).click();
		 
		
		 
		 
	 }
}

