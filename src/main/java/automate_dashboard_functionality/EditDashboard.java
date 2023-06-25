package automate_dashboard_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditDashboard extends Base{
	@Test
	public void runEditDashboard() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboards");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Dashboards']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Anbu_Task");	
		Thread.sleep(3000);
		
		WebElement myelement = driver.findElement(By.xpath("//a[@title='Anbu_Task']/span[@class='highlightSearchText']"));
		driver.executeScript("arguments[0].click", myelement);
		System.out.println("Clicked");
		
//		WebElement editframe = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
//		driver.switchTo().frame(editframe);
//		
//		driver.findElement(By.xpath("//button[text()='Edit']")).click();
	}

}
