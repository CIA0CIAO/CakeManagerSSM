package cake.manager.service;

import cake.manager.entity.*;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AuthService {
    void register(String username,String password);
    Boolean isRegister(String username);
    AuthUser findUser(HttpSession session);
    void updateProfile(String realname,String phone,String address,int id);
    void recharge(double recharge,int id);
    void payment(double payment, int id);
    List<Profile> selectProfile(int id);
    List<Cart> showCartbyuid(int uid);
    Object showTotal(int uid);
    int showproductnumber(int uid);
    void createOrder(int uid,int order_number,double total);
    List<Order> showOrderbyuid(int uid);
    void deleteOrderByuid(int order_id,int uid);
    List<User> showAlluser();

}
