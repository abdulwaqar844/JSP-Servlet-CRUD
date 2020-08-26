<html>
    <head>
        <title>Login Page</title>
        
    </head>
    <body>
<%
    String email=(String)session.getAttribute("email");
    if(email!=null){
        response.sendRedirect("ControllerServlet?action=LIST");
    }
    String status=request.getParameter("status");
    if(status!= null){
        if(status.equals("false")){
            out.print("Incorrect Username or Password");
        }else if(status.equals("error")){
            out.print("Some Error occured");}
    }

%>
        <form action="LoginController" method="post">
            <input type="text" name="email" value="" placeholder="Enter Email" /></br>
            <input type="password" name="password" value=""  placeholder="Enter Password"/></br>
        <input type="submit" value="Login" name="login" />
        </form>
        
    </body>
    
    
    
    
</html>
