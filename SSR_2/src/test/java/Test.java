import com.thinhnee.model.DAO;
import com.thinhnee.model.UserModel;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        UserModel user = DAO.login("wiener","peter");
        System.out.println(user);
    }
}
