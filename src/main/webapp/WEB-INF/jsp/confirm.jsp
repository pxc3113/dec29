<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>回访</title>
    </head>
    <body>
        <form action="http://localhost:8080/students/update" method="post">
            name
            <input type="text" name="name">
            <br>
            phone
            <input type="text"  name="phone">
            <br>
            <input type="button" value="Add student" onclick="check('${id}','${phone}')">   
        </form>
    </body>
    <script type="text/javascript">
        function check(id,phone) {
            if (document.getElementsByName("phone")[0]!=phone){
                return false;
            } else {
                location.href="http://localhost:8080/students/update/id="+id+"&phone="+phone;
            }
        }
        
    </script>
</html>