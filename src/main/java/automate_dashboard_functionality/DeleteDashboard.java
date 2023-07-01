package automate_dashboard_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteDashboard extends Base{
	@Test
	public void runEditDashboard() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboards");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Dashboards']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Anbu");	
		
		Thread.sleep(3000);
		WebElement searchtextClick = driver.findElement(By.xpath("//span[@class='highlightSearchText']"));
		driver.executeScript("arguments[0].click()", searchtextClick);
		Thread.sleep(3000);
		
		
		WebElement delframe = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(delframe);
			
		WebElement deleteClick = driver.findElement(By.xpath("//button[text()='Subscribe']/following::div/button"));
		driver.executeScript("arguments[0].click()", deleteClick);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		
		driver.findElement(By.xpath("//button[@id='modalBtn1']")).click();
		System.out.println("Deleted Successfully");
//		
//		// Confirmation
//		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Anbu_Task");
//		WebElement emptyText = driver.findElement(By.xpath("//span[@class='emptyMessageTitle']"));
//		String text = emptyText.getText();
//		System.out.println(text);
		
	}

}
