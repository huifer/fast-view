# Fast view center 
- 快速可视化中心

- fast view center client : 快速客可视化中心客户端, 用来发送配置信息到中央

- fast-view-center-core : 快速可视化核心代码
- fast-view-center-distribution : 快速可视化可视化工程 web 应用





- 作业流程

```sequence
app --> client: 
Note right of app: 应用使用fastViewClient进行配置采集.
client --> server: 发送配置信息

manager --> server: 登录管理页面
server --> manager: 可视化管理项目
manager --> server: req
server --> manager: resp


```

