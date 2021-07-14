package com.workbook.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginDto {
    private String userId;
    private String pw;

    @Builder
    public UserLoginDto(String userId, String pw){
        this.userId=userId;
        this.pw=pw;
    }
}
