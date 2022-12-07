package cake.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUser {
    int id;
    String password;
    String name;
    String role;
}
