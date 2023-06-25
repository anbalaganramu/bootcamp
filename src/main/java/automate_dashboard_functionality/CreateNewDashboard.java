package automate_dashboard_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateNewDashboard extends Base{
	
	@Test
	public void runCreateNewDashboard() throws InterruptedException {
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
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Anbu_Task");
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
		String cText = driver.findElement(By.xpath("//div[@class='slds-page-header__name-title']")).getText();
		System.out.println(cText);		
		
		driver.close();
	}

}
