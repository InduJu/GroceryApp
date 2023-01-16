package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageProduct {
	
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait ew=new ExplicitWait();
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
	
	@FindBy(xpath="//select[@id='sb']")
	WebElement subCategory1;
	
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
	
	public int getProductList() {
		 String a=gu.getElementText(productsList);
		 String b=  a.substring(1, a.length() - 1);
		 int val=Integer.parseInt(b);
		 return val;
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
	
	public String getValueFromSubCategoryForM(String value) {
		
		return gu.selectValueFromDropdown(subCategory1, value);	
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
		weightValueText.sendKeys("54");
	}
	
	public String selectWeightUnit(String value) {
		return gu.selectValueFromDropdown(weightUnitDropdown, value);
	}
	
	public void enterMaxOrderQty() {
		maximumQtyText.sendKeys("2");
	}
	
	public void enterPrice() {
		priceText.sendKeys("10");
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
		gu.clickJavaScriptExecutor(saveAddProductInfo, driver);
	}
	
	public String getAlertText() {
		return gu.getElementText(alertMessage);
	}
	public void clickSubCat() {
		subCategory.click();
	}
	public void clickSubCat1() {
		subCategory1.click();
	}
	public void explicitWaiteltToBeClikable() {
		ew.elementToBeClickable(driver, 10, subCategory);
	}
	
	public void explicitWaiteltToBeClikableForM() {
		ew.elementToBeClickable(driver, 10, subCategory1);
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
	
	public void getFileUpload(){
		
		gu.clickJavaScriptExecutor(filePath, driver);
		
		try {
			gu.chooseFileToUpload(driver,(System.getProperty("user.dir")+ "\\src\\main\\resources\\UploadFile\\image.png"));
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		try {
			wu.minimumDelay();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public int expectedImplementation() {
		int a=getProductList();
		return a+1;
	   
	}
}
