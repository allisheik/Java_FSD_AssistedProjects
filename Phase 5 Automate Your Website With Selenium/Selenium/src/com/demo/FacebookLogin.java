package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		
		//STEP:1 declare a path
		String path= "D:\\SimpliLearn\\selenium drivers\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		
		//STEP:2 initialize the webdriver
		WebDriver driver= new ChromeDriver();
		
		
		//STEP:3 give the base url
		String url="https://www.facebook.com/";
		driver.get(url);
		
		//maximise the window
		driver.manage().window().maximize();
	
		//get title of page
		System.out.println("Title:"+driver.getTitle());
		
		
		WebElement email=driver.findElement(By.id("email"));
		System.out.println(email.getAttribute("placeholder"));
		email.sendKeys("all@gmail.com");
		
		WebElement pass=driver.findElement(By.name("pass"));
		System.out.println(pass.getAttribute("placeholder"));
		pass.sendKeys("alli@123");
		
		WebElement login=driver.findElement(By.name("login"));
		login.submit();
		
		
		
		
		 

}
}