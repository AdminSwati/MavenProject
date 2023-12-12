package Day39;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginngTest {
	public WebDriver driver;
	public LoginPage lp;
	//LoginPage2 lp;
	
	@BeforeClass
	void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(50);
		
	}
	
@Test(priority=1)
	void testLogo()
	{
		lp=new LoginPage(driver);
		//lp=new LoginPage2(driver);
		
	//	Assert.assertEquals(lp.checkLogoPresence(), true);
	}
	
	
	@Test(priority=2)
	void testLogin()
	{
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp.ClickLogin();
		
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
				
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
}
