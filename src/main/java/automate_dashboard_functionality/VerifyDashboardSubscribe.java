package automate_dashboard_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VerifyDashboardSubscribe extends Base{
	@Test
	public void runVerifyDashboardSubscribe() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Dashboards");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Dashboards']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search recent dashboards...']")).sendKeys("Anbu");
		Thread.sleep(3000);
		WebElement searchClick = driver.findElement(By.xpath("(//div[@class='slds-hyphenate']//a)[1]"));
		driver.executeScript("arguments[0].click()", searchClick);
		Thread.sleep(3000);
		WebElement subscribeFrame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(subscribeFrame);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
		Thread.sleep(5000);
		
	
		driver.switchTo().defaultContent();
		WebElement dailyClick = driver.findElement(By.xpath("//legend[text()='Frequency']/following::label[1]"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(dailyClick));
		System.out.println(dailyClick.getText());
		
		driver.executeScript("arguments[0].click()", dailyClick);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		System.out.println("DONE");
		
	}

}
