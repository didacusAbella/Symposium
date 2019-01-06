<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${not empty user}">
        <c:redirect url="user/QuestionController?action=showQuestions"/>
    </c:when>
    <c:when test="${not empty admin}">
        <c:redirect url="admin/QuestionController?action=showQuestions"/>
    </c:when>
    <c:otherwise>
        <c:redirect url="GuestController?action=showQuestions"/>
    </c:otherwise>
</c:choose>