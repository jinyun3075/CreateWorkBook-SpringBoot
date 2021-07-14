package com.workbook.domain.user;

import com.workbook.web.dto.UserLoginDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE userId=?1")
    UserLoginDto login(String userId);

}
