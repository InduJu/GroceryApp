package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.RandomDataGeneration;
import utilities.WaitUtility;

public class PushNotification {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();
	RandomDataGeneration rdg=new RandomDataGeneration();

	public PushNotification(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#title")
	WebElement tilePushNotification;
	
	@FindBy(css="input[placeholder='Enter Description']")
	WebElement description;
	
	@FindBy(css="div[class='card-footer center']>button[name='create']")
	WebElement sendButton;
	
	@FindBy(css="div[class='alert alert-success alert-dismissible']>h5")
	WebElement assertionAlert;
	
	@FindBy(css="div[class='card-footer center']>a")
	WebElement resetButton;
	
	@FindBy(css="input#title")
	WebElement newTitleAfterReset;
	
	
	public void enterPushNotificationTitle() {
		tilePushNotification.sendKeys("Hello");
	}
	
	public void enterDescription() {
		description.sendKeys("Item is delivered");
	}
	
	public void clickOnSendButton() {
		sendButton.click();
	}
	
	public String getTextOfAlertMsg() {
		return gu.getElementText(assertionAlert);
	}
	
	public void clickOnResetButton() {
		resetButton.click();
	}
	
	public String clickTitleAfterReset() {
		
		return gu.getAttributeValue(newTitleAfterReset, "value");
	}
}
