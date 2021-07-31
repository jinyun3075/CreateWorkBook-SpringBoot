package com.workbook.domain.workBook;

import com.workbook.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class WorkBook extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userid;

    @Column(nullable = false)
    private String title;

    private String sub;


    @Builder WorkBook(Long userid, String title, String sub){
        this.userid=userid;
        this.title=title;
        this.sub=sub;
    }
    public void update(String title){
        this.title=title;
    }

}