package dao;
import entity.Student;
import java.util.List;

public interface StudentDAO {

public List<Student> get();
boolean save(Student student);
Student  get(int id);
boolean updatestudent(Student student);
boolean deletestudent(int id);
}


