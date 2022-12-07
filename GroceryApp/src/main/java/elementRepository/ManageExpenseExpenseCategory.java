package elementRepository;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageExpenseExpenseCategory {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

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
	
	@FindBy(xpath="//div[@class='row-sm-12']//div[1]/h5")
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
	
	@FindBy(xpath="//*")
	WebElement count;
	
	@FindBy(xpath="//li[@class='page-item']//a[6]")
	WebElement countElement;
	
	
	public void clickOnNew() {
		newButton.click();
	}
	
	public void addNewTitle() {
		titleText.sendKeys("Almond");
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
	
//	public void getCountOfWebElements() {
//		count.si
		
//	}
	
	
}
