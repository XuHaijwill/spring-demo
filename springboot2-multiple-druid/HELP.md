# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.13/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.13/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.13/reference/htmlsingle/#using.devtools)
*  [springboot 整合mybatis plus，使用druid 切换多数据源实现单数据库事务，附赠项目源码地址](https://blog.csdn.net/liyanlei5858/article/details/131535462)


### 测试方法
##### 使用idea的Tools-->HTTP Client-->Test RestFul web Service
测试数据如下
```

### 添加学生
POST http://localhost:8080/ssm/student/add
Content-Type: application/json

{"name": "韩立","age": "25","classname": "1班"}

### 添加学生
POST http://localhost:8080/ssm/student/add
Content-Type: application/json

{"name": "萧炎","age": "24","classname": "1班"}

### 添加老师
POST http://localhost:8080/ssm/teacher/add
Content-Type: application/json

{"name": "萧薰儿","age": "985","subject": "历史"}

### 添加老师
POST http://localhost:8080/ssm/teacher/add
Content-Type: application/json

{"name": "银月","age": "211","subject": "政治"}

### 查询老师
GET http://localhost:8080/ssm/teacher/list
Accept: application/json

### 查询学生
GET http://localhost:8080/ssm/student/list
Accept: application/json
###

```

##### 使用Postman



##### 使用 swagger
<a href="http://localhost:8080/ssm/swagger-ui.html" target="_blank">http://localhost:8080/ssm/swagger-ui.html</a>