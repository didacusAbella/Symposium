<%@tag description="Layout Tag for handle assets" pageEncoding="UTF-8"%>
<%@attribute name="title" type="java.lang.String" required="true" rtexprvalue="true" description="page title"%>

<!DOCTYPE html>
<html lang="it-IT" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
    <meta name="description" content="Sharing Knowledge Platform for IT Students">
    <meta name=”robot” content=”noindex,nofollow”>
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <link rel="canonical" href="http://symposium.it"/>
    <link rel="stylesheet" href="/Symposium/webjars/foundation-sites/6.5.1/dist/css/foundation.min.css"/>
    <link rel="stylesheet" href="/Symposium/webjars/foundation-icon-fonts/d596a3cfb3/foundation-icons.css"/>
    <link rel="stylesheet" href="/Symposium/webjars/jquery-tagsinput/1.3.2/jquery.tagsinput.css"/>
    <link rel="stylesheet" href="/Symposium/assets/index.css"/>
    <link rel="shortcut icon" type="image/png" href="/Symposium/assets/images/LogoSymposium.png"/>
    <script type="text/javascript" defer="true" src="/Symposium/webjars/jquery/3.3.1/dist/jquery.min.js"></script>
    <script type="text/javascript" async="true"
            src="/Symposium/webjars/what-input/5.1.1/dist/what-input.min.js"></script>
    <script type="text/javascript" defer="true"
            src="/Symposium/webjars/foundation-sites/6.5.1/dist/js/foundation.min.js"></script>
    <script type="text/javascript" defer="true"
            src="/Symposium/webjars/jquery-tagsinput/1.3.2/jquery.tagsinput.min.js"></script>
    <script type="text/javascript" defer="true" src="/Symposium/assets/index.js"></script>
    <noscript>
      <h1>Bisogna Abilitare Javascript per il corretto funzionamento del sito.</h1>
    </noscript>
  </head>
  <body>
    <%@include file="../../partials/header.jsp" %>
    <main>
      <jsp:doBody/>
    </main>
    <%@include file="../../partials/footer.jsp" %>
  </body>
</html>