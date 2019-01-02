<%-- 
    Document   : userOverview
    Created on : 2-gen-2019, 14.48.57
    Author     : SDelPiano
--%>

<%@tag description="View for tag model" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="user" type="it.blackhat.symposium.models.UserModel" required="true" rtexprvalue="true" %>
<tr> 
    <td> ${user.email} </td>
    <td> 
        <form method="post" action=""> 
            <input type="submit" value="Ban Temporaneo" class="button">
            <input type="submit" value="Ban Permanente" class="button">
        </form>
    </td>
</tr>