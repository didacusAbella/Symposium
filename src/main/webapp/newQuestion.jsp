<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Da continuare -->
<sy:layout title="Symposium-Nuova Domanda">
	<jsp:body>
    <form action="InsertQuestionAction.java" method="post" data-abide novalidate>
    <div data-abide-error class="alert callout" style="display: none;">
    <p><i class="fi-alert"></i> Ricontrolla la form</p></div>
 	<div class="grid-y" style="height: 50px;"></div>
    <div class="grid-x margin-x align-center">
      <div class="grid small-12 medium-6 large-6 callout primary">
 		<label>
 		Titolo:
 <input type="text" required maxlength="20" id="title" name="title">
 <span class="form-error"> Inserisci un titolo per la domanda</span>
 </label>
  <label>
  Contenuto:
  <textarea required maxlength="65535" id="question" name="question" rows="5"></textarea>
  <span class="form-error"> Scrivi qualcosa nel box </span>
  </label>
  <label>
  Tags:
  <!-- Aggiungere l'input -->
  <%--Aggiungere plugin Jquery per i tags --%>
  <span class="form-error"> Inserisci almeno un tag</span>
  </label>
  <input type="submit" class="button" value="Posta!">
	</div>
    </div>
		</form>
    
	</jsp:body>
</sy:layout>
