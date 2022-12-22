package cake.manager.controller.api;

import cake.manager.entity.AuthUser;
import cake.manager.service.AuthService;
import cake.manager.service.CakeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/user")
public class UserApiController {
    @Resource
    AuthService authService;
    @Resource
    CakeService cakeService;
    @RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
    public String updateprofile(@RequestParam("realname") String realname,
                             @RequestParam("phone") String phone,
                             @RequestParam("address") String address,
                             @SessionAttribute("user") AuthUser user){
        authService.updateProfile(realname,phone,address,user.getId());
        return "redirect:/page/user/profile";
    }
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public String updateprofile(@RequestParam("money") int money,
                                @SessionAttribute("user") AuthUser user){
        authService.recharge(money,user.getId());
        return "redirect:/page/user/profile";
    }

    @RequestMapping(value = "/addcart", method = RequestMethod.GET)
    public String addcart(@RequestParam("pid") int pid,
                                @SessionAttribute("user") AuthUser user){
        cakeService.addcakecart(pid,user.getId());
        return "redirect:/page/user/product";
    }
    @RequestMapping(value = "/deletecart", method = RequestMethod.GET)
    public String deletecart(@RequestParam("pid") int pid,
                          @SessionAttribute("user") AuthUser user){
        cakeService.deletecart(pid,user.getId());
        return "redirect:/page/user/cart";
    }
    @RequestMapping(value = "/deleteorder", method = RequestMethod.GET)
    public String deleteorder(@RequestParam("order_id") int order_id,
                             @SessionAttribute("user") AuthUser user){
        authService.deleteOrderByuid(order_id,user.getId());
        return "redirect:/page/user/index";
    }
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public String paymentByuid(@SessionAttribute("user") AuthUser user){
        String money = authService.showTotal(user.getId()).toString();;//通过uid查对应的购物车所需要的钱
        double payment = Double.parseDouble(money);
        int number = authService.showproductnumber(user.getId());
        authService.payment(payment,user.getId());//完成之后后先扣款
        cakeService.deletecartByuid(user.getId());//再删除购物车内商品
        authService.createOrder(user.getId(),number, payment);
        return "redirect:/page/user/index";
    }
    @RequestMapping(value = "/findbypname", method = RequestMethod.POST)
    public String findbypname(@RequestParam("pname") String pname,
                              @SessionAttribute("user") AuthUser user,
                              HttpSession session){
        if(pname != null){
            session.setAttribute("findPname",pname);
            session.setAttribute("cakebyPname",cakeService.selectCakebyPname(pname));
        }
        return "redirect:/page/user/find";
    }
}
