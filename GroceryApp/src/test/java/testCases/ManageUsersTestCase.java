package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageUsersPage;
import utilities.ExcelRead;

public class ManageUsersTestCase extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	ManageUsersPage mu;
	
	
/*	@Test
	public void verifyActiveUserList() throws IOException  {

		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		hp=new HomePage(driver);
		hp.clickOnManageUsers();
		
		mu=new ManageUsersPage(driver);
		
		int actual= mu.totalCountOfUsers();   //value----
		String expected="Active";        //text --How to assert? -------------------->>		
  		Assert.assertEquals(actual, expected, "dcscd");	
  }  
	
	@Test
	public void verifyActiveUserStatusCanBeChangedToInactive() throws IOException, InterruptedException  {
		
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		hp=new HomePage(driver);
		hp.clickOnManageUsers();
		
		mu=new ManageUsersPage(driver);
		mu.clickLockActionFromTable();
		
		String actual=mu.getTextOfStatus();
		String expected="Inactive";
		Assert.assertEquals(actual, expected, "::Active status is not as expected::");
	}   */
	
	
	@Test
	public void verifyPasswordOfUser() throws IOException, InterruptedException  {
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		hp=new HomePage(driver);
		hp.clickOnManageUsers();
		
		mu=new ManageUsersPage(driver);
		mu.clickPasswordArrowDown();
		
		String actual=mu.fetchPasswordFromDynamicTable();
		String expected="Password : resmi";
		Assert.assertEquals(actual, expected, "Password is not as expected");
		
	}	
		

	
	
}
