import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class YoutubeVideoTest {
static WebDriver driver;	
	public static void main(String[] args) throws FindFailed {
		

//intitialize browser
				System.setProperty("webdriver.chrome.driver", "E:\\Selenium tutorial\\chromedriver.exe");
				driver = new ChromeDriver();
				
//delete all cookies & maximize browser		
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
///dynamic wait time			
				driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//Enter url		
				driver.get("https://www.youtube.com/watch?v=w7WHdJiEJhU&t=675s");
				
//create the object of screen class -sikuli
				Screen s = new Screen();
	//pause youtube play button
		
		 Pattern pauseimage = new Pattern("Youtube_pause.png");
		  s.wait(pauseimage,2000); 
		  s.click();
		 
				
	//click on youtube play button		
	
			  Pattern playimage = new Pattern("Youtube_play.png"); s.wait(playimage,2000);
			  s.click();
			  s.click();
		 
	//click on youtube setting icon
				Pattern Settingsimage = new Pattern("Youtube_setting.png");
				s.wait(Settingsimage,2000);
				s.click();
				
	//change screen quality from 360p to 144p
				
				Pattern image360 = new Pattern("Youtube_Auto_360p.PNG");
				s.wait(image360,2000);
				s.click();
				
				Pattern image144p = new Pattern("Youtube_144p.png");
				s.wait(image144p,2000);
				s.click();
				
				
		driver.close();		
				
				
				
				
				
				
				
		
		
				
		

	}

}
