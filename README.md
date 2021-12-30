# SmartCity_App
基于android移动原生开发的一个智慧城市app, 本项目中的数据全部实现云数据请求。

# 拉取代码
```
git clone https://github.com/Lydever/smartcity_app.git
```

# 技术选型
- android studio 4.0
- gradle 6.1.1
- Android SDK 30

# android studio 如何导入项目？
1. `File`--`Open`--选择本地项目地址
2. ![image](https://user-images.githubusercontent.com/65069676/142759127-93e39418-765a-4160-87dd-8c5a22caebeb.png)
3. ![image](https://user-images.githubusercontent.com/65069676/142759172-c59275fd-7f8b-48fb-afe3-35c94a7b6c70.png)
修改好后重新运行构建一下

注意：项目是以前的，里面的接口可能挂了，登陆连接后台的，如果了的话会跑不起来，不过实现的思路一致，换个接口，根据接口返回的json字段参数重新写bean实体类，在根据对应的参数数据解析即可


# 核心功能

智慧城市是一个智慧巴士，智慧医疗，智慧社区，智慧养老，智慧服务等多个便民服务理念构成。最终实现的是首页热门，巴士推荐，热门主题，新闻，智慧服务（医疗服务，城市地铁，找工作，找房子等），智慧建党，个人中心等功能模块。

该项目有完善的智慧城市各个模块的api 实现服务端数据连接，运用okhttp+gson+RecycleView+Glide等各类第三方框架，实现服务端数据的请求解析，实现启动页，引导页，登录保存返回的token值，实现注册功能。利用最新的banner2.1.0实现广告轮播图的展示。
主要实现的功能：智慧服务中门诊预约、违章查询、个人订单、智慧巴士、城市地铁等功能模块。新闻模块中可以查看各类新闻并发表评论到服务端。智慧建党模块可以展示建党风采，建党学习，建党活动，建党献策，随手拍发帖等功能，个人中心模块实现修改密码，查看个人订单，发表建议，退出登录等

# 部分效果预览
![20210528172857251](https://user-images.githubusercontent.com/65069676/127735693-167d8560-29e8-463e-95b5-1153c36dfd28.gif)
![20210528172908209](https://user-images.githubusercontent.com/65069676/127735698-5e5edfab-c99f-4c2b-89b6-4b219ad68f8b.gif)
![20210528172924794](https://user-images.githubusercontent.com/65069676/127735701-f343347c-5d32-44a6-bc96-14a24a8998fc.gif)
![2021052817304511](https://user-images.githubusercontent.com/65069676/127735705-aa82a501-026a-4ab7-a290-c7f3c2fbd79e.gif)
![20210528173226552](https://user-images.githubusercontent.com/65069676/127735714-56911a33-c363-4250-aa4c-7a8057f0fc7b.gif)
![20210528173125445](https://user-images.githubusercontent.com/65069676/127735721-381aec3a-6f95-4bb9-92f3-94fc2e9c8343.gif)


# 博客文章
这个是自己在实习期间利用空余时间更得系列博客：本系列小文是一个简单的Android app项目实战，对于刚入门Android 的初学者来说，基础学完了，但是怎么综合的去写一个小app，可能无从下手，包括我自己当初入门也是一样的，不知道怎么写。。。通过空闲更上这个案例，让零碎的基础综合起来，知道怎么去用！当然去B站看实战小案例也是可以学习到的。在这些案例之中，能实现的方法可能有很多，例如实现网络请求的框架很多，像volley、android-async-http、HttpURLConnection等等；再者搭建App基本框架的方式也有很多... 每个人实现的方式可能不一样，我就用自己思维来写了，其他，自己想怎么实现都可以。


# 涉及知识

Android UI基础控件的使用、Activity与Adapter的实践、Intent数据传递、基本事件的处理、OkHttp网络数据请求、使用Gson实现json数据的解析、通过Intent实现简单的数据传递、ViewPager+TabLayout实现引导页切换、ViewPager+TabLayout+Fragment实现App主页框架搭建、使用Banner2.1.0实现广告图片链接首页轮播、ListView+OkHttp+Gson解析新闻数据、SharedPreferences本地数据存储、RecyclerView显示App首页数据、隐式调用系统相机、相册，......等基础知识的运用，这也算是一个比较综合入门案例了。

这个小系列就完结了~ ，关于V1.0（即初版）就写到这里了，其中肯定有很多不完善的地方，但是能让入门者学习到，目的就达到了，后面有时间再完善更新，感谢~

# 文章导航


[一、【Android项目实战 | 从零开始写app(一)】 创建项目](https://blog.csdn.net/weixin_43853746/article/details/115654086)

[二、【Android项目实战 | 从零开始写app(二)】实现闪屏页，启动app](https://blog.csdn.net/weixin_43853746/article/details/115654203)

[三、【Android项目实战 | 从零开始写app(三)】实现引导页，进入登录or主页面](https://blog.csdn.net/weixin_43853746/article/details/115653249)

[四、【Android项目实战 | 从零开始写app(四)】Okhttp+Gson实现服务端登录验证功能](https://blog.csdn.net/weixin_43853746/article/details/115673426)

[五、【Android项目实战 | 从零开始写app(五)】okhttp+gson实现服务端注册功能](https://blog.csdn.net/weixin_43853746/article/details/115674496)

[六、【Android项目实战 | 从零开始写app(六)】用TabLayout+ViewPager搭建App 框架主页面底部导航栏](https://blog.csdn.net/weixin_43853746/article/details/115653683)

[七、【Android项目实战 | 从零开始写app(七)】优化主页导航栏，禁用主页页面滑动切换效果](https://blog.csdn.net/weixin_43853746/article/details/115689794)

[八、【Android项目实战 | 从零开始写app(八)】实现app首页广告轮播图切换和搜索跳转](https://blog.csdn.net/weixin_43853746/article/details/115817088)

[九、【Android项目实战 | 从零开始写app(九)】Tablayout+ViewPager实现页面分类顶部标题页面联动切换](https://blog.csdn.net/weixin_43853746/article/details/116044971)

[十、【Android项目实战 | 从零开始写app(十)】Okhttp+glide+json+ListView实现新闻模块数据的填充显示](https://blog.csdn.net/weixin_43853746/article/details/116046094)

[十一、【Android项目实战 | 从零开始写app(十一)】实现app首页智慧服务页面服务分类数据的解析及点击跳转](https://blog.csdn.net/weixin_43853746/article/details/117360629)

[十二、【Android项目实战 | 从零开始写app(十二)】实现app首页智慧服务&热门推荐&热门主题、新闻](https://blog.csdn.net/weixin_43853746/article/details/116047544)

[十三、【Android项目实战 | 从零开始写app(十三)】实现用户中心模块清除token退出登录&信息修改等功能](https://blog.csdn.net/weixin_43853746/article/details/116464047)

[十四、【Android项目实战 | 从零开始写app(十四)】实现图片发布模块 | 必知必会之调用系统相机拍照、相册](https://blog.csdn.net/weixin_43853746/article/details/117230537)

[十五、【Android项目实战 | 从零开始写app(教程汇总)】Android 项目实战系列汇总、源代码](https://blog.csdn.net/weixin_43853746/article/details/117367078)

--------
