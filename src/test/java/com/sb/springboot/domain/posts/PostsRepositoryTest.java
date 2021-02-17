package com.sb.springboot.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.junit.jupiter.api.AfterEach;

//assertThat
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

//    @After
@AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void save_load() {
        //given
        String title = "test title";
        String content = "test content";

        postsRepository.save(Posts.builder() //exec insert/update query
            .title(title)
            .content(content)
            .author("diyun.dev@gmail.com")
            .build()); //essential

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test // test for automated date time allocation to entity classes
    public void BaseTimeEntity_save() {
    //given
        LocalDateTime now = LocalDateTime.of(2021,2,16,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>> createDate=" + posts.getCreatedDate()+", " +
                "modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
