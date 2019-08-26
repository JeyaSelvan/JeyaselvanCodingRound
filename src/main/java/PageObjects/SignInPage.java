package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtils;
import Utilities.WebdriverClass;

public class SignInPage extends WebdriverClass {
	
	private static final String XPATH_TITLE = "//h1[contains(text(),'Search flights')]"; 
	
	private static final String XPATH_YOUR_TRIPS= "//span[@class='span span19 truncate']"; 

	private static final String XPATH_SIGN_IN_BUTTON = "//input[@id='SignIn']"; 
	
	private static final String XPATH_POPUP_SIGN_IN_BUTTON = "//button[@id='signInButton']";
	
	private static final String XPATH_ERROR_MSG = "//span[contains(text(),'There were errors in your submission')]"; 
	

	@FindBy(xpath =XPATH_TITLE)
	public WebElement Title;
	
	@FindBy(xpath =XPATH_YOUR_TRIPS)
	public WebElement YourTrips;
	
	@FindBy(xpath =XPATH_SIGN_IN_BUTTON)
	public WebElement SignInBtn;
	
	@FindBy(xpath =XPATH_POPUP_SIGN_IN_BUTTON)
	public WebElement PopupSignInBtn;
	
	@FindBy(xpath =XPATH_ERROR_MSG)
	public WebElement ErrorMsg;
	
	
	
	public SignInPage (WebDriver driver) {
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
	 public boolean isTitleDisplayed() {
		    return PageUtils.checkElementDisplayed(Title);
	  }
	 public void ClickonYourTrips() {
		  PageUtils.clickOnWebElement(YourTrips);
	  }
	 public void ClickonSignInBtn() {
		  PageUtils.clickOnWebElement(SignInBtn);
	  }
	 public void ClickonPopupSignInBtn() {
		  PageUtils.clickOnWebElement(PopupSignInBtn);
	  }
	 public String getErrorMsg() throws InterruptedException {
		  return PageUtils.getElementText(ErrorMsg);
	  }
	 public boolean isErrorMsgDisplayed() {
		    return PageUtils.checkElementDisplayed(ErrorMsg);
	  }

}
