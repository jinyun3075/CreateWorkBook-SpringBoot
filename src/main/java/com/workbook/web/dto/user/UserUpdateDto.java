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
    private String pwcheck;
    @Builder
    public UserUpdateDto(String pw,String name,String pwcheck){
        this.pw=pw;
        this.name=name;
        this.pwcheck=pwcheck;
    }
}
