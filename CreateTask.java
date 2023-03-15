package week4day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateTask {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		Thread.sleep(5000);
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("(//div[@class='tooltipTrigger tooltip-trigger uiTooltip']/div)[2]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Tasks");
		driver.findElement(By.xpath("//mark[text()='Tasks']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='slds-context-bar__label-action slds-p-left--none'])[4]")).click();
		WebElement a = driver.findElement(By.xpath("//span[text()='New Task']"));
		driver.executeScript("arguments[0].click();",a);
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Bootcamp");
		driver.findElement(By.xpath("//a[text()='Not Started']")).click();
	
		driver.findElement(By.xpath("//a[text()='Waiting on someone else']")).click();
		driver.findElement(By.xpath("//span[text()='Save & New']")).click();
		 WebElement message = driver.findElement(By.xpath("//div[contains(@class,'slds-page-header__title slds-m-right--small slds-align-middle clip-text slds-line-clamp')]"));
		 if(message.isDisplayed()) {
			 System.out.println("Task Created");
		 }else {
			 System.out.println("Task Not Created");
		 }
		 driver.close();
	}

}
