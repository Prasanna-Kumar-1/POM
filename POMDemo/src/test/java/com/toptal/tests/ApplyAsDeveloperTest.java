package com.toptal.tests;

import com.toptal.webpages.DeveloperApplyPage;
import com.toptal.webpages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplyAsDeveloperTest {
   WebDriver driver;

   @BeforeTest
   public void setup(){
       //use FF Driver
//	   System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");
	   System.setProperty("webdriver.chrome.driver","C:\\Work\\chromedriver.exe");
//     driver = new FirefoxDriver();
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }

   @Test
   public void applyAsDeveloper() throws InterruptedException {
       //Create object of HomePage Class
       HomePage home = new HomePage(driver);
       home.clickOnDeveloperApplyButton();

       //Create object of DeveloperApplyPage
       DeveloperApplyPage applyPage =new DeveloperApplyPage(driver);

//       //Check if page is opened
//       Assert.assertTrue(applyPage.isPageOpened());
       
	      WebElement element1 = driver.findElement(By.xpath("//div[@class='input has-default_value']"));
	      element1.click();
	      	      
	      WebElement element2 = driver.findElement(By.xpath("//div[contains(text(),'Developer')]"));
	      element2.click();
           
       //Fill up data
       applyPage.setDeveloper_email("c001@gmail.com");
       applyPage.setDeveloper_full_name("c001");
       applyPage.setDeveloper_password("password123");
       applyPage.setDeveloper_password_confirmation("password123");
       
       //Click on join
       //applyPage.clickOnJoin();
       WebElement element3 = driver.findElement(By.xpath("//span[@class='label_wrap']"));
       element3.click();
       
       WebElement element4 = driver.findElement(By.xpath("//input[@id='save_new_talent_create_applicant']"));
       element4.submit();
   }

   
//    @AfterTest
//    public void close(){
//          driver.close();
//       }
   }