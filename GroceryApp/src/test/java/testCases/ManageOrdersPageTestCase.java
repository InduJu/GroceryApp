package testCases;



import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageOrdersPage;
import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class ManageOrdersPageTestCase extends BaseClass{
	LoginPage lp;
	HomePage hp;
	ManageOrdersPage mo;
	GeneralUtilities gu ;
	

	@Test(enabled = false)
	public void verifyDropdownOfPaymentMode(){
		
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
			
		hp=new HomePage(driver);
		hp.clickOnManageOrders();	
		
		mo = new ManageOrdersPage(driver);
		mo.clickOnSearch();

		String actual = mo.getValueFromPaymentMode();
		String expected = "COD";
		Assert.assertEquals(actual, expected, Constant.errorMessageManageOrdersDropdown);
	} 
	
	@Test 
	public void verifySearchOrdersListCanBeSearchedWithStartDate(){
		
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		
		hp=new HomePage(driver);
		hp.clickOnManageOrders();
		
		
		mo = new ManageOrdersPage(driver);
		mo.clickOnSearch();
		mo.inputDates();
		mo.clickOnSearchOfSearchListOrders();
		
		int actual=mo.checkPaymentModeCount();	
		int expected=11 ;
		Assert.assertEquals(actual, expected, Constant.errorMessageIncorrectPaymentModeCount);	
	} 
	
	
	@Test(enabled = false)
	public void verifyManageOrderPageHighlight(){
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		hp=new HomePage(driver);
		hp.clickOnManageOrders();
			
		mo = new ManageOrdersPage(driver);
		String actual=mo.manageOrdersPageIsHighLighted();
		String expected="active nav-link";
		Assert.assertEquals(actual, expected, Constant.errorMessageManageOrdersHighlight);	
	}  
	
	@Test (enabled=false)
	public void verifyThatUserGetAnAlertMessageduringDeleteClick(){
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		hp=new HomePage(driver);
		hp.clickOnManageOrders();
		
		mo = new ManageOrdersPage(driver);
		mo.clickDeleteDataFromTable();
		mo.explicitWaitAlertIsPresentImplementation();
		
		String actual=mo.alertHandlingText();	
		mo.clickAlertHandlingOkMessage();
		
		String expected="Do you want to delete this Order?";
		Assert.assertEquals(actual, expected, Constant.errorMessageinAlertText);
	
	}
	
}
