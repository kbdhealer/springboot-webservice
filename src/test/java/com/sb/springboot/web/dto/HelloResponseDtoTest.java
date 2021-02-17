package com.sb.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_func_test() {
        //given
        String name = "test";
        int amount= 999;

        //when
        HelloResponseDto hrd = new HelloResponseDto(name, amount);

        //then
        assertThat(hrd.getName()).isEqualTo(name);
        assertThat(hrd.getAmount()).isEqualTo(amount);
    }
}
