<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Il profilo di ${user.username}">
  <jsp:body>
    <div class="grid-x margin-x align-center">
      <div class="grid small-12 medium-6 large-6 callout primary">
        <span><i class="fi-torso" style="font-size: 80px"></i></span>
        <div class="cell">
          <a href="user/UserController?action=showEditProfile" class="button">Modifica L'account</a>
          <a href="favorites.jsp" class="button">I tuoi preferiti salvati</a>
          <a href="user/UserController?action=deleteAccount" name="delete" class="button">Elimina Account</a>
        </div>
        <dl>
          <dt>Nome:</dt>
          <dd>${user.firstName}</dd>
          <dt>Cognome:</dt>
          <dd>${user.lastName}</dd>
          <dt>Corso di laurea:</dt>
          <dd>
            <c:choose>
              <c:when test="${user.typeGrad}">
                <input type="checkbox" id="typeGrad" name="chkTypeGrad" value="${user.typeGrad}" checked
                       disabled>
                <label for="typeGrad">Magistrale</label>
              </c:when>
              <c:otherwise>
                <input type="checkbox" id="typeGrad" name="chkTypeGrad" value="${user.typeGrad}"
                       disabled>
                <label for="typeGrad">Magistrale</label>
              </c:otherwise>
            </c:choose>
          </dd>
        </dl>
      </div>
    </div>
  </jsp:body>
</sy:layout>