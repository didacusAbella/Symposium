<%-- 
    Document   : questionOverview
    Created on : 3 gen 2019, 17:36:27
    Author     : didacus
--%>

<%@tag description="Question Overview" pageEncoding="UTF-8"%>
<%@attribute name="question" type="it.blackhat.symposium.models.QuestionModel"%>

<tr>
    <td>${question.id}</td>
    <td>${question.title}</td>
    <td>${question.userFk}</td>
    <td>
        <a href="/admin/QuestionController?action=deleteQuestion&questionId=${question.id}" class="button">
            Elimina Domanda
        </a>
    </td>
</tr>