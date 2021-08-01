package com.workbook.web.dto.workBook;

import com.workbook.domain.user.User;
import com.workbook.domain.workBook.WorkBook;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WorkCreateDto {
    private User userid;
    private String title;
    private String sub;

    @Builder
    public WorkCreateDto(Long userid,String title,String sub){
        this.title=title;
        this.sub=sub;
    }
    public WorkBook toEntity(){
        return WorkBook.builder()
                .title(title)
                .sub(sub)
                .build();
    }
}
