package elementRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageOrdersPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();
	ExplicitWait ew = new ExplicitWait();

	public ManageOrdersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search;

	@FindBy(xpath = "//select[@id='pt']")
	WebElement paymentMode;

	@FindBy(xpath = "//input[@id='sd']")
	WebElement startDate;

	@FindBy(xpath = "//input[@id='ed']")
	WebElement endDate;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchOfSearchListOrders;

	@FindBy(xpath = "//a[@class='active nav-link']")
	WebElement highLightManageOrders;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> firstColumn;

	public void clickOnSearch() {
		search.click();
	}

	public String getValueFromPaymentMode() {

		return gu.selectValueFromDropdown(paymentMode, "COD");
	}

	public void inputDates() {
		startDate.sendKeys("12-01-2021");
		ew.attributeToBeNotEmpty(driver, 10, endDate, "id");
		endDate.sendKeys("19-12-2022");
	}

	public void clickOnSearchOfSearchListOrders() {
		searchOfSearchListOrders.click();
	}

	public int checkPaymentModeCount() {

		List<WebElement> PaymentColumn = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]"));	
		int bankCount=0, CODCount=0;	
		for (int i = 0; i < PaymentColumn.size(); i++) {
			
			if (PaymentColumn.get(i).getText().equals("Bank")) {
				
				bankCount++;
			} 
			else {
				
				CODCount++;
			}
		}
		return bankCount;
		 	
	}

	public String manageOrdersPageIsHighLighted() {
		String text = highLightManageOrders.getAttribute("class");
		return text;
	}

	public void clickDeleteDataFromTable() {

		List<WebElement> list1 = firstColumn;
		WebElement delete;
		gu.selectValueFromScroll(0, 500, driver);  //scroll
		try {
			wu.minimumDelay();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                         //delay
		
		int row=gu.selectValueFromDynamicTable(firstColumn, "335");
	
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (row+1)+ "]//td[7]//a[2]";
		delete = driver.findElement(By.xpath(locator));	

		gu.clickJavaScriptExecutor(delete, driver);
	}

	public void explicitWaitAlertIsPresentImplementation() {
		ew.alertIsPresent(driver, 5);
	}
	public String alertHandlingText() {

		return gu.clickOnAlertHandlingText(driver);
	}

	public void clickAlertHandlingOkMessage() {

		gu.pressOKOnAlertHandling(driver);
	}
}
