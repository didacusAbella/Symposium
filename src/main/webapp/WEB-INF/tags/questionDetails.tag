<%-- 
    Document   : questionDetails
    Created on : 3 gen 2019, 10:53:45
    Author     : Andrea Raiola
--%>
<%@tag description="Question Details custom tag" pageEncoding="UTF-8"%>
<%@attribute name="question" type="it.blackhat.symposium.models.QuestionModel" required="true" rtexprvalue="true"%>
<%@attribute name="answers" type="java.util.List<it.blackhat.symposium.models.AnswerModel>" required="true" rtexprvalue="true"%>
<%@attribute name="tags" type="java.util.List<it.blackhat.symposium.models.TagModel>" required="true"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>

<article class="grid-x align-center">
    <div class="cell">
        <h2 class="text-center">Visualizza Domanda</h2>
    </div>
    <div class="cell large-6 medium-6 small-12 callout primary">
        <div class="card">
            <div class="card-divider">
                <strong>${question.userFk}</strong>
            </div>
            <div class="card-section">
                <h4>${question.title}</h4>
                <p>${question.content}</p>
                <c:if test="${not empty user}">
                    <c:forEach items="${tags}" var="tag">
                        <span class="label">${tag.name}</span>
                    </c:forEach>
                    <p>
                    <form action="user/QuestionController?action=addFavourite" method="POST" data-abide novalidate>
                        <input type="hidden" name="userEmail" value="${user.email}">
                        <input type="hidden" name="questionId" value="${question.id}">
                        <a href="user/AnswerController?action=showAnswerPage&questionId=${question.id}" class="button hollow">Rispondi</a>
                        <input type="submit" class="button hollow" value="Aggingi ai Preferiti">
                    </form>
                    </p>
                </c:if>
            </div>
        </div>
        <h3>Risposte:</h3>
        <c:forEach items="${answers}" var="answer">
            <sy:answer answer="${answer}"></sy:answer>
        </c:forEach>
    </div>
</article>

