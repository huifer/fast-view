# 接入指南-redis
## SpringBoot
### 默认配置

```yaml

server:
  port: 8132
logging:
  level:
    com.github.huifer: debug


spring:
  redis:
    database: 1
    port: 6379
    host: 127.0.0.1
fast:
  view:
    username: 1
    password: 1
```
访问地址: 
    - localhost:8132/redis/login.html
    


### 自定义 配置项

```yaml
server:
  port: 8132
  servlet:
    context-path: /a
logging:
  level:
    com.github.huifer: debug


spring:
  redis:
    database: 1
    port: 6379
    host: 127.0.0.1
fast:
  view:
    redis:
      urlMapping: /rd/*
    username: 1
    password: 1
```

访问地址: 
    - localhost:8132/a/rd/login.html
    