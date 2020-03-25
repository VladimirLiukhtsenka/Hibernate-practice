import com.liukhtenko.ticket.entity.Role;
import com.liukhtenko.ticket.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TableAddition {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try (SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save( new Role(1,"Robbin"));
//            session.save( new StudentEntity("Hibernate"));
            session.getTransaction().commit();
            session.close();
        }

    }
}
