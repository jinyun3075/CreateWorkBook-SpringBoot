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
        model.addAttribute("workBook",workService.getList(user.getId()));
        return "publicWork/index";
    }

    @GetMapping("/create")
    public String create(Model model,Authentication authentication)
    {
        user =(User)authentication.getPrincipal();
        model.addAttribute("userid",user.getId());

        return "publicWork/create";
    }
    @GetMapping("/view/{bookId}")
    public String view(@PathVariable Long bookId,Authentication authentication,Model model) throws IOException {
        user =(User)authentication.getPrincipal();
        model.addAttribute("bookId",bookId);
        model.addAttribute("sub",workService.sub(bookId));
        model.addAttribute("work",workService.getListWork(user.getId(),bookId));
        return "publicWork/view";
    }

    @GetMapping("/view/create/{id}")
    public String createView(Model model, @PathVariable Long id){
        model.addAttribute("id",id);
        return "publicWork/work/create";
    }


}
