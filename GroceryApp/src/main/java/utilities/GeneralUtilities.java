package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	JavascriptExecutor js;

	public void getCredentials(WebElement element, String Value) {
		element.sendKeys(Value);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String selectValueFromDropdown(WebElement element, String value) {
		Select obj = new Select(element);
		obj.selectByVisibleText(value);
		WebElement selectedElement = obj.getFirstSelectedOption();
		String text = selectedElement.getText();
		return text;
	}

	public boolean selectValueFromCheckboxOrRadioButton(WebElement element) {
		element.click(); 
		boolean a = element.isSelected();
		return a;
	}

	public void selectValueFromScroll(int x, int y, WebDriver driver) {

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public String clickOnAlertHandlingText(WebDriver driver) {

		String text = driver.switchTo().alert().getText();
		return text;
	}

	public void pressOKOnAlertHandling(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void pressCancelOnAlertHandling(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public int selectValueFromDynamicTable(List<WebElement> listOfColumn, String value) {
	
		
		int j=0;
		for (int i = 0; i < listOfColumn.size(); i++) {
			if (listOfColumn.get(i).getText().equals(value)) {
				
				j=i;
				break;
			}
		}
		return j;

	}
	
	
	public void chooseFileToUpload(WebDriver driver, String filePath) throws AWTException {
		
	//	 Actions obj=new Actions(driver);
	//	 obj.moveToElement(element).click().perform(); 

	    StringSelection ss = new StringSelection(filePath); 
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	     
	     Robot robot=new Robot();
	     robot.delay(200);

	     robot.keyPress(KeyEvent.VK_CONTROL);  
	     robot.keyPress(KeyEvent.VK_V);
	     robot.delay(200);
	     
	     robot.keyRelease(KeyEvent.VK_CONTROL); 
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.delay(200);
	     
	     robot.keyPress(KeyEvent.VK_ENTER); 
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     
	}

	public void fileUploadUsingSendKeys(WebElement element, String path) {
		element.sendKeys(path);
	} 
}
