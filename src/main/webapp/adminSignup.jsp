<%-- 
    Document   : adminSignup
    Created on : 3 gen 2019, 15:37:29
    Author     : didacus
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/" %>

<sy:layout title="Symposium-Admin Signup">
    <jsp:body>
        <div class="grid-x">
            <div class="grid-container">
                <form class="cell" method="post" action="GuestController?action=signinAdmin">
                    <label>Username:
                        <input type="text" name="username" placeholder="Username"/>
                    </label>
                    <label>
                        <input type="password" name="password" placeholder="Password"/>
                    </label>
                    <input type="submit" value="Accedi" class="button"/>
                </form>
            </div>
        </div>
    </jsp:body>
</sy:layout>