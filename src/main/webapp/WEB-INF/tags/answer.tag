<%-- 
    Document   : answer
    Created on : 3 gen 2019, 11:21:57
    Author     : Symposium Group
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="answer" type="it.blackhat.symposium.models.AnswerModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="card">
    <div class="card-divider">
        <strong>${answer.userFk}</strong>
    </div>
    <div class="card-section">
        <p>${answer.content}</p>
        <c:if test="${not empty user}">
            <a href="user/AnswerController?action=chooseBestAnswer" class="button hollow">Risposta Migliore</a>
        </c:if>
    </div>
</div>