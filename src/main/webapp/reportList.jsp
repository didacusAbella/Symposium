<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sy:layout title="Symposium - Lista Segnalazioni">
   <jsp:body>
    <div class="grid-x">
       <c:forEach var="report" items="${listReports}" varStatus="status">
           
           <div class="cell medium-6 large-4">
  				<div class="callout primary">
           <sy:report report="${report}" question="${listQuestions[status.index]}"/>
           </div>
          </div>
       </c:forEach>
       </div>
   </jsp:body>
</sy:layout>