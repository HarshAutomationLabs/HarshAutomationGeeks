package mentoring;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utility.Constant;
import utility.webDriverInstance;

public class projectResources extends webDriverInstance{
	
	@Test(priority=9)
	public void assignedExternalMaterils() throws InterruptedException{
		try {
			//User Login
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(3000);
			
			//Project Resources Test Cases
			driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[5]/a")).click();
			Thread.sleep(3000);
			String currentResourcesURL = driver.getCurrentUrl();
			Assert.assertEquals(currentResourcesURL,Constant.myResourcesURL, "Resources URL doesn't matched");
			System.out.println("Resources URL matched");
			
			WebElement resources_div = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/project-resources/div/div/div[2]/div[1]"));
			Assert.assertFalse(resources_div.isDisplayed(), "External Materials are not assigned");
			String materialLink;
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/project-resources/div/div/div[2]/div[1]/div/span[contains(text()," + Constant.externalMaterialTitle + ")]")).isDisplayed());
			System.out.println("Given external material is present");
			WebElement materialLinkSpan = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/project-resources/div/div/div[2]/div[1]/div/span[contains(text()," + Constant.externalMaterialTitle + ")]"));
			materialLink = materialLinkSpan.getAttribute("href");
			materialLinkSpan.click();
			Thread.sleep(5000);
			String materialCurrentURL = driver.getCurrentUrl();
			Assert.assertEquals(materialLink, materialCurrentURL, "Materials link doesn't opened");
			System.out.println("Materials Current URL matched");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 @AfterMethod
	  public void browserClose(){
		driver.close();
	  }
}


