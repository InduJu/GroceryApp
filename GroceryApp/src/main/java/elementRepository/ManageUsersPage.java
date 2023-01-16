package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageUsersPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();

	public ManageUsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody//tr//td[5]//a")
	List<WebElement> totalCountFirstColumn;
	
	@FindBy(xpath = "//table/tbody/tr//td[1]")
	List<WebElement> firstColumn;

	@FindBy(xpath="//table/tbody/tr[7]/td[5]/a/span")
	WebElement status;
	
	@FindBy(xpath="//table/tbody/tr[8]/td/div/div/span")
	WebElement password;
	
	public int totalCountOfUsers() {

		List<WebElement> list1 = totalCountFirstColumn;
		int count = 0;
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).getText().equals("Active")) {

				count++;
			}
		}
		return count;
	}
	
	
	public void clickLockActionFromTable(){

		List<WebElement> list1 = firstColumn;
		WebElement lock;
		gu.selectValueFromScroll(0, 150, driver);  //scroll
		try {
			wu.minimumDelay();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                         //delay
		
		int row=gu.selectValueFromDynamicTable(firstColumn, "Abhiramkrishnakumarsreenatest d");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (row+1)+ "]//td[6]/a[1]";
		lock = driver.findElement(By.xpath(locator));	
		
		gu.clickJavaScriptExecutor(lock, driver);
	}
	
	
	public String getTextOfStatus() {
		
		return gu.getElementText(status);
	}
	
	
	public void clickPasswordArrowDown() {
		List<WebElement> list1 = firstColumn;
		WebElement passwrdArrow;
		gu.selectValueFromScroll(0, 150, driver);  //scroll
		try {
			wu.minimumDelay();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                         //delay
		
		int row=gu.selectValueFromDynamicTable(firstColumn, "Abhiramkrishnakumarsreenatest d");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (row+1)+ "]//td[3]/div/a";
		passwrdArrow = driver.findElement(By.xpath(locator));	

		gu.clickJavaScriptExecutor(passwrdArrow, driver);
	}
	
	public String fetchPasswordFromDynamicTable() {
		WebElement password;
		gu.selectValueFromScroll(0, 150, driver);  //scroll
		try {
			wu.minimumDelay();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                         //delay	
		int row=gu.selectValueFromDynamicTable(firstColumn, "Abhiramkrishnakumarsreenatest d");
		String locator="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (row+2)+ "]/td/div";
		password = driver.findElement(By.xpath(locator));
		return password.getText();	
	}

}
