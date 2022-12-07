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
	public void verifyNewExpenseCategoryCanBeAdded() throws IOException {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageExpense();
		hp.clickOnExpenseCategory();

		meec = new ManageExpenseExpenseCategory(driver);
		meec.clickOnNew();
		meec.addNewTitle();
		meec.clickOnSave();

		String actual = meec.getAlertMsg();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.errorMessageNewCategoryText);
	}

	@Test 
	public void verifyAddedCategoryCanBeModified() throws IOException {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageExpense();
		hp.clickOnExpenseCategory();

		meec = new ManageExpenseExpenseCategory(driver);
		meec.clickEditButton();
		meec.editCategoryInformation();
		meec.clickUpdate();

		String actual = meec.getAlertMsg();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.errorMessageModifiedCategoryText);
	}

	@Test
	public void verifyAnExpenseCategoryCanBeSearched() throws IOException {
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
	
/*	@Test
	public void verifyTotalCategoryCount() {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));

		hp = new HomePage(driver);
		hp.clickOnManageExpense();
		hp.clickOnExpenseCategory();

		meec = new ManageExpenseExpenseCategory(driver);
		String actual=meec.getCountOfWebElements();
		String expected=""
	}  */

}
