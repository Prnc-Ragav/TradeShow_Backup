package firstTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectOptionExample {
    public static void main(String[] args) {
        // Set up the WebDriver (make sure the path to the ChromeDriver is correct)
//        System.setProperty("webdriver.chrome.driver", "path_to_your_chromedriver");
    	
        WebDriver driver = new ChromeDriver();

        // Open a webpage
        driver.get("http://127.0.0.1:5500/elementsGetting/index.html");

        // Find the <select> element by its name, id, or other locator
        WebElement selectElement = driver.findElement(By.id("sel"));

        // Create a Select object
        Select select = new Select(selectElement);

        

        // Option 3: Select by index (0-based index)
        select.selectByIndex(2);

        // Continue with other operations

        // Close the driver
//        driver.quit();
    }
}