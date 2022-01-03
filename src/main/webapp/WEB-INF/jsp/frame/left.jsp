<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <dl>
       <dt>机票管理</dt>
       <dd>
         <a href="<%=request.getContextPath()%>/ticket/toGetAll" target="main">机票查询</a>
       </dd>
       <dd>
         <a href="<%=request.getContextPath()%>/ticket/toAdd" target="main">机票新增</a>
       </dd>
     </dl>
</body>
</html>