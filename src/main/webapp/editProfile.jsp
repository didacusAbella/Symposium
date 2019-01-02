<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Modifica Profilo">
    <jsp:body>
    
    <form action="EditAccount" method="post"data-abide novalidate>
    
    <div data-abide-error class="alert callout" style="display: none;">
    <p><i class="fi-alert"></i> Ricontrolla la form</p></div>
   
  
  
   <label>Nome:<%--getName(Session)--%>
   <input type="text" required pattern="\w+{4,20}" id="name" name="firstName">
    <span class="form-error"> Inserisci un nome valido</span> <%--value=getNomeFromDatabase()--%>
   </label>
   
   <label>
   Cognome:<%--getSurname(Session)--%>
   <input type="text" required pattern="\w+{4,20}" id="surname" name="lastName" ><%--value=getCognomeFromDatabase()--%>
   <span class="form-error">Inserisci un cognome valido</span>
   </label>
   
   <label>
   Password:<%--getPassword(Session)--%>
   <input type="password" pattern="{6,20}" required id="password" name="password"><%--value=getPasswordFromDatabase()--%>
   <span class="form-error"> Inserisci una password valida</span>
   </label>
   <label>
   Username:<%--getUsername(Session)--%>
   <input type="text"  required id="username" name="username" pattern="{4,20}"><%--value=getUsernameFromDatabase()--%>
   <span class="form-error">Inserisci un username valido </span>
    </label>
   Corso di laurea:
     <%--getCollegeCourse(Session)--%>
     <label>
    <input type="radio" name="collegeCourse" value="Triennale" id="triennale" checked> Triennale<br>
	<input type="radio" name="collegeCourse" value="Magistrale" id="magistrale"> Magistrale<br>
	</label>
   
    <input class="button" type="submit" value="Salva le modifiche">
   </form>
  
    
	</jsp:body>
</sy:layout>