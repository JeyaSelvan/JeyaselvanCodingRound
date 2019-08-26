package TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.FlightPage;
import Utilities.PageUtils;
import Utilities.Utilities;

public class FlightBookingTest {
	String url="appUrl";
	String browser = "chrome";

	@BeforeClass
	public void setEnv() {
		Utilities.setBrowser(browser, Utilities.getData(url));
	}
	@Test
	public void FlightBooking() throws IOException, InterruptedException{
		PageUtils.implicitWait(Utilities.getDriver(), 1000);
		FlightPage flight = new FlightPage(Utilities.getDriver());
		Assert.assertEquals(flight.isCorrectPage(), true);
		
		flight.ClickonOneWayRadioBtn();
		flight.setTexttoFromTextBox(Utilities.getData("From"));
		flight.setTexttoToTextBox(Utilities.getData("To"));
		flight.ClickonDepartDate();
		flight.ClickonDatePick();
		flight.ClickonSearchBtn();
		Thread.sleep(5000);
		Assert.assertEquals(flight.isSearchResultsHeaderDisplayed(), true);
		System.out.println(flight.getSearchResultsHeader());
		String Actual = flight.getSearchResultsHeader();
		Assert.assertTrue(Actual.contains("Bangalore → New Delhi"));
	}
	@AfterClass
	public void stop() {
		Utilities.tearDown();
	}

}
