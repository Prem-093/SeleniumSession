package Seleniumcheataheet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecuter {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=js.executeScript("return document.title;").toString();
		System.out.println(title);
		
		  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		  Thread.sleep(2000);
		  js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		  Thread.sleep(2000);
		  js.executeScript("window.scrollTo(0,document.body.scrollHeight/2)");
		 
		WebElement element=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		System.out.println("-----------------------------------");
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollto(0,document.body.scrollHeight)");
		js1.executeScript("window.scrollto(document.body.scrollHeight,0)");
		js1.executeScript("argument[0].scrollIntoView(true);", element);
	}

}
