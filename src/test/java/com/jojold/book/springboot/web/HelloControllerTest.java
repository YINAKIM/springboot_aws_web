package com.jojold.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String helle = "hello"; // 여기 hello가 HelloController에 있는 return "hello";랑 같아야된다. ㅋㅋㅋㅋ오 신기해
        /*
        Response content expected:<helloooo> but was:<hello>
        Expected :helloooo
        Actual   :hello
        */
        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(helle));

            //    (get("/hello")).andExpect(status().isOk()).andExpect(content().string(helle));
    }
}
