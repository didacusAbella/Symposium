<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Il profilo di <%--getName(Session)--%>>">
    <jsp:body>
    <img alt="profilePage" src="https://image.flaticon.com/icons/png/128/118/118781.png<%--getProfileImage(Session)--%>"><br/><br/>
    
    <%--ifUserLogged(Session){ --%>
    
    <a href="editProfile.jsp" class="button">Modifica L'account</a>
    <a href="favorites.jsp" class="button">I tuoi preferiti salvati</a>
    <button class="button" onclick="alert('Sei Sicuro?');">Elimina L'account</button>
    
    <%--} --%>
    <dl>
    <dt>Nome:</dt><dd><%--getName(Session)--%> Test</dd>
    <dt>Cognome:</dt><dd><%--getSurname(Session)--%>McTesty</dd>
    <dt>Corso di laurea:</dt>
    <dd><%--getCollegeCourse(Session)--%>
    <input type="radio" name="collegeCourse" value="Triennale" disabled checked> Triennale<br>
	<input type="radio" name="collegeCourse" value="Magistrale" disabled> Magistrale<br>
	</dd>
    </dl>
    
    </jsp:body>
</sy:layout>