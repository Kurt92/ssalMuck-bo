package com.ssalMuck.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssalMuck.cmmn.TimeUtil.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Board2 extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String username;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")

}
