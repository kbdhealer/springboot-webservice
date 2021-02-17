package com.sb.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; //enable mvc.perform(get....
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;// enable mvc.perform.andExpect

import static org.hamcrest.Matchers.is;  // jsonPath.....is()

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    //lombok, add dto
    @Test
    public void helloDto_return() throws Exception {
        String name="adam";
        int amount=9999;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount", String.valueOf(amount)))  //only string allowed
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


    }

}
