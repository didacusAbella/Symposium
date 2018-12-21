

<!--
@author ParrilliCarmiantonio
@version 1.0
@date 18/12/2018
 -->

<nav class="top-bar">
	<div class="top-bar-left">
		<ul class="menu">
			<li><a href="index.jsp"> <img
					src="./assets/images/LogoSymposium.png"
					style="width: 100px; height: 100px;" />
			</a></li>
		</ul>
	</div>
	<div class="top-bar-right">
	<ul class="menu">
			<li>
				<form>
					<div class="input-group">
						<input class="input-group-field" type="text">
						<div class="input-group-button">
							<input type="submit" class="button" value="Submit">
						</div>
					</div>
				</form>
			</li>
			<li>
				<div class="button-group">
					<a href="myQuestions.jsp" class="button">Le mie domande</a> <a
						href="myResponses.jsp" class="button">Le mie Risposte</a> <a
						href="" class="button">I mieiTags</a>
				</div>
			</li>
			<%-- if(userIsLogged){ --%>
			<li><a href="profile.jsp"><%-- =getUserName(Session) --%>ilNomeUtenteDalProfilo</a></li>
			<%--}else{ --%>
			<li><a href="signIn.jsp">Sign In</a></li>
			<li>|</li>
			<li><a href="signUp.jsp">Sign Up</a></li>
			<%-- --%>
		</ul>

	</div>
</nav>
