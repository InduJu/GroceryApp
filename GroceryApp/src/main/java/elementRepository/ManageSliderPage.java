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
	List<WebElement> firstColumn;
	
	
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void clickFileToUpload() throws AWTException {
		gu.chooseFileToUpload(driver, chooseFile, (System.getProperty("user.dir")+"\\src\\main\\resources\\UploadFile\\image.png"));
	}
	
	public void sendTextToLinkField() {
		link.sendKeys("www.xyz.com");
	}
	
	public void clickSave() {
		save.click();
	}
	
	public void imageVerification() {
		List<WebElement> list1=firstColumn;
	//	List<WebElement> upload= "C:\\Users\\INDU M\\eclipse-workspace\\GroceryApp\\src\\main\\resources\\UploadFile\\image.png";
	//	if(list1 = "img")
	}

}
