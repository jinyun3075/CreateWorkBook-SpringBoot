package com.workbook.service.user;

import com.workbook.domain.user.UserRepository;
import com.workbook.web.dto.UserJoinDto;
import com.workbook.web.dto.UserLoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserLoginDto login(UserLoginDto userLoginDto){
        return userRepository.login(userLoginDto.getUserId());
    }
    @Transactional
    public Long join(UserJoinDto userJoinDto){
        return userRepository.save(userJoinDto.toEntity()).getId();
    }
}
