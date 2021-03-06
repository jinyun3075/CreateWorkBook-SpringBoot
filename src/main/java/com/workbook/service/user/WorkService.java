package com.workbook.service.user;

import com.workbook.domain.user.User;
import com.workbook.domain.user.UserRepository;
import com.workbook.domain.work.LinkWork;
import com.workbook.domain.work.LinkWorkRepository;
import com.workbook.domain.work.WorkRepository;
import com.workbook.domain.workBook.WorkBook;
import com.workbook.domain.workBook.WorkBookRepository;
import com.workbook.web.dto.work.WorkCreateDto;
import com.workbook.web.dto.work.WorkListDto;
import com.workbook.web.dto.workBook.WorkBookCreateDto;
import com.workbook.web.dto.workBook.WorkBookListDto;
import com.workbook.web.dto.workBook.WorkBookSub;
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
    private final LinkWorkRepository linkWorkRepository;
    private final WorkRepository workRepository;
    @Transactional(readOnly = true)
    public List<WorkBookListDto> getList(Long id) throws IOException {
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalAccessError("ㅎㅇ"+id ));
        List<WorkBook> workBook = workBookRepository.findByUserid(user);

       return workBook.stream().map(WorkBookListDto::new).collect(Collectors.toList());

    }
    @Transactional(readOnly = true)
    public String sub(Long id) throws IOException {
        WorkBook workBook = workBookRepository.findById(id)
                .orElseThrow(()->new IllegalAccessError("ㅎㅇ"+id ));
        return workBook.getSub();

    }
    @Transactional(readOnly = true)
    public List<WorkListDto> getListWork(Long user_id,Long work_id){
        User user = userRepository.findById(user_id)
                .orElseThrow(()->new IllegalAccessError("ㅎㅇ"+user_id ));
        WorkBook workBook=workBookRepository.findById(work_id)
                .orElseThrow(()->new IllegalAccessError("ㅎㅇ"+work_id ));
        LinkWork linkWork=linkWorkRepository.findByUserAndWorkbook(user,workBook);

       return workRepository.findByLinkWork(linkWork)
                .stream().map(WorkListDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long createBook(WorkBookCreateDto dto, Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalAccessError("ㅎㅇ"+id ));
        return linkWorkRepository.save(LinkWork.builder()
                .user(user)
                .workbook(workBookRepository.save(WorkBook.builder()
                        .title(dto.getTitle())
                        .sub(dto.getSub())
                        .userid(user)
                        .build()
                )).build()).getId();
    }

    @Transactional
    public Long createWork(WorkCreateDto dto, Long bookId, Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalAccessError("ㅎㅇ"+userId ));
        WorkBook workBook=workBookRepository.findById(bookId)
                .orElseThrow(()->new IllegalAccessError("ㅎㅇ"+bookId ));
        LinkWork linkWork=linkWorkRepository.findByUserAndWorkbook(user,workBook);

        return workRepository.save(dto.toEntity(dto,linkWork)).getId();
    }


}
