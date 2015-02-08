<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<title>geoicon</title>
<style type="text/css">
a {
    color: rgb(100,100,100);
    font-size: small;
}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
<link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</head>
<body>

<h3>${message}</h3>

<a href="https://github.com/swellergis" style="float: right;">GitHub Project</a>
<div><button id="btn_test1">Home</button></div>
<br/>

<div style="border: 1px solid rgb(30,30,30);">
<iframe id="iframe_main" height="620" width="100%" frameborder="0" scrolling="no" src="">
Sorry, your browser doesn't support inline frames.
</iframe>
</div>

</body>
</html>
