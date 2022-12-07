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

public class ManageProductTestCases extends BaseClass {

	LoginPage lp;
	HomePage hp;
	ManageExpenseExpenseCategory meec;
	ManageProduct mp;
	
	GeneralUtilities gu = new GeneralUtilities();

/*	@Test
	public void verifyTotalProductsListIsSameAsListed() throws IOException {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageProduct();

		mp = new ManageProduct(driver);
		String actual = mp.getProductList();
		String expected = "(691)"; // how to dynamically get this value
		Assert.assertEquals(actual, expected, Constant.errorMessageProductListText);
	}   */

	@Test
	public void verifyNewProductCanBeAddedWithMandatoryFields() throws IOException, InterruptedException, AWTException {

		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageProduct();

		mp = new ManageProduct(driver);
		mp.clickNew();
		mp.enterTitleText();
		mp.enterProductType();
		mp.getValueFromCategory("Diary & Bakery");
		mp.smallWait();
		mp.getValueFromSubCategory("Egg");
		mp.enterPriceType();
		mp.enterWeightValue();
		mp.selectWeightUnit("g");
		mp.enterMaxOrderQty();
		mp.enterPrice();
		mp.scroll();
		mp.enterStockAvailability();
//		mp.selectStock();
//		mp.selectFeatured();
		mp.getFileUpload();
		mp.javaScriptExecutorForClick();
		mp.saveNewProductInformation();
		
		String actual= mp.getAlertText(); 
		String expected= " Alert!";  //-------------------->
		Assert.assertEquals(actual, expected, Constant.errorMessageNewProductAddingAlert);
	}  

/*	@Test 
	public void verifySearchUsingMandatoryFields() throws InterruptedException, IOException {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageProduct();

		mp = new ManageProduct(driver);
		mp.clickSearch();
		mp.getValueFromCategory("Diary & Bakery");
		mp.smallWait();
		mp.getValueFromSubCategory("Egg");
		mp.clickSearchListProducts();

		String actual = mp.getTableCategoryValue();
		String expected = "Diary & Bakery >> Egg";
		Assert.assertEquals(actual, expected, Constant.errorMessageCategoryTableValue);
	}  

	@Test
	public void verifyAlertOccursWhenMandatoryFieldIsNotEntered() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageProduct();

		mp = new ManageProduct(driver);
		mp.clickNew();
		mp.enterTitleText();
		mp.enterProductType();
		mp.getValueFromCategory("Diary & Bakery");
		mp.smallWait();
		mp.getValueFromSubCategory("Egg");
		mp.enterPriceType();
		mp.enterWeightValue();
		mp.smallWait();
		mp.selectWeightUnit("g");
		
		mp.enterMaxOrderQty();
		mp.enterPrice();
		mp.scroll();
		mp.javaScriptExecutor();
		
		String actual = mp.getAlertHandlingText();
		mp.clickOkAlertHandling();
		String expected = "Please enter stock count";
		Assert.assertEquals(actual, expected, Constant.errorMessageProductListText);
	}   */
	
	
}
