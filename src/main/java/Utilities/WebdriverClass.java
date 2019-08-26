package Utilities;

import org.openqa.selenium.WebDriver;

public abstract class WebdriverClass {

    private final WebDriver webDriver;

    public WebdriverClass(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    protected final WebDriver getWebDriver() {
             return this.webDriver;
    }

    public String getPageTitle()  {
        return getWebDriver().getTitle();
    }

    public String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }
    public abstract boolean isCorrectPage();
}
