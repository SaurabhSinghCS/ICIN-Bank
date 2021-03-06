package com.icin.bank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserPortalNegativeTests {

	static String url = "http://angular-front.s3-website-us-east-1.amazonaws.com/";
	
	@Test
	public void incorrectUsernameTest() {
		
		System.out.println("starting incorrect user name test");
		// create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//sleep for 3 seconds
		sleep(3000);
		
		//maximize browser window
		driver.manage().window().maximize();
		
		// open test page
		driver.get(url);
		System.out.println("page is opened");
		
		//enter username
		WebElement username = driver.findElement(By.name("username"));
//		username.sendKeys("saursingh");
		username.sendKeys("tomsmith");
		
		//enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("simplilearn");
		
		//click login button
		WebElement loginButton = driver.findElement(By.xpath("//app-root//app-login//form/div[3]/button[@class='btn btn-primary']"));
		loginButton.click();
		sleep(2000);
		
		//verifications
		WebElement errorMessage = driver.findElement(By.xpath("//app-root//app-register//form/div[@class='col-xs-4']/h3[.='User Registration']"));
		String expectedErrorMessage = "User Registration";
		String actualErrorMessage = errorMessage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual error message does not contains expected. \nActual :"
				+actualErrorMessage+"\nExpected :"
				+expectedErrorMessage);
		
		//close browser
		driver.quit();
	}
	
	
	@Test
	public void incorrectPasswordTest() {
		
		System.out.println("starting incorrect password test");
		// create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//sleep for 3 seconds
		sleep(3000);
		
		//maximize browser window
		driver.manage().window().maximize();
		
		// open test page
		driver.get(url);
		System.out.println("page is opened");
		
		//enter username
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("saursingh");
		
		//enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("incorrectPassword");
		
		//click login button
		WebElement loginButton = driver.findElement(By.xpath("//app-root//app-login//form/div[3]/button[@class='btn btn-primary']"));
		loginButton.click();
		
		//verifications
		WebElement errorMessage = driver.findElement(By.xpath("//app-root/div[@class='container']/app-login/div/div[1]"));
		String expectedErrorMessage = "Invalid Credentials";
		String actualErrorMessage = errorMessage.getText();
		System.out.println(actualErrorMessage);
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual error message does not contains expected. \nActual :"
				+actualErrorMessage+"\nExpected :"
				+expectedErrorMessage);
		
		//close browser
		driver.quit();
	}


	@Test
	public void emptyUsernameAndPasswordTest() {
		
		System.out.println("starting incorrect user name test");
		// create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//sleep for 3 seconds
		sleep(3000);
		
		//maximize browser window
		driver.manage().window().maximize();
		
		// open test page
		driver.get(url);
		System.out.println("page is opened");
		
		//enter username
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("");
		
		//enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("");
		
		//click login button
		WebElement loginButton = driver.findElement(By.xpath("//app-root//app-login//form/div[3]/button[@class='btn btn-primary']"));
		loginButton.click();
		sleep(2000);
		
		//verifications
		WebElement errorMessage = driver.findElement(By.xpath("//app-root/div[@class='container']/app-login//div[@class='alert text-danger']"));
		String expectedErrorMessage = "All credentials are required";
		String actualErrorMessage = errorMessage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual error message does not contains expected. \nActual :"
				+actualErrorMessage+"\nExpected :"
				+expectedErrorMessage);
		
		//close browser
		driver.quit();
	}
	
	
	
	private void sleep(long m) {
		
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
