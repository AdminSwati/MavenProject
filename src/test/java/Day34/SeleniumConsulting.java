package Day34;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;


import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumConsulting {
	
	WebDriver driver = new ChromeDriver();
	//WebDriver driver = new FirefoxDriver();
	
  @BeforeMethod
  public void OpenApp()
  {
	  WebDriverManager.chromedriver().setup();
	  driver.get("https://www.selenium-consulting.ch/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
	
 
  

  
  @AfterClass
 
  public void Close() {
	  // driver.quit();
  }
  
}
