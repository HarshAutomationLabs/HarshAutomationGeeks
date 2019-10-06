package mentoring;
import utility.Constant;
import utility.webDriverInstance;
import org.openqa.selenium.*;
import org.testng.Assert;

public class projectCommunities extends webDriverInstance{
	
	public void communities(){
		try{
			//User Login
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(3000);
			String currentCommunitiesURL = driver.getCurrentUrl();
			Assert.assertEquals(currentCommunitiesURL,Constant.myCommunitiesURL, "Communities URL doesn't matched");
			System.out.println("Already have an account URL matched");			
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/communities/div/div[2]/div/div[1]")).click();
		} catch (Exception e) {
			e.printStackTrace();
			}
	}	
}
