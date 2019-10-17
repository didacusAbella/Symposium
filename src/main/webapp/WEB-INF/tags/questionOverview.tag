<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Question Overview" pageEncoding="UTF-8"%>
<%@attribute name="question" type="it.blackhat.symposium.models.QuestionModel"%>

<tr>
  <td>${question.id}</td>
  <td>${question.title}</td>
  <td>${question.userFk}</td>

  <c:if test="${not empty admin}">
    <td>
      <a href="/admin/QuestionController?action=deleteQuestion&questionId=${question.id}" class="button" name="delete1">
        Elimina Domanda
      </a>
    </td>
  </c:if>
  <c:if test="${question.userFk == email}">
    <td>
      <a href="/user/QuestionController?action=deleteQuestion&questionId=${question.id}" class="button" name="delete2">
        Elimina Domanda
      </a>
    </td>
  </c:if>
  <td>
    <a href="/user/QuestionController?action=reportQuestion&questionId=${question.id}" class="button">
      Segnala Domanda
    </a>
  </td>

</tr>