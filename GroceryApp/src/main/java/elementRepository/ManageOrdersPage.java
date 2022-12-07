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

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageOrdersPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

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

	public void inputDates() throws InterruptedException {
		startDate.sendKeys("19-04-2021");
		Thread.sleep(2000);
		endDate.sendKeys("19-04-2021");
	}

	public void clickOnSearchOfSearchListOrders() {
		searchOfSearchListOrders.click();
	}

	public List<Integer> checkPaymentModeCount() {

		List<WebElement> PaymentColumn = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]"));
		List<Integer> count=new ArrayList<Integer>();
		int bankCount=0;
		int CODCount=0;
		for (int i = 0; i < PaymentColumn.size(); i++) {
			
			if (PaymentColumn.get(i).getText().equals("Bank")) {
				
				bankCount++;
			} 
			else {
				
				CODCount++;
			}
		}
		
		count.add(bankCount);
		count.add(CODCount);
		return count;		
	}

	public List expectedLList()
	{
		List<Integer> expected= new ArrayList();
		expected.add(4);
		expected.add(1);
		return expected;
	}
	
	public String manageOrdersPageIsHighLighted() {
		String text = highLightManageOrders.getAttribute("class");
		return text;
	}

	public void clickDeleteDataFromTable() throws InterruptedException {

		List<WebElement> list1 = firstColumn;
		WebElement delete;
		gu.selectValueFromScroll(0, 500, driver);  //scroll
		wu.minimumDelay();                         //delay
		
		int row=gu.selectValueFromDynamicTable(firstColumn, "386");
	
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (row+1)+ "]//td[7]//a[2]";
		delete = driver.findElement(By.xpath(locator));	

		gu.clickJavaScriptExecutor(delete, driver);
	}

	public String alertHandlingText() {

		return gu.clickOnAlertHandlingText(driver);
	}

	public void clickAlertHandlingOkMessage() {

		gu.pressOKOnAlertHandling(driver);
	}
}
