package cake.manager.mapper;

import cake.manager.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from users where name = #{name}")
    AuthUser getPasswordByUsername(String name);
    @Select("select `name` from users where `name`=#{name}")
    String isRegister(@Param("name") String name);
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Insert("insert into users(name, role, password) values(#{name}, #{role}, #{password})")
    int registerUser(AuthUser user);
    @Insert("insert into profile(id, realname,phone, money,address) value(#{id},#{realname},#{phone},#{money},#{address})")
    int addProfile(@Param("id")int id,@Param("realname")String realname,@Param("phone")String phone,@Param("money")int money,@Param("address")String address);
    @Update("update profile SET money = money + #{recharge} WHERE id= #{id}")
    int recharge(@Param("recharge")double recharge,@Param("id")int id);//增加uid对应的金额
    @Update("update profile SET money = money - #{payment} WHERE id= #{id}")
    int payment(@Param("payment")double payment,@Param("id")int id);//减掉uid对应的金额
    @Update("update profile SET realname=#{realname},phone=#{phone},address=#{address} where id=#{id}")
    int upadteProfile(@Param("id")int id,@Param("realname")String realname,@Param("phone")String phone,@Param("address")String address);//更新uid对应的个人信息
    @Select("select * from profile where id=#{id}")
    List<Profile> getProfile(@Param("id")int id);//获取uid对应的个人信息
    @Insert("insert into `order`(uid, order_number, total, time) value(#{uid},#{order_number},#{total},NOW())")
    int createOrder(@Param("uid")int uid,@Param("order_number")int order_number,@Param("total")double total);//创建uid对应的order订单
    @Results({
            @Result(column = "pid", property = "pid"),
            @Result(column = "pname", property = "pname"),
            @Result(column = "price", property = "price"),
            @Result(column = "count", property = "count"),
            @Result(column = "allprice", property = "allprice")
    })
    @Select("SELECT cart.pid as pid,pname,price,count(cart.pid) as count,price*count(cart.pid) as allprice FROM cake,users,cart " +
            "WHERE cake.pid = cart.pid AND cart.uid = users.uid AND users.uid = #{uid} Group by pname")
    List<Cart> getCartbyUid(@Param("uid")int uid);//获取uid对应的购物车
    @Select("SELECT SUM(price) FROM cake,users,cart WHERE cake.pid = cart.pid AND cart.uid = users.uid " +
            "Group by users.uid HAVING users.uid = #{uid}")
    Object gettotal(@Param("uid")int uid);//获取uid对应的总金额
    @Select("SELECT count(pname) FROM cake,users,cart WHERE cake.pid = cart.pid AND cart.uid = users.uid and users.uid =#{uid}")
    int getproductnumber(@Param("uid")int uid);//获取uid对应的商品数量
    @Select("select order_id,order_number,total,time from `order` where uid=#{uid}")
    List<Order> getOrderbyUid(@Param("uid")int uid);
    @Delete("delete from `order` where order_id = #{order_id} and uid = #{uid}")
    void deleteOrderbyUid(@Param("order_id")int order_id,@Param("uid")int uid);
    @Results({
            @Result(column = "name", property = "name"),
            @Result(column = "money", property = "money"),
            @Result(column = "realname", property = "realname"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "address", property = "address")
    })
    @Select("select name,money,realname,phone,address from users,profile where uid = id")
    List<User> findallUser();

}
