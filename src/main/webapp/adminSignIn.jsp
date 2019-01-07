<%-- 
    Document   : adminSignin
    Created on : 3 gen 2019, 15:37:29
    Author     : Symposium Group
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>

<sy:layout title="Symposium-Accesso Amministratore">
    <jsp:body>
        <c:if test="${not empty errLogAdmin}">
            <div class="callout alert" data-closable>
                <h5>Credenziali Errate</h5>
                <button class="close-button" aria-label="Dismiss alert" type="button" data-close>
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
        <form method="post" action="GuestController?action=signinAdmin" data-abide novalidate>
            <div data-abide-error class="alert callout" style="display: none;">
                <p><i class="fi-alert"></i> Username o Password non validi</p>
            </div>
            <div class="grid-y" style="height: 50px;"></div>
            <div class="grid-x margin-x align-center">
                <div class="grid small-12 medium-6 large-6 callout primary">
                    <h4>Symposium Accesso Amministratore</h4>
                    <div>
                        <input type="text" name="username" placeholder="Username" required pattern="\w{6,20}" />
                        <span class="form-error"> Inserisci un username valido</span>
                    </div>
                    <div>
                        <input type="password" name="password" placeholder="Password" required pattern="\w{6,20}" />
                        <span class="form-error"> Inserisci una password</span>
                        <input type="submit" value="Accedi" class="button" />
                    </div>
                </div>
            </div>
        </form>
    </jsp:body>
</sy:layout>