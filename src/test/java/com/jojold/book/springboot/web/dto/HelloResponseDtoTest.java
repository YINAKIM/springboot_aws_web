package com.jojold.book.springboot.web.dto;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {


    @Test
    public void 롬복_기능테스트(){
        //given
        String name="test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //=> given 필드
        assertThat(dto.getAmount()).isEqualTo(amount);

        /*
          assertThat() : assertj라는 테스트 검증 라이브러리의 검증메소드
          import static org.assertj.core.api.Assertions.assertThat;
          검증하고 싶은 대상을 메소드 인자로 받는다
          메소드 체이닝이 지원, isEqualTo같이 메소드를 이어서 사용할 수 있음
          --> junit의 기본 assertThat이 아닌, assertj의 assertThat을 사용함 :

          *** junit과 비교해서 장점 ***
          ==> CoreMatchers와 달리 추가적으로 라이브러리가 필요하지않음 (Junit의 assertThat을 쓰게되면, is()와 같이 CoreMatchers 라이브러라기 필요하다)
          ==> 자동완성이 좀더 확실하게 지원된다.

          isEqualTo : assertj의 동등비교 메소드
          assertThat에 있는 값과 isEqualTo의 값을 비교, 같을 때만 성공
        */

    }

    /*
    실행결과1.
    > Task :compileJava FAILED
/Users/kim-yina/Desktop/boot_ws/boot_ex/freelec-springboot2-webservice/src/main/java/com/jojold/book/springboot/web/dto/HelloResponseDto.java:10: error: variable name not initialized in the default constructor
    private final String name;
                         ^
2 errors
똑같이 private final int amount;도 생성자 없었음  ==>  gradle버전 확인하라그래서
확인 ( 프로젝트에서 gradle > wrapper > gradle-wrapper.properties ) : distributionUrl=https\://services.gradle.org/distributions/gradle-6.8-bin.zip
되어있음, 이 책의 예제들은
Java 8
Gradle 4.x
Spring Boot 2.1.x
버전에서 진행된다고함



    */
}
