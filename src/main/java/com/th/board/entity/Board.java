package com.th.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board extends TimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 10, nullable = false)
    private String writer;

    @Column(length=100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;

    @Builder
    public Board(Long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}
