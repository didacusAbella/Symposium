<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sy:layout title="Symposium-Iscrizione">
    <jsp:body>
    <form action="checkSignIn.jsp" method="post" data-abide novalidate>
      <div data-abide-error class="alert callout" style="display: none;">
    <p><i class="fi-alert"></i> Ricontrolla la form</p></div>
    <div class="grid-y" style="height: 50px;"></div>
    <div class="grid-x margin-x align-center">
      <div class="grid small-12 medium-6 large-6 callout primary">
        <h4>Iscriviti</h4>
        <input type="text" placeholder="Nome Utente" id="userName" required/>
         <span class="form-error"> Inserisci un nome utente valido</span>
        <input type="email" placeholder="Email Ateneo" id="emailUser"  required/>
         <span class="form-error"> Inserisci una mail valida</span>
        <input type="email" placeholder="Conferma Email Ateneo"  required/>
         <span class="form-error"> Inserisci una mail valida</span>
        <input type="password" placeholder="Password" id="passwordUser"  required/>
         <span class="form-error"> Inserisci una password valida</span>
        <input type="password" placeholder="Conferma Password" required/>
         <span class="form-error"> Inserisci una password valida</span>
        <input type="submit" class="button large" value="Iscrivimi!" />
      
      </div>
    </div>
    </form>
  </jsp:body>
</sy:layout>