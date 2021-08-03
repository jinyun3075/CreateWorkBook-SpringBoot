package com.workbook.web;

import com.workbook.domain.workBook.WorkBookRepository;
import com.workbook.service.user.WorkService;
import com.workbook.web.dto.workBook.WorkCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/work")
public class WorkController {
    private final WorkService workService;
    @PostMapping("/create/{id}")
    public Long create(@PathVariable Long id,@RequestBody WorkCreateDto workCreateDto){
        System.out.println("view 문제");
        return workService.create(workCreateDto,id);
    }

}
