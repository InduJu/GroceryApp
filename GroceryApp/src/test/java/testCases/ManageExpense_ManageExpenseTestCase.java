package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpense_ManageExpensePage;
import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class ManageExpense_ManageExpenseTestCase extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	ManageExpense_ManageExpensePage me_me;
	GeneralUtilities gu;
	
  @Test
  public void verifyNewReportTabIsOpeningWhileClickingReportButton(){
	  
	  lp = new LoginPage(driver);
	  lp.logInWithCredetials(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 0));

	  hp = new HomePage(driver);
	  hp.clickOnManageExpense();
	  hp.clickOnManageExpense_me();
	  
	  me_me=new ManageExpense_ManageExpensePage(driver);
	  me_me.clickOnSearchButton();
	  me_me.scroll();
	  me_me.explicitWaitAttributeContainsImplementation();  
	  me_me.clickOnSearchRedButton();
	  me_me.clickOnReport();
	  String actual= me_me.newTabData();
	  String expected="Expense Report";
	  Assert.assertEquals(actual, expected, Constant.errorMessageinMultiTabwindow);
  }
}
