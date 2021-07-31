package com.workbook.domain.workBook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WorkBookRepository extends JpaRepository<WorkBook,Long> {
    List<WorkBook> findByUserid(Long userid);
}
