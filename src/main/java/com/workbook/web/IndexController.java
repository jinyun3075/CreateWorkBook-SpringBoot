package com.workbook.web;

import com.workbook.domain.user.User;
import com.workbook.service.user.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final WorkService workService;
    User user =null;
    @GetMapping("/")
    public String index(Model model,Authentication authentication){
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
        user =(User)authentication.getPrincipal();
        model.addAttribute("user_id",user.getId());
        return "update";
    }

    @GetMapping("/workbook")
    public String work(Model model,Authentication authentication) throws IOException {
        user =(User)authentication.getPrincipal();
        model.addAttribute("userid",user.getId());
        model.addAttribute("user",workService.GetList(user.getId()));
        return "publicWork/index";
    }

    @GetMapping("/workbook/create")
    public String create(Model model,Authentication authentication)
    {
        user =(User)authentication.getPrincipal();
        model.addAttribute("userid",user.getId());

        return "publicWork/create";
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
