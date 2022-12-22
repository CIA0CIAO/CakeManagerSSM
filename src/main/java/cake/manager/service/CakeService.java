package cake.manager.service;

import cake.manager.entity.Cake;
import cake.manager.entity.GlobalStat;
import cake.manager.entity.Order;

import java.util.List;

public interface CakeService {
    List<Cake> getAllCake(Integer pageNumber);//获取所有商品带分页
    int getCakeCount();//获取商品的总列数
    Cake getCakeDetail(int pid);//获取商品详细信息
    List<Cake> selectCakebyPname(String pname);
    void addcakecart(int pid,int uid);
    void deletecart(int pid,int uid);
    void deletecartByuid(int uid);
    List<Order> showAllorder();
    void deleteOrderbyorderid(int order_id);
    double selecttotalbyorderid(int order_id);
    GlobalStat getGlobalStat();
    void deleteCake(int pid);
    void addCake(String pname,double price,int number);
    void updatedetail(int pid,String pname,double price,String description,int number);

}
