package utility;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class webDriverInstance {
	public WebDriver driver;
	@SuppressWarnings("unused")
	@BeforeMethod
	public void invokeBrowser(){
		try {
			if (Constant.driverName == "chromeDriver"){
				System.setProperty("webdriver.chrome.driver",Constant.driverPath);
				driver = new ChromeDriver();
			} else if (Constant.driverName == "IEDriverServer"){
				System.setProperty("webdriver.ie.driver",Constant.driverPath);
				driver = new InternetExplorerDriver();
			} else {
				driver = new FirefoxDriver();
			}
			
			//Default Properties
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(Constant.baseURL);	
		} catch (Exception e) {
			e.printStackTrace();
		   }
	  }
}
