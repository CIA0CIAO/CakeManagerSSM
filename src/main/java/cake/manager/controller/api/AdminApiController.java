package cake.manager.controller.api;

import cake.manager.service.AuthService;
import cake.manager.service.CakeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/admin")
public class AdminApiController {
    @Resource
    CakeService cakeService;
    @Resource
    AuthService authService;
    @RequestMapping(value = "/deleteorder", method = RequestMethod.GET)
    public String deleteorder(@RequestParam("order_id") int order_id,
                              @RequestParam("uid") int uid){
        double money = cakeService.selecttotalbyorderid(order_id);
        authService.recharge(money,uid);
        cakeService.deleteOrderbyorderid(order_id);
        return "redirect:/page/admin/index";
    }
    @RequestMapping(value = "/addcake", method = RequestMethod.POST)
    public String addcake(@RequestParam("pname") String pname,
                           @RequestParam("price") double price,
                          @RequestParam("number") int number){
        cakeService.addCake(pname,price,number);
        return "redirect:/page/admin/cake";
    }
    @RequestMapping(value = "/deletecake", method = RequestMethod.GET)
    public String deleteorder( @RequestParam("pid") int pid){
        cakeService.deleteCake(pid);
        return "redirect:/page/admin/cake";
    }
}