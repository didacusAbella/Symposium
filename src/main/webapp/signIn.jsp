<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sy:layout title="Symposium-Login">
    <jsp:body>
    
    <c:if test="${not empty emailErr}">
    <div class="callout alert" data-closable>
  <h5>Email o password errata</h5>
  <button class="close-button" aria-label="Dismiss alert" type="button" data-close>
    <span aria-hidden="true">&times;</span>
  </button>
  </div>
    </c:if>
        <form action="GuestController?action=signIn" method="post" data-abide novalidate>
      <div data-abide-error class="alert callout" style="display: none;">
    <p><i class="fi-alert"></i> Ricontrolla la form</p></div>
    <div class="grid-y" style="height: 50px;"></div>
    
    <div class="grid-x margin-x align-center">
      <div class="grid small-12 medium-6 large-6 callout primary">
      
        <h4>Accedi</h4>
        <input type="email" placeholder="Email Ateneo" id="email" name="email" pattern="[a-z0-9._%+-]+@studenti.unisa.it" required />
        <span class="form-error"> Inserisci una mail valida</span>
        <input type="password" placeholder="Password" id="password" name="password" pattern="{6,20}" required />
        <span class="form-error"> Inserisci una password valida</span>
        <input type="submit" class="button large" value="Accedi" />
      
      </div>
    </div>
    </form>
  </jsp:body>
</sy:layout>
