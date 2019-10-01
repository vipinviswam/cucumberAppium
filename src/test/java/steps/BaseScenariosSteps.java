package steps;

import cucumber.api.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.PopularTabPage;

public class BaseScenariosSteps extends BaseSteps {
	
	private BasePage oBase = new BasePage();
	private PopularTabPage oPopular = new PopularTabPage();

//    @Given("^the Reddit app has launched$")
//    public void theRedditAppHasLaunched() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
////        throw new PendingException();
//    	instanceOf(BasePage.class).appFullyLaunched();
//    }
	
	
	 @Given("^the welcome screen has been skipped without logging in$")
	    public void theWelcomeScreenHasBeenSkippedWithoutLoggingIn() throws Throwable {
	        // Write code here that turns the phrase above into concrete actions
//	        throw new PendingException();
		 instanceOf(BasePage.class).appFullyLaunched();
		 instanceOf(BasePage.class).clickSkipForNowButton();
	    }
	 
	    @When("^I view the Home tab$")
	    public void iSelectTheHomeTab() throws Throwable {
	        // Write code here that turns the phrase above into concrete actions
	        oPopular.popularLandingPage();
	    }
	    
	    @Then("I see new posts and information pertaining to the Home tab")
	    public void i_see_new_posts_and_information_pertaining_to_the_Home_tab() {
	        // Write code here that turns the phrase above into concrete actions
	        throw new cucumber.api.PendingException();
	    }
}
