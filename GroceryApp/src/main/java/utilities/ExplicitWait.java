package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public void elementToBeClickable(WebDriver driver, long seconds, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void alertIsPresent(WebDriver driver, long seconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void attributeContains(WebDriver driver, long seconds, WebElement element, String attribute, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
	
	public void attributeToBeNotEmpty(WebDriver driver, long seconds, WebElement element, String attribute) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
	}

	public void textToBePresentInElement(WebDriver driver, long seconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.textToBePresentInElement(element, null));
	}

	
}
