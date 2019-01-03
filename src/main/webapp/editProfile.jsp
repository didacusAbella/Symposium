<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Modifica Profilo">
    <jsp:body>
        <div class="grid-x margin-x align-center">
            <div class="columns small-12 medium-6 large-6 callout">
                <form action="user/UserController?action=editProfile" method="post"data-abide novalidate>

                    <div data-abide-error class="alert callout" style="display: none;">
                        <p><i class="fi-alert"></i> Ricontrolla la form</p></div>


                    <label>Nome:
                        <input type="text" placeholder="Name" id="name" name="Nome" value="${found.firstName}"required>
                        <span class="form-error"> Inserisci un nome valido</span>
                    </label>

                    <label>
                        Cognome:
                        <input type="text" placeholder="LastName" id="lastname" name="Cognome" value="${found.lastName}" required>
                        <span class="form-error">Inserisci un cognome valido</span>
                    </label>

                    <label>
                        Password:
                        <input type="text" placeholder="Password" id="password" name="Password" value="${found.password}" required>
                        <span class="form-error"> Inserisci una password valida</span>
                    </label>
                    <label>
                        Username:
                        <input type="text" placeholder="Username" id="username" name="Nome Utente" value="${found.username}"  required>
                        <span class="form-error">Inserisci un username valido </span>
                    </label>
                    
                        Corso di laurea triennale?
                    <label>
                        <input id="checkbox1" type="checkbox" value="Triennale" id="triennale" checked><label for="checkbox1">Si</label>
                        <input id="checkbox2" type="checkbox" value="Magistrale" id="magistrale"><label for="checkbox2">No</label>
                    </label>

                    <input class="button" type="submit" value="submit">
                </form>
            </div>
        </jsp:body>
    </sy:layout>