package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class User {

	static WebDriver driver;

	public static void main(String[] args) {
		OpenBrowser br = new OpenBrowser();
		driver = br.launchBrowser("chrome");
		WebDriverConcept con = new WebDriverConcept(driver);
		con.launchURL("http://www.amazon.com");
		//con.implicitwait(20);
		String pageURL = con.getCurrentURL();
		con.getTitle();
		By loc = By.xpath("//button[text()='Continue shopping']");
		con.getElement(loc);
		Boolean flags=con.elementIsEnabled(loc);
		System.out.println(flags);
		con.doClick(loc);
		By locval = By.xpath("//input[@id='twotabsearchtextbox']");
		con.doSendKeys(locval, "glass");
		con.doSendKeys1(locval, "electronic");
		String text = con.getText(locval);
		System.out.println(text);
		String searchText = con.getAttribute(locval, "placeholder");
		System.out.println("Search BOX text :" + searchText);
		By logo = By.xpath("//a[@href='/ref=nav_logo']");
		Boolean flag = con.elementIsDisplay(logo);
		System.out.println(flag);
		
		WaitConcept wait=new WaitConcept(driver);
	    wait.elementVisible(loc,10);
	}

}
