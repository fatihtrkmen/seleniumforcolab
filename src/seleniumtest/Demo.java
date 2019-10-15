package seleniumtest;
import org.openqa.selenium.By;  
import org.openqa.selenium.JavascriptExecutor;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.openqa.*;  
import java.util.Scanner;
public class Demo {

	public static void main(String[] args) {           
		
		if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");  
		}
		else if(System.getProperty("os.name").toLowerCase().contains("linux")) {
			System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver"); 
		}
		
		WebDriver c = new org.openqa.selenium.chrome.ChromeDriver();
		
		ScheduledExecutorService execService = Executors.newScheduledThreadPool(5);
		execService.scheduleAtFixedRate(()->{
		func(c);
		}, 0, 30, TimeUnit.SECONDS);
		
	}

	private static void func(WebDriver c) {
		try {
			String reconnect = c.findElement(By.cssSelector("#connect > paper-button > span")).getText();
	        if(reconnect.toString().equals("Reconnect") || reconnect.toString().equals("Connect") || reconnect.toString().equals("Idle"))
	        {
	        	c.findElement(By.cssSelector("#connect > paper-button > span")).click();
	            System.out.println("Attempt to reconnect");
	        }
		}catch (Exception e) {
			// TODO: handle exception
		}		
	}
}



