package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//li[2]/a/p/i")
	WebElement manageExpense;

	@FindBy(xpath="//ul[@class='nav nav-treeview']//child::p[1]")
	WebElement expenseCategory;
	
	@FindBy(xpath="//ul[@class='nav nav-treeview']//child::p[2]")
	WebElement subManageExpense;
	
	@FindBy(xpath="//ul[@class='nav nav-treeview']//child::p[3]")
	WebElement createMerchant;
	
	@FindBy(xpath = "//p[text()='Manage Orders']")
	WebElement manageOrders;
	
	@FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column']//li[4]//a")
	WebElement manageProduct;
	
	@FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column']/li[6]/a/p")
	WebElement manageUsers;
	
	@FindBy(xpath="//nav[@class='mt-2']//ul//li[10]//a//p")
	WebElement manageSlider;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-users']")
	WebElement adminUsers;
	
	public void clickOnManageExpense() {
		manageExpense.click();
	}
	
	public void clickOnExpenseCategory() {
		expenseCategory.click();
	}
	
	public void clickOnsubManageExpense() {
		subManageExpense.click();
	}
	
	public void clickOnCreateMerchant() {
		createMerchant.click();
	}
	
	
	public void clickOnManageOrders() {
		manageOrders.click();
	}

	public void clickOnManageProduct() {
		manageProduct.click();
	}
	
	public void clickOnManageUsers() {
		manageUsers.click();
	}
	
	public void clickOnManageSlider() {
		manageSlider.click();
	}
	
	public void clickOnAdminUsers() {
		adminUsers.click();
	}
	
}
