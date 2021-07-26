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
    public String index(Model model, Authentication authentication){
        User user =null;
        if(authentication!=null){
        user =(User)authentication.getPrincipal();
            model.addAttribute("user",user.getName());
       }
        return "index";
    }
    @GetMapping("/generic")
    public String generic(){
        return "generic";
    }
    @GetMapping("/elements")
    public String elements(){
        return "elements";
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



}
