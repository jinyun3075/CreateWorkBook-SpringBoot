package com.workbook.domain.workBook;

import com.workbook.domain.BaseTimeEntity;
import com.workbook.domain.user.User;
import com.workbook.domain.work.LinkWork;
import com.workbook.domain.work.Work;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class WorkBook extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title;

    private String sub;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User userid ;

    @OneToMany
    @JoinColumn(name = "workbook_id")
    List<LinkWork> l;



    @Builder WorkBook( String title, String sub,User userid){
        this.title=title;
        this.sub=sub;
        this.userid=userid;
    }
    public void update(String title){
        this.title=title;
        this.sub=sub;
    }

}
