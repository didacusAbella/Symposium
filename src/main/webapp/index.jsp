<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>


<c:choose>
    <c:when test="${not empty user}">
        <jsp:include page="user/QuestionController?action=showQuestions"/>
    </c:when>
    <c:when test="${not empty admin}">
        <jsp:include page="admin/QuestionController?action=showQuestions"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="GuestController?action=showQuestions"/>
    </c:otherwise>
</c:choose> 
