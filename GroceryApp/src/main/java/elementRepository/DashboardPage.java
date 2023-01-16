package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashboardPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();


	public DashboardPage(WebDriver driver) {
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//div[@class='inner']//p[1]")
	WebElement managePagesFontsize;
	
	@FindBy(xpath="//div[@class='inner']//p[text()='Dashboard']")
	WebElement dashboardBgColor;
	
	@FindBy(xpath="//div[@class='inner']//p[text()='Manage Product']")
	WebElement manageProductFontType;
	
	public String getFontSizeOfManagePages() {
		return managePagesFontsize.getCssValue("font-size");
	}
	
	public String getBgColorOfDashboard() {
		return dashboardBgColor.getCssValue("background-color");
	}
	
	public String getFontTypeOfManageProduct() {
		return manageProductFontType.getCssValue("font-family");
	}
}
