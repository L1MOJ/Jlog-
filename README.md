# Jlog-
Blog based on java, springboot,mp
# Springboot练习-简单的个人博客

## 项目概述

我采用的是前后端分离的开发方法

设置允许跨域访问

![image-20221217154345867](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217154345867.png)



### 前端

- Vue2
- Element UI
- Vue Router
- Mockjs

![image-20221217154432757](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217154432757.png)



### 后端

- Springboot
- MybatisPlus
- Mysql
- Swagger

![image-20221217154519950](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217154519950.png)

#### 接口文档

![image-20221217175744102](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217175744102.png)





## 基本功能

### 精选文章

精选文章在主页和侧边栏展示

![image-20221217182718997](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217182718997.png)

![image-20221217183005352](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217183005352.png)

### 最新文章

按文章发布时间排序，取最近发布的五篇文章展示在侧边栏

![image-20221217183026785](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217183026785.png)

### 全部文章

点击我的博客，显示全部文章并分页

![image-20221217182857515](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217182857515.png)



![image-20221217183206719](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217183206719.png)

![image-20221217183123303](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217183123303.png)

查询所有文章时会判断接收到的categoryId参数，若指定了则分类查询

#### 分类查找

点击右侧按钮分类查找，文章的类名和创建日期显示在右上角

![image-20221217183243860](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217183243860.png)

![image-20221217183300704](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217183300704.png)

得到文章所有分类名显示在左侧

### 文章详情

引入mavonEditor支持markdown格式显示

![image-20221217183817646](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217183817646.png)

![image-20221217183903627](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217183903627.png)



### 赞赏页

一开始练手分页查询做的，没什么实际功能

![image-20221217184021528](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217184021528.png)

### 文章管理-登录

考虑到做前后台两个界面工作量有点大，所以只做了一个简单的文章管理页面，目前只支持管理员账号登录，不提供注册，没有cookie保存，所以每次都要重新登陆，就当是为了保证文章的安全性吧

***用户名：limoj 密码：111***

#### 登录

##### 取消登录

点击取消会自动跳回到主页面

##### 密码错误

![image-20221217184253511](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217184253511.png)

![image-20221217190341501](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217190341501.png)

#### 文章管理

![image-20221217184414155](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217184414155.png)

##### 根据关键字模糊查询

![image-20221217184437490](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217184437490.png)

跟查询所有文章用的是同一个接口，传入了用户输入的关键词参数content

##### 文章删除

勾选checkbox再点击上方垃圾桶按钮

##### 文章精选

勾选后点击上方五角星按钮，已被精选的文章会被取消精选，而未被精选的文章会被精选

##### 文章编辑

可以进行文章内容的修改，也可以增加原来不存在的文章类别（重复增加会报错）

![image-20221217185402671](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217185402671.png)

![image-20221217185421250](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217185421250.png)

##### 新增文章

与编辑文章类似，必须输入文章标题、类名以及创建时间才可以提交

![image-20221217185505201](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217185505201.png)

##### 文章分享

![image-20221217190104902](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217190104902.png)

点击下载并分享按钮后会弹出下载按钮，点击会自动下载文字的txt格式，包括文字标题、概述以及正文

![image-20221217190148849](C:\Users\MSI-NB\AppData\Roaming\Typora\typora-user-images\image-20221217190148849.png)





## 心得体会

第一次独立完成类似全栈开发的大作业，在实现过程中通过上课、网上搜索了解和接触了许多新的知识点，对web开发、前端、后端、数据库等概念和技术有了更深刻的理解和认识，也掌握了一定的开发能力。在做的过程中也碰到了不少问题和困难，大多都通过网上搜索解决了，收获颇丰。
