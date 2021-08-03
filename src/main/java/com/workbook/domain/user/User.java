package com.workbook.domain.user;

import com.workbook.domain.work.LinkWork;
import com.workbook.domain.workBook.WorkBook;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


@Getter
@NoArgsConstructor
@Entity
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false, unique = true)
    private String userid;

    @Column(nullable = false)
    private String auth;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<WorkBook> u ;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<LinkWork> l;


    @Builder
    public User(String userid, String pw, String name,String auth){
        this.name=name;
        this.pw=pw;
        this.userid=userid;
        this.auth =auth;
    }
    public void update(String pw, String name){
        this.pw=pw;
        this.name=name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.auth));
    }

    @Override
    public String getPassword() {
        return pw;
    }

    @Override
    public String getUsername() {
        return userid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
