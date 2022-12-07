package cake.manager.entity;

import lombok.Data;

@Data
public class Cart {
    int cart_id;
    int pid;
    int uid;
    String pname;
    double price;
    int count;//商品数量
    double allprice;
}
