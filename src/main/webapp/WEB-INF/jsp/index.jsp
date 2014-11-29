<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<title>geoicon</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
<link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</head>
<body>

<h3>${message}</h3>
<br/>

<div><button id="btn_test1">test1</button></div>
<br/>
<div><button id="btn_test2">test2</button></div>
<br/>

<div><iframe id="iframe_main" src=""></iframe></div>
	
</body>
</html>
