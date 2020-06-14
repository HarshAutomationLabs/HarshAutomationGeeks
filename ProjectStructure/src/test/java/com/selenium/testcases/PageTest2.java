package com.selenium.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import com.selenium.base.TestBase;
import com.selenium.pages.Page;

public class PageTest2 extends TestBase{

	Page page1;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		page1 = new Page();
		driver.get("https://www.amazon.in");
	}
	
	@Test
	public void testMethod() throws IOException{
		String pageTitle = page1.validatePageTitle();
		System.out.println(pageTitle);
	}
}
