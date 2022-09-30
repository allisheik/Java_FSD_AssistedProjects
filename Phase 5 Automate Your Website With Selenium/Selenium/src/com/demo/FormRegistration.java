package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormRegistration {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\SimpliLearn\\selenium drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.shine.com/registration/");
		
		WebElement name=driver.findElement(By.id("id_name"));
		name.sendKeys("alli");
		
		WebElement email=driver.findElement(By.id("id_email"));
		email.sendKeys("alli456@gmail.com");
		
		WebElement number=driver.findElement(By.id("id_cell_phone"));
		number.sendKeys("6234567890");
		
		WebElement pass=driver.findElement(By.id("id_password"));
		pass.sendKeys("Alli@123");
		
		WebElement submit=driver.findElement(By.cssSelector("#registerButton"));
		submit.click();
		
		
	}
}
