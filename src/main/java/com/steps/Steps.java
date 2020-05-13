package com.steps;

import com.po.MailPo;
import cucumber.api.java.zh_cn.并且;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by User on 2020/5/9.
 */
public class Steps {
    WebDriver webDriver;

    @当("^我打开浏览器输入\"(.*?)\"网址$")
    public void open(String url){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\IdeaProjects\\webDemo\\driver\\chromedriver.exe");
        webDriver=new ChromeDriver();
        webDriver.get(url);

    }

    @并且("^在Email文本框输入\"(.*?)\",输入密码\"(.*?)\"$")
    public void login(String a,String b) throws InterruptedException {
        WebElement webElement= webDriver.findElement(MailPo.iframe);
        webDriver.switchTo().frame(webElement);
        webDriver.findElement(MailPo.user).sendKeys(a);
        webDriver.findElement(MailPo.pwd).sendKeys(b);


    }

    @当("^我点击登录$")
    public void submit() throws Throwable {
        webDriver.findElement(MailPo.bo).click();
    }


    @那么("^我登录成功$")
    public void assertTest() throws Throwable {

        System.out.print("登录成功");
    }



}
