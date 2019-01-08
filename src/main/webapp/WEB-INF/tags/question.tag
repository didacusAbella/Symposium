<%--
  Created by IntelliJ IDEA.
  User: Przemyslaw Szopian
  Date: 21/12/2018
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="Layout Tag for handle assets" pageEncoding="UTF-8"%>
<%@attribute name="questionTags" type="java.util.List<it.blackhat.symposium.helpers.QuestionTag>" 
             required="true" rtexprvalue="true" description="list of questions"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${questionTags}" var="questionTag">
    <div class="media-object">
        <div class="media-object-section">
            <div>
                <p><i class="fi-torso"></i></p>
                <h5>${questioTag.question.userFk}</h5>
            </div>
        </div>
        <div class="media-object-section">
            <h4>
                <c:choose>
                    <c:when test="${not empty user}">
                        <a href="user/QuestionController?action=showQuestion&questionId=${questionTag.question.id}">
                            ${questionTag.question.title}
                        </a>
                    </c:when>
                    <c:when test="${not empty admin}">
                        <a href="admin/QuestionController?action=showQuestion&questionId=${questionTag.question.id}">
                            ${questionTag.question.title}
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a href="GuestController?action=showQuestion&questionId=${questionTag.question.id}">
                            ${questionTag.question.title}
                        </a>
                    </c:otherwise>
                </c:choose>
            </h4>
            <p>${questionTag.question.content}</p>
            <h5>${questionTag.question.lastUpdate}</h5>
            <c:forEach items="${questionTag.tags}" var="tag">
                <span class="label">${tag.name}</span>
            </c:forEach>
        </div>
    </div>
</c:forEach>
