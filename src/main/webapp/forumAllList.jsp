<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="web.forum.service.impl.ForumServiceImpl"%>
<%@page import="web.forum.bean.ForumVO"%>

<%
    ForumServiceImpl forumSvc = new ForumServiceImpl();
    List<ForumVO> list = forumSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>