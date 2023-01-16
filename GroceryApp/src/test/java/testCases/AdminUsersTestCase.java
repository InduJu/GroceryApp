package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminUsers;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelRead;
import utilities.RandomDataGeneration;
import utilities.WaitUtility;

public class AdminUsersTestCase extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	AdminUsers au;
	WaitUtility wu;
	RandomDataGeneration rdg;
	
	@Test
	public void verifyWhetherANewUserIsAbleToLoginToApplication() {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 0));

		hp = new HomePage(driver);
		hp.clickOnAdminUsers();
		
		au=new AdminUsers(driver);
		au.clicknewButton();
		au.enterUsername();
		au.enterPassword();
		au.selectUserTypeFromDropdown();
		au.selectSave();
		
		String actual=au.getTextOfAlert();
		String expected="Alert!";
		Assert.assertEquals(actual, expected, Constant.errorMessageInvalidProfileText);
	}  
	
	public void verifyWhetherNavigatingToDashboardPageWhileClickingHome() {
		
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 0));

		hp = new HomePage(driver);
		hp.clickOnAdminUsers();
		
		au=new AdminUsers(driver);
		au.clickHome();
		
		String actual=au.getDashboardHighlight();
		String expected="active nav-link";
		Assert.assertEquals(actual, expected, Constant.errorMessageInvalidNavigation);	
	}
}
