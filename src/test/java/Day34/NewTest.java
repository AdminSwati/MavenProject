package Day34;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeMethod;


import java.time.Duration;

import org.openqa.selenium.By;
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
	
  @Test(priority=1)
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
		try {
			act_label= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		}
		catch(NoSuchElementException e) {
			
		}
		
		if(act_label.equals("Dashboard"))
				System.out.print("Successful login, dashboard is present");
		else
				System.out.print("Test failed Dashboard");
		if(driver.getTitle().equals("OrangeHRM"))
		System.out.print("\nTest passed, title is OrangeHRM");
		else
		System.out.print("\n test failed");
  }
  
  @Test(priority=4)
  public void Search() {
	  System.out.print("testCreated");
  }
  @AfterClass
 
  public void Close() {
	  driver.quit();
  }
  
}
