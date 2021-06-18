package com.jojold.book.springboot.web;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@RunWith(SpringRunner.class) --> 이거 Junit4
@ExtendWith(SpringExtension.class) //--> 이거 Junit5, jupiter.api
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello"; // 여기 hello가 HelloController에 있는 return "hello";랑 같아야된다. ㅋㅋㅋㅋ오 신기해
        /*
        Response content expected:<helloooo> but was:<hello>
        Expected :helloooo
        Actual   :hello
        */
        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));

            //    (get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));//---> 이거 Junit5, jupiter.api
                //.andExpect(jsonPath("$.amount", is(amount)));---> 이거 Junit4
    }

}
