package cake.manager.controller.api;

import cake.manager.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/auth")
public class AuthApiController {

    @Resource
    AuthService service;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           HttpSession session){
        if(service.isRegister(username)){
            session.setAttribute("username_exit",new Object());
            return "redirect:/page/auth/register";
        }else {
            service.register(username,  password);
            return "redirect:/login";
        }
    }
}