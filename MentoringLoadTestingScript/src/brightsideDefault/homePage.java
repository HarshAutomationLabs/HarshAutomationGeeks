package brightsideDefault;
import utility.Constant;
import utility.webDriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class homePage extends webDriverInstance {
	  
	  @Test(priority=0)
	  private void sign_up() throws InterruptedException{
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[1]/input")).sendKeys(Constant.projectCode);
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[2]/input")).click();
			Thread.sleep(3000);
			String currentURL = driver.getCurrentUrl();
			Assert.assertEquals(currentURL,Constant.signUpURL + Constant.projectCode, "Sign up with project code URL doesn't matched");
			System.out.println("Sign up with project code URL matched");
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[1]/div[1]/input")).sendKeys(Constant.newfirstName);
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[1]/div[2]/input")).sendKeys(Constant.newlastName);	
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[2]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[3]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[1]/input")).sendKeys(Constant.newPostCode);
			new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[1]/select"))).selectByVisibleText(Constant.newDate);
			new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[2]/select"))).selectByVisibleText(Constant.newMonth);
			new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[3]/select"))).selectByVisibleText(Constant.newYear);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[5]/input")).click();
			Thread.sleep(5000);
			String currentFeedsURL = driver.getCurrentUrl();
			Assert.assertEquals(currentFeedsURL,Constant.feedsURL, Constant.newfirstName + " cannot be added");
			System.out.println(Constant.newfirstName + " added successfully");
			driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[9]/a")).click();
		} catch (Exception e) {
			e.printStackTrace();
			}
	  }
	  
	  @Test(priority=1)
	  private void alreadyAccount() throws InterruptedException{
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[1]/input")).sendKeys(Constant.projectCode);
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[2]/input")).click();
			
			//Terms and Conditions
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/p[3]/a[1]")).click();
			Thread.sleep(3000);
			String termsURL = driver.getCurrentUrl();
			if (termsURL.equalsIgnoreCase(Constant.termsConditionURL)) {
				System.out.println("Terms and Condition page successfully opened");
				driver.navigate().back();
			} else{
				System.out.println("Terms and Condition page doesn't opened");
				}
				
			//Privacy and Policy
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/p[3]/a[2]")).click();
			Thread.sleep(3000);
			String policyURL = driver.getCurrentUrl();
			if (policyURL.equalsIgnoreCase(Constant.privacyPolicyURL)) {
				System.out.println("Privacy policy page successfully opened");
				driver.navigate().back();
			} else{
				System.out.println("Privacy policy page doesn't opened");
			}
			
			//Already have an account
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/p[1]/a")).click();
			Thread.sleep(3000);
			String currentExistSignUpURL = driver.getCurrentUrl();
			Assert.assertEquals(currentExistSignUpURL,Constant.existSignUpURL + Constant.projectCode, "Already have an account URL doesn't matched");
			System.out.println("Already have an account URL matched");
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(5000);
			String currentExistFeedsURL = driver.getCurrentUrl();
			Assert.assertEquals(currentExistFeedsURL,Constant.feedsURL, Constant.newfirstName + " cannot be added to project");
			System.out.println(Constant.newfirstName + " successfully added to project");
			driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[9]/a")).click();
		} catch (Exception e) {
			e.printStackTrace();
			}
	  }
	  
	  @Test(priority=2)
	  private void forgot_password(){
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[4]/div/span/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/new/div/div/div/div/form/div/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/new/div/div/div/div/form/div/div[2]/input")).click();
			System.out.println("Reset email has been sent to your email Id");
			driver.get(Constant.baseURL);		
		} catch (Exception e) {
			e.printStackTrace();
		   }
	  }
	  
	  @Test(priority=3)
	  private void user_login() throws InterruptedException{
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(3000);
			String currentFeedsURL = driver.getCurrentUrl();
			Assert.assertEquals(currentFeedsURL,Constant.feedsURL, "User not able to login");
			System.out.println("User successfully logged in their profile");
			driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[9]/a")).click();
		} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	  @AfterMethod
	  public void browserClose(){
		driver.close();
	  }
}
