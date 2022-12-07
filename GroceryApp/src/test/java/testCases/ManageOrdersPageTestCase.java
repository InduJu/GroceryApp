package testCases;


import java.io.IOException;
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
	

/*	@Test
	public void verifyDropdownOfPaymentMode() throws IOException {
		
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
	public void verifySearchOrdersListCanBeSearchedWithStartDate() throws IOException, InterruptedException {
		
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		
		hp=new HomePage(driver);
		hp.clickOnManageOrders();
		
		
		mo = new ManageOrdersPage(driver);
		mo.clickOnSearch();
		mo.inputDates();
		mo.clickOnSearchOfSearchListOrders();
		List<Integer> actual=mo.checkPaymentModeCount();
		
		List<Integer> expected= mo.expectedLList();    //----->doubt convertion of expected to list
		Assert.assertEquals(actual, expected, "ef");
		

	} 
	
	
	@Test
	public void verifyManageOrderPageHighlight() throws IOException {
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		
		hp=new HomePage(driver);
		hp.clickOnManageOrders();
		
		
		mo = new ManageOrdersPage(driver);
		String actual=mo.manageOrdersPageIsHighLighted();
		String expected="active nav-link";
		Assert.assertEquals(actual, expected, Constant.errorMessageManageOrdersHighlight);
		
	}  */
	
	@Test
	public void verifyThatUserGetAnAlertMessageduringDeleteClick() throws IOException, InterruptedException {
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		hp=new HomePage(driver);
		hp.clickOnManageOrders();
		
		mo = new ManageOrdersPage(driver);
		mo.clickDeleteDataFromTable();
		
		Thread.sleep(2000);
		
		String actual=mo.alertHandlingText();
		
		mo.clickAlertHandlingOkMessage();
		
		String expected="Do you want to delete this Order?";
		Assert.assertEquals(actual, expected, "::Alert text is not as expected::");
	
	}
	
}
