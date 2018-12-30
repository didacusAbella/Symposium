<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sy:layout title="Lista Admins">
  <jsp:body>
      <c:forEach var="admin" items="${admins}">
          <p>${admin.username}</p>
          <p>${admin.password}</p>
      </c:forEach>
  </jsp:body>
</sy:layout>
