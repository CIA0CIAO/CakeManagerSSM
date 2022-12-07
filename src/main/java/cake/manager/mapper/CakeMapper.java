package cake.manager.mapper;

import cake.manager.entity.Cake;
import cake.manager.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CakeMapper {
    @Select("select * from cake")
    List<Cake> allCake();
    @Select("select * from cake where pid = #{pid}")
    Cake cakeDetail(@Param("pid")int pid);
    @Insert("insert into cart(pid, uid) values(#{pid}, #{uid})")
    void addCart(@Param("pid") int pid, @Param("uid") int uid);
    @Delete("delete from cart where pid = #{pid} and uid = #{uid}")
    void deleteCartbyPid(@Param("pid")int pid,@Param("uid")int uid);//从购物车删除pid对应的uid
    @Delete("delete from cart where uid = #{uid}")
    void deleteCartbyUid(@Param("uid")int uid);//购买后删除购物车的商品
    @Results({
            @Result(id = true,column = "order_id", property = "order_id"),
            @Result(column = "order_number", property = "order_number"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "name", property = "name"),
            @Result(column = "total", property = "total"),
            @Result(column = "time", property = "time")
    })
    @Select("select * from `order`,users where `order`.uid = users.uid")
    List<Order> findAllorder();
    @Delete("delete from `order` where order_id = #{order_id}")
    void deleteOrder(@Param("order_id")int order_id);
    @Select("select total from `order` where order_id = #{order_id}")
    double selecttotal(@Param("order_id")int order_id);
    @Select("select count(*) from profile")
    int getUserCount();
    @Select("select count(*) from cake")
    int getCakeCount();
    @Select("select count(*) from `order`")
    int getOrderCount();
    @Select("select sum(total) from `order`")
    double getTotalCount();
    @Delete("delete from cake where pid = #{pid}")
    void deleteCakebypid(@Param("pid")int pid);
    @Insert("insert into cake(pname, price, number) value(#{pname},#{price},#{number})")
    void addCake(@Param("pname")String pname,@Param("price")double price,@Param("number")int number);


}
