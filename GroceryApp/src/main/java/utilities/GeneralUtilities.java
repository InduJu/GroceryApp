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
		element.click(); // comment for loginPage RememberMe
		boolean a = element.isSelected();
		System.out.println(a);
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
	
		//	String elementLocator = gu.selectValueFromDynamicTable(list1, "386", "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\"+ (i+1) +\"]//td[7]//child::a[2]");
		int j=0;
//		String elementLocator = null;
		for (int i = 0; i < listOfColumn.size(); i++) {
			if (listOfColumn.get(i).getText().equals(value)) {
				//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\"+ (i+1) +\"]//td[7]//child::a[2]
				j=i;
				//elementLocator = locator;
				break;
			}
		}
		return j;
//		return elementLocator;
	}
	
	
	public void chooseFileToUpload(WebDriver driver,WebElement fileElement,String filePath) throws AWTException {
//		WebElement fileElement=  driver.findElement(By.id("uploadfile_0"));
		Actions obj=new Actions(driver);
	    obj.moveToElement(fileElement).click().perform(); 
	    StringSelection ss = new StringSelection(filePath); //StrignSelection is a class for accessing system OS
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	     
	     Robot robot=new Robot();
	     robot.delay(200);

	     robot.keyPress(KeyEvent.VK_CONTROL);  //Cntrl+v  --> Press   [File name from the s/m screen]
	     robot.keyPress(KeyEvent.VK_V);
	     robot.delay(200);
	     
	     robot.keyRelease(KeyEvent.VK_CONTROL); // cntrl+v --> Release/paste
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.delay(200);
	     
	     robot.keyPress(KeyEvent.VK_ENTER); // Enter --> press
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     
	}

	
	

}
