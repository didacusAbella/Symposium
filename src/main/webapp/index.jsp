<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Benvenuto">
    <jsp:body>
        <div class="grid-x padding-3">
            <c:forEach var="question1" items="questions">
                <sy:question question="${question}" tag="${tagss}"/>                      
            </c:forEach >
        </div>
    </jsp:body>
</sy:layout>