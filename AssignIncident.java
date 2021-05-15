package Week4.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://dev103117.service-now.com");
		 driver.switchTo().frame(0);
		 driver.findElement(By.id("user_name")).sendKeys("admin");
		 driver.findElement(By.id("user_password")).sendKeys("India@123");
		 driver.findElement(By.xpath("//button[text()='Log in']")).click();
		 driver.findElement(By.id("filter")).sendKeys("incident");
		 driver.findElement(By.xpath("//div[text()='open-unassigned']")).click();
		 driver.switchTo().frame("gsft_main");
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 String incidentNo=driver.findElement(By.id("incidentNumber")).getAttribute("value");
		 driver.findElement(By.id("sys_display.incident.assingment_group")).clear();
		 driver.findElement(By.id("sys_display.incident.assingment_group")).sendKeys("software",Keys.TAB);
		 Thread.sleep(2000);
		 driver.findElement(By.id("sys_display.incident.assinged_to")).sendKeys("ITIL user",Keys.TAB);
		 Thread.sleep(1500);
        driver.findElement(By.id("activity-stream-commentstextarea")).sendKeys("updating incident with software group assingndriment");
	driver.findElement(By.xpath("//button[text()='post']")).click();
	driver.findElement(By.id("sysverb_update_bottom")).click();
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//div[text()='open']")).click();
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.xpath("//a@class='input-group']//input")).click();
	driver.findElement(By.xpath("//a@class='linked formlink']")).click();
	String AssignedGroup=driver.findElement(By.id("sys_display.incident.assignment_group")).getAttribute("value");
	if(AssignedGroup.equals("software")) {
		System.out.println(" incident is assigned");
		driver.close();
	}
	
	
	
	
	}

}
