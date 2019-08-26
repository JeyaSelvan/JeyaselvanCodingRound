package TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.SignInPage;
import Utilities.PageUtils;
import Utilities.Utilities;

public class SignInTest {
	String url="appUrl";
	String browser = "chrome";

	@BeforeClass
	public void setEnv() {
		Utilities.setBrowser(browser, Utilities.getData(url));
	}
	@Test
	public void FlightBooking() throws IOException, InterruptedException{
		PageUtils.implicitWait(Utilities.getDriver(), 1000);
		SignInPage signin = new SignInPage(Utilities.getDriver());
		signin.ClickonYourTrips();
		signin.ClickonSignInBtn();
		Thread.sleep(1000);
		signin.ClickonPopupSignInBtn();
		System.out.println("The Error Msg is displayed as: "+signin.getErrorMsg());
		Assert.assertEquals(signin.isErrorMsgDisplayed(), true);
		Assert.assertEquals(signin.getErrorMsg(), "There were errors in your submission");
	}
	@AfterClass
	public void stop() {
		Utilities.tearDown();
	}
}
