package cake.manager.service.impl;

import cake.manager.entity.*;
import cake.manager.mapper.UserMapper;
import cake.manager.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    UserMapper mapper;
    @Transactional//可以帮助我们把事务开启、提交或者回滚的操作
    @Override
    public void register(String username, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        AuthUser user = new AuthUser(0, encoder.encode(password), username, "user");
        if (mapper.registerUser(user) <= 0)
            throw new RuntimeException("用户基本信息添加失败！");
        if (mapper.addProfile(user.getId(),"","",0,"") <= 0)
            throw new RuntimeException("用户详细信息插入失败！");
    }
    @Override
    public AuthUser findUser(HttpSession session) {
        AuthUser user = (AuthUser) session.getAttribute("user");
        if(user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = mapper.getPasswordByUsername(authentication.getName());
            session.setAttribute("user", user);
        }
        return user;
    }
    @Transactional
    @Override
    public void updateProfile(String realname, String phone, String address,int id) {
        if(mapper.upadteProfile(id,realname,phone,address)<=0)
            throw new RuntimeException("用户详细信息更改失败！");
    }
    @Transactional
    @Override
    public void recharge(double recharge, int id) {
        if(mapper.recharge(recharge,id)<=0)
            throw new RuntimeException("用户充值失败！");
    }
    @Transactional
    @Override
    public void payment(double payment, int id) {
        if(mapper.payment(payment,id)<=0)
            throw new RuntimeException("用户付款失败！");
    }
    @Override
    public List<Profile> selectProfile(int id) {
        return mapper.getProfile(id);
    }
    @Override
    public List<Cart> showCartbyuid(int uid) {
        return mapper.getCartbyUid(uid);
    }
    @Override
    public Object showTotal(int uid) {
        if(mapper.gettotal(uid)==null)
            return "";
        else
            return mapper.gettotal(uid);
    }
    @Override
    public int showproductnumber(int uid) {
        return mapper.getproductnumber(uid);
    }
    @Override
    public void createOrder(int uid, int order_number, double total) {
        mapper.createOrder(uid,order_number,total);
    }
    @Override
    public List<Order> showOrderbyuid(int uid) {
        return mapper.getOrderbyUid(uid);
    }
    @Override
    public void deleteOrderByuid(int order_id, int uid) {
        mapper.deleteOrderbyUid(order_id,uid);
    }

    @Override
    public List<User> showAlluser() {
        return mapper.findallUser();
    }

}