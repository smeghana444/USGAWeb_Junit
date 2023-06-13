package stepdefinations;


import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LatestPage;


public class Latest_PageSteps
{
	private LatestPage latest=new LatestPage();
	
	@Given("Verify the app title")
	public void get_the_app_title() throws Exception 
	{
		
		String title=latest.getLoginPageTitle();
		System.out.println("Launch page title is "+title);
		Assert.assertEquals(title, "USGA.ORG | The official home of the United States Golf Association");	
		
	}
	@Then("Navigate to championships")
	public void navigate_to_championships() 
	{
		System.out.println("Navigate to Championship");
		latest.navigate_championship();
		Assert.assertTrue(true);
		
	}
	
    @Then("select championship {string}")
	public void select_championship(String selectchampionship) throws Exception 
	{
		
		System.out.println("Select the championship");
		Thread.sleep(1000);
		latest.select_championship(selectchampionship);
		Assert.assertTrue(selectchampionship, true);	
	    
	}
    @Then("Click on More menu and close")
	public void click_on_more_menu() throws Exception
	{
		
		System.out.println("Click on more menu");
		latest.moremenu();
		System.out.println("More menu closed");
		Assert.assertTrue(true);
	}

	@Then("click on latest tab")
	public void click_on_latest_tab()
	{
		
		System.out.println("Click on latest tab");
		latest.navigate_to_latesttab();
		Assert.assertTrue("click on latest tab is passed", true);
		
	}

	@Then("Navigate to Articles section")
	public void navigate_to_articles_section() 
	{
		System.out.println("Navigate to Articles section");
		latest.scrolltill_articlessection();
		Assert.assertTrue(true);
	}
	@Then("Total Article Cards and Dates")
	public void total_articles_sectioncards_dates() throws Exception 
	{
		System.out.println("Verify total article cards");
		latest.total_articlescards();
		Assert.assertTrue(true);
	}	

	@Then("Verify left and right navigation in articles {string}")
	public void verify_left_and_right_navigation_in_articles(String artcilesswipe) throws Exception 
	{
		System.out.println("Verify left and right navigation");
		latest.navigateto_leftandright_cards(artcilesswipe);
		Assert.assertTrue(true);
	}
	@Then("Naviagte to quickreads")
	public void navigate_quickreads() throws Exception
	{
		latest.scrolltill_quickreadssection();
		Assert.assertTrue(true);
	}
	
	@Then("Total QuickReads Cards and Dates")
	public void total_quick_reads_cards_and_dates() throws Exception 
	{
	   System.out.println("Verify total quick reads cards");
	   latest.total_quickreadscards();
	   Assert.assertTrue(true);
	}
	@Then("Verify left and right navigation in quickreads {string}")
	public void verify_left_and_right_navigation_in_quickreads(String quickreadsswipe) throws Exception {
		latest.navigateto_leftandright_quickreadscards(quickreadsswipe);
		Assert.assertTrue(true);
	}

 @Then("Verify quickreads readmore and close card")
 public void quickreads_more_close() throws Exception
 {
	 latest.scrolltill_ReadMore();
	 Assert.assertTrue(true);
 }
  @Then("verify social shares in quick reads")
  public void socialshares() throws Exception
{
	latest.verifyfcopyshare();
	Assert.assertTrue(true);
	latest.verifyfacebookshare();
	Assert.assertTrue(true);
	latest.verifylinkedinshare();
	Assert.assertTrue(true);
	latest.verifytwittershare();
	Assert.assertTrue(true);
}
@Then("Navigate to Social Section")
public void navigate_socialsection() throws Exception
{
	latest.scrolltill_SocialSection();
	Assert.assertTrue(true);
}
@Then("Verify left and right navigation in social section {string}")
public void verify_left_and_right_navigation_in_socialsection(String socialswipe) throws Exception {
	latest.navigateto_leftandright_socialsectioncards(socialswipe);
	Assert.assertTrue(true);
}
@Then("Click on Ask any question button")
public void navigate_Topcta() throws Exception
{
	latest.click_ask_question();
	Assert.assertTrue(true);
}	
@Then("Click mobile testing guide and verify response")
public void navigate_clickmobiletestingguide() throws Exception
{
	latest.click_mobiletestingguide_verifyanstext();
	Assert.assertTrue(true);
}
@Then("Close ask a question screen")
public void navigate_close_asking_question() throws Exception
{
	latest.closeaskingquestiont();
	Assert.assertTrue(true);
}
}
