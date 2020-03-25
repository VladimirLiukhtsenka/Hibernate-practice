import com.liukhtenko.ticket.entity.StudentEntity;
import com.liukhtenko.ticket.hibernatedao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class HibernateStudentDaoTest {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
//        StudentEntity studentEntity = new StudentEntity("Samoilov");
//        studentDao.addStudent(studentEntity);
//        studentDao.removeStudent(4);
        List<StudentEntity> studentEntities;
        studentEntities = studentDao.getAllStudents();
        System.out.println(studentEntities);

    }
}
