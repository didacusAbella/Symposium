<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<sy:layout title="Symposium - Statistiche">
    <jsp:body>
        <div class="grid-x grid-margin-x">
            <form method="post" action="admin/StatsController?action=generateStats" class="cell large-4 medium-4 small-12">
               <h2>Symposium Generazione Report</h2>
                <label> Inserisci anno:
                    <select name="year">
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                    </select>
                </label>
                <input type="submit" name="report" value="Genera Report" class="button">
            </form>
            <div class="cell auto">
                <sy:stats bannedUsers="${bannedUsers}" stats="${stats}" tags="${tags}"/>
            </div>
        </div>
    </jsp:body>
</sy:layout>
