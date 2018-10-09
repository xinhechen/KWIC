<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <title> 输入界面</title></head>
    <body>
	<form action="./ADT" method="post" >
	<table  align="center" bgcolor="yellow" >
	<div>
		<tr>
			<td ><input  type="text" size="50"  class="form-control" placeholder="please enter a sentence" name="search" /></td>
			<td><input type="submit" onblur="check" value="enter"/></td>
		</tr>
	</div>
	</table>
	<table>
	<div>
		<c:set var="alloutputlist" value="${sessionScope.output}"/>
		<c:if test="${empty alloutputlist}"></c:if>
		<c:if test="${!empty alloutputlist}">
			<c:forEach var="onelist" varStatus="status" items="${alloutputlist}" ><!-- 因为List里面是有还有一个list所有这里是取出第一组list -->
				
				<c:set var="circleindex" value="${status.index}"/>
				<c:if test="${circleindex=='0'}">
					Circular Shifted:<br>
					<c:forEach var="onevalue" items="${onelist}"><!-- 这里用List里面第二个list -->
						<tr>
							<c:if test="${!empty onevalue}">
								<li><font color="blue">${onevalue}</font></li><br>
							</c:if>	
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${circleindex=='1'}">
					Alphabetized:<br>
					<c:forEach var="onevalue" items="${onelist}"><!-- 这里用List里面第二个list -->
						<tr>
							<c:if test="${!empty onevalue}">
								<li><font color="black">${onevalue}</font></li><br>
							</c:if>	
						</tr>
					</c:forEach>
				</c:if>
			</c:forEach>
		</c:if>			
	</div>
   </table>
   </form>
  </body>
  </head>
</html>


