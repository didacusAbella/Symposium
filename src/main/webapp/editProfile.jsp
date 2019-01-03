<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Modifica Profilo">
    <jsp:body>
        <h1 class="text-center">Modifica Profilo di ${user.username}</h1>
        <div class="grid-x margin-x align-center">
            <div class="grid small-12 medium-6 large-6 callout primary">
                <form action="user/UserController?action=editProfile" method="post"data-abide novalidate>
                    <dl>
                        <dt>Email:</dt><dd><input disabled type="email" placeholder="E-mail" id="email" name="email" value="${user.email}"required>
                        <dt>Nome:</dt><dd><input type="text" placeholder="Name" id="name" name="firstName" value="${user.firstName}"required>
                            <span class="form-error"> Inserisci un nome valido</span></dd>
                        <dt>Cognome:</dt><dd><input type="text" placeholder="LastName" id="lastname" name="lastName" value="${user.lastName}" required>
                            <span class="form-error">Inserisci un cognome valido</span></dd>
                        <dt>Password:</dt><dd><input type="text" placeholder="Password" id="password" name="password" value="${user.password}" required>
                            <span class="form-error"> Inserisci una password valida</span></dd>
                        <dt>Username:</dt><dd><input type="text" placeholder="Username" id="username" name="username" value="${user.username}"  required>
                            <span class="form-error">Inserisci un username valido </span></dd>
                        <dt>Corso di laurea:</dt>
                        <dd>
                            <input type="checkbox" name="typeGrad" value="false"/><label for="typeGrad">Magistrale</label>
                        </dd>
                        <dd>
                            <input class="button" type="submit" value="Modifica">
                        </dd>
                    </dl>
                </form>
            </div>    
        </div>
    </jsp:body>
</sy:layout>
