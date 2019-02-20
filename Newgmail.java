package sel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Newgmail {
	WebDriver web;
	JavascriptExecutor jse;

	public void invgmail() {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver", "C:\\chrome_driver\\chromedriver.exe");
			dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir=C:\\Users\\schevvakula\\AppData\\Local\\Google\\Chrome\\User Data");
			dc.setCapability(ChromeOptions.CAPABILITY, options);
			Thread.sleep(200);
			web = new ChromeDriver(dc);
			web.manage().deleteAllCookies();
			web.manage().window().maximize();
			web.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			web.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			web.get("https://www.google.com/gmail/about/new/");
			login();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login() throws AWTException {
		try {
			int i;
			/*if(!(isElementPresent(By.xpath("/html/body/nav/div/a[2]"))))
			{
			web.findElement(By.xpath("/html/body/div[2]/div[1]/div[5]/ul[1]/li[2]/a")).click();
			Thread.sleep(1000);
			window();
		    i=1;
			}
			else
			{
				web.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
				i=2;
			}*/
			if(!(isElementPresent(By.xpath("//a[text()='Sign In']"))))
			{
			web.findElement(By.xpath("//ul[@class='h-c-header__cta-list header__nav--ltr']/li[@class='h-c-header__nav-li g-mail-nav-links']/a[contains(text(),'Sign in')]")).click();
			Thread.sleep(1000);
			window();
		    i=1;
			}
			else
			{
				web.findElement(By.xpath("//a[text()='Sign In']")).click();
				i=2;
			}
			Thread.sleep(1000);
			if(isElementPresent(By.xpath("//*[text()='Remove an account']")))
				remove();
			Thread.sleep(2000);
			if(i==1)
			{
			web.findElement(By.name("identifier")).sendKeys("innogmtest@gmail.com");
			Thread.sleep(1000);
			web.findElement(By.className("CwaK9")).click();
			}
			Thread.sleep(3000);
			web.findElement(By.name("password")).sendKeys("innominds");
			Thread.sleep(1000);
			web.findElement(By.className("CwaK9")).click();
			photos();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void photos() throws AWTException
	{
			try {
				web.findElement(By.className("gb_lf")).click();
				Thread.sleep(3000);
				web.findElement(By.xpath("//*[text()='Photos']")).click();
				Thread.sleep(3000);
				window();
				web.findElement(By.xpath("//*[text()='Upload']")).click();
				Thread.sleep(2000);
				 StringSelection ss = new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");
				    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				    Robot robot = new Robot();
				    Thread.sleep(3000);
				    robot.keyPress(KeyEvent.VK_CONTROL);
				    robot.keyPress(KeyEvent.VK_V);
				    robot.keyRelease(KeyEvent.VK_CONTROL);
				    robot.keyRelease(KeyEvent.VK_V);
				    Thread.sleep(3000);
				    robot.keyPress(KeyEvent.VK_ENTER);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}	

	public void window() {
		Set<String> allWindows = web.getWindowHandles();
		for (String currentWindow : allWindows) {
			web.switchTo().window(currentWindow);
			System.out.println(currentWindow);
		}
	}

	public void remove() throws AWTException
	{
		try {
			web.findElement(By.xpath("//*[text()='Remove an account']")).click();
			web.findElement(By.className("n3x5Fb")).click();
			window();
			Robot r=new Robot();
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isElementPresent(By element) {
		   try {
		       web.findElement(element);
		       return true;
		   } catch (NoSuchElementException e) {
		       return false;
		   }
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Newgmail g = new Newgmail();
		g.invgmail();

	}

}
