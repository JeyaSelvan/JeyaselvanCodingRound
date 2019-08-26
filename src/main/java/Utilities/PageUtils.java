package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {


	public static void setTextToElement(WebElement element, String text)  {
		try {
			element.clear();
			element.sendKeys(text);
		} catch (NoSuchElementException e) {
		System.out.println(e.getMessage());
		}
	}

	public static void clickOnWebElement(WebElement element)  {
		try {
			if (element.isDisplayed()) {
				element.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String getElementText(WebElement element) {
		try {
			return element.getText().trim();
		} catch (NoSuchElementException e) {
			return e.getMessage();
		}
	}

	
	public static String selectDropdownByVisibleText(WebElement element, String text){
		try {
			if (!text.isEmpty()) {
				Select select = new Select(element);
				select.selectByVisibleText(text);
				//return element.getAttribute("value");
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		return "";
	}
	public static boolean checkElementDisplayed(WebElement element)  {
    boolean isDisplayed = false;
    try {
      if (element != null)
        isDisplayed = element.isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
    return isDisplayed;
  }

	public static void implicitWait(WebDriver driver, long timeout)  {
		try {
			driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	public static WebElement explicitWait(WebDriver driver, WebElement element, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement foundElement = wait.until(ExpectedConditions.visibilityOf(element));
			return foundElement;
		} catch (WebDriverException e) {
			return null;
		}
	}

	
	public static String getElementText(WebDriver driver, String inputField)  {
		WebElement element = null;
		String getText = null;
		try {
			element = driver.findElement(By.xpath(inputField));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		if (null != element)
			getText = getElementText(element);
		return getText;
	}

	
	public static void clickOnWebElement(WebDriver driver, String inputField) {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(inputField));
			if (element.isDisplayed()) {
				element.click();
			} 
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

	
	public static void selectDropdownByVisibleText(WebDriver driver, String inputField, String text) {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(inputField));
			if (!text.isEmpty()) {
				Select select = new Select(element);
				select.selectByVisibleText(text);
				// return element.getAttribute("value");
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

	
	
	
}
