<%-- 
    Document   : signUp.jsp
    Created on : 25 dec 2018
    Author     : Parrilli Carminantonio
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sy:layout title="Symposium-Iscrizione">
	<jsp:body>
    <c:if test="${not empty emailErr}">
    <div class="callout alert" data-closable>
  <h5>L'email immessa è già in uso</h5>
  <button class="close-button" aria-label="Dismiss alert" type="button" data-close>
    <span aria-hidden="true">&times;</span>
  </button>
  </div>
    </c:if>
        <form action="GuestController?action=signUp" method="post" name="SignUpForm"  data-abide novalidate>
            <div data-abide-error class="alert callout" style="display: none;">
                <p><i class="fi-alert"></i>Ricontrolla la form</p></div>
            <div class="grid-y" style="height: 50px;"></div>
            <div class="grid-x margin-x align-center">
                <div
					class="grid small-12 medium-6 large-6 callout primary">
                    <h4>Iscriviti</h4>
                    <div>
                    <input type="text" placeholder="Nome Utente" name="username" pattern="\w{6,20}" required />
                    <span class="form-error"> Inserisci un nome utente valido</span>
                    </div>
                    <div>
                    <input type="text" placeholder="Nome" name="firstName" pattern="\w{6,20}" required />
                    <span class="form-error"> Inserisci un nome valido</span>
                    </div>
                    <div>
                    <input type="text" placeholder="Cognome"name="lastName" pattern="\w{6,20}" required />
                    <span class="form-error"> Inserisci un cognome valido</span>
                    </div>
                    <div>
                    <input type="password" placeholder="Password" name="password" pattern="\w{6,20}" required /> 
                    <span class="form-error"> Inserisci una password valida</span>
                    </div>
                    <div>
                    <input type="email" placeholder="Email Ateneo" name="email"pattern="[a-z]{1}\.[a-z]{2,20}([1-9][0-9]?)?@studenti.unisa.it" required />
                    <span class="form-error"> Inserisci una mail valida</span>
                    </div>
                    <div>
                    <input type="email" placeholder="Conferma Email Ateneo" name="confirmMail" required />
                    <span class="form-error"> Inserisci una mail valida</span>
                    </div>
                    <fieldset>
                        <legend>Corso di Laurea</legend>
                        <input type="checkbox" name="typeGrad" value="false" /><label for="typeGrad">Magistrale</label>
                    </fieldset>
                    <input type="submit" class="button large" value="Iscrivimi!" />
                </div>
            </div>
        </form>
    </jsp:body>
</sy:layout>
