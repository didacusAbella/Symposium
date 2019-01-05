<%@tag description="stats custom tag" pageEncoding="UTF-8"%>
<%@attribute name="stats" type="it.blackhat.symposium.models.StatsModel"%>
<%@attribute name="bannedUsers" %>
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
                    <dd>Lista Tag</dd>
                    <dt>
                        <i class="fi-alert"></i>
                        Numero Segnalazioni
                    </dt>
                    <dd>${stats.totalReports}</dd>
                </dl>