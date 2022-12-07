package cake.manager.service.impl;

import cake.manager.entity.Cake;
import cake.manager.entity.GlobalStat;
import cake.manager.entity.Order;
import cake.manager.mapper.CakeMapper;
import cake.manager.service.CakeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CakeServiceImpl implements CakeService {
    @Resource
    CakeMapper mapper;
    @Override
    public List<Cake> getAllCake() {
        List<Cake> cakes = mapper.allCake();
        return cakes
                .stream()
                .collect(Collectors.toList());
    }
    @Override
    public Cake getCakeDetail(int pid) {
        return mapper.cakeDetail(pid);
    }
    @Override
    public void addcakecart(int pid, int uid) {
        mapper.addCart(pid,uid);
    }

    @Override
    public void deletecart(int pid, int uid) {
        mapper.deleteCartbyPid(pid,uid);
    }

    @Override
    public void deletecartByuid(int uid) {
        mapper.deleteCartbyUid(uid);
    }

    @Override
    public List<Order> showAllorder() {
        return mapper.findAllorder();
    }

    @Override
    public void deleteOrderbyorderid(int order_id) {
        mapper.deleteOrder(order_id);
    }
    @Override
    public double selecttotalbyorderid(int order_id) {
        return mapper.selecttotal(order_id);
    }

    @Override
    public GlobalStat getGlobalStat() {
        return new GlobalStat(mapper.getUserCount(),
                mapper.getCakeCount(),
                mapper.getOrderCount(),
                mapper.getTotalCount());
    }

    @Override
    public void deleteCake(int pid) {
        mapper.deleteCakebypid(pid);
    }

    @Override
    public void addCake(String pname, double price, int number) {
        mapper.addCake(pname,price,number);
    }

}
