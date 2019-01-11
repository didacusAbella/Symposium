<%@ page pageEncoding="UTF-8" language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sy:layout title="Modifica Tag">
    <jsp:body>
        <div class="grid-x">
            <div class="grid-container">
                <form action="admin/TagController?action=changeTag" method="post" data-abide novalidate>
                    <fieldset class="fieldset">
                        <legend class="legend">Cambia Tag</legend>
                        <c:forEach items="${tags}" var="tag">
                            <sy:tagDetails tag="${tag}"></sy:tagDetails>
                        </c:forEach>
                        <input type="hidden" name="questionId" value="${questionId}"/> 
                        <input type="submit" class="button" name="change" value="Cambia"/>
                    </fieldset>
                </form>
            </div>
        </div>
    </jsp:body>
</sy:layout>