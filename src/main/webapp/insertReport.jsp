<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>

<sy:layout title="Segnala Domanda">
    <div class="grid-x">
        <div class="cell small-12 medium-6 large-6">
            <form method="post" action="user/ReportController?action=">
                <fieldset class="fieldset">
                    <legend>Segnala Domanda</legend>
                    <label>
                        Categoria:
                        <input type="text" name="category" placeholder="Inserisci una categoria">
                    </label>
                    <label>Motivazione:
                        <textarea name="reason" placeholder="Inserisci Motivazione"></textarea>
                    </label>
                    <input type="hidden" name="userFk" value="${user.email}"/>
                    <input type="hidden" name="questionFk" value="${questionId}"/>
                    <input type="submit" value="Segnala"/>
                </fieldset>
            </form>
        </div>
    </div>
</sy:layout>