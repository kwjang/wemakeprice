package com.project.wemakeprice.service;

import com.project.wemakeprice.component.JsoupComponent;
import com.project.wemakeprice.component.MapComponent;
import com.project.wemakeprice.component.StringComponent;
import com.project.wemakeprice.dto.RequestDto;
import com.project.wemakeprice.dto.ResponseDto;
import com.project.wemakeprice.error.exception.InvalidHttpRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CrawlingService {
    @Autowired
    private JsoupComponent jsoupComponent;
    @Autowired
    private StringComponent stringComponent;
    @Autowired
    private MapComponent mapComponent;

    public ResponseDto project(RequestDto requestDto) {
        if(requestDto.getUrl().isEmpty() || requestDto.getType().isEmpty() || requestDto.getBundle().toString().isEmpty()) {
            throw new InvalidHttpRequestException("파라미터 미존재");
        }

        // 1. Jsoup
        String strText = jsoupComponent.getJsoup(requestDto.getUrl(), requestDto.getType());

        // 2. Alphabet Sort
        String strAlphabetSort = stringComponent.getAlphabetSort(strText);

        // 3. Number Sort
        String strNumberSort = stringComponent.getNumberSort(strText);

        // 4. Cross Output
        String strOutput = stringComponent.getCrossOutput(strAlphabetSort, strNumberSort);

        // 5. quotient, remainder
        Map<String, String> objMap = mapComponent.getCalc(strOutput, requestDto.getBundle());

        return new ResponseDto(objMap.get("quotient"), objMap.get("remainder"));
    }
}