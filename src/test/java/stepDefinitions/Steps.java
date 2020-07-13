package stepDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginInfo;
import pageObjects.TravelSpecs;
import resources.DriverInit;

public class Steps extends DriverInit {
	HomePage hp = new HomePage(driver);
	LoginInfo li = new LoginInfo(driver);
	TravelSpecs ts = new TravelSpecs(driver);


	@Given("^a user logs into uber website$")
	public void a_user_logs_into_uber_website() throws Throwable {

		hp.SignInAsUser();
		li.InputingUserInfo(prop.getProperty("cel"), prop.getProperty("pass"));

		Assert.assertTrue(
				prop.getProperty("full-name").contains(ts.getDisplayedName()) || 
				prop.getProperty("full-name").equalsIgnoreCase(ts.getDisplayedName())
				);
	}

	@When("^chooses his origin point as \"([^\"]*)\", \"([^\"]*)\" and destination as \"([^\"]*)\", \"([^\"]*)\"$")
	public void chooses_his_point_and(String origin_st_add, String origin_neighborhood, String dest_st_add, String dest_neighborhood)
			throws Throwable {

		ts.selectingLocation(origin_st_add, origin_neighborhood);
		ts.selectingLocation(dest_st_add, dest_neighborhood);

		Assert.assertTrue(ts.getDisplayedOrigin().contains(origin_st_add.toLowerCase()));
		Assert.assertTrue(ts.getDisplayedDestination().contains(dest_st_add.toLowerCase()));
	}

	@Then("^selects uber default options, requests a car and verifies that \"([^\"]*)\" is displayed and cancels the request$")
	public void selects_uber_and_requests_a_car(String confirmation_msg) throws Throwable {

		ts.clickRequest();
		Assert.assertEquals(ts.getRequestConfirmation(), confirmation_msg);

		ts.cancelRequest();
	}
}
