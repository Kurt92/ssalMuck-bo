package com.jt.ssalMuck.chat.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor

public class ChatDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long chat_detail_id;

    private long chat_id;
    private String msg_from;
    private String msg_to;
    private String msg;
    @CreatedDate
    private String createdDate;

}
