package com.sb.springboot.service;

import com.sb.springboot.domain.posts.Posts;
import com.sb.springboot.domain.posts.PostsRepository;
import com.sb.springboot.web.dto.PostsResponseDto;
import com.sb.springboot.web.dto.PostsSaveRequestDto;
import com.sb.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found. id= "+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found. id= "+id));
        return new PostsResponseDto(entity);
    }
}
