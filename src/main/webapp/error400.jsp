<%-- 
    Document   : error400
    Created on : 24-dic-2018, 11.36.27
    Author     : Przemyslaw Szopian
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Error400">
    <jsp:body>
        <div class="grid-x align-center callout">
        <div class="grid small-12 medium-8 large-8 callout alert">
            <h1 align="center">Error 400!</h1>
            <h3 align="center">BAD REQUEST!.</h3>
            <h3 align="center">Your request resulted in an error.</h3>
        </div>
    </div>
    <div class="grid-x padding-x align-center callout">
        <a href="index.jsp">
            <span class="label primary">Back to Home Page</span>
        </a>
    </div>
    </jsp:body>
</sy:layout>

