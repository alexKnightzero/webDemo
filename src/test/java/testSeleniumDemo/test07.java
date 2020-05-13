package testSeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by User on 2020/5/7.
 */
public class test07 {
    WebDriver webDriver;
    @BeforeMethod
    public  void openBroser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\IdeaProjects\\webDemo\\driver\\chromedriver.exe");
        webDriver=new ChromeDriver();
    }


    @Test
    public void test(){
        webDriver.get("https://mail.qq.com/");
        webDriver.findElement(By.id("u")).sendKeys("1254687");



    }

    @AfterMethod
    public void closeBroser(){

//        webDriver.quit();
    }
}
