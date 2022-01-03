<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <title>View tickets</title>
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <td>id</td>
                <td>start city</td>
                <td>end city</td>
                <td>berth</td>
                <td>start date</td>
                <td>company</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${page.list}" var="ticket">
                <tr>
                    <td>${ticket.id}</td>
                    <td>${ticket.startCity}</td>
                    <td>${ticket.endCity}</td>
                    <td>${ticket.berth}</td>
                    <td>${ticket.startDate}</td>
                    <td>${ticket.company.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <input type="button" value="first" onClick="query(1)">
    <input type="button" value="previous" onClick="query('${page.currentPage-1}')">
    <input type="button" value="jump to" onClick="query($('#jumpTo').val())">
    <input type="text" value="${page.currentPage}" id="jumpTo">
    <input type="button" value="next" onClick="query('${page.currentPage+1}')">
    <input type="button" value="last" onClick="query('${page.pageSize}')">
  
</body>
<script type="text/javascript">
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
    function next() {

    }
    function previous() {

    }
    //删除
    function delUser(userid) {
        if (confirm("你确定删除吗？")) {
            $.ajax({
                url: "<%=request.getContextPath()%>/user/delUser.do",
                type: "post",
                data: {
                    "userid": userid
                },
                success: function () {
                    location.reload();
                },
                error: function () {
                    alert("删除失败");
                }
            })
        }
    }

    //修改前的回填
    function toUpdateUser(userid) {
        location.href = "<%=request.getContextPath()%>/user/toUpdateUser.do?userid=" + userid;
    }

    //全选
    function checkAll() {
        $("input[name='userid']").prop("checked", $("#check").prop("checked"))
    }

    //批量删除
    function delsUser() {
        var ids = "";
        $("input[name='userid']:checked").each(function () {
            ids += "," + $(this).val();
        })
        if (ids != null && ids != "") {
            $.ajax({
                url: "<%=request.getContextPath()%>/user/delsUser.do",
                type: "post",
                data: {
                    "ids": ids.substring(1)
                },
                success: function () {
                    location.reload();
                },
                error: function () {
                    alert("删除失败");
                }
            })
        } else {
            alert("请选择要删除的项");
        }
    }
</script>

</html>