package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageContent_Pages;
import utilities.ExcelRead;

public class ManageContent_PagesTestCase extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	ManageContent_Pages mcp;
	
  @Test
  public void verifyLinkContentFromDescriptionIsVisibleInNewPage(){
	  lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 0));

		hp = new HomePage(driver);
		hp.clickOnManageContent();
		hp.clickOnManageContentPage();
		
		mcp=new ManageContent_Pages(driver);
		mcp.clickOnNewButton();
		mcp.clickOnLinkButton();
		mcp.sendTextToDisplayField();
		mcp.sendTextToURLField();
		mcp.clickOnInsertLinkButton();
		mcp.clickOnDescriptionText();
		mcp.clickOnDescriptionTextLink();
		String actual=mcp.newTabURL();
		String expected="https://en.wikipedia.org/wiki/Cat";
		Assert.assertEquals(actual, expected, Constant.errorMessageinNewPageURL); 	
  }
}