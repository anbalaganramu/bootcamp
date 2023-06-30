package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateAccount {
	@Test	
	public void createnewaccount() throws InterruptedException {
//		Login to https://login.salesforce.com/, Username: hari.radhakrishnan@qeagle.com, Password: Leaf@1234
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		WebElement salesClick = driver.findElement(By.xpath("(//mark[text()='Sales'])[1]"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(salesClick));
		salesClick.click();
		
	//	driver.findElement(By.xpath("//mark[text()='Sales']")).click();
		Thread.sleep(3000);
		WebElement account = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", account);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='New']")).click();
		driver.findElement(By.xpath("//label[text()='Account Name']/following-sibling::div/input")).sendKeys("Anbu Testleaf");
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div")).click();
		WebElement ownership = driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]"));
		driver.executeScript("arguments[0].click();", ownership);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
			
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		String text = driver.findElement(By.xpath("//div[@class='toastContent slds-notify__content']")).getText();
		System.out.println(text);
		if(text.contains("created")) {
			System.out.println("Acccount has been created successfully");
		}
		else {
			System.out.println("Please try again"); 
		}
	}

}
