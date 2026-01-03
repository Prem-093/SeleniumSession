package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Appuser {
     
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Appuser user=new Appuser();
		OpenBrowser br= new OpenBrowser();
		 driver=br.launchBrowser("chrome");
		driver.get("http://www.amazon.com");
	
		WaitConcept con=new WaitConcept(driver);
		By locval = By.xpath("//input[@id='twotabsearchtextbox4336']");
		By loc = By.xpath("//button[text()='Continue shopping']");
		//con.elementVisible(locval, 10);
		con.elementClickable(loc, 10);
	}

}
