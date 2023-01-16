package elementRepository;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageExpense_ManageExpensePage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait ew=new ExplicitWait();

	public ManageExpense_ManageExpensePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchRed;

	@FindBy(xpath = "//a[@target='_blank']")
	WebElement expenseReport;

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void scroll() {
		gu.selectValueFromScroll(0, 150, driver);
	}

	public void clickOnSearchRedButton() {
		gu.clickJavaScriptExecutor(searchRed, driver);
	}

	public void clickOnReport() {
		gu.clickJavaScriptExecutor(expenseReport, driver);
	}
	
	public void explicitWaitAttributeContainsImplementation() {
		ew.attributeContains(driver, 5, searchRed, "name", "Search");
	}

	public String newTabData() {

		String parentWindow = driver.getWindowHandle(); 
		
		WebElement childElt = null;

		Set<String> allWindows = driver.getWindowHandles(); 
		for (String childWindow : allWindows) 
		{
			if (!parentWindow.equals(childWindow)) {
				
				driver.switchTo().window(childWindow);
				childElt=driver.findElement(By.xpath("//div[@class='card-header']//h4"));
				return gu.getElementText(childElt);
			}
		}
		return gu.getElementText(childElt);

	}
}
