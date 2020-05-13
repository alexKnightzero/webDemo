#language: zh-CN

  功能: 163登录功能

    @p0
    场景: 测试正确的账号登录

      当我打开浏览器输入"https://mail.qq.com/"网址
      并且在Email文本框输入"814547334",输入密码"zq0815"
      当我点击登录
      那么我登录成功

    @p1
    场景大纲:多数据登录


      当我打开浏览器
      并且在Email文本框输入"<userName>",输入密码"<pwd>"
      当我点击登录
      那么我登录成功


      例子:
       |userName |pwd|
       |test01   |pwd01|
       |test02   |pwd02|