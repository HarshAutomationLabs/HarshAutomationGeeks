package com.brightside.mentoring.utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.brightside.mentoring.base.TestBase;

public class TestUtils extends TestBase {

	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICIT_WAIT = 20;
	public static final String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public TestUtils() {
		super();
	}
	
	public String getUserRole() {
		return prop.getProperty("role");
	}
	
	public static void navigateTo(String URL) {
		driver.navigate().to(prop.getProperty("BASE_URL") + URL);
		//driver.navigate().to("http://dev.angular.brightsidementoring.tudip.uk/sign-in");
	}

	// Wait until element present
	public static void waitUntilElementPresent(WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) Element));
	}

	// Wait until element gets clickable
	public static void waitUntilElementClickable(WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable((By) Element));
	}

	// Wait until element gets invisible
	public static void WaitUntilInvisiblityOfElement(By elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
	}

	// Take Screenshot
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
		System.out.println(scrFile);
		String currentDir = System.getProperty("user.dir");
		System.out.println(currentDir);
//	    TestUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	// To validate message
	public static boolean validateText(String demoText) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(getMessageElement(demoText)));
		return getMessageElement(demoText).isDisplayed();
	}

	private static WebElement getMessageElement(String demoText) {
		String str1 = "//*[text()='";
		String str2 = "']";
		WebElement element = driver.findElement(By.xpath(str1 + demoText + str2));
		return element;
	}

	// To Generate Random Message
	private static String generateRandomString(int length, String symbols) {
		char[] chars = symbols.toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i <= length; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	private static String generateRandomString() {
		return (generateRandomString(5, alphabets));
	}

	public static String userString = generateRandomString();

	public static String currentProjectRole() {
		By projectRoleLocator = By.xpath("//*[@class='roleName']");
		return driver.findElement(projectRoleLocator).getText();
	}
}
