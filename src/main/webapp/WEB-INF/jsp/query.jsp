<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
</head>
<body>
  <form id="form">
    start city<input type="text" name="startCity"><br>
    company<select name = "companyId" id="companies"></select><br>
    start date<input type="date" name="startDateLeft">~<input type="date" name="startDateRight"><br>
    <input type="button" value="查询" onclick="query(1)"><input type="reset">
    <a href="<%=request.getContextPath()%>/ticket/toAdd">add a ticket</a>
    <input type="hidden" name="currentPage" id="currentPage">
    <input type="hidden" name="pageSize" id="pageSize">
    <input type="hidden" name="totalRowNum" id="totalRowNum">
  </form>
  <div id="display"></div>

</body>
<script type="text/javascript">
  //页面加载事件
  $(function () {
    init();
    query(1);
  })

  function init() {
    $.ajax({
      url: "<%=request.getContextPath()%>/company/getAll",
      type: "get",
      dataType: "json",
      success: function (data) {
        var str=" <option value='-1'>请选择</option>";
			  for(var i=0;i<data.length;i++){
				  str+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
			  }
        $("#companies").html(str)
      },
      error: function () {
        window.alert("查询失败");
      }
    })
  }

  function query(page) {
    $("#currentPage").val(page);
    $("#totalRowNum").val(200);
    $("#pageSize").val(10);
    $.ajax({
      url: "<%=request.getContextPath()%>/ticket/getAll",
      type: "post",
      dataType: "html",
      data: $("#form").serialize(),
      success: function (data) {
        $("#display").html(data);
      },
      error: function () {
        window.alert("查询失败");
      }
    })
  }
</script>

</html>