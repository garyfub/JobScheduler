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

# 第二步

对 Quartz 做一些删减，或者参考其实现，自己改进实现。




