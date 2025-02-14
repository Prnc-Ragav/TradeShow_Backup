package firstTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SliderAutomation {
    public static void main(String[] args) {
        // Set up WebDriver
    	
    	
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("http://127.0.0.1:5500/elementsGetting/index.html"); // Change this to your webpage URL

        // Find the range input element
        WebElement slider = driver.findElement(By.id("r"));

        // Use JavaScript to set the value of the range slider
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int value = 90;
        js.executeScript("arguments[0].value = "+ value  +  ";", slider);

        // Verify the changed value
        String newValue = slider.getAttribute("value");
        System.out.println("Slider New Value: " + newValue);

        // Close the browser
//        driver.quit();
    }
}