package SeleniumExercise3;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class quest4 {
	public WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anurag Pandey\\eclipse-workspace\\anurag\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.tothenew.com/");
	}
	
	@Test
	public void scrollTTN() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//This will scroll from top to 600px down.
		js.executeScript("window.scrollBy(0,1000)");

		//This will scroll from top to bottom
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//WebElement element = driver.findElement(By.xpath("(//div[@class=\"heading\"])[3]"));
		
		
		//This will scroll from top to particular element
		//js.executeScript("arguments[0].scrollIntoView();", element);

	}
	
	@AfterClass
	public void closeBrowser() {
		//driver.close();
	}

}