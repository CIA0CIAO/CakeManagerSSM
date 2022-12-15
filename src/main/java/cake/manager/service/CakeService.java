package cake.manager.service;

import cake.manager.entity.Cake;
import cake.manager.entity.GlobalStat;
import cake.manager.entity.Order;

import java.util.List;

public interface CakeService {
    List<Cake> getAllCake();
    Cake getCakeDetail(int pid);
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
