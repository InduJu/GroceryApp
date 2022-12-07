package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageSliderPage;
import utilities.ExcelRead;

public class ManageSliderPageTestCase extends BaseClass {

	LoginPage lp;
	ManageSliderPage msp;

	@Test   //yet to implement
	public void verifyImageUploadedIsSameAsShownInTable() throws IOException, AWTException {

			lp=new LoginPage(driver);
			lp.logInWithCredetials(ExcelRead.readStringData(0,0), ExcelRead.readStringData(0,0));
			
			msp=new ManageSliderPage(driver);
			msp.clickOnNewButton();
			msp.clickFileToUpload();
			msp.sendTextToLinkField();
			msp.clickSave();		
			
	}
}
