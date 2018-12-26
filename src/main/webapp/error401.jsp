<%-- 
    Document   : error401
    Created on : 24-dic-2018, 15.22.08
    Author     : Przemyslaw Szopian
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Error404">
    <jsp:body>
        <div class="grid-x align-center callout">
        <div class="grid small-12 medium-8 large-8 callout alert">
            <h1 align="center">Error 401!</h1>
            <h3 align="center">Accesso non autorizzato!.</h3>
            <h3 align="center">Siamo spiacenti ma la tua richiesta non può essere processata.</h3>
        </div>
    </div>
    <div class="grid-x padding-x align-center callout">
        <a href="index.jsp">
            <span class="label primary">Back to Home Page</span>
        </a>
    </div>
    </jsp:body>
</sy:layout>



