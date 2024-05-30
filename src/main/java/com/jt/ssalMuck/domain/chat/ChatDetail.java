package com.jt.ssalMuck.domain.chat;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor

public class ChatDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long chat_detail_id;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;
    private String msg_from;
    private String msg_to;
    private String msg;
    @CreatedDate
    private String createdDate;

}
