<%--
   Document   : report
   Created on : 3 gen 2019, 11:21:57
   Author     : Przemyslaw Szopian, Drew.
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="report" type="it.blackhat.symposium.models.ReportModel"%>
<%@attribute name="question" type="it.blackhat.symposium.models.QuestionModel"%>

<div class="columns small-9 medium-6 large-3">
    <dl>
        <dt>Domanda:</dt>
        <dd><a href="/user/QuestionController?showQuestion&questionId=${question.id}">${question.title}</a></dd>
        <dt>Category:</dt>
        <dd>${report.category}</dd>
        <dt>Reason:</dt>
        <dd>${report.reason}</dd>
        <dt>User</dt>
        <dd>${report.userFk}</dd>
    </dl>
</div>