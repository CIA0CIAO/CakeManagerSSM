package cake.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    String name;
    String money;
    String realname;
    String phone;
    String address;
}
