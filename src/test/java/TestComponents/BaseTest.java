package TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ecommerce.PageObjects.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage loginPage;

	public WebDriver InitiliazeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\JAVA_SELENIUM\\ProjectEcommerce\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}

	@BeforeMethod
	public LoginPage launchTheApplication() throws IOException {
		driver = InitiliazeDriver();
		loginPage = new LoginPage(driver);
		loginPage.goToLoginPage();
		return loginPage;
	}

	@AfterMethod
	public void tearDown() {
		 driver.close();
	}

}
