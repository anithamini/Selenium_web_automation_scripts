package sel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	WebDriver web;
	JavascriptExecutor jse;
	static Logger log = Logger.getLogger(Amazon.class);
	public void invBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\chrome_driver\\chromedriver.exe");
			web = new ChromeDriver();
			web.manage().deleteAllCookies();
			web.manage().window().maximize();
			web.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			web.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			web.get("https://www.amazon.in/");
			searchitem();
			// web.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void searchitem() throws AWTException {
		try {
			web.findElement(By.id("twotabsearchtextbox")).sendKeys("books");
			Thread.sleep(1000);
			web.findElement(By.className("nav-input")).click();
			jse = (JavascriptExecutor) web;
			jse.executeScript("scroll(0,1200)");
			Thread.sleep(1000);
			web.findElement(By.xpath("//h2[text()='The Girl in Room 105']")).click();
			Thread.sleep(3000);
			Set<String> allWindows = web.getWindowHandles();
			for (String currentWindow : allWindows) {
				web.switchTo().window(currentWindow);
				
			}
			Robot r = new Robot();
			Thread.sleep(10000);
			r.keyPress(KeyEvent.VK_ENTER);
			jse.executeScript("scroll(0,200)");
			Thread.sleep(3000);

			web.findElement(By.id("add-to-cart-button")).click();
			Thread.sleep(1000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Amazon a = new Amazon();
		
		PropertyConfigurator.configure("C:\\Users\\schevvakula\\eclipse-workspace\\sel\\src\\sel\\log4j.properties");
		a.invBrowser();
		log.trace("This is a debug message");
		log.info("This is an info message");

	}

	
}
