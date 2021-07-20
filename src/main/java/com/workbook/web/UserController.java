package com.workbook.web;

import com.workbook.service.user.UserService;
import com.workbook.web.dto.UserJoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    @PostMapping("/join")
    public Long join(@RequestBody UserJoinDto userJoinDto){
        return userService.join(userJoinDto);
    }
}
