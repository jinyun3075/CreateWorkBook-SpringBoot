package com.workbook.domain.work;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String sel1;
    @Column(nullable = false)
    private String sel2;
    @Column(nullable = false)
    private String sel3;
    @Column(nullable = false)
    private String sel4;

    @Column(nullable = false)
    private Long val;

    @ManyToOne
    @JoinColumn(name = "link_id")
    LinkWork linkWork;

    @Builder
    public Work(String question,String sel1,String sel2,String sel3, String sel4,Long val,LinkWork linkWork){
        this.question=question;
        this.sel1=sel1;
        this.sel2=sel2;
        this.sel3=sel3;
        this.sel4=sel4;
        this.val=val;
        this.linkWork=linkWork;
    }
}
