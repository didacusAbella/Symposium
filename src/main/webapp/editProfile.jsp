<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Modifica Profilo">
    <jsp:body>
    
    <form action="GuestController?action=editprofile" method="post"data-abide novalidate>
    
    <div data-abide-error class="alert callout" style="display: none;">
    <p><i class="fi-alert"></i> Ricontrolla la form</p></div>
   
  
  
   <label>Nome:
   <input type="firstname" placeholder="Name" id="name" name="name" value="${found.firstName}"required>
    <span class="form-error"> Inserisci un nome valido</span>
   </label>
   
   <label>
   Cognome:<%--getSurname(Session)--%>
   <input type="lastname" placeholder="LastName" id="lastname" name="lastname" value="${found.lastName}" required>
   <span class="form-error">Inserisci un cognome valido</span>
   </label>
   
   <label>
   Password:<%--getPassword(Session)--%>
   <input type="password" placeholder="Password" id="password" name="password" value="${found.password}" required>
   <span class="form-error"> Inserisci una password valida</span>
   </label>
   <label>
   Username:
   <input type="username" placeholder="Username" id="username" name="username" value="${found.username}"  required><
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