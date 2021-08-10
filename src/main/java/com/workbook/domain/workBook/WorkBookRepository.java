package com.workbook.domain.workBook;

import com.workbook.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WorkBookRepository extends JpaRepository<WorkBook,Long> {
    List<WorkBook> findByUserid(User user);
}
