package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Utilities {
	static String currentDir = System.getProperty("user.dir");
	static Properties prop = new Properties();
	static FileInputStream file;
	static Utilities obj= new Utilities();
	private static WebDriver driver;
	
	public static void main(String[] args) {
		String key="appUrl";
		System.out.println(Utilities.getData(key));
	}
	
	public static String getData(String key) {
		String value=null;
		obj=new Utilities();
			String propPath="\\src\\main\\java\\Repository\\Credentials.properties";
			value = obj.getPropertyValue(propPath, key);
		return value;
	
	}
	public String getPropertyValue(String propPath, String key) {
		String val = null;
		try {
			file = new FileInputStream(currentDir+propPath);
			prop.load(file);
			val=prop.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}
	
	@SuppressWarnings("deprecation")
	public static void setBrowser(String browserName, String url) {

        if (driver == null || driver.toString().contains("(null)")) {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",currentDir+"\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver",currentDir+"\\Drivers\\geckodriver.exe");
                FirefoxProfile f= new FirefoxProfile();
                f.setPreference("security.mixed_content.block_active_content", false);
                f.setPreference("security.mixed_content.block_display_content", true);
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("ie")) {
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                System.setProperty("webdriver.ie.driver",currentDir+"\\Drivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver(capabilities);
            }
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.MILLISECONDS);
            
        }
    
	}
	
	
	public static WebDriver getDriver() {
		if(driver!=null) {
			return driver;
		}else {
			System.out.println("Null driver found");
		}
		return driver;
	}
	
	public static void tearDown() {
		driver.quit();
	}
	

}

