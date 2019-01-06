<%-- 
    Document   : userList
    Created on : 2-gen-2019, 14.32.19
    Author     : SDelPiano
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<sy:layout title="Symposium - Lista Utenti"> 
    <jsp:body> 
        <h1>Gestione Utente</h1>
        <div class="callout grid-x grid-margin-x callout">
            <c:forEach var="user" items="${listUsers}" >
            
            <div class="callout primary">
               <div class="grid-3 grid-padding-10">
                <sy:userOverview user="${user}"/>
               </div>
             </div>
            </c:forEach>
        </div>  
    </jsp:body>
</sy:layout>
    

