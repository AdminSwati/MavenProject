package Day39;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	//constructor
	public WebDriver driver;
	

	LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	//locators
	
	By login_Username = By.name("username");
	By login_pass = By.name("password");
	By login_submit = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

//Action Methods
	
	public void setUsername(String Username)
	{
		driver.findElement(login_Username).sendKeys(Username);
		
	}
	
	public void setPassword(String Password)
	{
		
		
			driver.findElement(login_pass).sendKeys(Password);
		
	}
	public void ClickLogin()
	{
		driver.findElement(login_submit).click();
	}
}
