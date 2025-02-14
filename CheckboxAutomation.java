package firstTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxAutomation {
    public static void main(String[] args) {
        // Set up WebDriver

        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("http://127.0.0.1:5500/elementsGetting/index.html"); // Change to your webpage URL

        // Locate the checkbox
        WebElement checkbox = driver.findElement(By.id("checkbox"));

        // Check if checkbox is already selected
        if (!checkbox.isSelected()) {
            checkbox.click(); // Select the checkbox
        }

        // Verify the checkbox state
        if (checkbox.isSelected()) {
            System.out.println("Checkbox is checked!");
        } else {
            System.out.println("Checkbox is unchecked!");
        }

        // Uncheck the checkbox
//        checkbox.click();

        // Close the browser
//        driver.quit();
    }
}
