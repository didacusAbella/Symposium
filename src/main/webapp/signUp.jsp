<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sy:layout title="Symposium-Iscrizione">
	<jsp:body>
        <form action="GuestController?action=signUp" method="post" data-abide novalidate>
      <div data-abide-error class="alert callout" style="display: none;">
    <p>
					<i class="fi-alert"></i> Ricontrolla la form</p>
			</div>
    <div class="grid-y" style="height: 50px;"></div>
    <div class="grid-x margin-x align-center">
      <div class="grid small-12 medium-6 large-6 callout primary">
        <h4>Iscriviti</h4>
        <input type="text" placeholder="Nome Utente" name="username" pattern="\w+{4,20}" required/>
         <span class="form-error"> Inserisci un nome utente valido</span>
         <input type="text" placeholder="Nome" name="firstName" pattern="\w+{4,20}" required/>
         <span class="form-error"> Inserisci un nome  valido</span>
         <input type="text" placeholder="Cognome" name="lastName" pattern="\w+{4,20}" required/>
         <span class="form-error"> Inserisci un cognome  valido</span>
         <input type="password" placeholder="Password" name="password" pattern="{6,20}" required/>
         <span class="form-error"> Inserisci una password valida</span>
        <input type="email" placeholder="Email Ateneo" name="email" pattern="[a-z0-9._%+-]+@studenti.unisa.it" required />
        <span class="form-error"> Inserisci una mail valida</span>
        <input type="email" placeholder="Conferma Email Ateneo" required/>
        <span class="form-error"> Inserisci una mail valida</span>
        <fieldset>
        <legend>Corso di Laurea</legend>
        <input type="checkbox" name="typeGrad" value="false"/><label for="typeGrad">Magistrale</label>
        </fieldset>
        <input type="submit" class="button large" value="Iscrivimi!" />
      </div>
    </div>
    </form>
  </jsp:body>
</sy:layout>
