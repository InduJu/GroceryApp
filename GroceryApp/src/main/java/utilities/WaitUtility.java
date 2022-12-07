package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	
	public void minimumDelay() throws InterruptedException {
		
		Thread.sleep(2000);
	}

//ImplicitWait
	
//	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

//fluentWait
	
/*
 * Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
 * .withTimeout(Duration.ofSeconds(30)) //maximum time duration-->max time out
 * .pollingEvery(Duration.ofSeconds(5)) //intermediate interval(every 5Sec til
 * total 30s) to chk the elts load --> polling interval
 * .ignoring(NoSuchElementException.class);
 * 
 * 
 * WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {
 * public WebElement apply(WebDriver driver) { return
 * driver.findElement(By.id("foo")); } }); }
 */

}