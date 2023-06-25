package automate_dashboard_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateNewDashboard {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		
		ChromeDriver driver=new ChromeDriver(options);
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
		
		
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboards");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Dashboards']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='New Dashboard']")).click();
		Thread.sleep(3000);
		WebElement dframe = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(dframe);
		
		
		// Enter Name as 'Salesforce Automation by Your Name ' 
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by Anbu");
		Thread.sleep(3000);
		// Click on Create
		driver.findElement(By.id("submitBtn")).click();
		
		Thread.sleep(3000);
//		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		// Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.switchTo().defaultContent();
		String sText = driver.findElement(By.xpath("//span[text()='Dashboard saved']")).getText();
		System.out.println(sText);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		driver.findElement(By.xpath("//button[text()='Done']")).click();
//			
//		System.out.println(ds);
		
		 String cText = driver.findElement(By.xpath("//div[@class='slds-page-header__name-title']")).getText();
		
		System.out.println(cText);
		
//		WebElement savebtn = driver.findElement(By.xpath("//button[text()='Save']"));
//		driver.executeScript("arguments[0].click();", savebtn);
		
		
//		Thread.sleep(3000);
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
//		WebElement ds = driver.findElement(By.xpath("//span[text()='Dashboard saved']"));
//		System.out.println(ds);
//		Thread.sleep(3000);
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='dashboard']")));
		
	}

}
