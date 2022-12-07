package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class AdminUsers {
	
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();

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
	
	@FindBy(xpath="//li[@class='nav-item dropdown']//a")
	WebElement profileText;
	
	public void clicknewButton() {
		newButton.click();
	}
	
	public void enterUsername() {
		userName.sendKeys("indu");
	}
	
	public void enterPassword() {
		
		passWord.sendKeys("indu123");
	}
	
	public void selectUserTypeFromDropdown() {
		gu.selectValueFromDropdown(userTypeDropdown, "Admin");
	}
	
	public void selectSave() {
		saveButton.click();
	}
	
	public void clickProfile() {
		adminDropdown.click();
	}
	public void clickProfileLogout() {
		logout.click();	
	}
	
	
	
	public void enterNewUser() {
	    newUsername.sendKeys("indu");
	}
	
	public void enterNewPassword() {
		newPassword.sendKeys("indu123");
	}
	
	public void clickSignIn() {
		signIn.click();
	}
	
	public String getTextOfNewProfile() {
		return gu.getElementText(profileText);
	}

}
