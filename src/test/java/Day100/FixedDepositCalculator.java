package Day100;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDepositCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		/*driver.findElement(By.xpath("/html/body/div[3]/form/div[1]/div/input")).sendKeys("swati.bg007@gmail.com");
		driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div[1]/input")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"mc_login\"]/div[4]/a")).click();*/
		
		 	driver.findElement(By.xpath("//*[@id=\"LoginModal\"]")).click();
		    driver.switchTo().frame("myframe");
		    driver.findElement(By.id("email")).sendKeys("xyz@gmail.com");
		    driver.findElement(By.id("pwd")).sendKeys("abc");
		    //driver.findElement(By.xpath("/html/body/div[3]/form/div[1]/div/input")).sendKeys("swati.bg007@gmail.com");
			//driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div[1]/input")).sendKeys("1234");
		
		String file=System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		int rows=XLUtility.getRowCount(file, "Sheet1");
		
		
		for(int i=1;i<=rows;i++)
		{
			//read data from excel
			String princ=XLUtility.getCellData(file,"Sheet1",i,0);
			String rateofinterest=XLUtility.getCellData(file,"Sheet1",i,1);
			String per1=XLUtility.getCellData(file,"Sheet1",i,2);
			String per2=XLUtility.getCellData(file,"Sheet1",i,3);
			String fre=XLUtility.getCellData(file,"Sheet1",i,4);
			String exp_mvalue=XLUtility.getCellData(file,"Sheet1",i,5);
			
				
			//pass data to the app
			driver.findElement(By.id("principal")).sendKeys(princ);
			driver.findElement(By.id("interest")).sendKeys(rateofinterest);
			driver.findElement(By.id("tenure")).sendKeys(per1);
			
			Select perdrp=new Select(driver.findElement(By.id("tenurePeriod")));
			perdrp.selectByVisibleText(per2);
			
			Select fredrp=new Select(driver.findElement(By.id("frequency")));
			fredrp.selectByVisibleText(fre);
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement calculate_btn=driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
			js.executeScript("arguments[0].click();",calculate_btn);  // clicking on calculate button
						
			//validation & update results in excel
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
			
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test Passsed");
				XLUtility.setCellData(file, "Sheet1",i,7,"Passed");
				XLUtility.fillGreenColor(file, "Sheet1",i,7);
			}
			else
			{
				System.out.println("Test Failed");
				XLUtility.setCellData(file, "Sheet1",i,7,"Failed");
				XLUtility.fillRedColor(file, "Sheet1",i,7);
			}
			Thread.sleep(3000);
				
			WebElement clear_btn=driver.findElement(By.xpath("//img[@class='PL5']"));
			js.executeScript("arguments[0].click();",clear_btn);  // clicking on clear button
		
		
		}

	}

}