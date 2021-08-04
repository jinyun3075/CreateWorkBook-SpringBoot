package com.workbook.web.dto.workBook;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WorkBookCreateDto {
    private String title;
    private String sub;

    @Builder
    public WorkBookCreateDto(String title, String sub){
        this.title=title;
        this.sub=sub;
    }

}
