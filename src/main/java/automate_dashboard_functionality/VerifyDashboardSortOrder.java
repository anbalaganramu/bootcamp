package automate_dashboard_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VerifyDashboardSortOrder extends Base{
	@Test
	public void runEditDashboard() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		//Search and Click on Dashboards text
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboards");
		Thread.sleep(3000);
		// Click on Dashboard
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Dashboards']")).click();
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("(//span[text()='Dashboard Name']/following::lightning-primitive-icon)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='slds-scrollable_y']/table/thead/tr/th)[1]")).click();
		System.out.println("Click Happened");
		
	}

}
