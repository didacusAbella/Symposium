<%-- 
    Document   : questionDetails
    Created on : 3 gen 2019, 10:53:45
    Author     : didacus
--%>
<%@tag description="Question Details custom tag" pageEncoding="UTF-8"%>
<%@attribute name="question" type="it.blackhat.symposium.models.QuestionModel" required="true" rtexprvalue="true"%>
<%@attribute name="answers" type="java.util.List<it.blackhat.symposium.models.AnswerModel>" required="true" rtexprvalue="true"%>
<%@attribute name="tags" type="java.util.List<it.blackhat.symposium.models.TagModel>" required="true"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>

<article class="grid-x">
    <div class="grid-container">
        <div class="cell">
            <section class="media-object">
                <div class="thumbnail">
                    <i class="fi-torso"></i>
                </div>
                <div class="media-object-section">
                    <h4>${question.title}</h4>
                    <p>${question.content}</p>
                    <c:forEach items="${tags}" var="tag">
                        <sy:tagDetails tag="${tag}"></sy:tagDetails>
                    </c:forEach>
                    <c:forEach items="${answers}" var="answer">
                        <sy:answer answer="${answer}"></sy:answer>
                    </c:forEach>
                </div>
            </section>
        </div>
    </div>
</article>

