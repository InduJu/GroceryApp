package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageProduct {
	
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();

	public ManageProduct(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement titleText;
	
	@FindBy(xpath="//div[@class='col-sm-6 form-group']//label[3]//input")
	WebElement productTypeRadioButton;
	
	@FindBy(xpath="//input[@id='purpose']")
	WebElement priceTypeRadioButton;
	
	@FindBy(xpath="//input[@id='m_weight']")
	WebElement weightValueText;
	
	@FindBy(xpath="//select[@id='w_unit']")
	WebElement weightUnitDropdown;
	
	@FindBy(xpath="//input[@id='max_weight']")
	WebElement maximumQtyText;
	
	@FindBy(xpath="//input[@id='w_price']")
	WebElement priceText;
	
	@FindBy(xpath="//input[@id='w_stock']")
	WebElement stockAvailabilityText;
	
	@FindBy(xpath="//input[@name='stock']")
	WebElement stockRadioButton;
	
	@FindBy(xpath="//input[@name='featured']")
	WebElement featuredRadioButton;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveAddProductInfo;
	
	@FindBy(xpath="//div[@class='col-sm-12']//a[text()=' Search']")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@class='card-header']//b")
	WebElement productsList;
	
	@FindBy(xpath="//select[@id='cat_id']")
	WebElement selectCategory;
	
	@FindBy(xpath="//select[@id='sub_id']")
	WebElement subCategory;
	
	@FindBy(xpath="//button[@name='Search']")
	WebElement searchListProduct;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody/tr[1]/td[3]")
	WebElement tableCategory;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement alertMessage;
	
	
	@FindBy(xpath="//input[@id='main_img']")
	WebElement filePath;
	
	public String getProductList() {
		
		return gu.getElementText(productsList);	
	}
	
	public void clickSearch() {
		searchButton.click();
	}
	
	public void clickSearchListProducts() {
		searchListProduct.click();
	}
	
	public String getValueFromCategory(String value) {
		
		return gu.selectValueFromDropdown(selectCategory, value);	
	}
	
	public String getValueFromSubCategory(String value) {
		
		return gu.selectValueFromDropdown(subCategory, value);	
	}
	
	public String getTableCategoryValue() {
		
		return gu.getElementText(tableCategory);
	}
	
	public void clickNew() {
		newButton.click();
	}
	
	public void enterTitleText() {
		titleText.sendKeys("Red Meat");	
	}
	
	public void enterProductType() {
		productTypeRadioButton.click();
	}

	public void enterPriceType() {
		priceTypeRadioButton.click();
	}
	
	public void enterWeightValue() {
		weightValueText.sendKeys("12");
	}
	
	public String selectWeightUnit(String value) {
		return gu.selectValueFromDropdown(weightUnitDropdown, value);
	}
	
	public void enterMaxOrderQty() {
		maximumQtyText.sendKeys("2");
	}
	
	public void enterPrice() {
		priceText.sendKeys("150");
	}
	
	public void enterStockAvailability() {
		stockAvailabilityText.sendKeys("7");
	}
	public boolean selectStock() {
		return gu.selectValueFromCheckboxOrRadioButton(stockRadioButton);
	}
	
	public boolean selectFeatured() {
		return gu.selectValueFromCheckboxOrRadioButton(featuredRadioButton);
	}
	
	public void saveNewProductInformation() {
		saveAddProductInfo.click();
	}
	
	public String getAlertText() {
		return gu.getElementText(alertMessage);
	}
	
	public void smallWait() throws InterruptedException {
		wu.minimumDelay();
	}
	
	public String getAlertHandlingText() {
		
		return gu.clickOnAlertHandlingText(driver);
	}
	
	public void clickOkAlertHandling(){
		
		gu.pressOKOnAlertHandling(driver);
	}
	
	public void scroll() {
		gu.selectValueFromScroll(0,500, driver);
	
	}
	
	public void javaScriptExecutorForClick() {
		gu.clickJavaScriptExecutor(saveAddProductInfo, driver);
	}
	
	public void getFileUpload() throws AWTException {
		gu.chooseFileToUpload(driver, filePath, (System.getProperty("user.dir")+ "\\src\\main\\resources\\UploadFile\\Document.docx"));
	}
	
}
