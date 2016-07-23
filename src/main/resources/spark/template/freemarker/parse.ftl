<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

<ul style="width:10%; float:left; list-style: none;">
	<h2> Word </h2>
	<#list results as x >
		
  		<li> ${x} </li>
	</#list>
</ul>

<ul style="width:10%; float:left; list-style: none;">
	<h2> Occurences </h2>
	<#list numbers as n >
	
  		<li> : ( ${n} )</li>
	</#list>
</ul>

    <script src='http://ajax.googleapis.com/ajax/libs/prototype/1.7.1/prototype.js'></script>

        <script src="js/index.js"></script>

    
  

</body>
</html>
