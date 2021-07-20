package com.workbook.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
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
    public String main(){
        return "main";
    }


}
