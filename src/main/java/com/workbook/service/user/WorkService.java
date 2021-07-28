package com.workbook.service.user;

import com.workbook.domain.workBook.WorkBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WorkService {
    private WorkBookRepository workBookRepository;
}
