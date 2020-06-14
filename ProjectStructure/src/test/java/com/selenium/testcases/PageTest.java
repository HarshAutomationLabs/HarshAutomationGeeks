package com.selenium.testcases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.selenium.base.TestBase;
import com.selenium.pages.Page;

public class PageTest extends TestBase {

	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	Page page1;

	public PageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		log.info("Driver in initialized");
		page1 = new Page();
		driver.get("https://www.google.com");
		log.info("Navigated to google page");
	}

	@Test
	public void testMethod() throws IOException {
		String pageTitle = page1.validatePageTitle();
		log.info("Recieved the title");
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "Test");
	}
}