package week4day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateContact {
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
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement a = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", a);
		
		driver.findElement(By.xpath("//a[@title='New']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("DN");
		
		
		driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement message = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']"));
		if(message.isDisplayed()) {
			System.out.println("Account Created");
		}else {
			System.out.println("Account not Created");
		}
		driver.close();
		
	}

}
