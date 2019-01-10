<%-- 
    Document   : questionDetails
    Created on : 3 gen 2019, 10:53:45
    Author     : Andrea Raiola
--%>
<%@tag description="Question Details custom tag" pageEncoding="UTF-8" %>
<%@attribute name="question" type="it.blackhat.symposium.models.QuestionModel" required="true" rtexprvalue="true" %>
<%@attribute name="answers" type="java.util.List<it.blackhat.symposium.models.AnswerModel>" required="true"
             rtexprvalue="true" %>
<%@attribute name="tags" type="java.util.List<it.blackhat.symposium.models.TagModel>" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/" %>

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
                <c:forEach items="${tags}" var="tag">
                    <span class="label">${tag.name}</span>
                </c:forEach>
                    <p style="margin-top:10px;">
                    <c:choose>
                        <c:when test="${not empty user}">
                            <a href="user/AnswerController?action=showAnswerPage&questionId=${question.id}" 
                               class="button hollow">Rispondi</a>
                            <c:choose>
                                <c:when test="${question.userFk == user.email}">
                                    <a href="user/QuestionController?action=deleteQuestion&questionId=${question.id}" class="button alert" 
                                       name="buttonDeleteUser">Elimina</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="user/QuestionController?action=addFavourite&questionId=${question.id}&userEmail=${user.email}" 
                                       name="Favorites" class="button alert" name="buttonDeleteUser">Aggiungi ai Preferiti</a>
                                </c:otherwise>
                            </c:choose>     
                        </c:when>
                        <c:when test="${not empty admin}">
                            <a href="admin/QuestionController?action=deleteQuestion&questionId=${question.id}"
                               class="button alert" name="buttonDelete">Elimina</a>
                            <a href="admin/TagController?action=showEditTag&questionId=${question.id}" class="button alert" name="changeTag">Modifica Tag</a>
                        </c:when>
                    </c:choose>
                </p>
            </div>
        </div>
        <h3>Risposte:</h3>
        <c:set var="found" value="false"/>
        <c:forEach items="${answers}" var="answer">
            <c:if test="${answer.correct}">
                <c:set var="found" value="true"/>
            </c:if>
        </c:forEach>
        <c:forEach items="${answers}" var="item">
            <sy:answer answer="${item}" found="${found}"></sy:answer>
        </c:forEach>
    </div>
</article>

