package firstTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.v118Domains;
import org.openqa.selenium.support.ui.Select;

import Inputs.*;
import Inputs.Number;
import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.xpath.XPath;

public class Validator {
	
	static WebDriver driver = new ChromeDriver();
	
    public static void main(String[] args) {
        // Set up ChromeDriver
        // Change path
        
    	driver.manage().window().maximize();
        // Open a website
        driver.get("https://testsigma.com/signup"); // Change to your target URL
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Calculate the top, middle, and bottom sections

        // Get all elements on the page
        List<WebElement> allElements = driver.findElements(By.tagName("input"));
        allElements.addAll(driver.findElements(By.tagName("select")));
        
        
        List<WebElement> aTags = driver.findElements(By.tagName("a"));
        // Categorize elements based on their position
        for (WebElement element : allElements) {
            // Get the element's position
            
            
            System.out.println(element.getAttribute("outerHTML"));
            System.out.println(element.getAttribute("type"));

            
        }
        
        
        for(WebElement ele : aTags)
        {
        	System.out.println(ele.getAttribute("outerHTML"));
        	
        }
        
        
        
        a(allElements);
//        driver.navigate().back();
        System.out.println("Finished");
//        driver.quit();
    }
    
    
    
    
    
    
    
    
    
    public static WebElement click(String xPath)
    {
    
    	WebElement element = driver.findElement(By.xpath(xPath));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	
//    	while(true)
//    	{
    		try {
	    		element.click();
//	    		break;
			} catch (Exception e) {

				js.executeScript("window.scrollTo(0, 1000);");
	    		element.click();
			}
//    	}
    	return element;
    }

    
    

    public static void type(String xPath,String input)
    {
    	click(xPath).sendKeys(input);
    }
    
    
    
    
    public static void giveInput(String type,String xpath,WebElement element) {
    	switch (type) {
	 		case "text" : 
	 		{
	 			giveTextInput(xpath, element);
	 			break;
	 		}
	 		case "email":
	 		{
	 			giveEmailInput(xpath, element);
	 			break;
	 		}
	 		case "password":System.out.println(xpath);
	 		{
	 			givePasswordInput(xpath, element);
	 			break;
	 		}
	 		case "tel" : 
	 		{
	 			giveNumberInput(xpath, element);
	 			break;
	 		}
	 		case "url":
	 		{
	 			giveURlInput(xpath, element);
	 		}
	 		case "number":
	 		{
	 			giveNumberInput(xpath, element);
	 		}
	 		case "select":
	 		{
	 			System.out.println("--------------------------------------Select---------------------------------------");
	 			selectOption(element);
	 			break;
	 		}
	 		case "range":
	 		{
	 			break;
	 		}
	 		case "date":
	 		{
	 			break;
	 		}
	 		case "time":
	 		{
	 			break;
	 		}
	 		case "datetime-local":
	 		{
	 			break;
	 		}
	 		case "month":
	 		{
	 			break;
	 		}
	 		case "week":
	 		{
	 			break;
	 		}
	 		case "color":
	 		{
	 			break;
	 		}
	 		case "file":
	 		{
	 			break;
	 		}
	 		case "checkbox" :
	 		{
	 			break;
	 		}
	 		case "radio":
	 		{
	 			break;
	 		}
	 		case "submit" :
	 		{
	 			submit(xpath);
	 			break;
	 		}
	 		case "reset":
	 		{
	 			break;
	 		}
	 		case "button":
	 		{
	 			break;
	 		}
	 		case "hidden":
	 		{
	 			break;
	 		}
	 		case "image":
	 		{
	 			break;
	 		}
	 		case "search":
	 		{
	 			break;
	 		}
	 		default:
	 		{
	 			System.out.println("Unexpected value: " + type);
	 		}
		}
	}
    
    
    public static String getXpath(WebElement element)
    {
    	String xpath = (String) ((org.openqa.selenium.JavascriptExecutor) driver)
   			 .executeScript("function getXPath(element) {" +
                        "var paths = [];" +
                        "for (; element && element.nodeType == 1; element = element.parentNode) {" +
                        "var index = 0;" +
                        "for (var sibling = element.previousSibling; sibling; sibling = sibling.previousSibling) {" +
                        "if (sibling.nodeType == 1 && sibling.nodeName == element.nodeName) { index++; } }" +
                        "var tagName = element.nodeName.toLowerCase();" +
                        "var pathIndex = (index ? '[' + (index+1) + ']' : '');" +
                        "paths.unshift(tagName + pathIndex);" +	
                        "}" +
                        "return '/' + paths.join('/');" +
                        "}" +
                        "return getXPath(arguments[0]);", element);
    	return xpath;
    }
    
   
    
    public static void a(List<WebElement> elements)
    {
    	
    	List<String> paths = new ArrayList<String>();
    	int i = 0;
    	for(WebElement element : elements)
    	{
    		
    		String type = getType(element);
    		paths.add(getXpath(element));
    		
    		fistTimeInput(type, paths.get(i), element);
    		
    		i++;
    		
    	}
    	
//    	for(i=0;i<elements.size();i++)
//    	{
//    		String type = getType(elements.get(i));
//    		giveInput(type, paths.get(i),elements.get(i));
//    	}
    	
    }
    
    
    
   
    
    
    
