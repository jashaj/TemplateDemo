<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jspf" %>
<body>
<div class=container-fluid>
  <%@ include file="pageTitle.jspf" %>
  <forms:form action="/jsp" method="post" cssClass="form-horizontal" modelAttribute="form">

    <div class=control-group>
      <forms:label path="name" cssClass="control-label"><spring:message code="example.name"/></forms:label>
      <div class=controls>
        <form:input path="name" cssClass="input-xlarge"/>
      </div>
    </div>
    <div class=control-group>
      <forms:label path="email" cssClass="control-label"><spring:message code="example.email"/></forms:label>
      <div class=controls>
        <spring:message code="example.email.placeholder" var="emailPlaceholder"/>
        <forms:input path="email" type="email" cssClass="input-xlarge" placeholder="${emailPlaceholder}"/>
      </div>
    </div>
    <div class=control-group>
      <forms:label path="word" cssClass="control-label"><spring:message code="example.pick-word"/></forms:label>
      <div class=controls>
        <forms:select path="word" items="${words}"/>
      </div>
    </div>
    <div class=control-group>
      <div class=controls>
        <spring:message code="example.submit" var="submitValue"/>
        <input type=submit class="btn btn-primary" value=${submitValue}>
      </div>
    </div>
  </forms:form>
</div>
<%@ include file="scripts.jspf" %>
</body>
</html>