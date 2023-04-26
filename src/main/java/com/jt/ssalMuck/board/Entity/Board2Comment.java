package com.jt.ssalMuck.board.Entity;

import com.jt.framework.util.TimeUtil.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Board2Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String username;
    private String comment;
    private String likeHit;
    private String delete_yn;

}
