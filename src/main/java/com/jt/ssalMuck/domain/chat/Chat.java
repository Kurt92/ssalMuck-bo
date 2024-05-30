package com.jt.ssalMuck.domain.chat;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chat_id;
    private String room_nm;
    private String chatter;
    @CreatedDate
    private String createdDate;

    @OneToMany
    private List<Chat> ChatDetail;

}
