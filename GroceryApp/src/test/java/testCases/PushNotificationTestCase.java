package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.PushNotification;
import utilities.ExcelRead;

public class PushNotificationTestCase extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	
	PushNotification pn;
	
	
  @Test
  public void verifyPushNotificationInformationsCanBeSendUsingCSSSelector() {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 0));

		hp = new HomePage(driver);
		hp.clickOnPushNotification();
		
		pn=new PushNotification(driver);
		pn.enterPushNotificationTitle();
		pn.enterDescription();
		pn.clickOnSendButton();
		
		String actual=pn.getTextOfAlertMsg();
		String expected="Alert!";
		Assert.assertEquals(actual, expected, Constant.errorMessageInPushNotificationAlert);
	}  
  
  @Test
  public void verifyPushNotificationInformationsCanBeResetUsingCSSSelector() {
		lp = new LoginPage(driver);
		lp.logInWithCredetials(ExcelRead.readStringData(0, 0), ExcelRead.readStringData(0, 0));

		hp = new HomePage(driver);
		hp.clickOnPushNotification();
		
		pn=new PushNotification(driver);
		pn.enterPushNotificationTitle();
		pn.enterDescription();
		pn.clickOnResetButton();
		String actual=pn.clickTitleAfterReset();
		String expected="";
		Assert.assertEquals(actual, expected, Constant.errorMessageInPushNotificationResetAlert);		
	}  
}
