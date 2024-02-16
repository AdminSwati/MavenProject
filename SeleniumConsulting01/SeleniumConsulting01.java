package SeleniumConsulting01;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SeleniumConsulting01 {

	WebDriver driver = new ChromeDriver();
	  @BeforeMethod
	  public void OpenApp()
	  {
		  WebDriverManager.chromedriver().setup();
		  driver.get("https://www.selenium-consulting.ch/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }

}
