<%-- 
    Document   : tagDetails
    Created on : 3 gen 2019, 11:12:56
    Author     : Symposium Group
--%>

<%@tag description="Custom Tag for Question Tag" pageEncoding="UTF-8"%>
<%@attribute name="tag" type="it.blackhat.symposium.models.TagModel" required="true" rtexprvalue="true"%>

<span class="label primary">${tag.name}</span>
<label>
    <input type="text" placeholder="New Name Tag" name="tag" pattern="[a-zA-Z]{3,20}" required value="${tag.name}">
    <span class="form-error">Il Tag deve essere minimo 3 massimmo 20 caratteri</span>
</label>
<input type="hidden" name="tagId" value="${tag.id}">

