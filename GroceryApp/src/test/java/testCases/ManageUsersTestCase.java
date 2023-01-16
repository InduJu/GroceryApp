package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageUsersPage;
import utilities.ExcelRead;

public class ManageUsersTestCase extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	ManageUsersPage mu;
	
	
	@Test
	public void verifyActiveUserList() {

		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		hp=new HomePage(driver);
		hp.clickOnManageUsers();
		
		mu=new ManageUsersPage(driver);
		
		int actual= mu.totalCountOfUsers();   
		int expected=7;       		
  		System.out.println(actual +","+ expected);
		Assert.assertEquals(actual, expected, "dcscd");	
  }  
	
	@Test
	public void verifyActiveUserStatusCanBeChangedToInactive() {
		
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		hp=new HomePage(driver);
		hp.clickOnManageUsers();
		
		mu=new ManageUsersPage(driver);
		mu.clickLockActionFromTable();
		
		String actual=mu.getTextOfStatus();
		String expected="Active";
		Assert.assertEquals(actual, expected, Constant.errorMessageInStatusVerification);
	}   
	
	
	@Test
	public void verifyPasswordOfUser(){
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		hp=new HomePage(driver);
		hp.clickOnManageUsers();
		
		mu=new ManageUsersPage(driver);
		mu.clickPasswordArrowDown();
		
		String actual=mu.fetchPasswordFromDynamicTable();
		String expected="Password : resmi";
		Assert.assertEquals(actual, expected, Constant.errorMessageInPasswordVerification);
		
	}	
}
