<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sy:layout title="Symposium - Statistiche">
    <jsp:body>
        <c:forEach var="stats" items="${stats}">
            <sy:stats stats="${stats}" bannedUsers="${bannedUsers}"/>
        </c:forEach>
    </jsp:body>
</sy:layout>
