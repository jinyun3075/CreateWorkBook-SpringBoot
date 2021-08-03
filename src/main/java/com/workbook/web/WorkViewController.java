package com.workbook.web;

import com.workbook.domain.user.User;

import com.workbook.service.user.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
@RequestMapping("/workbook")
public class WorkViewController {
    private final WorkService workService;
    private User user ;
    @GetMapping("")
    public String work(Model model, Authentication authentication) throws IOException {
        user =(User)authentication.getPrincipal();
        model.addAttribute("userid",user.getId());
        model.addAttribute("user",workService.GetList(user.getId()));
        return "publicWork/index";
    }

    @GetMapping("/create")
    public String create(Model model,Authentication authentication)
    {
        user =(User)authentication.getPrincipal();
        model.addAttribute("userid",user.getId());

        return "publicWork/create";
    }
    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable Long id){
        model.addAttribute("id",id);
        return "publicWork/view";
    }
}
