package com.workbook.service.user;

import com.workbook.domain.workBook.WorkBook;
import com.workbook.domain.workBook.WorkBookRepository;
import com.workbook.web.dto.workBook.WorkBookListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WorkService {
    private WorkBookRepository workBookRepository;

    @Transactional(readOnly = true)
    public List<WorkBookListDto> GetList(Long id){
       return workBookRepository.findByUserid(id).stream()
               .map(WorkBookListDto::new)
               .collect(Collectors.toList());
    }
}
