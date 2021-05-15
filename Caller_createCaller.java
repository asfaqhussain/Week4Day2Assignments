package Week4.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Caller_createCaller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://dev63235.service-now.com");
		 driver.switchTo().frame(0);
		 driver.findElement(By.id("user_name")).sendKeys("admin");
		 driver.findElement(By.id("user_password")).sendKeys("India@123");
		 driver.findElement(By.xpath("//button[text()='Log in']")).click();
		 driver.findElement(By.id("fliter")).sendKeys("knowledge");
        driver.findElement(By.xpath("//div[text()='my knowledge Articles']")).click();   
	     driver.switchTo().frame("gsft_main");
	     driver.findElement(By.xpath("//button[text()='new]")).click();
	     driver.findElement(By.id("sys _user.first_name")).sendKeys("Asfaq");
	     driver.findElement(By.id("sys _user.Last_name")).sendKeys("Hussain");
	     driver.findElement(By.id("sys _user.title")).sendKeys("mr");
	     driver.findElement(By.id("sys _user.email")).sendKeys("Asfaqhussain05@gmail.com");
	     driver.findElement(By.id("sys _user.phone")).sendKeys("123456789");
	     driver.findElement(By.id("sys _user.mobile_phone")).sendKeys("123456789");
	driver.findElement(By.xpath("sysverb_insert")).click();
	System.out.println("caller is created");
	
	
	
	
	
	
	
	}
	

}
