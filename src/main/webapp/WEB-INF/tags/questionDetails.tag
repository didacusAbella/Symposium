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
            <h2>${question.title}</h2>
            <a href="user/AnswerController?action=insertAnswer&id=${question.id}" class="button">Rispondi</a>
        </div>
        <section id="tags" class="cell">
             <c:forEach items="tags" var="tag">
                <sy:tagDetails tag="${tag}"/>
            </c:forEach>
        </section>
        <section id="answers" class="cell" >
            
        </section>
    </div>
</article>

