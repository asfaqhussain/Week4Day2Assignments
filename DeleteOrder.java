package Week4.Day2;

import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOrder {

	private static RemoteWebDriver js;

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
		 WebElement findElement=driver.findElement(By.id("filter"));
		 findElement.sendKeys("service catalog");
		 Thread.sleep(20000);
		 findElement.sendKeys(Keys.ENTER);
       driver.findElement(By.xpath("//div[text()='service catlog']")).click();
		 driver.switchTo().frame(0);
		 driver.findElement(By.xpath("//h2[text()[normalize-space()='mobiles']]")).click();
		 WebElement mobiles=driver.findElement(By.xpath("//strong[text()='samsung galaxy S7']"));
		 js.executeScript("arguments[0].scrollIntoView();",mobiles);
		 WebElement findElement2=driver.findElement(By.xpath("//strong[text()='Apple iphone 6s']"));
		 findElement2.click();
		 WebElement appleMobile=driver.findElement(By.xpath("//div[text()='exists in categories']"));
		 js.executeScript("arguments[0].scrollIntoView();",appleMobile);
		 WebElement MonthlyDataAllowance=driver.findElement(By.xpath("//select[@class='form-control cat_item_option']"));
		 new Select(MonthlyDataAllowance).selectByIndex(2);
		 WebElement color=driver.findElement(By.xpath("//select[@class='form-control cat_item_option'])[2]"));
		 new Select(color).selectByIndex(3);
		 WebElement Storage=driver.findElement(By.xpath("//select[@class='form-control cat_cat_item_option'][3]"));
	     new Select(Storage).selectByIndex(2);
	driver.findElement(By.id("oi_order_now_button")).click();
	String Ordermsg=driver.findElement(By.xpath("//span[text()='thank you request has been submitted']")).getText();
	System.out.println(Ordermsg);
	String RequestNumber=driver.findElement(By.xpath("/a[@class='linked requestItemUrl']//b[1]")).getText();
	System.out.println("order number:"+RequestNumber);
	driver.findElement(By.xpath("//a[@class='linked requestItemUrl']//b[1]")).click();
	driver.findElement(By.id("sysverb_delete_bottom")).click();
	driver.findElement(By.id("ok button")).click();
	String OrderEmptyClose=driver.findElement(By.xpath("//div[text()='order:empty']")).getText();
	System.out.println("order deletedn and msg is:"+OrderEmptyClose+RequestNumber);
	
	
	
	
	}

}
