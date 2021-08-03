package com.workbook.service.user;

import com.workbook.domain.user.User;
import com.workbook.domain.user.UserRepository;
import com.workbook.domain.workBook.WorkBook;
import com.workbook.domain.workBook.WorkBookRepository;
import com.workbook.web.dto.workBook.WorkCreateDto;
import com.workbook.web.dto.workBook.WorkListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WorkService {
    private final WorkBookRepository workBookRepository;
    private final UserRepository userRepository;
    @Transactional(readOnly = true)
    public List<WorkListDto> GetList(Long id) throws IOException {
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalAccessError("ㅎㅇ"+id ));
        List<WorkBook> workBook = workBookRepository.findByUserid(user);

       return workBook.stream().map(WorkListDto::new).collect(Collectors.toList());

    }

    @Transactional
    public Long create(WorkCreateDto dto,Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalAccessError("ㅎㅇ"+id ));
        System.out.println("service");
        return workBookRepository.save(WorkBook.builder()
                        .title(dto.getTitle())
                        .sub(dto.getSub())
                        .userid(user)
                .build()
        ).getId();
    }


}
