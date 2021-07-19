package com.workbook.service.user;


import com.workbook.config.MyUserDetail;
import com.workbook.domain.user.User;
import com.workbook.domain.user.UserRepository;
import com.workbook.web.dto.UserJoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Transactional
    public Long join(UserJoinDto userJoinDto){
        return userRepository.save(userJoinDto.toEntity()).getId();
    }

    @Override
    public MyUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUserid(username);
        User u =user.get();
        return new MyUserDetail(u);

    }
}
