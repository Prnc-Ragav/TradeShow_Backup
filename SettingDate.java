package firstTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SettingDate {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("http://127.0.0.1:5500/elementsGetting/index.html"); // Change to your page URL

        // Find the date input field
        WebElement dateInput = driver.findElement(By.id("dateInput"));

        // Set the date using sendKeys() (YYYY-MM-DD format)
        dateInput.sendKeys("20-02-2025");

        // Verify the date entered
        String enteredDate = dateInput.getAttribute("value");
        System.out.println("Selected Date: " + enteredDate);

        // Close the browser
//        driver.quit();
    }
}