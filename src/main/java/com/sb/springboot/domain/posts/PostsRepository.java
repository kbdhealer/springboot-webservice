package com.sb.springboot.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //access DB using Posts class. create CRUD methods automatically(thisclassName.save(classname.builder()......)
}
