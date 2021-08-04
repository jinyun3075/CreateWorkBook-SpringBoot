package com.workbook.web.dto.workBook;

import com.workbook.domain.workBook.WorkBook;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class WorkBookListDto {
    private Long id;
    private String title;
    private LocalDateTime modifiedDate;

    public WorkBookListDto(WorkBook workBook){
        this.id=workBook.getId();
        this.title=workBook.getTitle();
        this.modifiedDate=workBook.getModifiedDate();
    }
}
