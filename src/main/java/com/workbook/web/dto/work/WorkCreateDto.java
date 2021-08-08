package com.workbook.web.dto.work;

import com.workbook.domain.work.LinkWork;
import com.workbook.domain.work.Work;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WorkCreateDto {
    private String question;
    private String sel1;
    private String sel2;
    private String sel3;
    private String sel4;
    private Long val;

    @Builder WorkCreateDto(String question,String sel1,
                           String sel2,String sel3,String sel4,Long val){
        this.question=question;
        this.sel1=sel1;
        this.sel2=sel2;
        this.sel3=sel3;
        this.sel4=sel4;
        this.val=val;
    }

    public Work toEntity(WorkCreateDto dto, LinkWork linkWork){
        return Work.builder()
                .question(dto.question)
                .sel1(dto.sel1)
                .sel2(dto.sel2)
                .sel3(dto.sel3)
                .sel4(dto.sel4)
                .val(dto.val)
                .linkWork(linkWork).build();

    }
}
