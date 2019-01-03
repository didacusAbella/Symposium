<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Il profilo di ${user.username}">
    <jsp:body>
        <div class="grid-x margin-x align-center">
            <div class="grid small-12 medium-6 large-6 callout primary">
                <form action="user/UserController?action=showprofile" method="post"data-abide novalidate>
                    <img alt="profilePage" src="https://image.flaticon.com/icons/png/128/118/118781.png<%--getProfileImage(Session)--%>"><br/><br/>
                    <a href="editProfile.jsp" class="button">Modifica L'account</a>
                    <a href="favorites.jsp" class="button">I tuoi preferiti salvati</a>
                    <button class="button" onclick="alert('Sei Sicuro?');">Elimina L'account</button>

                    <dl>
                        <dt>Nome:</dt><dd>${user.firstName}</dd>
                        <dt>Cognome:</dt><dd>${user.lastName}</dd>
                        <dt>Corso di laurea:</dt>
                        <dd>
                            <input type="checkbox" name="typeGrad" value="false" disabled/><label for="typeGrad">Magistrale</label>
                        </dd>
                    </dl>
                </form>
            </div>    
        </div>
    </jsp:body>
</sy:layout>