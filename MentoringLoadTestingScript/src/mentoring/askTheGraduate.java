package mentoring;
import utility.Constant;
import utility.webDriverInstance;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class askTheGraduate extends webDriverInstance{

	@Test(priority=10)
	public void myGraduates() throws InterruptedException{
		try{
			//User Login
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id='mySidenavR']/ul/li[3]/a")).click();
			Thread.sleep(3000);
			
			WebElement askGraduate_webElement = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-ask-graduate/div/div[1]/ul/li[1]"));
			WebElement graduate_webElement = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-ask-graduate/div/div[1]/ul/li[2]"));
			if (askGraduate_webElement.isDisplayed()){
				String currentAskGraduateURL = driver.getCurrentUrl();
				Assert.assertEquals(currentAskGraduateURL,Constant.myAskGraduateURL, "Ask the Graduates URL doesn't matched");
				System.out.println("Ask the Graduates  URL matched");
				
				WebElement questionTextArea = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-ask-graduate/div/div[2]/div/div/div/div/div[4]/div[3]/textarea"));
				Assert.assertFalse(questionTextArea.isDisplayed(), "Ask Question text area is not present");
				questionTextArea.sendKeys(Constant.myQuestionMessage);
				Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-ask-graduate/div/div[2]/div/div/div/div/div[4]/div[3]/input")).isEnabled(), "Submit button doesn't enabled");
				driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-ask-graduate/div/div[2]/div/div/div/div/div[4]/div[3]/input")).click();
				Alert confirmMessage = driver.switchTo().alert();
				String currentSentMessage = confirmMessage.getText();
				Assert.assertEquals(currentSentMessage,Constant.successSentMessage, "User details doesn't updated successfully");
			} else if (graduate_webElement.isDisplayed()){
				String currentGraduateURL = driver.getCurrentUrl();
				Assert.assertEquals(currentGraduateURL,Constant.myGraduateURL, "Graduates URL doesn't matched");
				System.out.println("Graduates URL matched");
				driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-ask-graduate/div/div[2]/div/div/div[3]/a")).click();
				System.out.println("Gradute Profile opened");
			} else {
				System.out.println("Graduates is not enabled for this user");
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	@AfterMethod
	public void browserClose(){
		driver.close();
	}
}