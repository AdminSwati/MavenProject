package Day18;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DemoLocators1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://automationtesting.co.uk/loginPortal.html?");
		driver.manage().window().maximize();
		driver.findElement(By.id("login_text")).sendKeys("test");
		driver.findElement(By.id("login_password")).sendKeys("test123");
		driver.findElement(By.id("login_btn")).click();
		driver.close();
	}

}
