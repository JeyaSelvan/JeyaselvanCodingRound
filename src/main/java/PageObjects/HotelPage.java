package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtils;
import Utilities.Utilities;
import Utilities.WebdriverClass;

public class HotelPage extends WebdriverClass {
	
	private static final String XPATH_TITLE = "//h1[contains(text(),'Search for hotels')]"; 
	
	private static final String XPATH_HOTEL_LINK= "//ul[@class='navGroup productNav withArrows']//li[contains(@class,'hotelApp')]/a[@href='/hotels']"; 

	private static final String XPATH_WHERE_TEXT_BOX = "//input[@id='Tags']"; 
	
	private static final String XPATH_WHERE_TEXT_BOX_DROPDOWN = "//ul[@id='ui-id-1']/li/a";
	
	private static final String XPATH_CHECK_IN_DATE = "//a[contains(@class,'ui-state-default ui-state-active')]"; 
	
	private static final String XPATH_CHECK_OUT_DATE= "//td[contains(@class,'range')]//a[contains(@class,'ui-state-default')][contains(text(),'27')]"; 
	
	private static final String XPATH_TRAVELLERS_DROPDOWN= "//select[@id='travellersOnhome']"; 

	private static final String XPATH_SEARCH_BUTTON = "//input[@id='SearchHotelsButton']";
	
	private static final String XPATH_SEARCH_RESULTS_HEADER = "//strong[contains(text(),'(1 night)')]"; 

	@FindBy(xpath =XPATH_TITLE)
	public WebElement Title;
	
	@FindBy(xpath =XPATH_HOTEL_LINK)
	public WebElement HotelLink;
	
	@FindBy(xpath =XPATH_WHERE_TEXT_BOX)
	public WebElement WhereTextBox;
	
	@FindBy(xpath =XPATH_WHERE_TEXT_BOX_DROPDOWN)
	public WebElement WhereTextBoxDropdown;
	
	@FindBy(xpath =XPATH_CHECK_IN_DATE)
	public WebElement CheckInDate;
	
	@FindBy(xpath =XPATH_CHECK_OUT_DATE)
	public WebElement CheckOutDate;
	
	@FindBy(xpath =XPATH_TRAVELLERS_DROPDOWN)
	public WebElement TravellersDropDown;
	
	@FindBy(xpath =XPATH_SEARCH_BUTTON)
	public WebElement SearchBtn;
	
	@FindBy(xpath =XPATH_SEARCH_RESULTS_HEADER)
	public WebElement SearchResultsHeader;
	
	public HotelPage (WebDriver driver) {
	    super(driver);
	    PageFactory.initElements(driver, this);
	  }
  
	 @Override
	  public boolean isCorrectPage() {
	    try {
	    	isTitleDisplayed();
	      return true;
	    } catch (Exception e) {
	      return false;
	    }
	  }
	 public boolean isTitleDisplayed()  {
		    return PageUtils.checkElementDisplayed(Title);
	  }
	 public void ClickonHotelLink()  {
		 Actions act = new Actions(Utilities.getDriver());
		 act.moveToElement(HotelLink).click().build().perform();
	  }
	 public void setTexttoWhereTextBox(String text) {
		  PageUtils.setTextToElement(WhereTextBox, text);
		  PageUtils.explicitWait(Utilities.getDriver(), WhereTextBoxDropdown, 2000);
		  Actions act = new Actions(Utilities.getDriver());
		  act.sendKeys(Keys.ENTER);
		  
	  }
	 public void ClickonCheckInDate() {
		  PageUtils.clickOnWebElement(CheckInDate);
	  }
	 public void ClickonCheckOutDate(){
		  PageUtils.clickOnWebElement(CheckOutDate);
	  }
	 public void SelectTravellersDropDown(String text){
		 PageUtils.selectDropdownByVisibleText(TravellersDropDown, text);
	 }
	 public void ClickonSearchBtn(){
		  PageUtils.clickOnWebElement(SearchBtn);
	  }
	 public String getSearchResultsHeader() throws InterruptedException {
		  return PageUtils.getElementText(SearchResultsHeader);
	  }
	 public boolean isSearchResultsHeaderDisplayed() {
		 PageUtils.explicitWait(Utilities.getDriver(), SearchResultsHeader, 2000);
		    return PageUtils.checkElementDisplayed(SearchResultsHeader);
	  }
}
