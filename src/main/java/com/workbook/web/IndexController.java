package com.workbook.web;

import com.workbook.domain.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/join")
    public String join(){ return "join";
    }
    @GetMapping("/login")
    public String login(){return  "login"; }
    @GetMapping("/admin")
    public @ResponseBody String ad(){
        return "adminPage";
    }
    @GetMapping("/main")
    public String main(Model model, Authentication authentication){
        User user =(User)authentication.getPrincipal();
        model.addAttribute("user",user.getName());
        return "main";
    }


}
