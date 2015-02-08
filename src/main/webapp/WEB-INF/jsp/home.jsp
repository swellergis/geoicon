<!doctype html>
<html>
<head>
<title>welcome</title>
<style type="text/css">
table tr:nth-child(odd) {
    background-color: rgb(20,20,30);
}
table tr:nth-child(even) {
    background-color: rgb(30,30,40);
}
table {
	width: 100%;
    border: 1px solid black;
    border-spacing: 5px;
}
th {
    border: 2px solid rgb(0,70,140);
    background-color: rgb(10,10,10);
    padding: 8px;
    text-align: left;
}
td {
    padding: 6px;
    border: 1px solid rgb(70,70,100);
}
a {
    color: silver;
}
</style>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<body>

<div>
<p>
	Sweller Geoicon Web Portal<br/>
	Version : ${version}<br/>
	Counter : ${counter}
</p>
</div>

<div>
 <table>
  <col width="20%">
  <col width="80%">
  <tr>
    <th>Web Page</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>
    	 <a href="http://boulderdem.dnsdojo.com/map/index.html">Boulder County Hillshade</a> 
    </td>
    <td>
    	<b>High-resolution hillshade for Boulder County built from USGS DEM tiles, and processed
    	using open-source image-processing libraries including GDAL in Python.</b><br/><br/>
    	<b>Web Map Server:</b> hosted on an Amazon Web Service micro instance including Apache web servers (httpd
    	and Tomcat) and UMN Mapserver.<br/>
    	<b>Web Map Client</b>: map rendered using javascript (OpenLayers, jQuery), HTML/CSS, and generated from a
    	Spring MVC framework.<br/><br/>
    	<b>To Do:</b> ** Implement RESTful web services to retrieve and display dynamically generated icons with
    	spatial attributes. ** Implement MapCache in an effort to speed up display of very large datasets.
	</td>
  </tr>
</table>
</div>

<div id="msg"></div>	
<br/>
	
</body>
</html>
