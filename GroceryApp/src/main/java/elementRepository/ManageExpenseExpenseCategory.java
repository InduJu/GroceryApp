package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.RandomDataGeneration;
import utilities.WaitUtility;

public class ManageExpenseExpenseCategory {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();
	RandomDataGeneration rdg=new RandomDataGeneration();

	public ManageExpenseExpenseCategory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='col-sm-12']//child::a")
	WebElement newButton;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement titleText;
	
	@FindBy(xpath="//button[@name='Create']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement alertMsg;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td//a[1]")
	WebElement editButton;

	@FindBy(xpath="//div[@class='form-group']//input[@id='name']")
	WebElement editCategoryInfor;
	
	@FindBy (xpath="//div[@class='card-footer center']//button[@name='Update']")
	WebElement update;
	
	@FindBy(xpath="//div[@class='col-sm-12']//a[2]")
	WebElement searchCategory;
	
	@FindBy (xpath="//div[@class='col-sm-12 form-group']//input[@id='un']")
	WebElement searchCategoryTitle;
	
	@FindBy (xpath="//div[@class='card-body']//button[@name='Search']")
	WebElement titleSearch;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody/tr/td[1]")
	WebElement searchedElementText;
	
	@FindBy(xpath="//ul[@class='pagination pagination-sm m-0 float-right']//li//a")
	List<WebElement> listPage;
	
	@FindBy(xpath="//li[@class='page-item']//a[6]")
	WebElement countElement;
	
	
	public void clickOnNew() {
		newButton.click();
	}
	
	public void addNewTitle() {
		titleText.sendKeys("Almond"+ rdg.random());
	}
	
	public void clickOnSave() {
		saveButton.click();
	}

	public String getAlertMsg() {
		return gu.getElementText(alertMsg);	
	}
	
	public void clickEditButton() {
		editButton.click();
	}
	
	public void editCategoryInformation() {
		editCategoryInfor.sendKeys("123");
	}
	
	public void clickUpdate() {
		update.click();
	}
	
	public void clickSearchbutton() {
		searchCategory.click();
	}
	
	public void addTitleForSearch() {
		searchCategoryTitle.sendKeys("FruitNew");
	}
	
	public void clickTitleCategorySearch() {
		titleSearch.click();
	}
	
	public String getSearchedElementText() {
		
		return gu.getElementText(searchedElementText);	
	}
	
	public void fluentWaitImplementation() {
		wu.fluentWait(driver, alertMsg,"class", "alert alert-success alert-dismissible");
		
	}
	
	public int getCountOfWebElements() throws InterruptedException {
		
		int number=listPage.size();
		int i=number-2;
		
		WebElement element=driver.findElement(By.xpath("//ul[@class='pagination pagination-sm m-0 float-right']//li["+ i +"]//a"));
		gu.clickJavaScriptExecutor(element, driver);
		Thread.sleep(2000);
		List<WebElement> listTable=driver.findElements(By.xpath("//div[@class='card-body table-responsive p-0']//table//tbody//tr//td[1]"));
		int lastTableColumnCount=listTable.size();
		System.out.println(lastTableColumnCount);
		
		int totalCount=(i-1)*20+lastTableColumnCount;
		System.out.println(totalCount);
		return totalCount;
	}
	
	
}
