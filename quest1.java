package SeleniumExercise3;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class quest1 {
	public WebDriver driver;
	String fName = "Anurag";
	String lName = "Pandey";
	String address = "Gali no. 8 ,mamura chauwk,sector 61,Noida ";
	String email = "annuragp766@gmail.com";
	String phone = "8081001959";
	String language = "English";
	String password = "Anurag766";

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Anurag Pandey\\eclipse-workspace\\anurag\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
	}

	@Test
	public void fillTheFormAndSubmit() {
		WebElement firstTextBox =driver.findElement(By.cssSelector("input[placeholder=\"First Name\"]"));
		Actions action = new Actions(driver);
		action.click(firstTextBox)
		.sendKeys(fName + Keys.TAB)
		.sendKeys(lName + Keys.TAB)
		.sendKeys(address + Keys.TAB)
		.sendKeys(email + Keys.TAB)
		.sendKeys(phone).build().perform();
		driver.findElement(By.cssSelector("input[value=\"Male\"]")).click();
		driver.findElement(By.cssSelector("input[value=\"Movies\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"checkbox1\"]")).click();
		// Selecting Skills
		WebElement skills = driver.findElement(By.id("Skills"));
		Select selectSkills = new Select(skills);
		// selectSkills.selectByVisibleText("Java");
		selectSkills.selectByIndex(1);
		selectSkills.selectByVisibleText("Java");

		WebElement count = driver.findElement(By.cssSelector("#countries"));
		Select sCount = new Select(count);
		sCount.selectByIndex(0);

		// Selecting country
		WebElement country = driver.findElement(By.cssSelector("#country"));
		Select selectCountry = new Select(country);
		selectCountry.selectByValue("India");

		// Select Year
		WebElement year = driver.findElement(By.cssSelector("#yearbox"));
		Select selectYear = new Select(year);
		selectYear.selectByValue("1998");

		// Select month
		WebElement month = driver.findElement(By.xpath("//select[@placeholder=\"Month\"]"));
		Select selectMonth = new Select(month);
		selectMonth.selectByIndex(11);

		// Select date
		WebElement date = driver.findElement(By.xpath("//select[@placeholder=\"Day\"]"));
		Select selectDate = new Select(date);
		selectDate.selectByIndex(11);

		// uploading image
		driver.findElement(By.cssSelector("input[id=\"imagesrc\"]")).sendKeys("C:\\Users\\Anurag Pandey\\Desktop\\images.PNG");

		// Entering password
		WebElement pass = driver.findElement(By.id("firstpassword"));
		Actions inputPassword = new Actions(driver);
		inputPassword.click(pass)
		.sendKeys(password + Keys.TAB)
		.sendKeys(password + Keys.TAB).sendKeys(Keys.ENTER).build().perform();

	}

	@AfterClass
	public void closeBrowser() {
		//driver.close();
	}

}