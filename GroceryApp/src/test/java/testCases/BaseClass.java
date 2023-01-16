package testCases;

import org.testng.annotations.Test;

import utilities.ScreenshotCapture;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	WebDriver driver;
	ScreenshotCapture sc;
	public static Properties pro;

	public static void testBasic() throws IOException {

		pro = new Properties();
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
		pro.load(fp);
	}


	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String s) throws IOException {

		testBasic();

		if (s.equals("chrome")) {

			System.setProperty(pro.getProperty("ChromeDriver"),System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (s.equals("edge")) {
			System.setProperty(pro.getProperty("EdgeDriver"),System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (s.equals("firefox")) {
			System.setProperty(pro.getProperty("FirefoxDriver"),System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(pro.getProperty("BaseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}   

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenshotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		driver.close();
	}
}
