<%-- 
    Document   : answer
    Created on : 3 gen 2019, 11:21:57
    Author     : Symposium Group
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="answer" type="it.blackhat.symposium.models.AnswerModel"%>
<%@attribute name="found" type="java.lang.Boolean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="card">
    <div class="card-divider" style="${answer.correct ? 'background-color: #3adb76;' : 'background-color: #fff572;'}">
        <strong>${answer.userFk}</strong>
    </div>
    <div class="card-section">
        <blockquote>${answer.content}</blockquote>
        <c:if test="${not empty user && user.email != answer.userFk && !found}">
            <a href="user/AnswerController?action=chooseBestAnswer&id=${answer.id}" name="bottone" class="button hollow">Risposta Migliore</a>
        </c:if>
        <c:if test="${not empty admin}">
            <a href="admin/AnswerController?action=deleteAnswerAdmin&id=${answer.id}" class="button alert">Elimina Risposta</a>
        </c:if>
    </div>
</div>