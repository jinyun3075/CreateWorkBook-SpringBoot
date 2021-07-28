package com.workbook.web;

import com.workbook.service.user.UserService;
import com.workbook.web.dto.user.UserJoinDto;
import com.workbook.web.dto.user.UserUpdateDto;
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
    @PutMapping("/update/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody UserUpdateDto userUpdateDto){
        return userService.update(id,userUpdateDto);
    }
}
