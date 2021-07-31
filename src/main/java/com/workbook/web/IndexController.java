package com.workbook.web;

import com.workbook.domain.user.User;
import com.workbook.service.user.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final WorkService workService;
    @GetMapping("/")
    public String index(Model model,Authentication authentication){
        User user =null;
        if(authentication!=null){
        user =(User)authentication.getPrincipal();
            model.addAttribute("user_name",user.getName());
            model.addAttribute("user_id",user.getId());
       }
        return "index";
    }
    @GetMapping("/login")
    public String login(){return  "login"; }

    @GetMapping("/join")
    public String join(){ return "join";
    }

    @GetMapping("/update")
    public String update(Model model,Authentication authentication){
        User user =(User)authentication.getPrincipal();
        model.addAttribute("user_id",user.getId());
        return "update";
    }

    @GetMapping("/workbook")
    public String work(Model model,Authentication authentication){
        User user =(User)authentication.getPrincipal();
        model.addAttribute("user",workService.GetList(user.getId()));
        return "publicwork/index";
    }

    @GetMapping("/admin")
    public @ResponseBody String ad(){
        return "adminPage";
    }

    @GetMapping("/generic")
    public String generic(){
        return "generic";
    }
    @GetMapping("/elements")
    public String elements(){
        return "elements";
    }


}
