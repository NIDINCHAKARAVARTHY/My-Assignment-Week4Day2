package week4day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class ArchitectCertifications {
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
			driver.findElement(By.xpath("//span[text()='Learn More']")).click();
			Set<String>windowHandels = driver.getWindowHandles();
			System.out.println(windowHandels);
			
			List<String> window1 = new ArrayList<String>(windowHandels);
			System.out.println("Windows open :" + window1.size() );
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			
			driver.switchTo().window(window1.get(1));
			driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			Shadow dom= new Shadow(driver);
			dom.findElementByXPath("//span[text()='Learning']").click();
			Thread.sleep(5000);
	        WebElement a = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
	        Actions builder = new Actions(driver);
	        builder.moveToElement(a).perform();
	        dom.findElementByXPath("//a[text()='Salesforce Certification']").click();
	        driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
	        String currentUrl = driver.getCurrentUrl();
	        System.out.println(currentUrl);
	        WebElement b = driver.findElement(By.xpath("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']"));
	        String text = b.getText();
	        System.out.println(text);
	        List<WebElement> c = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
	        for (int i = 0; i < c.size(); i++) {
				String name= c.get(i).getText();
				System.out.println("List of Salesforce Architect Certifications Available ");
				System.out.println(name);
			}
	        driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
	        List<WebElement> d = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
	        for (int i = 0; i < d.size(); i++) {
	        	String name2 = d.get(i).getText();
	        	System.out.println("List of Certifications available ");
	        	System.out.println(name2);
				
			}
	        driver.quit();

}}
