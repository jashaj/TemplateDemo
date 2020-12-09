# Template Demo

[![Build Status](https://github.com/jashaj/TemplateDemo/workflows/Java%20CI/badge.svg)](https://github.com/jashaj/TemplateDemo/actions)

This is a demo project to show the differences among several Java templating engines in Spring MVC:
  - JSP
  - Apache Freemarker
  - Thymeleaf

## Build and run
You need Java 11 and [Apache Maven 3](https://maven.apache.org) to build and run this project.
Build the project with
    
    mvn clean install

Run the project with

    mvn jetty:run

See the demo URLs:
  - http://localhost:8080/jsp
  - http://localhost:8080/freemarker
  - http://localhost:8080/thymeleaf
