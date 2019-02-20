package sel;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;
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

public class Outlook {
	
	WebDriver web;
	JavascriptExecutor jse;

	public void invoutlook() {
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
			web.get("https://login.microsoftonline.com/");
			login();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public void login() throws AWTException {
		try {
			web.findElement(By.xpath("//*[@aria-label='Sign in with schevvakula@innominds.com work or school account.']")).click();
			Thread.sleep(3000);
			web.findElement(By.name("passwd")).sendKeys("Subbu1996%");
			Thread.sleep(2000);
			web.findElement(By.xpath("//input[@type='submit']")).click();
            web.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            web.findElement(By.xpath("//*[@title='Outlook']")).click();
            Thread.sleep(2000);
            window();
            upload();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}		
public void upload() throws AWTException
{
	try {
		web.findElement(By.xpath("//*[text()='New message']")).click();
		web.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		web.findElement(By.xpath("//input[@class='ms-BasePicker-input pickerInput_269bfa71']")).sendKeys("akesiboyina@innominds.com");
		web.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		web.findElement(By.id("subjectLine0")).sendKeys("pic");
		Thread.sleep(2000);
		web.findElement(By.xpath("//div[text()='Attach']")).click();
		Thread.sleep(1000);
		web.findElement(By.xpath("//*[text()='Browse this computer']")).click();
		attach();
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
			
public void attach() throws AWTException
{
	
		try {
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
			Thread.sleep(2000);
			web.findElement(By.xpath("//div[text()='Send']")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outlook g = new Outlook();
		g.invoutlook();

	}
}
