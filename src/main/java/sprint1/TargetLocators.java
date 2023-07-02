package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TargetLocators {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		//Simple Alert
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		System.out.println(text);
		
		// Confirm Alert
		driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following::button[1]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		// Prompt Alert
		driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following::button[1]")).click();
		driver.switchTo().alert().sendKeys("Anbalagan R");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		
	}

}
