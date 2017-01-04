# JobScheduler

支持集群的任务调度框架。

开发目的：

1. 现在工作中用到 Quartz，缺少一个 Quartz 监控的 dashboard，参考美团：[Quartz应用与集群原理分析](http://tech.meituan.com/mt-crm-quartz.html) 的 Quartz 的 dashboard。
2. 研究 Quartz 中好像发现一个 bug，使用别人的东西不好改，虽然不影响使用，但是比较不舒服。
3. 参考 Quartz 的实现，后期做一个减法，提供一个只支持核心的定时任务功能的骨架，以后用到就在这个骨架基础上二次开发，而不是用现成的 Quartz。

# 第一步

- 主要目的：依赖现有的 Quartz，提供 DashBoard。
- 设计：
  - 后端：springboot + mybatis + mysql。
  - 前端：nodejs + swig。

使用前后端，主要是考虑以后可以换后端，或者换前端。  

如下图：

Trigger查看：

![trigger](http://7xrzlm.com1.z0.glb.clouddn.com/quartdashboardTrigger.png)	
Job查看：

![job](http://7xrzlm.com1.z0.glb.clouddn.com/quartdashboardJon.png)

### 启动方式

在启动 mysql 数据库后：

#### 后端启动

1. 进入 bkjava 目录， `mvn clean install` 编译出 jar 包（在 boot/target 目录下）。
2. 进入 boot/target 目录， `java -jar boot-1.0-SNAPSHOT.jar &` 即可启动成功。

#### 前端启动

1. 进入 fnodejs 目录。 `node app.js &` 即可启动成功。

#### 相关配置

1. 后端端口配置在 /bkjava/boot/src/main/resources/application.yml 文件，默认为 6314 端口。
2. 前端端口配置在 /fnodejs/commons/constant/ServerConstant.js，默认为 7000端口。

#### 访问

`http://ip:port/quartz` 默认为：`http://localhost:7000/quartz`



# 第二步

对 Quartz 做一些删减，或者参考其实现，自己改进实现。




