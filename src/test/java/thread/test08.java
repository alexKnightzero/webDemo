package thread;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by User on 2020/5/7.
 */
public class test08 {
    WebDriver webDriver;
    @BeforeMethod
    public  void openBroser() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\IdeaProjects\\webDemo\\driver\\chromedriver.exe");
        DesiredCapabilities desiredCapabilities=DesiredCapabilities.chrome();
        webDriver= new RemoteWebDriver(new URL("http://192.168.1.23:4444/wd/hub"),desiredCapabilities);
        webDriver.get("http://www.baidu.com");
        System.out.println("before线程" + Thread.currentThread().getId());
    }

    @DataProvider(name = "word")
    public  Object[][] word(){
        return new Object[][]{
                {"b"},
                {"c"},
                {"a"}
        };
    }

    @Test(dataProvider = "word")
    public void test(String word) throws Exception{

        webDriver.findElement(By.id("kw")).sendKeys(word);
        webDriver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        System.out.print(webDriver.getTitle());
        System.out.print("线程"+Thread.currentThread().getId());
        Assert.assertEquals(word+"_百度搜索",webDriver.getTitle());



    }

    @Test(dataProvider = "word")
    public void test2(String word) throws Exception{

        webDriver.findElement(By.id("kw")).sendKeys(word);
        webDriver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        System.out.print(webDriver.getTitle());
        System.out.print("线程"+Thread.currentThread().getId());
        Assert.assertEquals(word+"_百度搜索",webDriver.getTitle());


    }

    @Test
    public void m(){
        System.out.print("08");
        System.out.print("线程"+Thread.currentThread().getId());
    }

    @AfterMethod
    public void closeBroser(){
        webDriver.quit();
        System.out.println("after线程" + Thread.currentThread().getId());
    }
}
