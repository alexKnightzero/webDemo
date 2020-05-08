package testSeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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



    public void test(String word){


    }

    @AfterMethod
    public void closeBroser(){
        webDriver.quit();
    }
}
