<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter New Record</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/logout.jsp"> Logout </a>
<%
       String email=(String)session.getAttribute("email");
       if(email==null){
       response.sendRedirect("index.jsp");
       }
        %>
        <h1> Enter details of Student</h1>

        <div class="container">
            <form action="${pageContext.request.contextPath}/ControllerServlet" method="post" >
            <table  class="table table-striped table-bordered">
                
                <tbody>
                    <tr>
                        <td>Student Name</td>
                        <td><input type="text" name="name" value="${student.name}" /></td>
                    </tr>
                    <tr>
                        <td>Student Department</td>
                        <td><input type="text" name="department" value="${student.department}" /></td>
                    </tr>
                    <tr>
                        <td>Student Cell No</td>
                        <td><input type="text" name="cell" value="${student.cellno}" /></td>
                    </tr>
                    <tr>
                        <td>Student D-O-B</td>
                        <td><input type="date" name="dob" value="${student.dob}" /></td>
                    </tr>
                </tbody>
                
            </table>
            <input type="submit" value="Submit" name="submit" />
            <input type="hidden" name="id" value="${student.id}">
        </form>
        </div>
    </body>
</html>
