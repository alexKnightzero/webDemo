package testSeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import po.loginPo;

import java.util.List;
import java.util.Objects;

/**
 * Created by User on 2020/5/5.
 */
public class testDemo02 {
    WebDriver webDriver;
    @BeforeMethod
    public  void openBroser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\IdeaProjects\\webDemo\\driver\\chromedriver.exe");
        webDriver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(webDriver,10);
    }

    @DataProvider(name = "user")
    public Object[][] user(){
        return new Object[][]{
                {"17600578157","zq123546"},
                {"17600578157","zq123545"},
                {"17600578153","zq123545"},
        };
    }

    @Test(dataProvider ="user" )
    public void login(String user,String psw) throws InterruptedException {
        webDriver.get("https://www.imooc.com/user/setprofile");
        webDriver.findElement(loginPo.email).sendKeys(user);
        webDriver.findElement(loginPo.password).sendKeys(psw);
        webDriver.findElement(loginPo.submitButtom).click();
        Thread.sleep(5000);
        String string=webDriver.findElement(By.className("js-edit-info")).getText();
        System.out.print(string);
        Assert.assertEquals(string,"编辑");

//        webDriver.findElement(By.xpath("//*[@id=\"setting-profile\"]/div[2]/a")).click();
//        WebElement element=webDriver.findElement(By.xpath("/html/body/div[9]/div"));
//        System.out.print("这个" + element.getText());
//        //List<WebElement> elementList= element.findElements(By.tagName("option"));
//        Select select=new Select(element.findElement(By.id("job")));
//        //System.out.print("输出"+select.getFirstSelectedOption().getText());
//        select.selectByIndex(8);
//        Select selectPro= new Select(element.findElement(By.id("province-select")));
//        selectPro.selectByValue("17");
//        Thread.sleep(200);
//        Select  selectCity=new Select(element.findElement(By.id("city-select")));
//        selectCity.selectByValue("171");


    }
    @Test
    public void mouseTest(){


    }


    @AfterMethod
    public void closeBroser(){
        webDriver.quit();
    }

}
