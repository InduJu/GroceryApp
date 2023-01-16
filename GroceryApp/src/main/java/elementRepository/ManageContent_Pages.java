package elementRepository;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ManageContent_Pages {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu=new WaitUtility();

	public ManageContent_Pages(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//button[@data-original-title='Link (CTRL+K)']")
	WebElement linkButton;

	@FindBy(xpath = "//input[@class='note-link-text form-control note-form-control note-input']")
	WebElement textToDisplay;

	@FindBy(xpath = "//input[@class='note-link-url form-control note-form-control note-input']")
	WebElement linkToURL;

	@FindBy(xpath = "//input[@value='Insert Link']")
	WebElement insertLinkButton;

	@FindBy(xpath = "//div[@class='note-editable card-block']//a")
	WebElement descriptionText;

	@FindBy(xpath = "//div[@class='popover-content note-children-container']//a")
	WebElement descriptionTextLink;

	public void clickOnNewButton() {
		newButton.click();
	}

	public void clickOnLinkButton() {
		linkButton.click();
	}

	public void sendTextToDisplayField() {
		textToDisplay.sendKeys("cat");
	}

	public void sendTextToURLField() {
		linkToURL.sendKeys("https://en.wikipedia.org/wiki/Cat");
	}

	public void clickOnInsertLinkButton() {
		insertLinkButton.click();
	}

	public void clickOnDescriptionText(){
		
		Actions obj = new Actions(driver);
		
		wu.implicitWait(driver);
		
		descriptionText.click();
		obj.sendKeys(Keys.ARROW_DOWN).perform();
	}

	public void clickOnDescriptionTextLink() {
		descriptionTextLink.click();
	}
	
	public String newTabURL() {
		
		 String parentWindow= driver.getWindowHandle();
		 Set <String> allWindows=driver.getWindowHandles(); 
			
		   
		   for(String childWindow :allWindows) 
		   {
			   if(!parentWindow.equals(childWindow))
			   {
				   driver.switchTo().window(childWindow);   
			   }
		   }
		   return gu.getURL(driver);
	}

}
