package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;
import utilities.ExcelRead;

public class ManageSliderPageTestCase extends BaseClass {

	LoginPage lp;
	HomePage hp;
	ManageSliderPage msp;

	@Test   
	public void verifyImageUploadedIsSameAsShownInTable() {

			lp=new LoginPage(driver);
			lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
			
			hp=new HomePage(driver);
			hp.clickOnManageSlider();
			
			msp=new ManageSliderPage(driver);
			msp.clickOnNewButton();
			msp.sendKeysFileUpload();
		
			msp.sendTextToLinkField();
			msp.clickSave();
			hp.clickOnManageSlider();
			boolean actual=msp.imageVerification();
			boolean expected=true;
			Assert.assertEquals(actual, expected, Constant.errorMessageImageVerification);
	}
}
