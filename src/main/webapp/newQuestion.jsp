<%@ page pageEncoding="UTF-8" language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Da continuare -->
<sy:layout title="Symposium-Nuova Domanda">
    <jsp:body>
        <div class="grid-x align-center">
            <div class="cell large-6 medium-6 small-12">
                <form action="user/QuestionController?action=insertQuestion" method="post" accept-charset="UTF-8">

                    <fieldset class="fieldset">
                        <legend>Inserisci una nuova Domanda</legend>
                        <label>
                            Titolo:
                            <input type="text" placeholder="inserisci titolo" name="title">
                        </label>
                        <label>
                            Contenuto:
                            <textarea name="content" rows="10"></textarea>
                        </label>
                        <div class="cell">
                            <label>
                                Tags:
                                <input name="tags" class="tags" name="tags" id="tags_1">
                            </label>
                        </div>
                        <div style="margin-top: 10px;">
                            <input type="submit" class="button" value="Inserisci domanda">
                        </div> 
                    </fieldset>
                </form>
            </div>
        </div>
    </jsp:body>
</sy:layout>
