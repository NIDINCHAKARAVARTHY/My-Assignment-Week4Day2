package week4day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task2 {
	public static void main(String[] args) {
		
	
	 ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		Boolean until = wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		System.out.println(until);
		
		driver.quit();

}}
