import com.liukhtenko.ticket.entity.StudentEntity;
import com.liukhtenko.ticket.hibernatedao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class HibernateTest {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        List<StudentEntity> studentEntities = new ArrayList<>();
        studentEntities = studentDao.getAllStudents();
        System.out.println(studentEntities);
    }
}
