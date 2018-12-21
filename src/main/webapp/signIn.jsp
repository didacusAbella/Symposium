<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<sy:layout title="SignIn - Symposium">
  <jsp:body>

    <div class="grid-y" style="height: 50px;"></div>
    <div class="grid-x margin-x align-center">
      <div class="grid small-12 medium-6 large-6 callout primary">
        <h4>Subscribe Nooooow</h4>
        <input type="text" placeholder="Nome Utente" />
        <input type="email" placeholder="Email Ateneo" />
        <input type="email" placeholder="Email Ateneo" />
        <input type="text" placeholder="Password" />
        <input type="text" placeholder="Conferma Password" />
        <input type="button secondary" class="button large" value="Iscriviti" />
      </div>
    </div>
  </jsp:body>
</sy:layout>