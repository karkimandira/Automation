package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CreateRoles extends AdminLogin {
	@Test
	public void createadmin() throws InterruptedException {
		WebDriver driver = Login();
        Thread.sleep(5);
		 driver.findElement(By.id("Roles")).click();
		 Thread.sleep(5);
		 driver.findElement(By.id("createNewRoleBtn")).click();
	
	 }

}
