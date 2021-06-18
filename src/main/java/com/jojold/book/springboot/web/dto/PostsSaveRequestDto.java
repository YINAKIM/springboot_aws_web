package com.jojold.book.springboot.web.dto;

import com.jojold.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto { // Controller와 Service에서 사용할 Dto

    /*
    * 이 DTO는 @Entity클래스와 거의 유사한 형태다.
    * 하지만 절대로!
    * Entity클래스를 Request/Response클래스로 사용해서는 안된다.
    *
    * [Entity클래스]는 DB와 맞닿은 핵심클래스다.
    * [Entity클래스]를 기준으로 테이블이 생성되고 스키마가 변경된다.
    *
    * ---> 때문에 Request/Response용 Dto는 View를 위한 클래스라서 자주 변경되고,
    *      Entity와 유사한 형태를 가지긴 하지만 정확히는 Entity 클래스는 아니다.
    * ---> Dto는 자주변경될 수 있는 View를 위한 클래스다
    *
    *
    * View계층과  DB계층은 역할을 철저히 분리하는게 좋다.
    * => 쉽게말해서,
    *    Controller에서 요청한 결과값이 여러 테이블을 조인한 결과값인 경우가 많음
    *    근데 Entity클래스는 JPA에서 하나의 테이블 역할을 하니까(Entity테이블 기준으로 테이블이생성, 스키마가 변경되니까)
    *    Entity클래스는 변경이 잦으면 안되는것,
    *    그래서 변경이 잦은 View를 위한 Dto클래스가(Entity클래스와 유사한 형태로) 필드를 정의하고, @Builder로 생성자에 값을 넣는 역할을 대신하는 것
    *    하지만 엔티티클래스는 아니므로 View에 따라 변경이 잦아도 괜찮고,
    * => 이 Dto클래스는 엔티티매니저가 관리하지 않으므로 테이블이 생성되지 않는다.
    *
    *
    *
    * */

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }


    // Dto로 Entity Obj의 생성자에 값 세팅하는 toEntity() --> 뷰를(편의를) 위해 따로 만든 Dto를 이용, 엔티티클래스로 테이블에 값을 넣어주는 역할
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }



}