    public static void fistTimeInput(String type,String xpath,WebElement element)
    {
    	switch (type) {
	 		case "text" : 
	 		{
	 			type(xpath , "text");
	 			break;
	 		}
	 		case "email":
	 		{
	 			type(xpath, "email");
	 			break;
	 		}
	 		case "password":
	 		{
	 			type(xpath,"password@1234");
	 			break;
	 		}
	 		case "tel" : 
	 		{
	 			type(xpath,"9876543210");
	 			break;
	 		}
	 		case "url":
	 		{
	 			type(xpath,"https://www.google.com");
	 		}
	 		case "number":
	 		{
	 			type(xpath,"81284");
	 		}
	 		case "range":
	 		{
	 			break;
	 		}
	 		case "date":
	 		{
	 			type(xpath,"30,03,2007");
	 			break;
	 		}
	 		case "select":
	 		{
	 			System.out.println("--------------------------------------Select---------------------------------------");
	 			Select ele = new Select(element);
	 			ele.selectByIndex(1);
	 			break;
	 		}
	 		case "time":
	 		{
	 			type(xpath,"00:00");
	 			break;
	 		}
	 		case "datetime-local":
	 		{
	 			
	 			break;
	 		}
	 		case "month":
	 		{
	 			type(xpath,"2025-01");
	 			break;
	 		}
	 		case "week":
	 		{
	 			type(xpath,"2025-W01");
	 			break;
	 		}
	 		case "color":
	 		{
	 			type(xpath, "#000000");
	 			break;
	 		}
	 		case "file":
	 		{
	 			type(xpath,"document.pdf");
	 			break;
	 		}
	 		case "checkbox" :
	 		{
	 			click(xpath);
	 			break;
	 		}
	 		case "radio":
	 		{
	 			click(xpath);
	 			break;
	 		}
	 		case "submit" :
	 		{
	 			submit(xpath);
	 			break;
	 		}
	 		case "reset":
	 		{
	 			break;
	 		}
	 		case "button":
	 		{
	 			click(xpath);
	 			break;
	 		}
	 		case "image":
	 		{
	 			type(xpath, "aaladin.png");
	 			break;
	 		}
	 		case "search":
	 		{
	 			type(xpath, "google");
	 			break;
	 		}
	 		default:
	 		{
	 			System.out.println("Unexpected value: " + type);
	 		}
		}
    }
    
    
    
    public static void selectOption(WebElement element) {
    	
		Select ele = new Select(element);
		for(int i=1;i<ele.getOptions().size();i++)
		{
			ele.selectByIndex(i);
		}
		
	}
    
    
    public static String getType(WebElement element)
    {
    	String tag = element.getTagName();
    	String type = "";
    	if(tag.equals("input")){
			type = element.getAttribute("type");
		}
		else if(tag.equals("select"))
		{
			type = "select";
		}
    	return type;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void giveTextInput(String xpath,WebElement element)
    {
    	
    	
    	Text inputs = new Text();

    	for(int i=0;i<inputs.getSize();i++)
    	{
    		element.clear();
    		click(xpath);
    		String input = inputs.give();
    		try {
    			type(xpath, input);
    			System.out.println(input);
			} catch (Exception e) {
				System.out.println("-------------------------------------------------------------");
			}
    		
    	}
    	
    	
    	
    }
    
    
    
    
    
    public static void giveEmailInput(String xpath,WebElement element) {
		Email inputs = new Email();
		
		for(int i=0;i<inputs.getSize();i++)
    	{
    		element.clear();
    		click(xpath);
    		String input = inputs.give();
    		try {
    			type(xpath, input);
    			System.out.println(input);
			} catch (Exception e) {
				System.out.println("-------------------------------------------------------------");
			}
    	}
	
	}
    
    
    public static void givePasswordInput(String xpath,WebElement element) {
    	
		Password inputs = new Password();
		for(int i=0;i<inputs.getSize();i++)
    	{
    		element.clear();
    		click(xpath);
    		String input = inputs.give();
    		try {
    			type(xpath, input);
    			System.out.println(input);
			} catch (Exception e) {
				System.out.println("-------------------------------------------------------------");
			}
    	}
		
	}
    
    
    public static void giveNumberInput(String xpath,WebElement element) {
		
    	Number inputs = new Number();

    	for(int i=0;i<inputs.getSize();i++)
    	{
    		element.clear();
    		click(xpath);
    		String input = inputs.give();
    		try {
    			type(xpath, input);
    			System.out.println(input);
			} catch (Exception e) {
				System.out.println("-------------------------------------------------------------");
			}
    	}
    	
	}
    
    
    public static void giveURlInput(String xpath,WebElement element) {
    	
		URL inputs = new URL();
		for(int i=0;i<inputs.getSize();i++)
    	{
    		element.clear();
    		click(xpath);
    		String input = inputs.give();
    		try {
    			type(xpath, input);
    			System.out.println(input);
			} catch (Exception e) {
				System.out.println("-------------------------------------------------------------");
			}
    	}
		
	}
    
    
    
    public static void submit(String xpath) {
		
    	click(xpath);
    	
	}
    
    
   
    
    
}