package Week4.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangeMangeMent_AssessChange {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://dev63235.service-now.com");
		 driver.switchTo().frame(0);
		 driver.findElement(By.id("user_name")).sendKeys("admin");
		 driver.findElement(By.id("user_password")).sendKeys("India@123");
		 driver.findElement(By.xpath("//button[text()='Log in']")).click();
		 driver.findElement(By.id("fliter")).sendKeys("change");
        driver.findElementByXPath("//div[text()='open')[3]").click();
        driver.switchTo().frame("gsft_main");
        Select Search=new Select(driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")));
        Search.selectByVisibleText("Number");
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("CHGOOOOO33",Keys.TAB);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Select Status=new Select(driver.findElement(By.id("change_request.state")));
	    Status.selectByVisibleText("Assess");
	driver.findElement(By.id("sys_display.change_request.assigned_to")).sendKeys("software",Keys.TAB);
	Thread.sleep(2000);
	driver.findElement(By.id("sys_display.change_request.assingment_to")).sendKeys("ITIL",Keys.TAB);
	driver.findElement(By.id("sysverb_update_bottom")).click();
	driver.findElement(By.xpath("//input[@class='linked formlink']")).sendKeys("CHGOOOOO33",Keys.TAB);
	driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	String SelectState=driver.findElement(By.xpath("//select_display.change_request.state']//option[@selected='selected']")).getText();
	String assignedTo=driver.findElement(By.id("sys_display.change_request.assigned_to")).getAttribute("value");
	if(SelectState.equals("Assess"))assignedTo.equals("ITIL user");{
		System.out.println("state and assigned to updates are done");
	}
	
	
	
	
	
	
	
	}

}
