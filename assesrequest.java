package Week4.Day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assesrequest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		 ChromeDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://dev63235.service-now.com/navpage.do");
		 driver.switchTo().frame(0);
		 driver.findElement(By.id("user_name")).sendKeys("admin");
		 driver.findElement(By.id("user_password")).sendKeys("India@123");
		 driver.findElement(By.xpath("//button[text()='Log in']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@id='fliter']")).click();
driver.findElement(By.xpath("//div[text()='open'])[3]")).click();
WebElement iframe=driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
WebElement search= driver.findElement(By.xpath("//input[@class='form-control'])[1]"));
search.sendKeys("CHGOO30040",Keys.ENTER);
Thread.sleep(2000);
String firstele=driver.findElement(By.xpath("//td[@class='vt][1]/a")).getText();
	System.out.println(firstele);
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//td[@class='vt'])[1]/a")).click();
	WebElement state=driver.findElement(By.id("change_request.state"));
	Select Select=new Select(state);
	Select.selectByVisibleText("Assess");
	driver.findElement(By.xpath("//button[@id='lookup.change_request.assingnment_group']")).click();
	Set<String>Winset=driver.getWindowHandles();
	List<String>winList=new ArrayList<String>(Winset);
	driver.switchTo().window(winList.get(0));
	String Title=driver.getTitle();
	System.out.println(Title);
	driver.findElement(By.xpath("//a[text()='software']")).click();
	driver.switchTo().window(winList.get(0));
	WebElement iframe2=driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	driver.switchTo().frame(iframe2);
	driver.findElement(By.xpath("//button[@id='lookup.change_request.assigned_to']")).click();
	Set<String>winset1=driver.getWindowHandles();
	List<String>winList1=new ArrayList<String>(winset1);
	driver.switchTo().window(winList1.get(1));
	String Title1=driver.getTitle();
	System.out.println(Title);
	driver.findElement(By.xpath("//a[text()='ITIL user']")).click();
	driver.switchTo().window(winList.get(0));
	WebElement iframe3=driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	driver.switchTo().frame(iframe3);
	driver.findElement(By.xpath("//button[@id='sysverb_update']"));
	WebElement Assess=driver.findElement(By.xpath("//td[@class='vt')[4]]"));
	if(Assess.equals("Assess")) {
		System.out.println("Assess The Change Request");
		
	}else {
		System.out.println("Does Not Assess The Change Request");
	}
	
	
	
	
	}
	
	
	
	

}
