package com.workbook.web;

import com.workbook.domain.user.User;
import com.workbook.service.user.WorkService;
import com.workbook.web.dto.work.WorkCreateDto;
import com.workbook.web.dto.work.WorkListDto;
import com.workbook.web.dto.work.WorkSolvDto;
import com.workbook.web.dto.workBook.WorkBookCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/work")
public class WorkController {
    private final WorkService workService;
    @PostMapping("/WorkBookCreate/{id}")
    public Long WorkBookCreate(@PathVariable Long id,@RequestBody WorkBookCreateDto workBookCreateDto){
        return workService.createBook(workBookCreateDto,id);
    }
    @PostMapping("/WorkCreate/{bookId}")
    public Long WorkCreate(@RequestBody WorkCreateDto workCreateDto, @PathVariable Long bookId
    , Authentication authentication){
        User user = (User)authentication.getPrincipal();
        workService.createWork(workCreateDto,bookId,user.getId());
        return bookId;
    }

    @PostMapping("/nextWork/{in}")
    public Long nextPage(HttpServletRequest request, Model model, @RequestBody List<WorkListDto> sol, @PathVariable int in){
        HttpSession session = request.getSession();

        model.addAttribute("sol",sol.get(in));
        model.addAttribute("in",in+1);
        return 1l;
    }
    @PostMapping("/solving/view/next/{bookId}")
    public int nextView(@RequestBody WorkSolvDto workSolvDto, Model model, Authentication authentication, @PathVariable Long bookId){
        User user =(User)authentication.getPrincipal();
        List<WorkListDto> list=workService.getListWork(user.getId(),bookId);
        String index =workSolvDto.getLocation();
        if(workSolvDto.getVal()!=workSolvDto.getValCheck()){
            Cookie cookie = new Cookie(index,index);
        }
        model.addAttribute("sol",list.get(Integer.parseInt(index)+1));
        model.addAttribute("index",Integer.parseInt(index)+1);
        model.addAttribute("bookId",bookId);
        return 1;
    }
}
