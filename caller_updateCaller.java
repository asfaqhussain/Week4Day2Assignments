package Week4.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class caller_updateCaller {

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
		 driver.findElement(By.id("fliter")).sendKeys("callers",Keys.TAB);
      driver.findElement(By.xpath("//div[text()='callers']")).click();   
	     driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//a[@class='form-control']").sendKeys("Asfaq",Keys.TAB);
	    driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	   driver.findElement(By.id("sys_user.phone")).sendKeys("123456789");
	   driver.findElement(By.id("sys_user.phone")).sendKeys("12345679");
	driver.findElement(By.id("sysverb_update")).click();
	if(driver.findElement(By.xpath("tbody[@class='list2_body']/td[text()='(123) 456-789']")).isDisplayed());{
		
	}
	System.out.println("caller is updated");
	
	
	
	}

}
