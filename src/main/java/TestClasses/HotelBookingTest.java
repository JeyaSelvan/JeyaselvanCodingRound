package TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.HotelPage;
import Utilities.PageUtils;
import Utilities.Utilities;


public class HotelBookingTest {
	String url="appUrl";
	String browser = "chrome";

	@BeforeClass
	public void setEnv() {
		Utilities.setBrowser(browser, Utilities.getData(url));
	}
	@Test
	public void FlightBooking() throws IOException, InterruptedException{
		PageUtils.implicitWait(Utilities.getDriver(), 1000);
		HotelPage hotel = new HotelPage(Utilities.getDriver());
		Assert.assertEquals(hotel.isCorrectPage(), true);
		hotel.ClickonHotelLink();
		hotel.setTexttoWhereTextBox(Utilities.getData("Where"));
		hotel.ClickonCheckInDate();
		hotel.ClickonCheckOutDate();
		hotel.SelectTravellersDropDown(Utilities.getData("Travellers"));
		hotel.ClickonSearchBtn();
		Thread.sleep(5000);
		Assert.assertEquals(hotel.isSearchResultsHeaderDisplayed(), true);
		System.out.println(hotel.getSearchResultsHeader());
		String Actual = hotel.getSearchResultsHeader();
		Assert.assertTrue(Actual.contains("Bangalore (1 night)"));
	}
	@AfterClass
	public void stop() {
		Utilities.tearDown();
	}

}
