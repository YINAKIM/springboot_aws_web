package com.jojold.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
        /*
           @SpringBootApplication

           스프링부트의 자동설정, 스프링 Bean읽기와 생성을 모두 자동으로 설정
           @SpringBootApplication이 있는 위치부터 설정을 읽기때문에 이게 붙은 클래스는 꼭! 프로젝트 최상단에 위치해야한다
           이 어노테이션이 붙은 클래스의 main이 실행되면서 내장 WAS를 실행한다. => 톰캣설치 필요없음, 스프링부트로 만들어진 Jar파일만 실행하면 된다.

           언제 어디서나 같은 환경에서 스프링부트를 배포할 수 있기때문에 내장 WAS를 사용하는 것이 권장된다.


           예를들어, 새로운 서버가 추가되거나 여러개의 서버를 한꺼번에 추가해야 되는 경우, 버전이 변경될 때 불편하고 실수가 생겨서 문제생길 수도 있다.
           근데 내장 WAS를 사용하면 이런 문제를 해결할 수 있다.
           (톰캣도 서블릿으로 이루어진 자바 어플리케이션이다. 같은 코드를 사용하고 있으므로 내장WAS와 성능상 이슈는 크게 고려하지 않아도 된다)
        */
    }//main

    /*
    Application만 실행시켜보면,
    2021-06-07 15:44:29.600  INFO 3371 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    로 8080포트번호로 Tomcat이 시작된게 보인다
    http://localhost:8080/hello로 접속하면 hello 출력됨 ( HelloController.java )
    */
}
