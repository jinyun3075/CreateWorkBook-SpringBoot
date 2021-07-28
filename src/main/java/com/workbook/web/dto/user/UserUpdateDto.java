package com.workbook.web.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateDto {
    private String pw;
    private String name;
    @Builder
    public UserUpdateDto(String pw,String name){
        this.pw=pw;
        this.name=name;
    }
}
