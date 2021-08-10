package com.workbook.web.dto.work;

import com.workbook.domain.work.Work;

import lombok.Getter;


@Getter
public class WorkListDto {
    private Long id;
    private String question;
    private String sel1;
    private String sel2;
    private String sel3;
    private String sel4;
    private Long val;
    public WorkListDto(Work work){
        this.id=work.getId();
        this.question=work.getQuestion();
        this.sel1=work.getSel1();
        this.sel2=work.getSel2();
        this.sel3=work.getSel3();
        this.sel4=work.getSel4();
        this.val=work.getVal();
    }
}
