package sel;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Lulu {
	WebDriver web;
	JavascriptExecutor jse;

	public void invlulu() {
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
			web.get("https://stghybris.lulumea.com/en-ae/");
			login();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void login()
	{
		try {
			web.findElement(By.xpath("//span[@class='cart']")).click();
			Thread.sleep(2000);
			if(isElementPresent(By.id("removeEntry_0")));
			{
				Thread.sleep(2000);
				removecart();
			}
			web.findElement(By.xpath("//button[@class='close']")).click();
			WebElement link_gad=web.findElement(By.xpath("//a[@title='MOBILES & GADGETS']"));
			Actions builder = new Actions(web);
			Action mouseOverHome = builder.moveToElement(link_gad).build();
			mouseOverHome.perform();
			web.findElement(By.xpath("//a[@title='Smart Phones']")).click();
			jse = (JavascriptExecutor)web;
			jse.executeScript("scroll(0,750)");
			Thread.sleep(2000);
			web.findElement(By.xpath("//form[@id='addToCartForm1371309']//button[contains(text(),'ADD')]")).click();
			Thread.sleep(2000);
			jse.executeScript("scroll(750,0)");
			web.findElement(By.xpath("//span[@class='cart']")).click();
			Thread.sleep(2000);
			web.findElement(By.xpath("//button[text()='VIEW CART']")).click();
			Thread.sleep(2000);
			web.findElement(By.xpath("//input[@value='CONTINUE TO CHECKOUT']")).click();
			web.findElement(By.id("checkout-guest-login")).click();
			Thread.sleep(2000);
			web.findElement(By.id("guest.email")).sendKeys("innogmtest@gmail.com");
			Thread.sleep(2000);
			web.findElement(By.id("guest.confirm.email")).sendKeys("innogmtest@gmail.com");
			web.findElement(By.xpath("//button[text()='Check Out as a Guest']")).click();
			address();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
public void address()
{
	try {
		web.findElement(By.xpath("//div[@class='add-plus-img']/button[@class='delivery-add-new']")).click();
		web.findElement(By.id("address.addressTitle")).sendKeys("wave");
		WebElement dropdownElement = web.findElement(By.xpath("//select[@id='address.title']"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByIndex(1);
		web.findElement(By.id("address.firstName")).sendKeys("hello");
		Thread.sleep(1000);
		web.findElement(By.name("lastName")).sendKeys("world");
		web.findElement(By.id("address.line1")).sendKeys("wave");
		web.findElement(By.id("address.line2")).sendKeys("rock");
		web.findElement(By.id("address_mobilePhone")).sendKeys("987654321");
		web.findElement(By.xpath("//button[text()='Create']")).click();
		//jse.executeScript("scroll(0,500)");
		web.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		web.findElement(By.xpath("//div[@class='shiiping-details-show']/button")).click();
		Thread.sleep(5000);
		payment();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void payment()
{
	try {
		WebElement dropdownElement = web.findElement(By.id("card_type"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		web.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		forloop("card_number","5405102527817146");
		//web.findElement(By.id("card_number")).sendKeys("5405102527817146");
		Thread.sleep(2000);
		jse.executeScript("scroll(0,300)");
		web.findElement(By.name("ccardsurname")).sendKeys("Kadi Schuelke");
		web.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		forloop("card_expiry_date","052024");
		//web.findElement(By.id("card_expiry_date")).sendKeys("052024");
		web.findElement(By.id("card_cvn")).sendKeys("895");
		web.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		web.findElement(By.xpath("//button[text()='CONFIRM & PAY']"));
		Thread.sleep(5000);
		web.close();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void forloop(String c,String s1)
{
	char[] s2=s1.toCharArray();
	try {
		for(char s: s2)
		{
			web.findElement(By.id(c)).sendKeys(Character.toString(s));
			Thread.sleep(1000);
		}
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



public void removecart()
{
	web.findElement(By.id("removeEntry_0")).click();
	
	}

public void window() {
		Set<String> allWindows = web.getWindowHandles();
		for (String currentWindow : allWindows) {
			web.switchTo().window(currentWindow);
			System.out.println(currentWindow);
		}
	}	
	
	
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lulu g = new Lulu();
		g.invlulu();

	}

}
