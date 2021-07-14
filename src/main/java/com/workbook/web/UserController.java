package com.workbook.web;


import com.workbook.service.user.UserService;
import com.workbook.web.dto.UserJoinDto;
import com.workbook.web.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/api/login")
    public UserLoginDto login(@RequestBody UserLoginDto Check){
        return userService.login(Check);
    }
    @PostMapping("/api/join")
    public Long join(@RequestBody UserJoinDto userJoinDto){
        return userService.join(userJoinDto);
    }

}
