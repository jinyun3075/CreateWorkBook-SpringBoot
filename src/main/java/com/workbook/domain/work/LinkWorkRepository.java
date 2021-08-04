package com.workbook.domain.work;

import com.workbook.domain.user.User;
import com.workbook.domain.workBook.WorkBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkWorkRepository extends JpaRepository<LinkWork, Long> {
    LinkWork findByUserAndWorkbook(User userid, WorkBook bookId);
}
