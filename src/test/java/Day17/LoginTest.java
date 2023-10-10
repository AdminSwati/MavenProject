package Day17;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
/* Launch Browser
 * open url
 * login Admin admin123
 * click on login button and verify title of the dashboard page
 */
public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(500);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(5000);
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
		driver.quit();
	}
	
}
