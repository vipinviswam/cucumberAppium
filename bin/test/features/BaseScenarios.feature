@Pixel 
#Feature: BaseScenarios 
#	These scenarios can be used in any project  	
# 
#Scenario: 01. Validate the PageSource string on the app screen 
#	Given the Reddit app has been launched 
#	Then I see "Share, upvote, and discuss the best of the internet" in the PageSource 
#	
#Scenario: 02. Validate existence of multiple texts in PageSource 
#	Given the Reddit app has been launched
#	Then I see 
#		| SKIP FOR NOW  |
#		| LOG IN        |
#		| SIGN UP       |
#
Feature: Navigation Scenarios
  As a user of Reddit, I can navigate around the Reddit app
 
  Scenario: 01. View the 'Home' tab whilst logged out
    Given the welcome screen has been skipped without logging in
    When I view the Home tab
    Then I see new posts and information pertaining to the Home tab