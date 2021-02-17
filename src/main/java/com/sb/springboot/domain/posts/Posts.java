package com.sb.springboot.domain.posts;

import com.sb.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter  //lombok
@NoArgsConstructor  //lombok
@Entity //connected to a table
public class Posts extends BaseTimeEntity { //automated date time allocation for entity classes

    @Id //primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk generation rule, can create auto increment key
    private Long id;

    @Column(length = 500, nullable = false) //set column options
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // default varchar(255)
    private String content;

    private String author;

    @Builder //use builder rather than constructor , like args constructor
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
