<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="stats custom tag" pageEncoding="UTF-8" %>
<%@attribute name="stats" type="it.blackhat.symposium.models.StatsModel" %>
<%@attribute name="bannedUsers" %>
<%@attribute name="tags" type="java.util.Map<java.lang.String, java.lang.Integer>" %>

<c:choose>
    <c:when test="${empty stats}">
        <h2>Nessun Report Generato</h2>
        <h3 class="subheader">Per farlo seleziona l'anno per generare il report desiderato</h3>
    </c:when>
    <c:otherwise>
        <h2>Report Anno: ${stats.year}</h2>
        <dl>
            <dt><i class="fi-torsos"></i> Utenti Iscritti:</dt>
            <dd><span class="badge">${stats.numSigned}</span></dd>
            <dt><i class="fi-prohibited"></i> Utenti Bannati:</dt>
            <dd><span class="badge">${bannedUsers}</span></dd>
            <dt><i class="fi-pricetag-multiple"></i> Tag più usati:</dt>
            <dd>
                <table>
                    <thead>
                        <tr>
                            <th>Nome Tag</th>
                            <th>Uso</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${tags}" var="tag">
                            <tr>
                                <td><span class="label">${tag.key}</span></td>
                                <td><span class="badge">${tag.value}</span></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </dd>
            <dt><i class="fi-alert"></i> Numero Segnalazioni:</dt>
            <dd><span class="badge">${stats.totalReports}</span></dd>
        </dl>
    </c:otherwise>
</c:choose>
