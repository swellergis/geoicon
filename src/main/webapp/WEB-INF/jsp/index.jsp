<!doctype html>
<html>
<head>
<title>howdy</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
<script type="text/javascript" src="resources/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="resources/js/main.js"></script>
<script type="text/javascript">
// Initialize some stuff for this page as soon as it's done loading.
$(document).ready(function($) {
	$('#msg').html('populated by jQuery');
});
</script>
</head>
<body>

<h3>Message : ${message}</h3>
<h3>Counter : ${counter}</h3>
<br/>

<div id="msg"></div>	
<br/>

<div><button id="btn_run">run</button></div>
<br/>

<div><iframe id="iframe_main" src=""></iframe></div>
	
</body>
</html>
