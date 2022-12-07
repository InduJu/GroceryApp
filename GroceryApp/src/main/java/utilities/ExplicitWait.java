package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public void elementToBeClicked(WebDriver driver, long seconds, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		
		 
		   
		/*
		 * wait.until(ExpectedConditions.alertIsPresent()); //delay in alert coming
		 * wait.until(ExpectedConditions.attributeContains(By.xpath(elt, atri type, atri val)); //delay in HTML attributes
		 * wait.until(ExpectedConditions.textToBePresentInElement(login, null); //delay in reading any text wait.until(ExpectedConditions.urlContains(null));
		 */
		
	}

}
