<!--
@author ParrilliCarmiantonio
@version 1.0
@date 18/12/2018
 -->
<head>
<link rel="stylesheet" href="headerCSS.css">
</head>
<body>
  <a href="index.jsp"><img alt="symposium" src="LogoSymposium.png" id="HomeShortHeader"></a>
  <div id="ricEfavHeader">
  <form action="cerca.jsp">
  <input type="text" placeholder="cerca">
  <input type="submit" value="cerca" >
  </form>
  <button id="Domande" onclick="location.href = 'Domande.jsp';">Le mie Domande</button>
  <button id="Risposte" onclick="location.href = 'Risposte.jsp';">Le mie Risposte</button>
  <button id="Tag" onclick="location.href = 'Tags.jsp';">I miei Tag</button>
  </div>
  
  <div id="loginHeader">
  <a href="SignIn.jsp">Sign In</a>
  |
  <a href="SignUp.jsp">Sign Up</a>
  </div>
  <br>
  <hr>
</body>
