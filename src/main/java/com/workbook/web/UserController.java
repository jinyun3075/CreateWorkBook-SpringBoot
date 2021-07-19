package com.workbook.web;


import com.workbook.domain.user.User;
import com.workbook.service.user.UserService;
import com.workbook.web.dto.UserJoinDto;
import com.workbook.web.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/api/join")
    public Long join(@RequestBody UserJoinDto userJoinDto){
        return userService.join(userJoinDto);
    }
    @GetMapping("/api/login")
    public String login(@RequestBody UserLoginDto Check){
        return "index";
    }
    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "/login";
    }


}
