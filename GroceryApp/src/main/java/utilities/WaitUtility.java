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

	public void implicitWait(WebDriver driver) {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}


	public void fluentWait(WebDriver driver, WebElement element, String attribute, String attributeValue) {
		 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		            .withTimeout(Duration.ofSeconds(30))
		            .pollingEvery(Duration.ofSeconds(5))
		            .ignoring(NoSuchElementException.class);		 
		 fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
				 
				 
			
		
	}
	
}

