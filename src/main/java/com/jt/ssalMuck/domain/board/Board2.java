package com.jt.ssalMuck.domain.board;

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
@EqualsAndHashCode(callSuper = false)
public class Board2 extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private String username;
    @ColumnDefault("0")
    private Long hit;
    @ColumnDefault("0")
    private Long likeHit;
    @ColumnDefault("0")
    private Long dislike;
    private String delete_yn;

}
