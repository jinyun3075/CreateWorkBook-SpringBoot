package com.workbook.web.dto.work;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WorkSolvDto {
    String location;
    Long val;
    Long valCheck;
    Integer next;
    @Builder
    public WorkSolvDto(String location,Long val, Long valCheck,Integer next){
        this.location=location;
        this.val=val;
        this.valCheck=valCheck;
        this.next=next;
    }
}
