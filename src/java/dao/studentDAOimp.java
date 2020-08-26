package dao;
import entity.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnectionUtil;
public class studentDAOimp implements StudentDAO{
        Connection connection=null;
        ResultSet resultset=null;
        public List<Student> list;

        @Override
        public List<Student> get(){
    try{
            list = new  ArrayList<Student>();
            String sql= "select * from student";
            connection=DBConnectionUtil.openConnection();
            Statement statement=connection.createStatement();
            resultset=statement.executeQuery(sql);
          
      while(resultset.next()){
            Student student = new Student();
            student.setId(resultset.getString("id"));
            student.setName(resultset.getString("name"));
            student.setDepartment(resultset.getString("department"));
            student.setCellno(resultset.getString("cellno"));
            student.setDob(resultset.getString("dob"));
            list.add(student);
           
      }
        }catch(Exception e){
}

    return list;
    }   

    @Override
    public boolean save(Student student) {
        boolean status=false;
            try {
                String name=student.getName();
                String department=student.getDepartment();
                String cell=student.getCellno();
                String dob=student.getDob();
                String sql="INSERT INTO `student`(`name`, `department`, `cellno`, `dob`) "
                        + "VALUES('"+name+"','"+department+"','"+cell+"','"+dob+"')";
                connection=DBConnectionUtil.openConnection();
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                status=true;
            } catch (SQLException ex) {
                Logger.getLogger(studentDAOimp.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    return status;
    }

    @Override
    public Student get(int id) {
    Student student =null;
    try{
        student =new Student();
        String sql= "select * from student where id="+id;
        connection=DBConnectionUtil.openConnection();
        Statement statement = connection.createStatement();
        resultset=statement.executeQuery(sql);
    while(resultset.next()){
        student.setId(resultset.getString("id"));
        student.setName(resultset.getString("name"));
        student.setDepartment(resultset.getString("department"));
        student.setCellno(resultset.getString("cellno"));
        student.setDob(resultset.getString("dob"));
}
}catch(SQLException ex){
    }
        return student;
    }

    @Override
    public boolean updatestudent(Student student) {
    boolean flag=false;
    
        try{
    
                String id=student.getId();
                String name=student.getName();
                String department=student.getDepartment();
                String cell=student.getCellno();
                String dob=student.getDob();
                String sql="UPDATE STUDENT SET NAME='"+name+"',Department='"+department+"',cellno='"+cell+"',dob='"+dob+"' where id="+id;
                connection=DBConnectionUtil.openConnection();
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                flag=true;
    
        }catch(SQLException e){
        e.printStackTrace();
        }
    return flag;
    }

    @Override
    public boolean deletestudent(int id) {
    boolean flag=false;
        try{
                String sql="DELETE FROM `student` WHERE id="+id;
                connection=DBConnectionUtil.openConnection();
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                flag=true;
     }catch(SQLException ex){
    ex.printStackTrace();
    }
            return flag;
    }
}