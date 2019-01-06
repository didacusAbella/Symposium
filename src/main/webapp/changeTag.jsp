<%-- 
    Document   : changeTag
    Created on : 3-gen-2019, 14.35.14
    Author     : Giuseppe Madonna
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sy:layout title="Sympsosium - Domanda">
    <jsp:body>
        <form action="admin/TagController?action=changeTag" method="POST" data-abide novalidate>
            <input type="search" placeholder="New Name Tag" name="tagName" required>
            <input type="hidden" name="tagId" value="${tag.id}">
            <button type="submit" class="button">Cambia</button>
        </form>
    </jsp:body>
</sy:layout>