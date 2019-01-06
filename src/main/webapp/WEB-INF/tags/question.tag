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

<div class="columns small-6 large-7 callout">
    <div class="columns small-6 large-7 callout">
        <a href="GuestController?action=showQuestion&questionId=${question.id}">${question.title}</a>
    </div>
    <div>
    	<textarea>${question.content}</textarea>
    </div>
    <c:forEach var="tag1" items="tags">
        <span class="label">${tag.name}</span>
    </c:forEach>
</div>
