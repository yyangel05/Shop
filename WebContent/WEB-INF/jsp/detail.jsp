<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상품 상세 화면</title>
</head>
<body>

<div align="center" class="body">
	<h2>상품 상세 화면</h2>
	<table>
		<tr>
			<td><img src="img/${item.pictureUrl}"></td>
			<td align="center">
				<table>
					<tr height="50">
						<td width="80">상품명</td>
						<td width="160">${item.itemName}</td>
					</tr>	
					<tr height="50">
						<td width="80">가격</td>
						<td width="160">${item.price}원</td>
					</tr>
					<tr height="50">
						<td width="80">비고</td>
						<td width="160">${item.description}</td>
					</tr>
					<tr>
						<td colspan="2" align="center" width="240"><a href="index.html">★Goto List★</a>
					</tr>
				</table>
			</td>
		</tr>			
	</table>
</div>


</body>
</html>