<%-- 
    Document   : favoriteQuestion
    Created on : 4-gen-2019, 10.19.19
    Author     : Giuseppe Madonna
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sy:layout title="Lista Domande">
    <jsp:body>
        <c:choose>
            <c:when test="${empty questions}">
                <h2>Non ci sono domande</h2>
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Titolo</th>
                            <th>Autore</th>
                            <th>Visualizza</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${questions}" var="question">
                            <sy:questionResearch question="${question}"></sy:questionResearch>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</sy:layout>
