<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α��� ȭ��</title>
</head>
<body>

<div align="center" class="body">
	<h2>�α��� ȭ��</h2>
	<form:form modelAttribute="user" method="post" action="login.html">
		<spring:hasBindErrors name="user">
			<font color="red">
				<c:forEach items="${errors.globalErrors}" var="error">
					<spring:message code="${error.code}"/>
				</c:forEach>
			</font>
		</spring:hasBindErrors>
		
		<table>
			<tr height="40px">
				<td>����ID</td>
				<td>
					<form:input path="userId" cssClass="userId" />
					<font color="red"><form:errors path="userId"/></font>
				</td>
			</tr>
			<tr height="40px">
				<td>�н�����</td>
				<td>
					<form:password path="password" cssClass="password" />
					<font color="red"><form:errors path="password"/></font>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td align="center"><input type="submit" value="�α���"></td>
				<td align="center"><input type="reset" value="����"></td>
			</tr>
		</table>
	
	</form:form>

</div>

</body>
</html>