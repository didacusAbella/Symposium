<%-- 
    Document   : Error404
    Created on : 23-dic-2018, 18.55.05
    Author     : Przemyslaw Szopian
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Error404">
  <jsp:body>
    <div class="grid-x align-center callout">
      <div class="grid small-12 medium-8 large-8 callout alert">
        <h1 align="center">Ooops! Error 404!</h1>
        <h3 align="center">Sembra che hai qualche problema.</h3>
        <h3 align="center">La pagina web che cerchi non esiste.</h3>
      </div>
    </div>
    <div class="grid-x padding-x align-center callout">
      <a href="index.jsp">
        <span class="label primary">Home Page</span>
      </a>
    </div>
  </jsp:body>
</sy:layout>


