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

public class FlightPage extends WebdriverClass{
	
	private static final String XPATH_TITLE = "//h1[contains(text(),'Search flights')]"; 
	
	private static final String XPATH_ONE_WAY_RADIO_BUTTON= "//input[@id='OneWay']"; 

	private static final String XPATH_FROM_TEXT_BOX = "//input[@id='FromTag']"; 
	
	private static final String XPATH_FROM_TEXT_BOX_DROPDOWN = "//ul[@id='ui-id-1']/li/a"; 
	
	private static final String XPATH_TO_TEXT_BOX= "//input[@id='ToTag']"; 
	
	private static final String XPATH_TO_TEXT_BOX_DROPDOWN= "//ul[@id='ui-id-2']/li/a"; 

	private static final String XPATH_DEPART_DATE = "//input[@id='DepartDate']";
	
	private static final String XPATH_DATE_PICK = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[4]"; 

	private static final String XPATH_SEARCH_BUTTON = "//input[@id='SearchBtn']";
	
	private static final String XPATH_SEARCH_RESULTS_HEADER = "//div[@class='ctCol ctCenter']"; 
	

	@FindBy(xpath =XPATH_TITLE)
	public WebElement Title;
	
	@FindBy(xpath =XPATH_ONE_WAY_RADIO_BUTTON)
	public WebElement OneWayRadioBtn;
	
	@FindBy(xpath =XPATH_FROM_TEXT_BOX)
	public WebElement FromTextBox;
	
	@FindBy(xpath =XPATH_FROM_TEXT_BOX_DROPDOWN)
	public WebElement FromTextBoxDropdown;
	
	@FindBy(xpath =XPATH_TO_TEXT_BOX_DROPDOWN)
	public WebElement ToTextBoxDropdown;
	
	@FindBy(xpath =XPATH_TO_TEXT_BOX)
	public WebElement ToTextBox;
	
	@FindBy(xpath =XPATH_DEPART_DATE)
	public WebElement DepartDate;
	
	@FindBy(xpath =XPATH_DATE_PICK)
	public WebElement DatePick;
	
	@FindBy(xpath =XPATH_SEARCH_BUTTON)
	public WebElement SearchBtn;
	
	@FindBy(xpath =XPATH_SEARCH_RESULTS_HEADER)
	public WebElement SearchResultsHeader;
	
	public FlightPage (WebDriver driver) {
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
	 public void ClickonOneWayRadioBtn() {
		  PageUtils.clickOnWebElement(OneWayRadioBtn);
	  }
	 public void setTexttoFromTextBox(String text)  {
		  PageUtils.setTextToElement(FromTextBox, text);
		  PageUtils.explicitWait(Utilities.getDriver(), FromTextBoxDropdown, 2000);
		  Actions act = new Actions(Utilities.getDriver());
		  act.sendKeys(Keys.ARROW_DOWN);
		  act.sendKeys(Keys.ENTER);
		  
	  }
	 public void setTexttoToTextBox(String text)  {
		  PageUtils.setTextToElement(ToTextBox, text);
		  PageUtils.explicitWait(Utilities.getDriver(), ToTextBoxDropdown, 2000);
		  Actions act = new Actions(Utilities.getDriver());
		  act.sendKeys(Keys.ARROW_DOWN);
		  act.sendKeys(Keys.ENTER);
	  }
	 public void ClickonDepartDate()  {
		  PageUtils.clickOnWebElement(DepartDate);
	  }
	 public void ClickonDatePick()  {
		  PageUtils.clickOnWebElement(DatePick);
	  }
	 public void ClickonSearchBtn() {
		  PageUtils.clickOnWebElement(SearchBtn);
	  }
	 public String getSearchResultsHeader() throws InterruptedException {
		  return PageUtils.getElementText(SearchResultsHeader);
	  }
	 public boolean isSearchResultsHeaderDisplayed()  {
		 PageUtils.explicitWait(Utilities.getDriver(), SearchResultsHeader, 2000);
		    return PageUtils.checkElementDisplayed(SearchResultsHeader);
	  }

}
