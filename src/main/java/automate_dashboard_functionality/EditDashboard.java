package automate_dashboard_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditDashboard extends Base{
	@Test
	public void runEditDashboard() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboards");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Dashboards']")).click();
		Thread.sleep(5000);
		WebElement sElement = driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']"));
		
		sElement.sendKeys("Anbu");	
		Thread.sleep(3000);
	//	WebElement myelement = driver.findElement(By.xpath("//a[@title='Anbu']"));
		WebElement myelement = driver.findElement(By.xpath("//span[@class='highlightSearchText']"));
		
		//myelement.click();
		driver.executeScript("arguments[0].click()", myelement);
		Thread.sleep(5000);
		System.out.println("Clicked"); 
		
		WebElement editframe = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(editframe);
		Thread.sleep(5000);
		WebElement editClick = driver.findElement(By.xpath("//button[text()='Edit']"));
		driver.executeScript("arguments[0].click()", editClick);
		Thread.sleep(5000);
		WebElement editpropertyClick = driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']"));
		driver.executeScript("arguments[0].click()", editpropertyClick);
		driver.findElement(By.id("dashboardDescriptionInput")).sendKeys("Testleaf salesforce");
		driver.findElement(By.id("submitBtn")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//footer/button[text()='Save']")).click();
		Thread.sleep(5000);
		String dtitle = driver.findElement(By.xpath("//h1/span[contains(@class,'slds-page-header__title slds-truncate')]")).getText();

		System.out.println(dtitle);
		
		String ddesc = driver.findElement(By.xpath("//p[@class='slds-page-header__info']")).getText();
		
		System.out.println(ddesc);
		
		
	}

}
