<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-<%--getQuestionTitle() --%>>">
    <jsp:body>

	<!-- Viene recuperata una domanda dal database -->
        <label></label><!--Si recupera il titolo dalla domanda  -->
        <div data-abide-error class="alert callout" style="display: none;">
    <p><i class="fi-alert"></i> Ricontrolla la form</p></div>
 	<div class="grid-y" style="height: 50px;"></div>
    <div class="grid-x margin-x align-center">
      <div class="grid small-12 medium-6 large-6 callout primary">
 		<label>
 		<%--getQuestionState() --%>Aperta -Titolo<%--getQuestionTitle() --%>
 </label>
 
 
 
  <div>
  <%--getHREF() --%><a href="profile.jsp"><img alt="profilePage" src="https://image.flaticon.com/icons/png/128/118/118781.png<%--getProfileImage(Session)--%>"></a>
  <textarea disabled><%--getContententQuestion() --%></textarea>
  <%--getTags() --%>
  </div>
	</div>
    </div>
    <div class="grid-x margin-x align-center">
      <div class="grid small-12 medium-6 large-6 callout primary">
 		<label>
 		
 </label>
  <div>
  <form action="postResponse()" method="post" data-abide novalidate>
  <label>
  <textarea placeholder="Rispondi" required maxlength="65535" id="response"></textarea>
  <span class="form-error"> Devi scrivere qualcosa</span>
 </label>
  <input type="submit" value="Rispondi" class="button">
  </form>
  </div>
	</div>
    </div>
    
    </jsp:body>
</sy:layout>