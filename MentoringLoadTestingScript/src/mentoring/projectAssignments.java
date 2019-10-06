package mentoring;
import utility.Constant;
import utility.webDriverInstance;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.LocalDateTime;  

public class projectAssignments extends webDriverInstance{
	
	@Test(priority=7)
	private void testUploadAssignments() throws InterruptedException{
		try{
			//User Login
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(3000);
			
			//Upload Assignments
			driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[2]/a")).click();
			Thread.sleep(3000);
			String currentAssignmentURL = driver.getCurrentUrl();
			Assert.assertEquals(currentAssignmentURL,Constant.myAssignmentURL, "Assignments URL doesn't matched");
			System.out.println("Assignments URL matched");
			
			WebElement wb_assignments = driver.findElement(By.id("//*[@id='mySidenavR']/ul/li[4]/a"));
			wb_assignments.click();
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[1]/div[2]/a")).sendKeys(Constant.assignmentFilePath);
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[1]/div[3]/div[contains(text()," + Constant.assignmentFileName + ")]")).isDisplayed();
			System.out.println("File has been selected");
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[1]/div[3]/div[2]/a")).click();
			Thread.sleep(2000);
			Alert uploadingMessage = driver.switchTo().alert();
			String currentUploadConfirmMessage = uploadingMessage.getText();
			Assert.assertEquals(currentUploadConfirmMessage,Constant.uploadConfirmMessage, "User details doesn't updated successfully");
			System.out.println(Constant.uploadConfirmMessage);
		 } catch (Exception e) {
				e.printStackTrace();
				}
	}	
	
	@Test(priority=8)
	private void checkUploadFileName() throws InterruptedException{
		try{
			//check uploaded date
			LocalDateTime now = LocalDateTime.now();
		    int year = now.getYear();
		    int month = now.getMonthValue();
		    int day = now.getDayOfMonth();
		    String currnetDate = month + day + ", " + year;
			Assert.assertFalse(driver.findElements(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[2]/div/table/tbody/tr[2]/td[1]")).contains(currnetDate), "Date does not matched");		
			System.out.println("Date matched");
		    
		    //check uploaded file name
			Assert.assertFalse(driver.findElements(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).contains(Constant.assignmentFileName), "File doesn't uploaded");
			System.out.println("File uploaded successfully");
			
			//check uploaded file download
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[2]/div/table/tbody/tr[2]/td[3]/a")).click();
			System.out.println("Uploaded file has been downloaded");
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