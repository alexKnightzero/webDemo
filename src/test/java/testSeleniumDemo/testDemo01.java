package testSeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by User on 2020/5/4.
 */
public class testDemo01 {
    WebDriver webDriver;
    @BeforeMethod
    public  void openBroser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\IdeaProjects\\webDemo\\driver\\chromedriver.exe");
         webDriver=new ChromeDriver();
    }

    /**
     * 点击显示模块没有display
     * @throws InterruptedException
     */
    @Test
    public void getUrl() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebDriverWait wait=new WebDriverWait(webDriver,10);
        //webDriver.manage().window().maximize();
        Actions action=new Actions(webDriver);
        WebElement div=webDriver.findElement(By.xpath("//*[@id=\"u1\"]/a[9]"));
        action.moveToElement(div).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[5]/a[1]")));
        webDriver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[5]/a[1]")).click();
//      //action.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"head_wrapper\"]/div[2]")));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tj_yingxiao")));
        //webDriver.findElement(By.name("tj_yingxiao")).click();
    }



    /**
     * 点击显示模块有display
     * @throws InterruptedException
     */
    @Test
    public void getUrl2() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        WebDriverWait wait=new WebDriverWait(webDriver,10);
        WebElement webElement= webDriver.findElement(By.name("tj_briicon"));
        Actions actions=new Actions(webDriver);
        actions.moveToElement(webElement).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"head_wrapper\"]/div[2]/div/div[2]/div[1]/div/a[3]/span")));
        webDriver.findElement(By.xpath("//*[@id=\"head_wrapper\"]/div[2]/div/div[2]/div[1]/div/a[3]/span")).click();
        String title=webDriver.getTitle();
        Assert.assertEquals(title,"百度图片-发现多彩世界");
        webDriver.getWindowHandles();
        String currentHand=webDriver.getWindowHandle();
        System.out.print(currentHand);
        webDriver.switchTo().window(currentHand);
        //Assert.assertTrue(flag);
//        Actions action=new Actions(webDriver);
//        WebElement div=webDriver.findElement(By.xpath("//*[@id=\"u1\"]/a[9]"));
//        action.moveToElement(div).perform();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/div[5]/a[1]")));

    }



    @AfterMethod
    public void closeBroser(){
         webDriver.quit();
    }
}
