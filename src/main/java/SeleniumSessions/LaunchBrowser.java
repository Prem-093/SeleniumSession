package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		
		LaunchCrossBrowser launchBrw= new LaunchCrossBrowser();
		
		launchBrw.launchBrowser("Chrome");
		launchBrw.launchURL("https://www.flipkart.com/");
		String pageTitle=launchBrw.getTitle();
		System.out.println(pageTitle);
		Boolean flagValue=VerifyText.verifyText(pageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"
				);
		System.out.println(flagValue);
	}

}
