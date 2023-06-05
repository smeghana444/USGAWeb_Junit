package DriverFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class webdriverfactory

{

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	public WebDriver init_driver(String browser)
	{
		System.out.println("browser value is: "+browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			tlDriver.set(new ChromeDriver(options));
				
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			tlDriver.set(new EdgeDriver(options));
			
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
	}
	
	public static WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
}
