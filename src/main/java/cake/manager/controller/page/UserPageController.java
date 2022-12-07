package cake.manager.controller.page;

import cake.manager.entity.AuthUser;
import cake.manager.entity.Cake;
import cake.manager.service.AuthService;
import cake.manager.service.CakeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page/user")
public class UserPageController {
    @Resource
    AuthService service;
    @Resource
    CakeService cakeService;
    @RequestMapping("/index")
    public String index(HttpSession session, Model model){
        AuthUser user = service.findUser(session);
        model.addAttribute("user", user);
        model.addAttribute("number",service.showproductnumber(user.getId()));
        model.addAttribute("order_list",service.showOrderbyuid(user.getId()));
        return "/user/index";
    }
    @RequestMapping("/profile")
    public String profile(HttpSession session, Model model){
        AuthUser user = service.findUser(session);
        model.addAttribute("user", service.findUser(session));
        model.addAttribute("number",service.showproductnumber(user.getId()));
        model.addAttribute("profile_list",service.selectProfile(user.getId()));
        return "/user/profile";
    }
    @RequestMapping("/cart")
    public String cart(HttpSession session, Model model){
        AuthUser user = service.findUser(session);
        model.addAttribute("user", service.findUser(session));
        model.addAttribute("number",service.showproductnumber(user.getId()));
        model.addAttribute("cartlistbyuid",service.showCartbyuid(user.getId()));
        model.addAttribute("total",service.showTotal(user.getId()));
        return "/user/cart";
    }
    @RequestMapping("/product")
    public String product(HttpSession session, Model model){
        AuthUser user = service.findUser(session);
        model.addAttribute("user", service.findUser(session));
        model.addAttribute("number",service.showproductnumber(user.getId()));
        model.addAttribute("product_list",cakeService.getAllCake());
        return "/user/product";
    }
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(HttpSession session, @RequestParam("pid") int pid, Model model){
        AuthUser user = service.findUser(session);
        Cake cakeDetail = cakeService.getCakeDetail(pid);
        model.addAttribute("cakeDetail",cakeDetail);
        model.addAttribute("user", service.findUser(session));
        model.addAttribute("number",service.showproductnumber(user.getId()));
        return "/user/details";
    }
}


