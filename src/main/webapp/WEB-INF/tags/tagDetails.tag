<%-- 
    Document   : tagDetails
    Created on : 3 gen 2019, 11:12:56
    Author     : didacus
--%>

<%@tag description="Custom Tag for Question Tag" pageEncoding="UTF-8"%>
<%@attribute name="tag" type="it.blackhat.symposium.models.TagModel" required="true" rtexprvalue="true"%>
<%@attribute name="question" type="it.blackhat.symposium.models.QuestionModel" required="true" rtexprvalue="true"%>

<span class="label primary">${tag.name}</span>
<c:if test="${not empty admin}">
    <form action="admin/TagController?action=changeTag" method="POST" data-abide novalidate>
        <input type="search" placeholder="New Name Tag" name="tagName" required>
        <input type="hidden" name="questionId" value="${question.id}">
        <input type="hidden" name="tagId" value="${tag.id}">
        <button type="submit" class="button">Cambia</button>
    </form>
</c:if>

