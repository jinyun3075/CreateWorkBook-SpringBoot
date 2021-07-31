package com.workbook.service.user;



import com.workbook.domain.user.User;
import com.workbook.domain.user.UserRepository;
import com.workbook.web.dto.user.UserJoinDto;
import com.workbook.web.dto.user.UserUpdateDto;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Transactional
    public Long join(UserJoinDto userJoinDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userJoinDto.setPw(encoder.encode(userJoinDto.getPw()));
        return userRepository.save(userJoinDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id,UserUpdateDto userUpdateDto){
        if(userUpdateDto.getPw().equals(userUpdateDto.getPwcheck())){
            User user = userRepository.findById(id)
                    .orElseThrow(()->new IllegalArgumentException("수정할 수 없습니다.="+id));
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            userUpdateDto.setPw(encoder.encode(userUpdateDto.getPw()));
            user.update(userUpdateDto.getPw(), userUpdateDto.getName());
            return id;
        }else{
            return (long) -1;
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserid(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
