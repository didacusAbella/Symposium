<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sy:layout title="Symposium-Iscrizione">
	<jsp:body>
    <form action="SignUp" method="post" data-abide novalidate>
      <div data-abide-error class="alert callout" style="display: none;">
    <p>
					<i class="fi-alert"></i> Ricontrolla la form</p>
			</div>
    <div class="grid-y" style="height: 50px;"></div>
    <div class="grid-x margin-x align-center">
      <div class="grid small-12 medium-6 large-6 callout primary">
        <h4>Iscriviti</h4>
        <input type="text" placeholder="Nome Utente" name="username" required/>
         <span class="form-error"> Inserisci un nome utente valido</span>
         <input type="text" placeholder="Nome" name="firstname" required/>
         <span class="form-error"> Inserisci un nome utente valido</span>
         <input type="text" placeholder="Cognome" name="lastname" required/>
         <span class="form-error"> Inserisci un nome utente valido</span>
         <input type="password" placeholder="Password" name="password" required/>
         <span class="form-error"> Inserisci una password valida</span>
        <input type="email" placeholder="Email Ateneo" name="email" required />
        <span class="form-error"> Inserisci una mail valida</span>
        <input type="email" placeholder="Conferma Email Ateneo" required/>
         <span class="form-error"> Inserisci una mail valida</span>
        <input type="radio" name="typeGrad" value="triennale" checked required>Triennale<br/>
		<input type="radio" name="typeGrad" value="magistrale" required>Magistrale<br/>
		
        <input type="submit" class="button large" value="Iscrivimi!" />
      
      </div>
    </div>
    </form>
  </jsp:body>
</sy:layout>
