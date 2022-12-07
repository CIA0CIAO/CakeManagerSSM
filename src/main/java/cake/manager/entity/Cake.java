package cake.manager.entity;

import lombok.Data;

@Data
public class Cake {
    int pid;
    String pname;
    double price;
    int number;
    String picture;
    String description;
}
