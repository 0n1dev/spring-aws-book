package com.dev.spring.springboot.service.posts;

import com.dev.spring.springboot.domain.posts.Posts;
import com.dev.spring.springboot.domain.posts.PostsRepository;
import com.dev.spring.springboot.dto.PostsListResponseDto;
import com.dev.spring.springboot.dto.PostsSaveRequestDto;
import com.dev.spring.springboot.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

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
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalStateException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public Posts get(Long id) {
        return postsRepository.findById(id).orElseThrow(() -> new IllegalStateException("해당 게시글이 없습니다. id=" + id));
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
