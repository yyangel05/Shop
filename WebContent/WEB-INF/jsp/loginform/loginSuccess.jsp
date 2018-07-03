<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인화면</title>
</head>
<body>

<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>

<div align="center" class="body">
	<h2>로그인화면</h2>
	환영해요 ${loginUser.userName }님~!

<a href="../index/index.html">■목록으로  </a><br>
<a href="../checkout/checkout.html">■계산하기 </a></div>
</div>

</body>
</html>