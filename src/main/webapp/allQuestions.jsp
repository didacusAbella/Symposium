<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sy:layout title="Symposium-Benvenuto">
    <jsp:body>
        <h3 class="text-center">Domande Top</h3>
        <div class="grid-x padding-3 align-center">
            <div class="callout cell large-8 medium-8 small-12 primary" id="allQuestions">
                <sy:question questionTags="${questionTags}"></sy:question>
            </div>
        </div>
    </jsp:body>
</sy:layout>