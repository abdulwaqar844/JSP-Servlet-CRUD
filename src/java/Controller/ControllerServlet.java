
package Controller;

import dao.StudentDAO;
import dao.studentDAOimp;
import entity.Student;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import static javax.persistence.criteria.Predicate.BooleanOperator.AND;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
    StudentDAO studentDAO;

    public ControllerServlet(){
    studentDAO=new studentDAOimp();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    String action=request.getParameter("action");
    switch(action){
    case "LIST":
        list(request,response);
        break;
     case "EDIT":
        getsinglestudent(request,response);
        break;
         case "DELETE":
        deletesutdent(request,response);
        break;
     default:
        list(request,response);
        break;
    }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    String id=request.getParameter("id");
    String name=request.getParameter("name");
    String department=request.getParameter("department");
    String cellno=request.getParameter("cell");
    String dob=request.getParameter("dob");
    Student student=new Student();
    student.setId(id);
    student.setName(name);
    student.setDepartment(department);
    student.setCellno(cellno);
    student.setDob(dob);
    if(id.isEmpty()){
    studentDAO.save(student);
    request.setAttribute("message", "New Record Added Succsefuly");
    list(request ,response);
    }else
    {
    studentDAO.updatestudent(student);
    request.setAttribute("message", "Updated Succsefuly");
    list(request ,response);
    }
    }
    public void list(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
    List<Student> student = studentDAO.get();
    request.setAttribute("student", student);
    RequestDispatcher dispatcher = request.getRequestDispatcher("view/student-list.jsp");
    dispatcher.forward(request ,response);
    }
    public void save(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    }

    private void getsinglestudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String id=request.getParameter("id");
       Student student= studentDAO.get(Integer.parseInt(id));
       request.setAttribute("name", "Abdul Waqar");
       request.setAttribute("student", student);
       RequestDispatcher dispatcher = request.getRequestDispatcher("view/add-student.jsp");
       dispatcher.forward(request ,response);
    }
    private void deletesutdent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
       int id=Integer.parseInt(request.getParameter("id"));
       studentDAO.deletestudent(id);
if(studentDAO.deletestudent(id)){
    request.setAttribute("message", "Deleted Succsefuly");
    list(request ,response);
    }
    }    }