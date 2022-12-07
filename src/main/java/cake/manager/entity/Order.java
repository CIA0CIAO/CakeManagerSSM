package cake.manager.entity;

import lombok.Data;

@Data
public class Order {
    int order_id;
    int order_number;//购买数量
    int uid;
    String name;//客户名称
    double total;//付款金额
    String time;//付款时间

}
