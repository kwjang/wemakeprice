package com.project.wemakeprice.controller;

import com.project.wemakeprice.dto.RequestDto;
import com.project.wemakeprice.dto.ResponseDto;
import com.project.wemakeprice.service.CrawlingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CrawlingController {
    private final CrawlingService crawlingService;

    @PostMapping(value = "/crawling", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ResponseDto> crawling(@RequestBody RequestDto requestDto) {
        return ResponseEntity.ok(crawlingService.project(requestDto));
    }
}
