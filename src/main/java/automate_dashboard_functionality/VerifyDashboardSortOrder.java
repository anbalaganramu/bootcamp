package automate_dashboard_functionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VerifyDashboardSortOrder extends Base{
	@Test
	public void runVerifyDashboardSortOrder() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		//Search and Click on Dashboards text
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboards");
		Thread.sleep(3000);
		// Click on Dashboard
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Dashboards']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Dashboard Name']")).click();
		Thread.sleep(3000);
		// To get number of Rows
		List<WebElement> totalrows = driver.findElements(By.xpath("//div[@class='slds-scrollable_y']/table/tbody/tr"));
		
		
		// To get number of Columns
//		List<WebElement> totalcols = driver.findElements(By.xpath("//div[@class='slds-scrollable_y']/table/thead/tr/th"));
		
		// Iterate data
		for(int i=1;i<=totalrows.size();i++) {
//			for(int j=1;j<=totalcols.size();j++) {
			
				String text = driver.findElement(By.xpath("//div[@class='slds-scrollable_y']/table/tbody/tr["+i+"]/th[1]")).getText();
				
				System.out.println(text);
//			}
			System.out.println("-------------------------------------------------------------");
			
		}
		
		
				
				
		
	}

}
