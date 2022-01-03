<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <title>add a student</title>
    <script src=https://code.jquery.com/jquery-3.6.0.min.js></script>
</head>

<body>
    <form id="form" action="<%=request.getContextPath()%>/ticket/add" method="post" onsubmit="return check()">
        start city<input type="text" id="startCity" name="startCity"><span id="span0" style="color:red"></span><br>
        end city<input type="text" id="endCity" name="endCity"><span id="span1" style="color:red"></span><br>
        berth:<input type="radio" name="berth" value="1">economy class<input type="radio" name="berth" value="2">first class<br>
        start date<input type="date" name="startDate" required><br>
        company<select name="company.id" id="companies" onChange="addCompany()"></select><span id="span2"></span><br>
        <input type="submit" value="submit">
    </form>
</body>
<script type="text/javascript">
    $(function () {
        init();
    })

    function init() {
        $.ajax({
            url: "<%=request.getContextPath()%>/company/getAll",
            type: "get",
            dataType: "json",
            success: function (data) {
                var str = " <option value='-1'>请选择</option>";
                for (var i = 0; i < data.length; i++) {
                    str += "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                }
                str += "<option value=\"-2\">add a new company</option>"
                $("#companies").html(str)
            },
            error: function () {
                window.alert("查询失败");
            }
        })
    }

    function addCompany() {
        if ($("#companies").val()=="-2"){
            $("#span2").html("<input type=\"text\" name=\"company.name\"><input type=\"text\" name=\"company.password\">")
        }
    }

    function check(){
        if ($("#startCity").val()==null ||
            $("#startCity").val()=="" 
        ){
            $("#span0").html("start city is required")
            return false
        }

        if ($("#endCity").val()==null ||
            $("#endCity").val()=="" 
        ){
            $("#span1").html("end city is required")
            return false
        }

        return true
    }
</script>

</html>