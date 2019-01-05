<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<sy:layout title="Symposium - Statistiche">
    <jsp:body>
        <div class="grid-x">
            <div class="grid-container">
                <form method="post" action="admin/StatsController?action=generateStats">
                    <label> inserisci anno:
                        <select name="year">
                            <option value="2018">2018</option>
                            <option value="2019">2019</option>
                        </select>
                    </label>
                    <input type="submit" value="Genera Report" class="button">
                </form>
                <sy:stats bannedUsers="${bannedUsers}" stats="${stats}">

                </sy:stats>
            </div>
        </div>
    </jsp:body>
</sy:layout>
