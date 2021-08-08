package com.workbook.web;

import com.workbook.domain.user.User;
import com.workbook.service.user.WorkService;
import com.workbook.web.dto.work.WorkCreateDto;
import com.workbook.web.dto.workBook.WorkBookCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/work")
public class WorkController {
    private final WorkService workService;
    @PostMapping("/WorkBookCreate/{id}")
    public Long WorkBookCreate(@PathVariable Long id,@RequestBody WorkBookCreateDto workBookCreateDto){
        return workService.createBook(workBookCreateDto,id);
    }
    @PostMapping("/WorkCreate/{bookId}")
    public Long WorkCreate(@RequestBody WorkCreateDto workCreateDto, @PathVariable Long bookId
    , Authentication authentication){
        User user = (User)authentication.getPrincipal();
        workService.createWork(workCreateDto,bookId,user.getId());
        return bookId;
    }


}
