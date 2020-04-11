package com.brightside.mentoring.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.brightside.mentoring.utils.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public final By PRELOADER = By.id("preloader");

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\acer\\eclipse-workspace\\Mentoring\\src\\main"
					+ "\\java\\com\\brightside\\mentoring\\config\\config.properties");
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
			System.setProperty("webdriver.chrome.driver", "D:\\Load Testing\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Load Testing\\chromedriver.exe");
			driver = new FirefoxDriver();
		}

		// Browser Properties
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// Get the Test URL
		driver.get(prop.getProperty("BASE_URL"));
		TestUtils.WaitUntilInvisiblityOfElement(PRELOADER);
	}
}
