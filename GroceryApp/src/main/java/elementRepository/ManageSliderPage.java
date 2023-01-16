package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSliderPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();


	public ManageSliderPage(WebDriver driver) {
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(xpath="//input[@id='main_img']")
	WebElement chooseFile;
	
	@FindBy(xpath="//input[@id='link']")
	WebElement link;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement save;
	
	@FindBy(xpath="//table/tbody/tr/td[1]//img")
	List<WebElement> firstColumnList;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]/img")
	WebElement firstelt;
	
	@FindBy(xpath="//input[@id='main_img']")
	WebElement chooseFileButton;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	public void clickOnChoosefileButton() {
		chooseFileButton.click();
	}
	
	public void sendKeysFileUpload(){
		
		gu.fileUploadUsingSendKeys(chooseFileButton, System.getProperty("user.dir")+"\\src\\main\\resources\\UploadFile\\image.png");
		
	}
	
	public void sendTextToLinkField() {
		link.sendKeys("www.xyz.com");
	}
	
	public void clickSave() {
		save.click();
	}
	
	public boolean imageVerification() {         
	
		boolean s1=false;
		
		String s=gu.getAttributeValue(firstelt, "src");	
		if( s!=null)
			 s1=true;
		
		return s1;
	}

}
