package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();


	public LoginPage(WebDriver driver) {
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signIn;

	@FindBy(xpath="//li[@class='nav-item dropdown']//a[@data-toggle='dropdown']")
	WebElement profileName;
	
	@FindBy(xpath="(//div[@class='alert alert-danger alert-dismissible']/text())[3]")
	WebElement invalidAlert;
	
	@FindBy(xpath="//div[@class='icheck-dark']//label")
	WebElement rememberMeChkBox;
	
	@FindBy(xpath="//input[@id='remember']")
	WebElement chkBoxIsSelected;

	public String getTitleOfCurrentPage() {
		
		return gu.getTitle(driver);
	}
	
	public String getURLOfCurrentPage() {
		
		return gu.getURL(driver);
	}
	
	
	
	public void inputUsername(String userName) {

		gu.getCredentials(username, userName);	
	}

	public void inputPassword(String pswrd) {

		gu.getCredentials(password, pswrd);
	}  
	
	public void clickOnSignIn() {
		signIn.click();
	} 
	
	
	public void logInWithCredetials(String userName, String pswrd)	{
		gu.getCredentials(username, userName);	
		gu.getCredentials(password, pswrd);
		signIn.click();
	}
	
	
	public String getTextSignInButton() {
		return gu.getElementText(signIn);
		 
	}
		
	public String profileNameText() {
		
		return gu.getElementText(profileName);		
	}
	
	public String InvalidLoginAlert() {
		
		return gu.getElementText(invalidAlert);	
	}   
	
	public boolean checkBoxValueReturn() {
		rememberMeChkBox.click();
		return gu.selectValueFromCheckboxOrRadioButton(chkBoxIsSelected);
	}
	
}
