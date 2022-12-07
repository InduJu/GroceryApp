package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.ExcelRead;


public class LoginPageTestCase extends BaseClass {

	LoginPage lp;
	
	@Test (groups ="High")
	public void verifySignInWithValidCredentials() throws IOException  {

		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		String actual=lp.profileNameText();
		String expected="Admin";
		Assert.assertEquals(actual, expected, Constant.errorMessageInvalidLoginText);

	} 
	
	@Test  (groups ="High")
	public void verifySignInPageTitle() throws IOException  {
		
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
	
		String actual=lp.getTitleOfCurrentPage();
		String expected="Dashboard | 7rmart supermarket";
		
		Assert.assertEquals(actual, expected, "Title of the page is not as expected");	
	}  
	
	@Test
	public void verifySignInPageURL() throws IOException  {
		
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		String actual=lp.getURLOfCurrentPage();
		String expected="https://groceryapp.uniqassosiates.com/admin";
		
		Assert.assertEquals(actual, expected, "Title of the page is not as expected");
	}  
	
	
/*	@Test   //-----------------need to check 'Alert!'
	public void verifySignInWithIncorrectCredentials() throws IOException {

		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		String actual=lp.InvalidLoginAlert();
		String expected="Invalid Username/Password";
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.errorMessageUnauthorizedLogin);
	}
	
	
	@Test
	public void verifySignInText() {

		lp = new LoginPage(driver);
		
		
		String actual=lp.getTextSignInButton();
		String expected="Sign In";
		Assert.assertEquals(actual, expected, Constant.errorMessageInvalidLogin);
	} 

	
	@Test  
	public void verifyRememberMeCheckboxIsSelectedOrNot() {

		lp = new LoginPage(driver);
		lp.inputUsername("admin");
		lp.inputPassword("admin");

		boolean actual = lp.checkBoxValueReturn();
		boolean expected=true;
		Assert.assertEquals(actual, expected, Constant.errorMessageCheckboxValue);
	}  */
}
