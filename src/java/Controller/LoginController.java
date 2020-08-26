/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import dao.LoginDAO;
import dao.LoginDAOimp;
import entity.login;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginController extends HttpServlet {
LoginDAO loginDAO =null;

    public LoginController() {
        loginDAO =new LoginDAOimp();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    HttpSession session = request.getSession();
        login lg=new login();
        lg.setEmail(request.getParameter("email"));
        lg.setPassword(request.getParameter("password"));
        String status = loginDAO.loginvalid(lg);
        
        if(status.equals("true")){
            session.setAttribute("email", lg.getEmail());
            response.sendRedirect("ControllerServlet?action=LIST");
}
        else{
            response.sendRedirect("index.jsp?status=false");


}
    
    }

}
