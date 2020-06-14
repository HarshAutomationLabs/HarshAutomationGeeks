package com.selenium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	static String basePath = System.getProperty("user.dir");

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					basePath + "\\src\\main\\java\\com\\selenium\\properties\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.out.println("Tried to " + browserName);
			System.setProperty("webdriver.chrome.driver", basePath + "\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", basePath + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		// Browser Properties
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Get the Test URL
		// driver.get(prop.getProperty("BASE_URL"));
	}

	public static void takeScreenshotAtEndOfTest(String methodName) throws IOException {
		File scrFile = (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
		System.out.println(scrFile);
		FileUtils.copyFile(scrFile,
				new File(basePath + "/screenshots/" + methodName + "_" + System.currentTimeMillis() + ".png"));
	}

	@AfterMethod
	public void shutDown() {
		driver.close();
		driver.quit();
	}
}