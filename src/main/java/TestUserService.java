import com.liukhtenko.ticket.entity.User;
import com.liukhtenko.ticket.exception.DaoException;
import com.liukhtenko.ticket.pool.CustomConnectionPool;
import com.liukhtenko.ticket.service.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class TestUserService {
    static Logger logger = LogManager.getLogger();
    
    public static void main(String[] args) throws DaoException {
        logger.log(Level.DEBUG, "Impossible to establish AutoCommit to value false!!!!!!!!!");

        UserService userService = new UserService();
        List<User> list = userService.findAllUsers();
        System.out.println(list);
//        User user = userService.findUserById( 2L);
//        System.out.println(user);
//        User user = userService.findUserByMailAndPassword("vl@gmail.com","cvbdf");
//        System.out.println(user.getMail()==null);


//        int i = 1;
//        for (Connection freeConnection : CustomConnectionPool.INSTANCE.freeConnections) {
//            System.out.println(i++);
//        }
//         User user = new User(8,"375293457634","Виталий","Борунов","Владимирович", (byte) 1,"cvbdf","vl@gmail.com",2);

//        User user1 = new User(1, "375259864732", "Игнат", "Жук", "Васильевич", (byte) 1, "lkjik2f", "Ign@gmail.com", 2);
//        System.out.println(user1);
//        System.out.println(user1.getId());
//        userService.createUser(user1);
//        System.out.println(user1.getId());
//        userService.updateUser(user);

    }

}
