package cake.manager.controller.page;

import cake.manager.service.AuthService;
import cake.manager.service.CakeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page/admin")
public class AdminPageController {
    @Resource
    AuthService authService;
    @Resource
    CakeService cakeService;

    @RequestMapping("/index")
    public String index(HttpSession session, Model model){
        model.addAttribute("user", authService.findUser(session));
        model.addAttribute("order_list",cakeService.showAllorder());
        model.addAttribute("stat",cakeService.getGlobalStat());
        return "/admin/index";
    }
    @RequestMapping("/users")
    public String users(HttpSession session, Model model){
        model.addAttribute("user", authService.findUser(session));
        model.addAttribute("user_list",authService.showAlluser());
        return "/admin/users";
    }
    @RequestMapping("/cake")
    public String cake(HttpSession session, Model model){
        model.addAttribute("user", authService.findUser(session));
        model.addAttribute("cakeList",cakeService.getAllCake());
        return "/admin/cake";
    }
    @RequestMapping("/add-cake")
    public String addcake(HttpSession session, Model model){
        model.addAttribute("user", authService.findUser(session));
        model.addAttribute("user_list",authService.showAlluser());
        return "/admin/add-cake";
    }
}
