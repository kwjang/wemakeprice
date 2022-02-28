package com.project.wemakeprice.component;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringComponentTest {
    @Test
    public void 알파벳_정렬() {
       StringComponent stringComponent = new StringComponent();

       String strInput = "!5ㄱㄴaA32bC";
       String str = stringComponent.getAlphabetSort(strInput);

       assertThat(str).isEqualTo("AabC");
    }

    @Test
    public void 숫자_정렬() {
        StringComponent stringComponent = new StringComponent();

        String strInput = "!5ㄱㄴaA32bC";
        String str = stringComponent.getNumberSort(strInput);

        assertThat(str).isEqualTo("235");
    }

    @Test
    public void 교차_출력() {
        StringComponent stringComponent = new StringComponent();

        String strInput1 = "AabC";
        String strInput2 = "235";
        String str = stringComponent.getCrossOutput(strInput1, strInput2);

        assertThat(str).isEqualTo("A2a3b5C");
    }
}
