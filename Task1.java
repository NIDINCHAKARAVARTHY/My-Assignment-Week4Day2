package week4day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task1 {
	public static void main(String[] args) throws InterruptedException {
		 ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			ChromeDriver driver = new ChromeDriver(options);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			Thread.sleep(5000);
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
			driver.findElement(By.id("password")).sendKeys("Leaf@123");
			driver.findElement(By.id("Login")).click();
			driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
			
			String window = driver.getWindowHandle();
			System.out.println(window);
			Set<String>windowHandels = driver.getWindowHandles();
			System.out.println(windowHandels);
			
			List<String> window1 = new ArrayList<String>(windowHandels);
			System.out.println("Windows open :" + window1.size() );
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
			
			driver.switchTo().window(window1.get(1));
			driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			String title = driver.getTitle();
			System.out.println(title);
			
			driver.close();
			driver.switchTo().window(window1.get(0));
			String title2 = driver.getTitle();
			System.out.println(title2);
	}

}
