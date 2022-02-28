package com.project.wemakeprice.component;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

public class JsoupComponentTest {
    @Test
    public void 크롤링_테스트_HTML제외() {
        JsoupComponent jsoupComponent = new JsoupComponent();

        String strText = jsoupComponent.getJsoup("https://www.naver.com/", "without html");
        System.out.print(strText);
    }

    @Test
    public void 크롤링_테스트_TEXT전체() {
        JsoupComponent jsoupComponent = new JsoupComponent();

        String strText = jsoupComponent.getJsoup("https://www.naver.com/", "all text");
        System.out.print(strText);
    }
}
