package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;




public class LatestPage
{
 WebDriver driver;

private By movetochampionship=By.xpath("(//button[text()='championships'])[1]");
private By selectchampionship=By.xpath("//a[@class='s-list-item s-alignment--left']");
private By moremenu=By.xpath("(//button[@aria-label='uso navigation More toggle button'])[2]");
private By moremenuclose=By.xpath("(//button[@class='nav-more_dropdown_closeBtn'])[2]");
private By Latesttab=By.xpath("//a[text()='Latest']");
private By scrolltillarticles=By.xpath("//h3[contains(text(),'Articles')]");
private By articles_totalcards=By.xpath("//a[@class='semi-bold-body small-card_body_title']");
private By nextarticle=By.xpath("(//button[@class='slick-next slick-arrow'])[2]");
private By nextquickread=By.xpath("(//button[@class='slick-next slick-arrow'])[1]");
private By previousarticle=By.xpath("(//button[@class='slick-prev slick-arrow'])[1]");
private By previousquickreads=By.xpath("(//button[@class='slick-prev slick-arrow'])[1]");
private By verifydate=By.xpath("//span[@class='regular-s']");
private By scrolltillquickreads=By.xpath("//h3[contains(text(),'Quick Reads')]");
private By quickreads_totalcards=By.xpath("//div[@class='semi-bold-body  large-card_body_title']");
private By quickreads_dates=By.xpath("//span[@class='regular-s large-card_body_date large-card_body_span']");
private By readmore=By.xpath("(//button[text()='Read More'])[14]");
private By closecard=By.xpath("//button[text()='Close']");
private By copyshare=By.xpath("(//div[@sectionname='Quick Reads']//li[@id='copy'])[14]");
private By facebookshare=By.xpath("(//div[@sectionname='Quick Reads']//li[@id='facebookId'])[14]");
private By twittershare=By.xpath("(//div[@sectionname='Quick Reads']//li[@id='twitterId'])[14]");
private By linkedinshare=By.xpath("(//div[@sectionname='Quick Reads']//li[@id='linkedinId'])[14]");
private By scrolltillsocialsection=By.xpath("//h3[@class='medium-title-m-mb social-section_hr-lines']");
private By nextsocialcard=By.xpath("//button[@class='slick-arrow slick-next']");
private By previoussocialcard=By.xpath("//button[@class='slick-arrow slick-prev']");
private By askquestion=By.xpath("//button[@aria-label='open chat']");
private By switchtoaskquestionframe=By.xpath("//div[@class='satisfi_chat']//iframe");
private By clickmobiletestingguide=By.xpath("//div[@class='satisfi_bubble satisfi_fill_available']//button[text()='Mobile Ticketing Guide']");
private By verifyanstext=By.xpath("(//div[@class='satisfi_bubble satisfi_fill_available']//p)[2]");
private By closeaskingquestion=By.xpath("//button[@aria-label='Close Chat Popup']");
JavascriptExecutor js = (JavascriptExecutor) driver;
	  	
	   public LatestPage(WebDriver driver)
	   {
		   this.driver=driver;	
		   PageFactory.initElements(driver,this);
	   }
	   
