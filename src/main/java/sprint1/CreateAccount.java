package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		driver.findElement(By.xpath("//p[@title='Manage your sales process with accounts, leads, opportunities, and more']")).click();
		Thread.sleep(3000);
		WebElement account = driver.findElement(By.xpath("//a[@title='Accounts']/span"));
		driver.executeScript("arguments[0].click();", account);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@title='New']")).click();
		driver.findElement(By.xpath("//label[text()='Account Name']/following-sibling::div/input")).sendKeys("Anbalagan Ramu");
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div")).click();
//		Thread.sleep(2000);
	//	driver.findElement(By.xpath("//button[@type='button']/span[text()='Public']")).click();
		
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
