package com.workbook.web.dto;
import com.workbook.domain.user.Role;
import com.workbook.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserJoinDto {
    private String userid;
    private String pw;
    private String name;
    @Builder
    public UserJoinDto(String userid,String pw,String name){
        this.userid=userid;
        this.pw=pw;
        this.name=name;

    }

    public User toEntity(){
        return User.builder()
                .userid(userid)
                .pw(pw)
                .name(name)
                .auth(Role.MEMBER.getVal())
                .build();
    }
}
