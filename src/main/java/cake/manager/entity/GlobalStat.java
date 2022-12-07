package cake.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GlobalStat {
    int userCount;
    int cakeCount;
    int orderCount;
    double totalCount;
}
