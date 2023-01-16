package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.ExcelRead;


public class LoginPageTestCase extends BaseClass {

	LoginPage lp;
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
	
		return new Object[][] {{"indu", "123" }, {"test", "data123"},{"admin","123"}};
	}
	
	@Test (groups ="High", priority=1)
	public void verifySignInWithValidCredentials(){

		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		String actual=lp.profileNameText();
		String expected="Admin";
		Assert.assertEquals(actual, expected, Constant.errorMessageInvalidLoginText);

	} 
	
	@Test  (groups ="High", priority=2)
	public void verifySignInPageTitle() throws IOException  {
		
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
	
		String actual=lp.getTitleOfCurrentPage();
		String expected="Dashboard | 7rmart supermarket";
		
		Assert.assertEquals(actual, expected, Constant.errorMessageinPageTitle);	
	}  
	
	@Test	(priority=3)
	public void verifySignInPageURL() {
		
		lp=new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
		
		String actual=lp.getURLOfCurrentPage();
		String expected="https://groceryapp.uniqassosiates.com/admin";
		
		Assert.assertEquals(actual, expected, Constant.errorMessageinPageURL);
	}  
	
	
	@Test  (dataProvider = "data-provider", priority=4)
	public void verifySignInWithIncorrectCredentials(String username, String password) {

		lp=new LoginPage(driver);
		lp.usernameInputDataProvider(username);
		lp.passwordInputDataProvider(password);
		lp.clickOnSignIn();
		
		String actual=lp.InvalidLoginAlert();
		String expected="Alert!";
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.errorMessageUnauthorizedLogin);
	}  
	
	
	@Test (priority=5)
	public void verifySignInText() {

		lp = new LoginPage(driver);
		String actual=lp.getTextSignInButton();
		String expected="Sign In";
		Assert.assertEquals(actual, expected, Constant.errorMessageInvalidLogin);
	}  

	
	@Test (priority=6)
	public void verifyRememberMeCheckboxIsSelectedOrNot() {

		lp = new LoginPage(driver);
		lp.inputUsername("admin");
		lp.inputPassword("admin");

		boolean actual = lp.checkBoxValueReturn();
		boolean expected=true;

		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actual, expected, Constant.errorMessageCheckboxValue);
		System.out.println("Soft assertion is implemented");
		softAssert.assertAll();
		
	}  
}
