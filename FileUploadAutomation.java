package firstTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadAutomation {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("http://127.0.0.1:5500/elementsGetting/index.html"); // Change to your webpage URL
        // Locate the file input field
        WebElement fileInput = driver.findElement(By.id("fileInput"));

        // Provide the file path (absolute path)
        fileInput.sendKeys("/home/manoj-zstk399/Pictures/Screenshots/aladdin.png"); // File path

        // Verify file selection
        String uploadedFile = fileInput.getAttribute("value");
        System.out.println("Selected File: " + uploadedFile);

        // Close the browser
//        driver.quit();
    }
}