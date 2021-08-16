package com.workbook.web.dto.work;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class WorkViewDto {
    private final WorkListDto sol;
    private final int index;
    private final Long bookId;

}
