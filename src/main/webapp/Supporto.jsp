<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Supporto">
  <jsp:body>
   <p>Se hai riscontrato problemi, non ti è chiaro qualcosa o vuoi semplicemente 
   chiaccherare mandaci una mail:
   </p>
   <form action="SendMail.jsp" method="post">
   E-mail*:
   <input type="email" required placeholder="Email Ateneo" id="email" >
   Messaggio*:
   <textarea rows="5" cols="10" required id="messaggio" maxlength="65535"></textarea>
   <input class="button" type="submit">
   </form>
   <br/>
   <br/>
   *Campo obbligatorio
  </jsp:body>
</sy:layout>