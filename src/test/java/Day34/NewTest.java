package Day34;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	
	WebDriver driver = new ChromeDriver();
	
  @BeforeMethod
  public void OpenApp()
  {
	  WebDriverManager.chromedriver().setup();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
	
  @Test(priority=1,groups ="Smoke Test")
  public void LoginTest() {
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @Test(priority=3)
  public void DashboardTest() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  String act_label="";
	  String exp_label= "Dashboard";
		try {
			act_label= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		}
		catch(NoSuchElementException e) {
			
		}
		Assert.assertEquals(exp_label,act_label);
	
  }
  
  @Test(priority=4)
  public void Search() {
	 String actual_title=driver.getTitle();
	 String expected_title= "OrangeHRM1";
	 Assert.assertEquals(actual_title, expected_title);
  }
  
  @Test(priority=5)
  public void UpdateInfo() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")).sendKeys(Keys.CONTROL + "a");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")).sendKeys(Keys.DELETE);
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")).sendKeys("Swati");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.CONTROL + "a");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(Keys.DELETE);
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("Emp03");
	driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button")).click();
	
  }
  @AfterClass
 
  public void Close() {
	  driver.quit();
  }
  
}
