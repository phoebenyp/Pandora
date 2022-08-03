<%@page import="web.forum.bean.ForumVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  ForumVO forumVO = (ForumVO) request.getAttribute("forumVO"); //EmpServlet.java(Concroller), 存入req的forumVO物件
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>員工資料 - ListOneEmp.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>文章編號</th>
												<th>作者</th>
												<th>標題</th>
												<th>內容</th>
												<th>發表時間</th>
												<th>次數</th>
												<th>狀態</th>
												<th>修改</th>
												<th>刪除</th>
	</tr>
	<tr>
		<td>${forumVO.postId }</td>
													<td>${forumVO.memberId }</td>
													<td>${forumVO.postTitle }</td>
													<td>${forumVO.postContent }</td>
													<td>${forumVO.postTime }</td>
													<td>${forumVO.clicks }</td>
													<td>${forumVO.status }</td>
													<td>
														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>/ForumServlet"
															style="margin-bottom: 0px;">
															<input type="submit" value="修改"> <input
																type="hidden" name="postID" value="${forumVO.postId}">
															<input type="hidden" name="action"
																value="getOne_For_Update_Forum">
														</FORM>
													</td>
													<td>
														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>/ForumServlet"
															style="margin-bottom: 0px;">
															<input type="submit" value="刪除"> <input
																type="hidden" name="postID" value="${forumVO.postId}">
															<input type="hidden" name="action" value="delete">
														</FORM>
													</td>
	</tr>
</table>

</body>
</html>