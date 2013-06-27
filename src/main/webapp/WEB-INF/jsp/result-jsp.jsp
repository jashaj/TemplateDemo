<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jspf" %>
<body>
<div class=container-fluid>
  <%@ include file="pageTitle.jspf" %>

  <dl class=dl-horizontal>
    <dt><spring:message code="example.name"/></dt>
    <dd><c:out value="${form.name}"/></dd>
    <dt><spring:message code="example.email"/></dt>
    <dd><c:out value="${form.email}"/></dd>
    <dt><spring:message code="example.word"/></dt>
    <dd><c:out value="${form.word}"/></dd>
  </dl>
</div>
<%@ include file="scripts.jspf" %>
</body>
</html>