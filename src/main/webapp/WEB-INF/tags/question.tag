<%--
  Created by IntelliJ IDEA.
  User: Przemyslaw Szopian
  Date: 21/12/2018
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="Layout Tag for handle assets" pageEncoding="UTF-8"%>
<%@attribute name="question" type="it.blackhat.symposium.models.QuestionModel" required="true" rtexprvalue="true" description="page title"%>
<%@attribute name="tags" type="it.blackhat.symposium.models.TagModel" required="true" rtexprvalue="true" description="page title"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${question.exact}">
        <div class="columns small-4 large-3 callout"><p>Ficusecc</p></div>

    </c:when>
    <c:otherwise>
        <div class="columns small-4 large-3 callout"><p>Ficusecc</p></div>

    </c:otherwise>
</c:choose>
<div class="columns small-6 large-7 callout">
    <div class="columns small-6 large-7 callout">
        <a href="">${question.title}</a>
    </div>
    <c:forEach var="tag" items="tags">
        <span class="label">${tag.name}</span>
    </c:forEach>
    <span class="label">Risposte</span>
</div>
