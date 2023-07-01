package automate_dashboard_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public ChromeDriver driver;
	
	@BeforeMethod()
	
	public void precondition() throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		
		driver=new ChromeDriver(options);
		// Login to https://login.salesforce.com/
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Enter Username
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		// Enter Password
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		// Click Login Button
		driver.findElement(By.id("Login")).click();
		
		Thread.sleep(3000);
		//Click on the toggle menu button from the left corner
		driver.findElement(By.className("slds-icon-waffle")).click();
		//Click View All 
		driver.findElement(By.xpath("//button[text()='View All']")).click();

	}
	
	@AfterMethod
	
	public void postcondition() {
		driver.close();
	}
}
