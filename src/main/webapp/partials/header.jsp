<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
@author ParrilliCarmiantonio
@version 1.0
@date 18/12/2018
-->

<nav class="top-bar" id="example-menu">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <li>
                <a href="index.jsp">
                    <img src="./assets/images/LogoSymposium.png" style="width: 100px; height: 100px;"/>
                </a>
            </li>
        </ul>
    </div>
    <div class="top-bar-right">
        <form action="GuestController?action=searchQuestionsBy" method="post" data-abide novalidate>
            <ul class="dropdown menu" data-dropdown-menu>
                <li><label>
                    <input type="search" placeholder="Cerca" name="searchBy" pattern="#[a-zA-Z]+|[a-zA-Z]+" required>
                    <span class="form-error">Il contenuto inserito non è valido!</span>
                </label></li>
                <li><input type="submit" class="button" name="search" value="Cerca"></li>
        </form>
        <c:choose>
            <c:when test="${not empty admin}">
                <li>
                    <a href="#">Sezione Amministratore</a>
                    <ul class="menu vertical">
                        <li><a href="admin/AdminController?action=showUsersAction" class="primary button">Lista
                                Utenti</a></li>
                        <li><a href="admin/AdminController?action=generateReportListAction" class="success button">Segnalazioni</a>
                        </li>
                        <li><a href="admin/StatsController?action=showStats" class="alert button">Genera Report</a></li>
                    </ul>
                </li>
                <form action="admin/AdminController?action=adminSignout" method="post" data-abide novalidate>
                    <input class="hollow button" type="submit" value="Log Out" name="LogOut">
                </form>
            </c:when>
            <c:when test="${not empty user}">
                <li>
                    <a href="#">${user.username}</a>
                    <ul class="menu vertical">
                        <li><a href="user/UserController?action=showProfile" name="profile" class="primary button">Profilo</a></li>
                        <li><a href="user/QuestionController?action=showQuestionByAuthor" class="button">Le mie domande</a></li>
                        <li><a href="user/QuestionController?action=showFavorite" class="button">Domande Preferite</a></li>
                        <li><a href="user/QuestionController?action=showNewQuestion" class="success button">Poni una
                                domanda!</a></li>
                        <li><a href="user/UserController?action=showEditProfile" class="alert button">Modifica Profilo</a></li>
                    </ul>
                </li>
                <form action="user/UserController?action=signOut" method="post" data-abide novalidate>
                    <input class="hollow button" type="submit" value="Log Out" name="LogOut">
                </form>
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
