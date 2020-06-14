package com.selenium.pages;

import com.selenium.base.TestBase;

public class Page extends TestBase{
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
}