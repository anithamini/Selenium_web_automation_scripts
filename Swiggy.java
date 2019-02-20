package selnum;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Swiggy {
	WebDriver web;
	JavascriptExecutor jse;
	
	//@SuppressWarnings("deprecation")
	public void invswig() throws AWTException {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chrome\\chromedriver.exe");
			dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir=C:\\Users\\akesiboyina\\AppData\\Local\\Google\\Chrome\\User Data");
			dc.setCapability(ChromeOptions.CAPABILITY, options);
			Thread.sleep(200);
			web = new ChromeDriver(dc);
			web.manage().deleteAllCookies();
			web.manage().window().maximize();
			web.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			web.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			web.get("https://www.swiggy.com/");
			operations();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void operations()  throws AWTException {
			
				try {
					web.findElement(By.xpath("//*[@class='icon-downArrow kVKTT']")).click();
					Thread.sleep(2000);
					web.findElement(By.xpath("//input[@type='text']")).sendKeys("Gachibowli");
					Thread.sleep(2000);
					web.findElement(By.className("Ku2oK")).click();
					Thread.sleep(2000);
					web.findElement(By.xpath("//li[@class='_1fo6c']/div/a/span[text()='Search']")).click();
					web.findElement(By.className("_2BJMh")).sendKeys("ice creams");
					Robot robot = new Robot();
					Thread.sleep(3000);
					robot.keyPress(KeyEvent.VK_ENTER);
					Thread.sleep(2000);
					robot.keyPress(KeyEvent.VK_DOWN);
					Thread.sleep(3000);
					robot.keyPress(KeyEvent.VK_ENTER);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
	}
	
	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		Swiggy g = new Swiggy();
		g.invswig();

	}
}

