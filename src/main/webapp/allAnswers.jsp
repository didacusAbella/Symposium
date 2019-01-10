<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sy:layout title="Symposium Lista Risposte">
    <jsp:body>
        <section class="grid-x">
            <div class="grid-container">
                <h4>Lista Risposte</h4>
                <div class="cell">
                    <table>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Utente</th>
                                <th>Azioni</th>
                            </tr>
                            <c:forEach items="${answers}" var="answer">
                                <tr>
                                    <td>${answer.id}</td>
                                    <td>${answer.userFk}</td>
                                    <td>
                                        <a href="/admin/AnswerController?action=deleteAnswerAdmin&id=${answer.id}" class="button hollow">Elimina</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </thead>
                    </table>
                </div>
            </div>
        </section>
    </jsp:body>
</sy:layout>