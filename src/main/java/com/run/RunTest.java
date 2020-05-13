package com.run;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources",
        format = {"pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber-json-report.json"},
        tags = {"@p0"},
        glue = {"com.steps"}
)
/*指定cucumber.feature文件，在工程的根目录下
  命令行/控制台输出日志
  生成html测试报告
  生成json测试报告*/

 public class RunTest extends AbstractTestNGCucumberTests {

}