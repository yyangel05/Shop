<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/jsp_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>카트 확인하기 화면</title>
</head>
<body>

<%@ include file="/WEB-INF/jsp/cart_header.jsp"%>

<div align="center" class="body">
	<h2>카트 확인하기 화면</h2>
	<div class="cart">
		<table style="font-size:  10pt;">
			<tr>
				<td colspan="2"><font color="green">카트에는 다음 상품이 들어있습니다</font>
			</tr>
			
			<c:forEach items="${cart.itemList }" var="itemSet">
				<tr>
					<td>${itemSet.item.itemName} </td>
					<td>${itemSet.quantity} </td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br/>
	
	${message} <br>
	<br>
	<a href="../index/index.html">■목록으로</a><br>
	<a href="../checkout/checkout.html">■계산하러</a>

</div>

</body>
</html>