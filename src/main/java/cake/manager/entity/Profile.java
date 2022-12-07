package cake.manager.entity;

import lombok.Data;

@Data
public class Profile {
    int id;
    String realname;
    String phone;
    int money;
    String address;
}
