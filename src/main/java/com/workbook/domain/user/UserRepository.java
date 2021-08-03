package com.workbook.domain.user;

import com.workbook.domain.workBook.WorkBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
        Optional<User> findByUserid(String userid);

        List<WorkBook> findByU(WorkBook id);

}
