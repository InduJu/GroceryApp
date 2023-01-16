package elementRepository;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.RandomDataGeneration;
import utilities.WaitUtility;

public class AdminUsers {
	
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();
	RandomDataGeneration rdg=new RandomDataGeneration();

	public AdminUsers(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']//i[@class='fas fa-edit']")
	WebElement newButton;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passWord;
	
	@FindBy(xpath="//select[@id='user_type']")
	WebElement userTypeDropdown;
	
	@FindBy(xpath="//div[@class='card-footer center']//button[@type='submit']")
	WebElement saveButton;
	
	
	@FindBy(xpath="//img[@class='img-circle']")
	WebElement adminDropdown;
	
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement newUsername;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement newPassword;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signIn;
	
	@FindBy(xpath="//h5[normalize-space()='Alert!']")
	WebElement alertText;
	
	@FindBy(linkText="Home")
	WebElement home;
	
	@FindBy(xpath="//a[@class='active nav-link']")
	WebElement dashboardHighlight;
	
	
	public void clicknewButton() {
		newButton.click();
	}
	
	public void enterUsername() {	
		userName.sendKeys("indu" + rdg.random());	
	}
	
	public void enterPassword() {
		  
		passWord.sendKeys("indu123" +  rdg.random());
	}
	
	public void selectUserTypeFromDropdown() {
		gu.selectValueFromDropdown(userTypeDropdown, "Admin");
	}
	
	public void selectSave() {
		saveButton.click();
	}
	
	public String getTextOfAlert() {
		return gu.getElementText(alertText);
	}
	
	public void clickHome() {
		home.click();
	}
	
	public String getDashboardHighlight() {
		return gu.getAttributeValue(dashboardHighlight, "class");
	}

}
