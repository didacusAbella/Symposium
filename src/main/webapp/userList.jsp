<%-- 
    Document   : userList
    Created on : 2-gen-2019, 14.32.19
    Author     : SDelPiano
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sy:layout title="lista utenti"> 
    <jsp:body> 
        <h1>Gestione Utente</h1>
        <div class="callout grid-x grid-margin-x callout">
            <c:forEach var="user" items="${listUsers}" >
                <sy:userOverview user="${user}"/>
            </c:forEach>
        </div>  
    </jsp:body>
</sy:layout>
    

