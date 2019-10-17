<%-- 
    Document   : searchResult
    Created on : 3-gen-2019, 12.47.06
    Author     : Giuseppe Madonna
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/" %>
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
              <th>Contenuto</th>
              <th>Azioni</th>
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