	   public String getLoginPageTitle()
	   {
		   return driver.getTitle();
	   }
		public void navigate_championship()
		{					
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(movetochampionship)).build().perform();
			
		}
		
		public void select_championship(String selectChampionship) throws Exception
		{
		List<WebElement> verifychampionship=driver.findElements(selectchampionship);
  		  
            int size=verifychampionship.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) 
            {
                String verify = verifychampionship.get(i).getText();
                System.out.println(verify);
                
                if (verify.equalsIgnoreCase(selectChampionship)) 
                {
                	verifychampionship.get(i).click();
                	Thread.sleep(5000);
                    break;
                } 
                
             }
      	
 	   
		}
		public void moremenu() throws Exception
		{
			
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		    driver.findElement(moremenu).click();
		    driver.findElement(moremenuclose).click();
		   
			
		}
		public void navigate_to_latesttab()
		{		
			driver.findElement(Latesttab).click();
		}
		public void scrolltill_articlessection()
		{			
			WebElement article=driver.findElement(scrolltillarticles);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].scrollIntoView();", article);
			
		}
		public void total_articlescards() throws Exception  
		{
			List<WebElement> totalcards=driver.findElements(articles_totalcards);
			List<WebElement> totaldates=driver.findElements(verifydate);
			int size=totalcards.size();
            System.out.println(size);
            for (int i = 10; i < size; i++) 
            {
                String cardname = totalcards.get(i).getText();
                String datename=totaldates.get(i).getText();
               
                if(cardname.isEmpty())
                {
                	WebElement nextcard=driver.findElement(nextarticle);
                    String nextcardname = nextcard.getText();
                    System.out.println("Naviagte to articles next card: "+nextcardname);
                    Thread.sleep(4000);
                    nextcard.click();
                    Thread.sleep(1000);
                    String visiblecardname = totalcards.get(i).getText();
                    System.out.println("Articles Cards are visible: " +visiblecardname);
                    String visibledatename = totaldates.get(i).getText();
                    System.out.println("Articles Dates are visible: " +visibledatename);
                 
                }
                else
                {
                	 System.out.println("Articles Cards Title is: " +cardname);
                	 System.out.println("Articles Cards Date is: " +datename);
                }
                
             }
			
		}
		public void navigateto_leftandright_cards(String articlecardswipe) throws Exception
		{
			int size=Integer.parseInt(articlecardswipe);  
			for (int i = 1; i <=size; i++) 
            {
				WebElement previouscard=driver.findElement(previousarticle);
                String pcardname = previouscard.getText();
                System.out.println("Naviagte to articles previous card: "+pcardname);
                Thread.sleep(1000);
                previouscard.click();
                             
            }		
			for (int i = 1; i <=size; i++) 
            {
				WebElement nextcard=driver.findElement(nextarticle);
                String ncardname = nextcard.getText();
                System.out.println("Naviagte to articles next card: "+ncardname);
                Thread.sleep(1000);
                nextcard.click();
                             
            }
				
			
		}
		public void scrolltill_quickreadssection() throws Exception
		{			
			WebElement quickreads=driver.findElement(scrolltillquickreads);
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",quickreads);
			
		}
		
		public void total_quickreadscards() throws Exception
		{
			List<WebElement> qtotalcards=driver.findElements(quickreads_totalcards);
			List<WebElement> qtotaldates=driver.findElements(quickreads_dates);
			int size=qtotalcards.size();
            System.out.println(size);
            for (int i = 8; i < size; i++) 
            {
                String cardname = qtotalcards.get(i).getText();
                String datename=qtotaldates.get(i).getText();
                if(cardname.isEmpty())
                {
                	WebElement nextcard=driver.findElement(nextquickread);
                    String nextcardname = nextcard.getText();
                    System.out.println("Naviagte to next quick read card: "+nextcardname);
                    Thread.sleep(1000);
                    nextcard.click();
                    Thread.sleep(1000);
                    String visiblecardname = qtotalcards.get(i).getText();
                    System.out.println("QuickReads Cards are visible: " +visiblecardname);
                    String visibledatename = qtotaldates.get(i).getText();
                    System.out.println("QuickReads Dates are visible: " +visibledatename);
                    
                  
                }
                else
                {
                	 System.out.println("QuickReads Cards Title is: " +cardname);
                	 System.out.println("QuickReads Cards Date is: " +datename);
                	
                	 
                }
                
             }
		}
		public void navigateto_leftandright_quickreadscards(String quickreadcardswipe) throws Exception
		{
			int size=Integer.parseInt(quickreadcardswipe);  
			for (int i = 1; i <=size; i++) 
            {
				WebElement previouscard=driver.findElement(previousquickreads);
                String pcardname = previouscard.getText();
                System.out.println("Naviagte to quick reads previous card: "+pcardname);
                Thread.sleep(1000);
                previouscard.click();
                             
            }		
			for (int i = 1; i <=size; i++) 
            {
				WebElement nextcard=driver.findElement(nextquickread);
                String ncardname = nextcard.getText();
                System.out.println("Naviagte to quick reads next card: "+ncardname);
                Thread.sleep(1000);
                nextcard.click();
                             
            }
							
		}
		public void scrolltill_ReadMore() throws Exception
		{	
			WebElement rscroll=driver.findElement(readmore);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",rscroll);
			Thread.sleep(5000);
        	driver.findElement(readmore).click();    
        	Thread.sleep(1000);
        	
        	
		}
		public void verifyfcopyshare() throws Exception
		{
			Thread.sleep(1000);
        	driver.findElement(copyshare).click();
        	System.out.println("Link copied");
        	Thread.sleep(1000);
		}
		public void verifyfacebookshare()throws Exception
		{
			Thread.sleep(1000);
        	driver.findElement(facebookshare).click();
        	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(2));
		    String facebooktitle=driver.getTitle();
		    System.out.println(facebooktitle);
		    driver.close();
		    
		}
		public void verifylinkedinshare() throws Exception
		{
			   
        	Thread.sleep(1000);
        	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles()); 
        	driver.switchTo().window(tabs.get(1));
        	Thread.sleep(3000);
			driver.findElement(linkedinshare).click();    
			Thread.sleep(3000);
			ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles()); 
        	driver.switchTo().window(tabs1.get(2));
        	Thread.sleep(3000);
        	String linkedin=driver.getTitle();
        	System.out.println(linkedin);
        	driver.close();
		}
		public void verifytwittershare() throws Exception
		{
		
        	Thread.sleep(1000);
        	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());   
        	driver.switchTo().window(tabs.get(1));
        	Thread.sleep(3000);
        	driver.findElement(twittershare).click(); 
        	Thread.sleep(3000);
			ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());        	
        	driver.switchTo().window(tabs1.get(2));
        	Thread.sleep(10000);
        	String twitter=driver.getTitle();
        	System.out.println(twitter);
        	driver.close();
        	driver.switchTo().window(tabs.get(1));
        	driver.findElement(closecard).click();
		}
		public void scrolltill_SocialSection() throws Exception
		{	
			WebElement rscroll=driver.findElement(scrolltillsocialsection);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",rscroll);
			Thread.sleep(5000);
        	
		}
		public void navigateto_leftandright_socialsectioncards(String socialswipe) throws Exception
		{
			int size=Integer.parseInt(socialswipe);  
			for (int i = 1; i <=size; i++) 
            {
				WebElement previouscard=driver.findElement(previoussocialcard);
                String pcardname = previouscard.getText();
                System.out.println("Naviagte to social  previous card: "+pcardname);
                Thread.sleep(2000);
                previouscard.click();
                             
            }		
			for (int i = 1; i <=size; i++) 
            {
				WebElement nextcard=driver.findElement(nextsocialcard);
                String ncardname = nextcard.getText();
                System.out.println("Naviagte to social next card: "+ncardname);
                Thread.sleep(2000);
                nextcard.click();
                             
            }
							
		}
		public void click_ask_question() throws Exception
		{
			Thread.sleep(2000);
			driver.findElement(askquestion).click();
			
		}
		public void click_mobiletestingguide_verifyanstext()throws Exception
		{
			Thread.sleep(5000);
			driver.switchTo().frame(driver.findElement(switchtoaskquestionframe));
			driver.findElement(clickmobiletestingguide).click();
			Thread.sleep(5000);
			String text=driver.findElement(verifyanstext).getText();
			System.out.println(text);
			
			
		}
		public void closeaskingquestiont()throws Exception
		{
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(closeaskingquestion).click();
			System.out.println("Closed asking a question Screen");
		}
		
		
}

