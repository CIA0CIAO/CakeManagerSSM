package cake.manager.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page/auth")
public class AuthPageController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(HttpSession session, Model model){
        if(session.getAttribute("username_exit") != null){
            model.addAttribute("failure",true);
            session.removeAttribute("username_exit");
        }
        return "register";
    }
}
