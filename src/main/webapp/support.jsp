<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<sy:layout title="Symposium-Supporto">
	<jsp:body>
   <h5>Se hai riscontrato problemi, non ti è chiaro qualcosa o vuoi semplicemente 
   chiaccherare mandaci una mail:
   </h5>
   <form action="SendMail.jsp" method="post" data-abide novalidate>
   <div data-abide-error class="alert callout" style="display: none;">
    <p><i class="fi-alert"></i> Ricontrolla la form</p>
  </div>
   <label>E-mail*:
   <input type="email" required placeholder="Email Ateneo" id="email">
   <span class="form-error"> Inserisci un campo e-mail valido</span>
   </label>
   <label>
   Messaggio*:
   <textarea rows="5" cols="10" required id="messaggio" pattern="\w+{10,65535}"></textarea>
   <span class="form-error">Il messaggio deve essere inferiore di 65535 caratteri</span>
    </label>
   <input class="button" type="submit" value="Scrivici!">
   </form>
   <br/>
   <br/>
   *Campo obbligatorio
  </jsp:body>
</sy:layout>