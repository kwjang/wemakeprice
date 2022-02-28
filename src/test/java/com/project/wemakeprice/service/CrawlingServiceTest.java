package com.project.wemakeprice.service;

import com.project.wemakeprice.dto.RequestDto;
import com.project.wemakeprice.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CrawlingServiceTest {
    @Autowired
    private CrawlingService crawlingService;

    @Test
    public void 정상() {
        RequestDto requestDto = new RequestDto();
        requestDto.setUrl("https://naver.com");
        requestDto.setType("without html");
        requestDto.setBundle(10);

        ResponseDto responseDto = crawlingService.project(requestDto);
        assertThat(responseDto).isNotNull();
    }

    @Test
    public void 파라미터_필수값_체크() {
        RequestDto requestDto = new RequestDto();
        requestDto.setUrl(null);
        requestDto.setType("without html");
        requestDto.setBundle(10);

        ResponseDto responseDto = crawlingService.project(requestDto);
        assertThat(responseDto).isNotNull();
    }

    @Test
    public void 파라미터_URL_체크() {
        RequestDto requestDto = new RequestDto();
        requestDto.setUrl("https://naver.com111111");
        requestDto.setType("without html");
        requestDto.setBundle(10);

        ResponseDto responseDto = crawlingService.project(requestDto);
        assertThat(responseDto).isNotNull();
    }
}
