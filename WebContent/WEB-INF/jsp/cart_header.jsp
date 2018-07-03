<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div align="center">
	<table class="header">
		<tr>
			<td width="160"><a href="../index/index.html">★목록</a></td>
			<td width="160"><a href="../checkout/checkout.html">★계산</a></td>
			<td width="160"><a href="../cart/cartConfirm.html">★카트확인</a></td>
			<td width="160"><a href="../cart/cartClear.html">★카트비우기</a></td>
			<td width="160">
				<c:choose>
					<c:when test="${not empty loginUser }">
						<font color="red">환영해욧<br>
							<c:out value="${loginUser.userId }"/>씨
						</font>
					</c:when>
					<c:when test="${empty loginUser }">
						<font color="red">환영해욧<br>
							<a href="../loginform/login.html">★로그인하기</a>
						</font>
					</c:when>
				</c:choose>
			</td>	
		</tr>
		
	</table>
</div>
</body>
</html>