package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpenseExpenseCategory;
import elementRepository.ManageOrdersPage;
import utilities.ExcelRead;

public class ManageExpenseExpenseCategoryTestCase extends BaseClass {

	LoginPage lp;
	HomePage hp;
	ManageExpenseExpenseCategory meec;
	

	@Test 
	public void verifyNewExpenseCategoryCanBeAdded(){
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageExpense();
		hp.clickOnExpenseCategory();

		meec = new ManageExpenseExpenseCategory(driver);
		meec.clickOnNew();
		meec.addNewTitle();
		meec.clickOnSave();
		meec.fluentWaitImplementation();
		String actual = meec.getAlertMsg();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.errorMessageNewCategoryText);
	}

	@Test 
	public void verifyAddedCategoryCanBeModified() {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageExpense();
		hp.clickOnExpenseCategory();

		meec = new ManageExpenseExpenseCategory(driver);
		meec.clickEditButton();
		meec.editCategoryInformation();
		meec.clickUpdate();
		meec.fluentWaitImplementation();
		String actual = meec.getAlertMsg();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.errorMessageModifiedCategoryText);
	}

	@Test
	public void verifyAnExpenseCategoryCanBeSearched() {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageExpense();
		hp.clickOnExpenseCategory();

		meec = new ManageExpenseExpenseCategory(driver);
		meec.clickSearchbutton();
		meec.addTitleForSearch();
		meec.clickTitleCategorySearch();

		String actual = meec.getSearchedElementText();
		String expected = "FruitNew";
		Assert.assertEquals(actual, expected, Constant.errorMessageSearchCategoryText);
	} 
	
	@Test
	public void verifyTotalCategoryCount() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageExpense();
		hp.clickOnExpenseCategory();

		meec = new ManageExpenseExpenseCategory(driver);
		int actual=meec.getCountOfWebElements();
		String expected="127";
		Assert.assertEquals(actual, expected, "fgf");
	}  

}
