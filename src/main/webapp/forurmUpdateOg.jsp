

<%@page import="web.forum.bean.ForumVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  ForumVO forumVO = (ForumVO) request.getAttribute("forumVO"); //ForumServlet.java (Concroller) 存入req的forumVO物件 (包括幫忙取出的forumVO, 也包括輸入資料錯誤時的forumVO物件)
%>
<%= forumVO==null %>--${forumVO.postId}--

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>員工資料修改 - update_emp_input.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>


</head>


<body>

<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>員工資料修改 - update_emp_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/ForumServlet" >
<table>
	<tr>
		<td>文章編號:<font color=red><b>*</b></font></td>
		<td><%=forumVO.getPostId()%></td>
	</tr>
	<tr>
		<td>作者:</td>
		<td><input type="TEXT" name="memberId" size="45" value="<%=forumVO.getMemberId()%>" /></td>
	</tr>
	<tr>
		<td>標題:</td>
		<td><input type="TEXT" name="postTitle" size="45"	value="<%=forumVO.getPostTitle()%>" /></td>
	</tr>
	<tr>
		<td>內容:</td>
		<td><input type="TEXT" name="postContent" size="45"	value="<%=forumVO.getPostContent()%>" /></td>
	</tr>
	<tr>
		<td>時間:</td>
		<td><input type="TEXT" name="postTime" size="45"	value="<%=forumVO.getPostTime()%>" /></td>
	</tr>
	<tr>
		<td>次數:</td>
		<td><input type="TEXT" name="clicks" size="45"	value="<%=forumVO.getClicks()%>" /></td>
	</tr>
	<tr>
		<td>狀態:</td>
		<td><input type="TEXT" name="status" size="45"	value="<%=forumVO.getStatus()%>" /></td>
	</tr>
	

<%-- 	<jsp:useBean id="forumSvc" scope="page" class="web.forum.service.impl.ForumServiceImpl" /> --%>
<!-- 	<tr> -->
<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="postId"> -->
<%-- 			<c:forEach var="forumVO" items="${forumSvc.all}"> --%>
<%-- 				<option value="${forumVO.postId}" ${(forumVO.postId==forumVO.postId)?'selected':'' } >${forumVO.dname} --%>
<!-- 			</c:forEach> -->
<!-- 		</select></td> -->
<!-- 	</tr> -->

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="empno" value="<%=forumVO.getPostId()%>">
<input type="submit" value="送出修改"></FORM>
</body>



</html>