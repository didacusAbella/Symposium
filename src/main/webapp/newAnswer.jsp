<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium ${question.title}">
    <div data-abide-error class="alert callout" style="display: none;">
        <p><i class="fi-alert"></i> Ricontrolla la form</p>
    </div>
    <div class="grid-y" style="height: 50px;"></div>
    <div class="grid-x margin-x align-center">
        <div class="grid small-12 medium-6 large-6 callout primary align-center">
            <h3 class="float-center">${question.title}</h3>
            <a href="user/UserController?action=showProfile"><img alt="profilePage" class="float-center"
                                                                  src="https://image.flaticon.com/icons/png/128/118/118781.png"></a>
            <p>${question.content}</p>
            <c:forEach items="${tags}" var="tag">
                <span class="label">${tag.name}</span>
            </c:forEach>
            <form action="user/AnswerController?action=insertAnswer" method="post" data-abide novalidate>
                <label>
                    <input type="hidden" id="questionID" name="questionID" value="${question.id}">
                    <textarea rows="2" required maxlength="4096" id="answerContent" name="answerContent"></textarea>
                    <span class="form-error"> Devi scrivere qualcosa</span>
                </label>
                <input type="submit" value="Rispondi" class="button" name="theNewAnswer">
            </form>

        </div>
    </div>
</sy:layout>