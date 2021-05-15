package Week4.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ArticleCreateWithMandatoryFields {

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
		 driver.findElement(By.id("fliter")).sendKeys("knowledge");
         driver.findElement(By.xpath("//div[text()='my knowledge Articles']")).click();   
	     driver.switchTo().frame("gsft_main");
	     driver.findElement(By.id("sysverb_new")).click();
	String KnowledgeNo=driver.findElement(By.id("sys_readonly.kb_knowlege.number")).getAttribute("value");
	driver.findElement(By.xpath("sys_display.kb_knowledge_base")).sendKeys("IT",Keys.TAB);
	driver.findElement(By.id("kb_knowledge.short_description")).sendKeys("This is Knowledge");
	Thread.sleep(2000);
	driver.findElement(By.id("sysverb_insert")).click();
	Select filter=new Select(driver.findElement(By.xpath("//span[@class='input-group-addon input-group-select']//select")));
	filter.selectByVisibleText("Number");
	driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys(KnowledgeNo,Keys.TAB);
	if(driver.findElement(By.xpath("//a[@class=linked formlink']")).isDisplayed()) {
		System.out.println(KnowledgeNo);
	}driver.close();
	
	
	
	}

}
