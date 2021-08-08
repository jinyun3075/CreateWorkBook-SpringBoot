package com.workbook.domain.work;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work,Long>{
   List<Work> findByLinkWork(LinkWork linkWork);
}
