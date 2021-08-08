package com.workbook.web.dto.work;

import com.workbook.domain.work.Work;

import lombok.Getter;


@Getter
public class WorkListDto {
    private Long id;
    private String title;
    public WorkListDto(Work work){
        this.title=work.getQuestion();
        this.id=work.getId();
    }
}
