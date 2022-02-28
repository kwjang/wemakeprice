package com.project.wemakeprice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.wemakeprice.dto.RequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CrawlingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    public void 컨트롤러_호출_테스트() throws Exception {
        RequestDto requestDto = new RequestDto();
        requestDto.setUrl("https://naver.com");
        requestDto.setType("without html");
        requestDto.setBundle(10);

        final ResultActions resultActions = mockMvc.perform(post("/crawling")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andDo(print());

        MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();
        String token = mvcResult.getResponse().getContentAsString();

        assertThat(token).isNotNull();
    }
}
