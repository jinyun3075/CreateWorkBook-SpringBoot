package com.workbook.domain.work;

import com.workbook.domain.user.User;
import com.workbook.domain.workBook.WorkBook;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class LinkWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "workbook_id")
    private WorkBook workbook;

    @OneToMany
    @JoinColumn(name = "link_id")
    private List<Work> work;

    @Builder
    LinkWork(User user,WorkBook workbook){
        this.user=user;
        this.workbook=workbook;
    }
}
