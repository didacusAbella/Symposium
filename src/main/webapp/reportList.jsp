<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sy:layout title="Symposium - Lista Segnalazioni">
   <jsp:body>
       <c:forEach var="report" items="${listReports}">
           <sy:report report="${report}" question="${question}"/>
       </c:forEach>
   </jsp:body>
</sy:layout>