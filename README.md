# Simple Blog Web Application

A [JavaEE](http://www.oracle.com/technetwork/java/javaee/overview/index.html) application 
which consists of a RESTful web service and an UI. The web service is built on top of 
[Jersey](https://jersey.github.io/). The UI is a [Vue.js](https://vuejs.org/) application.

## Demo
- UI: [http://34.245.3.143:8080/simple-blog-webapp](http://34.245.3.143:8080/simple-blog-webapp)
- API: [http://34.245.3.143:8080/simple-blog-webapp/api/application.wadl](http://34.245.3.143:8080/simple-blog-webapp/api/application.wadl)
- H2 Console: [http://34.245.3.143:8080/simple-blog-webapp/console](http://34.245.3.143:8080/simple-blog-webapp/console)

## Features
- It is possible to add / edit / delete posts.
- It is possible to search posts by title, text, author name.

## Technologies
- [JavaEE](http://www.oracle.com/technetwork/java/javaee/overview/index.html)
- [Java Servlet](https://docs.oracle.com/javaee/7/tutorial/servlets.htm)
- [Jersey](https://jersey.github.io/)
- [Vue](https://vuejs.org/)
- [Vue Material](https://vuematerial.io/)
- [Hibernate](http://hibernate.org/)
- [Hibernate Search](http://hibernate.org/search/)
- [H2 Database](http://www.h2database.com/html/main.html)

## Packaging
```
$ mvn clean package
```
The package `simple-blog-webapp.war` is then available from the `./targer` directory.
