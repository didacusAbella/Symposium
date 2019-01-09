<%-- 
    Document   : userOverview
    Created on : 2-gen-2019, 14.48.57
    Author     : SDelPiano 
--%>

<%@tag description="View for tag model" pageEncoding="UTF-8" %>
<%@attribute name="user" type="it.blackhat.symposium.models.UserModel" required="true" rtexprvalue="true" %>
<form method="post" action="admin/UserController?action=banUser" name="userForm">
    <div class="columns small-9 medium-6 large-3">
        <dl>
            <dt>Utente:</dt>
            <dd>${user.email}</dd>
            <dt>Ban:</dt>
            <dd>
                <input type="hidden" name="email" value="${user.email}"/>
                <input type="radio" name="typeBan1" value="false" id="false"><label for="false">Ban Temporaneo</label>
                <input type="radio" name="typeBan2" value="true" id="true"><label for="true">Ban Permanente</label>
                <input type="submit" class="button tiny" value="Conferma"/>
            </dd>
        </dl>
    </div>
</form>


