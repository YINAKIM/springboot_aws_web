package com.jojold.book.springboot.web;

import com.jojold.book.springboot.domain.posts.Posts;
import com.jojold.book.springboot.domain.posts.PostsRepository;
import com.jojold.book.springboot.web.dto.PostsSaveRequestDto;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

    /*
    ************* Controller테스트하는테 @WebMvcTest 를 사용하지 않은 이유?
    * @WebMvcTest는
    * JPA기능이 작동하지 않는다
    * Controller와 ControllerAdvice 같이 외부연동과 관련된 부분만 활성화될 뿐,
    * web요청을 테스트한다고 꼭 @WebMvcTest를 사용하는 것은 아니다
    *
    * [결론]
    * JPA + controller를 같이 테스트할 때는  @SpringBootTest 와 TestRestTemplate 사용할 것!
    * @WebMvcTest쓰면 안된다
    * */

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    //@TestInstance(Lifecycle.PER_CLASS)
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }


    @Test
    public void Posts_등록된다() throws Exception{
        //given
        String title = "title";
        String content = "content";

        PostsSaveRequestDto requestDto
                = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();
        String url = "http://localhost:"+port+"/api/v1/posts";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then

        // assertThat 안되는 문제 :  import static org.assertj.core.api.Assertions.assertThat; ---> 이거 import하면서 해결됨
        // https://www.notion.so/Junit-Assert-30aeadee7dd346af8d559ecd69ce47aa

        //200 OK 인지 확인
        //assertThat(responseEntity.getStatusCode().equals(HttpStatus.OK));
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        // 공식문서 참고 : https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html
        assertThat(responseEntity.getBody()).isGreaterThan(0L); // 0L 보다 큰지 test

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);


    }
}
