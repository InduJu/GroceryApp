package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpenseExpenseCategory;
import elementRepository.ManageProduct;
import utilities.ExcelRead;
import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageProductTestCases extends BaseClass {

	LoginPage lp;
	HomePage hp;
	ManageExpenseExpenseCategory meec;
	ManageProduct mp;


	@Test
	public void verifyTotalProductsListIsSameAsListed()   {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);	
		hp.clickOnManageProduct();
		
		mp = new ManageProduct(driver);
        int expected=mp.expectedImplementation();
		mp.clickNew();
		mp.enterTitleText();
		mp.enterProductType();
		mp.getValueFromCategory("Diary & Bakery");		
		mp.clickSubCat();	
		mp.explicitWaiteltToBeClikable();
		mp.getValueFromSubCategory("Egg");
		mp.explicitWaiteltToBeClikable();
		mp.enterPriceType();
		mp.enterWeightValue();
		mp.selectWeightUnit("g");
		mp.scroll();
		mp.enterMaxOrderQty();
		mp.enterPrice();
		mp.enterStockAvailability();	
		mp.getFileUpload();     
		mp.saveNewProductInformation();
		hp.clickOnManageProduct();
		int actual = mp.getProductList();
		Assert.assertEquals(actual, expected, Constant.errorMessageProductListText);
	}   

	@Test
	public void verifyNewProductCanBeAddedWithMandatoryFields() throws AWTException, InterruptedException {

		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageProduct();

		mp = new ManageProduct(driver);
		mp.clickNew();
		mp.enterTitleText();
		mp.enterProductType();
		mp.getValueFromCategory("Diary & Bakery");		
		mp.clickSubCat();	
		mp.explicitWaiteltToBeClikable();
		mp.getValueFromSubCategory("Egg");
		mp.explicitWaiteltToBeClikable();
		mp.enterPriceType();	
		mp.enterWeightValue();
		mp.selectWeightUnit("g");
		mp.scroll();
		mp.enterMaxOrderQty();
		mp.enterPrice();
		mp.enterStockAvailability();	
		mp.getFileUpload();     
		mp.saveNewProductInformation();
		String actual= mp.getAlertText(); 
		String expected= "Alert!";  
		Assert.assertEquals(actual, expected, Constant.errorMessageNewProductAddingAlert);
	}  

	@Test 
	public void verifySearchUsingMandatoryFields() {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageProduct();

		mp = new ManageProduct(driver);
		mp.clickSearch();
		mp.getValueFromCategory("Diary & Bakery");
		mp.explicitWaiteltToBeClikable();
		mp.clickSubCat1();	
		mp.explicitWaiteltToBeClikable();
		mp.getValueFromSubCategoryForM("Egg");
		mp.explicitWaiteltToBeClikable();
		mp.clickSearchListProducts();

		String actual = mp.getTableCategoryValue();
		String expected = "Diary & Bakery >> Egg";
		Assert.assertEquals(actual, expected, Constant.errorMessageCategoryTableValue);
	}  

	@Test
	public void verifyAlertOccursWhenMandatoryFieldIsNotEntered() throws InterruptedException{
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageProduct();

		mp = new ManageProduct(driver);
		mp.clickNew();
		mp.enterTitleText();
		mp.enterProductType();
		mp.getValueFromCategory("Diary & Bakery");
		mp.clickSubCat();	
		mp.explicitWaiteltToBeClikable();
		mp.getValueFromSubCategory("Egg");
		mp.explicitWaiteltToBeClikable();
		mp.enterPriceType();
		mp.enterWeightValue();	
		mp.selectWeightUnit("g");
		mp.enterMaxOrderQty();
		mp.enterPrice();
		mp.scroll();
		mp.javaScriptExecutorForClick();
		
		String actual = mp.getAlertHandlingText();
		mp.clickOkAlertHandling();
		String expected = "Please enter stock count";
		Assert.assertEquals(actual, expected, Constant.errorMessageProductListText);
	}   
		
}
