package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.AdminUsers;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelRead;
import utilities.WaitUtility;

public class AdminUsersTestCase extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	AdminUsers au;
	WaitUtility wu;
	
	@Test
	public void verifyWhetherANewUserIsAbleToLoginToApplication() throws IOException, InterruptedException {
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
		                           

		au.clickProfile(); 
		au.clickProfileLogout();
		

		au.enterNewUser();
		au.enterNewPassword();
		au.clickSignIn();
		String actual=au.getTextOfNewProfile();
		String expected="Indu";
		Assert.assertEquals(actual, expected, "New profile text is not as expected");
	}
}
