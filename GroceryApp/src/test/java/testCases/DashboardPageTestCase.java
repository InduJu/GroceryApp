package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class DashboardPageTestCase extends BaseClass {
	
	LoginPage lp;
	DashboardPage dp;

	
  @Test
  public void verifyTheFontSizeOfManagePages() {
	  
	  lp=new LoginPage(driver);
	  lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
	  
	  dp=new DashboardPage(driver);
	  String actual=dp.getFontSizeOfManagePages();
	  String expected="16px";
	  Assert.assertEquals(actual, expected, Constant.errorMessageIncorrectFontSize); 
  }
  
  @Test
  public void verifyTheBackgroundColorOfDashboard(){
	  lp=new LoginPage(driver);
	  lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
	  
	  dp=new DashboardPage(driver);
	  String actual=dp.getBgColorOfDashboard();
	  String expected="rgba(0, 0, 0, 0)";
	  Assert.assertEquals(actual, expected,Constant.errorMessageIncorrectBgColor); 
  }
  
  @Test
  public void verifyTheFontTypeOfManageProduct(){
	  lp=new LoginPage(driver);
	  lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
	  
	  dp=new DashboardPage(driver);
	  String actual=dp.getFontTypeOfManageProduct();
	  String expected="\"Source Sans Pro\", -apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif, \"Apple Color Emoji\", \"Segoe UI Emoji\", \"Segoe UI Symbol\"";
	  Assert.assertEquals(actual, expected, Constant.errorMessageIncorrectFontType); 
  } 
  
}
