package utility;

public class Constant {
	
//  Chrome Driver name and path
	public static final String driverName = "chromeDriver";
//	public static final String driverPath = "D:\\Selenium\\chromedriver.exe";
	public static final String driverPath = "C:\\Users\\HARSH\\workspace\\MySeleniumCode\\src\\org\\brightside\\chromedriver.exe";

//  IE Driver name and Path
//	public static final String driverName = "IEDriverServer";
//	public static final String driverPath = "D:\\Selenium\\IEDriverServer.exe";
//	public static final String driverPath = "C:\\Users\\HARSH\\workspace\\MySeleniumCode\\src\\org\\brightside\\IEDriverServer.exe";

	//Constant URL
	public static final String baseURL = "http://dev.angular.brightsidementoring.tudip.uk";
	public static final String signUpURL = "http://dev.angular.brightsidementoring.tudip.uk/sign-up?project_code=";
	public static final String feedsURL = "http://dev.angular.brightsidementoring.tudip.uk/feeds";
	public static final String termsConditionURL = "http://dev.angular.brightsidementoring.tudip.uk/terms";
	public static final String privacyPolicyURL = "http://dev.angular.brightsidementoring.tudip.uk/privacy";
	public static final String existSignUpURL = "http://dev.angular.brightsidementoring.tudip.uk/sign-in?project_code=";
	public static final String myAccountURL = "http://dev.angular.brightsidementoring.tudip.uk/users/718/edit";
	public static final String myAssignmentURL = "http://dev.angular.brightsidementoring.tudip.uk/assignments";
	public static final String myResourcesURL = "http://dev.angular.brightsidementoring.tudip.uk/project_resources";
	public static final String myAskGraduateURL = "http://dev.angular.brightsidementoring.tudip.uk/ask_graduate";
	public static final String myGraduateURL = "http://dev.angular.brightsidementoring.tudip.uk/graduates";
	public static final String myCommunitiesURL = "http://dev.angular.brightsidementoring.tudip.uk/communities";
	
	//Constant Default Variables
	public static final String projectCode = "YKOKWG";
	public static final String newfirstName = "Test";
	public static final String newlastName = "User";
	public static final String newEmailId = "ova_daniel@tudip.com"; 
	public static final String newPassword = "tudip123";
	public static final String newPostCode = "AB99AB";
	public static final String newDate = "27";
	public static final String newMonth = "October";
	public static final String newYear = "1994"; 
	
	//Messaging Constant Variables
	public static final String messagingURL = "http://dev.angular.brightsidementoring.tudip.uk/channels";
	public static final String testMessage = "Test Message";
	
	//MyAccount Constant Variables
	public static final String imagefilePath = "C:\\Users\\acer\\Desktop\\Harsh\\Testing images\\Brasilia1.jpeg";
	public static final String updateFirstName = "Frank";
	public static final String updateLastName = "Lawless";
	public static final String updateEmailId = "ova_daniel+update@tudip.com";
	public static final String updatePhoneNumber = "07412589630";
	public static final String updatePostCode = "AB99AB";
	public static final String updateDate = "16";
	public static final String updateMonth = "October";
	public static final String updateYear = "1995";
	public static final String successMessage = "Account updated successfully!";
	
	//Assignments 
	public static final String assignmentFileName = "Brasilia1.jpeg";
	public static final String assignmentFilePath = "C:\\Users\\acer\\Desktop\\Harsh\\Testing images\\" + assignmentFileName;
	public static final String uploadConfirmMessage = "Assignment submitted successfully";

	//Project Resources
	public static final String externalMaterialTitle = "External Materials";

	//Ask the Graduates
	public static final String myQuestionMessage = "What is testing";
	public static final String successSentMessage = "Question submitted successfully";
}
