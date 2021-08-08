package com.workbook.web.dto.workBook;

import com.workbook.domain.workBook.WorkBook;
import lombok.Getter;

@Getter
public class WorkBookSub {
    private String sub;
    public WorkBookSub(WorkBook s){
        this.sub=s.getSub();
    }
}
