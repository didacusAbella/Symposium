<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sy:layout title="Symposium-Login">
    <jsp:body>
    <form action="GuestController?action=signIn" method="post" data-abide novalidate>
      <div data-abide-error class="alert callout" style="display: none;">
    <p><i class="fi-alert"></i> Ricontrolla la form</p></div>
    <c:if test="${wrongCredentials!=null}">	
			 <div class="alert callout" data-closable>
			 <i class="fa fa-warning" aria-hidden="true"></i>
			 <button class="close-button" aria-label="Close alert" type="button" data-close>
   <span aria-hidden="true">&times;</span>
 </button>
    <p>
					<i class="fi-alert"></i><strong>  ${wrongCredentials}</strong> </p>
					
			</div>
			</c:if>
    <div class="grid-y" style="height: 50px;"></div>
    
    <div class="grid-x margin-x align-center">
      <div class="grid small-12 medium-6 large-6 callout primary">
      
        <h4>Accedi</h4>
        <input type="email" placeholder="Email Ateneo" id="email" name="email" required />
        <span class="form-error"> Inserisci una mail valida</span>
        <input type="password" placeholder="Password" id="password" name="password" required />
        <span class="form-error"> Inserisci una password valida</span>
        <input type="submit" class="button large" value="Accedi" />
      
      </div>
    </div>
    </form>
  </jsp:body>
</sy:layout>
