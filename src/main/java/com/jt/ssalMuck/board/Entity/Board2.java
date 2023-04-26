package com.jt.ssalMuck.board.Entity;

import com.jt.framework.util.TimeUtil.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Board2 extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private String username;
    private String hit;
    @ColumnDefault("0")
    private String likeHit;
    private String dislike;
    private String delete_yn;

}
