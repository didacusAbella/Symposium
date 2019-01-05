<%-- 
    Document   : tagDetails
    Created on : 3 gen 2019, 11:12:56
    Author     : didacus
--%>

<%@tag description="Custom Tag for Question Tag" pageEncoding="UTF-8"%>
<%@attribute name="tag" type="it.blackhat.symposium.models.TagModel" required="true" rtexprvalue="true"%>

<span class="label primary">${tag.name}</span>

