package com.workbook.web.dto;
import com.workbook.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserJoinDto {
    private String userId;
    private String pw;
    private String name;
    @Builder
    public UserJoinDto(String userId,String pw,String name){
        this.userId=userId;
        this.pw=pw;
        this.name=name;
    }

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .pw(pw)
                .name(name)
                .build();
    }
}
