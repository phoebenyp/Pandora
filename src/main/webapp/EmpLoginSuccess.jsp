<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
   <h1>email:${email1}</h1>
   <h1>password:${password1}</h1>
<h1>${empVO.englishFirstName} 登入成功</h1>

<h1>${requestScope.empVO.englishFirstName} 登入成功</h1>

<h1>${empVO.englishFirstName}&nbsp:${empVO.englishFirstName} 登入成功</h1>
</body>
</html>