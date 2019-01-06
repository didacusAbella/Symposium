<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sy:layout title="Lista Domande">
	<jsp:body>
        <c:choose>
            <c:when test="${empty questions}">
                <h2>Non ci sono domande</h2>
            </c:when>
            <c:otherwise>
            <div class="grid-x">
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Titolo</th>
                            <th>Autore</th>
                            <th>Azioni</th>
                        </tr>
                    </thead>
                    <tbody>
                     
                        <c:forEach items="${questions}" var="question">
                        <div class="cell medium-6 large-4">
  							<div class="callout primary">
                            <sy:questionOverview question="${question}"></sy:questionOverview>
                            </div>
                            </div>
                        </c:forEach>
                        
                    </tbody>
                </table>
                </div>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</sy:layout>