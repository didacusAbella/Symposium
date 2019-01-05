<%-- 
    Document   : questionResearch
    Created on : 4-gen-2019, 10.40.31
    Author     : Giuseppe Madonna
--%>

<%@tag description="Question Overview" pageEncoding="UTF-8"%>
<%@attribute name="question" type="it.blackhat.symposium.models.QuestionModel"%>

<tr>
    <td>${question.id}</td>
    <td>${question.title}</td>
    <td>${question.content}</td>
    <td>
        <a href="GuestController?action=showQuestion&questionId=${question.id}" class="button">
            Visualizza
        </a>
    </td>
</tr>