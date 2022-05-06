package com.ssalMuck.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Board2 {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String username;
    private String createDT;
}
