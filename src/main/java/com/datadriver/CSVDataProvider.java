package com.datadriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CSVDataProvider {
    public static WebDriver driver; //封装driver方法
    public static void get51Testing() throws InterruptedException {   //封装打开软件测试论坛首页的方法
        System.setProperty("webdriver.chrome.driver", "F:\\workspace\\Dagger-master\\res\\chromedriver.exe");
        String Url = "http://bbs.51testing.com/forum.php";
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public static Object [][] readCSV(String fileName) throws IOException {
        //封装读取CSV文件的的静态方法，使用绝对路径作为参数
        List<Object[]> records = new ArrayList<Object[]>();
        String record;
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        file.readLine();                           //忽略第一行
        while ((record=file.readLine())!=null){        //遍历读取文件中除第一行以外的所有行的内容
            String fields[] =  record.split(",");  //存储在名为records的ArrayList中
            records.add(fields);                    //每一个recods中存储的对象为一个String数组
        }
        file.close();  //关闭文件对象

        Object[][] results = new Object[records.size()][]; //定义函数返回值，即Object[][]
        for (int i=0; i<records.size();i++){            //将存储测试数据的List转换为一个人Object的二维数组
            results[i] = records.get(i);               //设置二维数组每行的值，每行是一个Object对象
        }
        return results;
    }

}
