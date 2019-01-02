<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--
@author ParrilliCarmiantonio
@version 1.0
@date 18/12/2018
-->

<div class="title-bar" data-responsive-toggle="example-menu" data-hide-for="large">
    <button class="menu-icon" type="button" data-toggle="example-menu"></button>
    <div class="title-bar-title">Symposium</div>
</div>

<nav class="top-bar" id="example-menu">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <li>  
                <a href="index.jsp"> 
                    <img src="./assets/images/LogoSymposium.png"style="width: 100px; height: 100px;" />
                </a>
            </li>
        </ul>
    </div>
    <div class="top-bar-right">
        <ul class="dropdown menu" data-dropdown-menu>
            <li><input type="search" placeholder="Search"></li>
            <li><button type="button" class="button">Cerca</button></li>

            <c:choose>
                <c:when test="${user!=null}">
                    <li>
                        <a href="#">${user.username}</a>
                        <ul class="menu vertical">
                            <li><a href="profile.jsp" class="primary button">Profilo</li>
                            <li><a href="myQuestions.jsp" class="button">Le mie domande</a></li>
                            <li><a href="myAnswers.jsp" class="button">Le mie Risposte</a></li>
                            <li><a href="newQuestion.jsp" class="success button">Poni una domanda!</a></li>
                            <li><a href="editProfile.jsp" class="alert button">Edit Profile</a></li>
                        </ul>
                    </li>
                    <li><a href="">Log Out</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="signIn.jsp">Sign In</a></li>
                    <li>|</li>
                    <li><a href="signUp.jsp">Sign Up</a></li>
                </c:otherwise>
            </c:choose>                     
        </ul>

    </div>
</nav>
