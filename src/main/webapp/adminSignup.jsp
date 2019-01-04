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
            <div class="grid-container align-center">
                <div class="cell large-6 medium-6 small-12">
                    <form method="post" action="GuestController?action=signinAdmin" data-abide no-validate>
                        <div data-abide-error class="alert callout" style="display: none;">
                            <p><i class="fi-alert"></i>Username o Password non validi</p>
                        </div>
                        <fieldset class="fieldset">
                            <legend>Symposium AdminSignup</legend>
                            <label>Username:
                                <input type="text" name="username" placeholder="Username" required="true" pattern="\w+{6,20}"/>
                            </label>
                            <label>
                                <input type="password" name="password" placeholder="Password" required="true" pattern="\w+{6,20}"/>
                            </label>
                            <input type="submit" value="Accedi" class="button"/>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</sy:layout>