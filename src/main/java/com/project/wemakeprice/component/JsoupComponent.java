package com.project.wemakeprice.component;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsoupComponent {
    /**
     * Jsoup을 이용한 크롤링
     * @param strUrl
     * @param strType
     * @return
     */
    public String getJsoup(String strUrl, String strType) {
        String strText = "";

        try {
            Document document = Jsoup.connect(strUrl).timeout(5000).get();
            strText = strType.equals("without html") ? document.text() : document.html();
        } catch (IOException e) {
            throw new RuntimeException("크롤링 실패");
        }

        return strText;
    }
}