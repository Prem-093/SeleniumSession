package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");
		
		/*
		 * String title=driver.getTitle(); System.out.println(title); driver.close();//
		 * invalid session id String url=driver.getCurrentUrl();
		 * System.out.println(url);
		 */
		
		String title=driver.getTitle();
		System.out.println(title);
		driver.quit();//  session id=null
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
	}

}
