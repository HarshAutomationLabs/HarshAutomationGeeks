Feature: Steps to test the Brightside Application 

Scenario: Testing the login functionality 

	Given user opens the "DevURL" in the "browser" 
	When user is on login page 
	Then user types "username" as "harshwardhan.gupta+mentor@tudip.com" 
	Then user types "password" as "tudip123" 
	Then user clicks "signin" button 
	Then user validate "projectName" in the homepage 
