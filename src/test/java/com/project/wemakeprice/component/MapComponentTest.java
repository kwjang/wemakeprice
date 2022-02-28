package com.project.wemakeprice.component;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapComponentTest {
    @Test
    public void 몫_나머지_구하기() {
        MapComponent mapComponent = new MapComponent();

        String strInput = "A2a3b5C";
        int intBundle = 2;
        Map<String, String> objMap = mapComponent.getCalc(strInput, intBundle);

        Map<String, String> objExpect = new HashMap<>();
        objExpect.put("quotient", "A2a3b5");
        objExpect.put("remainder", "C");

        assertThat(objMap).isEqualTo(objExpect);
    }

    @Test
    public void 몫_나머지_묶음길이초과() {
        MapComponent mapComponent = new MapComponent();

        String strInput = "A2a3b5C";
        int intBundle = 10;
        Map<String, String> objMap = mapComponent.getCalc(strInput, intBundle);

        Map<String, String> objExpect = new HashMap<>();
        objExpect.put("quotient", "");
        objExpect.put("remainder", "A2a3b5C");

        assertThat(objMap).isEqualTo(objExpect);
    }

    @Test(expected = ArithmeticException.class)
    public void 몫_나머지_묶음길이제로() {
        MapComponent mapComponent = new MapComponent();

        String strInput = "A2a3b5C";
        int intBundle = 0;
        Map<String, String> objMap = mapComponent.getCalc(strInput, intBundle);
    }
}
