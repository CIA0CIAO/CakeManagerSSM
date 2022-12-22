package cake.manager.controller.page;

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
    @RequestMapping(value = "/cake", method = RequestMethod.GET)
    public String cake(HttpSession session, @RequestParam(defaultValue = "1")Integer pageNumber, Model model){
        int cakeCount =cakeService.getCakeCount();// 获取总记录条数
        int pageCount = (cakeCount + 8 - 1) / 8;// 总页数
        // 将当前页码 和 总页数 设置到作用域
        session.setAttribute("pageNumber", pageNumber);
        session.setAttribute("pageCount", pageCount);
        model.addAttribute("user", authService.findUser(session));
        model.addAttribute("cakeList",cakeService.getAllCake((pageNumber - 1) * 8));
        return "/admin/cake";
    }
    @RequestMapping("/add-cake")
    public String addcake(HttpSession session, Model model){
        model.addAttribute("user", authService.findUser(session));
        model.addAttribute("user_list",authService.showAlluser());
        return "/admin/add-cake";
    }
}
