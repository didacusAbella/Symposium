<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="stats custom tag" pageEncoding="UTF-8" %>
<%@attribute name="stats" type="it.blackhat.symposium.models.StatsModel" %>
<%@attribute name="bannedUsers" %>
<%@attribute name="tags" type="java.util.Map<java.lang.String,java.lang.Integer>" %>

<c:choose>
    <c:when test="${empty stats}">
        <dl>
            <dt>
                <i class="fi-torsos"></i>
                Utenti Iscritti:
            </dt>
            <dd>0</dd>
            <dt>
                <i class="fi-prohibited"></i>
                Utenti Bannati
            </dt>
            <dd>0</dd>
            <dt>
                <i class="fi-pricetag-multiple"></i>
                Tag più usati:
            </dt>
            <dd>Lista Tag</dd>
            <dt>
                <i class="fi-alert"></i>
                Numero Segnalazioni
            </dt>
            <dd>0</dd>
        </dl>
    </c:when>
    <c:otherwise>
        <dl>
            <dt>
                <i class="fi-torsos"></i>
                Utenti Iscritti:
            </dt>
            <dd>${stats.numSigned}</dd>
            <dt>
                <i class="fi-prohibited"></i>
                Utenti Bannati
            </dt>
            <dd>${bannedUsers}</dd>
            <dt>
                <i class="fi-pricetag-multiple"></i>
                Tag più usati:

            </dt>
            <c:forEach items="${tags}" var="tag">
                <dd> ${tag.key}-${tag.value} </dd>
            </c:forEach>
            <dt>
                <i class="fi-alert"></i>
                Numero Segnalazioni
            </dt>
            <dd>${stats.totalReports}</dd>
        </dl>
    </c:otherwise>
</c:choose>
