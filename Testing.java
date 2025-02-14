package firstTesting;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing
{
	
	 static WebDriver driver;
	 public static WebDriver getDriverr() {
	
		WebDriverManager.firefoxdriver().setup(); // Automatically downloads the correct driver
		if(driver == null)
			driver = new FirefoxDriver();
		return driver;
	 
	 }
	 
	public static void main(String[] args) {
		 
		 
		WebDriver obj = getDriverr();
		
		 
		 
	}
	
	
	
	public void titleCheck()
	{
		
		System.out.println("driver created");
		WebDriver driver = getDriverr();
		
		driver.navigate().to("https://www.google.com");
		driver.manage().window().maximize();
		String actualTitleString = "Google";
		String title =  driver.getTitle();
		if (title.equals(actualTitleString)) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}
		
	}
	
	public void gmail1(){
		
		WebDriver driver = getDriverr();
		driver.navigate().to("https://mail.google.com/");

	}
	
}
