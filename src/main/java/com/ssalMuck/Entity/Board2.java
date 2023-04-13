package com.ssalMuck.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssalMuck.cmmn.TimeUtil.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

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
