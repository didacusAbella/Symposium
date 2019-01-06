<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sy:layout title="Sympsosium - Domanda">
    <jsp:body>
        <sy:questionDetails answers="${answers}" question="${question}" tags="${tags}"/>
    </jsp:body>
</sy:layout>