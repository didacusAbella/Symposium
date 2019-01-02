<%-- 
    Document   : error500
    Created on : 24-dic-2018, 11.38.08
    Author     : Przemyslaw Szopian
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Error500">
    <jsp:body>
        <div class="grid-x align-center callout">
        <div class="grid small-12 medium-8 large-8 callout alert">
            <h1 align="center">Questa pagina non funziona.</h1>
            <h3 align="center">esempio.com è attualmente inacessibile.</h3>
            <h4 align="center">HTTP Error 500</h4>
        </div>
    </div>
    <div class="grid-x padding-x align-center callout">
        <a href="index.jsp">
            <span class="label primary">Ricarica</span>
        </a>
    </div>
    </jsp:body>
</sy:layout>

