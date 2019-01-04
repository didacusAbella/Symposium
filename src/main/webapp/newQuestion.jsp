<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Da continuare -->
<sy:layout title="Symposium-Nuova Domanda">
	<jsp:body>
        <div class="grid-x">
            <div class="cell">
                <form action="user/QuestionController?action=insertQuestion" method="post">
                    <label>
                        Titolo:
                        <input type="text" placeholder="inserisci titolo" name="title">
                    </label>
                    <label>
                        Contenuto:

                        <textarea rows="10" cols="10" name="content">

                        </textarea>
                    </label>
                    <label>
                        Tags:
                        <input name="tags" class="tags" value="ESAME,2019,TSW"  id="tags_1">
                    </label>
                    <input type="submit" class="button" value="Inserisci domanda">
                </form>

            </div>

        </div>
	</jsp:body>
</sy:layout>
