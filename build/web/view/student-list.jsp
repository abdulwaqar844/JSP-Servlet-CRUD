<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <title>Student List</title>
       
    </head>
    <body>
        <%
       String email=(String)session.getAttribute("email");
       if(email==null){
       response.sendRedirect("index.jsp");
       }
        %>
        <a href="logout.jsp"> Logout </a>
        <div >      
            <button  onclick="window.location.href='view/add-student.jsp'">Add New</button>
            <h1 >${status}</h1>

            <h1 >All Student Record</h1>
        <table border ="1" >
            <tr >
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Student Department</th>
            <th>Student Cell No</th>
            <th>Student D-O-B</th>
            <th>Action</th>
            </tr>
                
                <c:forEach items="${student}" var="student">
              <tr >
                  <td>${student.id}</td>
                  <td>${student.name}</td>
                  <td>${student.department}</td>
                  <td>${student.cellno}</td>
                  <td>${student.dob}</td>
                  <td>
                      <a href="${pageContext.request.contextPath}/ControllerServlet?action=EDIT&id=${student.id}">Edit</a>
                      ||
                      <a href="${pageContext.request.contextPath}/ControllerServlet?action=DELETE&id=${student.id}">Delete</a>

                  </td>

            </tr></c:forEach>
  
            
       
            
        </table>
        </div>
    </body>
</html>
