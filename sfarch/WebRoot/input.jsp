<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <title> 输入界面</title></head>
    <body>
	<form action="./ADT" method="post" >
	<table  align="center" bgcolor="yellow" >
	<div>
		<tr>
			<td ><input  type="text" size="50"  class="form-control" placeholder="Enter a sentence" name="search" /></td>
			<td><input type="submit" onblur="check" value="enter"/></td>
		</tr>
	</div>
   </table>
   </form>
  </body>
  </head>
</html>


