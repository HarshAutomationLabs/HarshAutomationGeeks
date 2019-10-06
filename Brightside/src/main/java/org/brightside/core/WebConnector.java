package org.brightside.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebConnector {
	//Initializing Properties file
	
	public static WebDriver driver;
	public static Properties OR;
	public static Properties Config;
	public static FileInputStream fis;
	public static Logger logs = Logger.getLogger("Dev");
	public final static By PRELOADER = By.id("preloader");
	
	// default constructor
	public WebConnector(){
		
		if(OR==null){
			OR = new Properties();
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\main\\java\\org\\brightside\\config\\OR.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			Config = new Properties();
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\main\\java\\org\\brightside\\config\\Config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				Config.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void openBrowser(String 	browserType){
		
		if(Config.getProperty("browser").equals("firefox")){
			driver = new FirefoxDriver();
		}else if(Config.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(Config.getProperty("browser").equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}
	
	//navigation
	public void navigate(String URL){
		driver.get(Config.getProperty(URL));
	}
	
	//click on locator
	public void click(String locator){
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
	}

	// writing in a text field / select value from a list
	public void type(String locator, String data){
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(data);
	}
}