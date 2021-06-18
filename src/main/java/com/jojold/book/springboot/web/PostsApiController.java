package com.jojold.book.springboot.web;

import com.jojold.book.springboot.service.posts.PostsService;
import com.jojold.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    //여기 컨트롤러인데 Autowired없는 이유? --> PostsService에서 @RequiredArgsConstructor 쓰고있는데,
    //                                   이게 final이 선언된 모든 필드를 인자로 하는 생성자를 만들어준다(lombok),
    //                                   @Autowired로 주입받는게 아니라,
    //                                   postsService에 선언된 @RequiredArgsConstructor가 만들어주는 생성자로 주입받기 때문
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

}
