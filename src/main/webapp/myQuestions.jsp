<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<sy:layout title="Symposium-Benvenuto">
  <jsp:body>
    <%--While(getQuestionsUser(Session)){ --%>

    <div class="grid-y" style="height: 50px;"></div>
    <div class="grid-x margin-x align-center">
      <div class="grid small-100 medium-100 large-100 callout primary">
        <%--getQuestionState() --%>
        <h2 class="float-center">
          <a href="#"<%--getQuestionThread() --%>>Risolta - Esercitazioni esame basi di dati?</a>
        </h2>
        <%--getQuestionTitle() --%>
        <%--getHREF() --%>
        <a href="profile.jsp"><img class="float-center"
                                   alt="profilePage"
                                   src="https://image.flaticon.com/icons/png/128/118/118781.png<%--getProfileImage(Session)--%>"></a>
        <div class="float-center">
          <%--checkIfSolved() --%>
          <div class="float-left">
            <i class="fi-check"></i>
          </div>
          <textarea class="float-right" disabled rows="" cols="">Qualcuno può dirmi dove posso trovare delle esercitazioni per basi di dati?</textarea>
        </div>
      </div>
    </div>

    <div class="grid-y" style="height: 50px;"></div>
    <div class="grid-x margin-x align-center">
      <div class="grid small-100 medium-100 large-100 callout primary">
        <%--getQuestionState() --%>
        <h2 class="float-center">
          <a href="#"<%--getQuestionThread() --%>>Aperta - Ufficio professore mobile computing?</a>
        </h2>
        <%--getQuestionTitle() --%>
        <%--getHREF() --%>
        <a href="profile.jsp"><img class="float-center"
                                   alt="profilePage"
                                   src="https://image.flaticon.com/icons/png/128/118/118781.png<%--getProfileImage(Session)--%>"></a>
        <div class="float-center">
          <%--checkIfSolved() --%>
          <div class="float-left">
            <i class="fi-wrench"></i>
          </div>
          <textarea class="float-right" disabled rows="" cols="">Dove si trova l'ufficio del professore di mobile computing?</textarea>
        </div>
      </div>
    </div>

    <%--} --%>
  </jsp:body>
</sy:layout>