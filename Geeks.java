package selnum;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Geeks {
	WebDriver web;
	JavascriptExecutor jse;
	
	//@SuppressWarnings("deprecation")
	public void invgeeks() {
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
			web.get("https://www.geeksforgeeks.org/");
			operations();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void operations() {
		try {
			WebElement link_lang=web.findElement(By.linkText("Languages ▼"));
			
			Actions builder = new Actions(web);
			Action mouseOverHome = builder.moveToElement(link_lang).build();
			mouseOverHome.perform();  
			Thread.sleep(2000);
			
			web.findElement(By.linkText("Java")).click();
			web.findElement(By.xpath("//*[text()='Step by Step Preparation']")).click();
			
			web.findElement(By.xpath("//*[@id=\"cbb\"]/svg/path")).click();
			web.close();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Geeks g=new Geeks();
		g.invgeeks();
	}

}
