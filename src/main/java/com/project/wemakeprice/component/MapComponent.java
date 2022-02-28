package com.project.wemakeprice.component;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MapComponent {
    /**
     * 몫, 나머지
     * @param strOutput
     * @param intBundle
     * @return
     */
    public Map<String, String> getCalc(String strOutput, int intBundle) {
        int intLength = strOutput.length();
        int intQuotient = intLength / intBundle;
        int intPosition = intQuotient * intBundle;

        Map<String, String> objMap = new HashMap<>();
        objMap.put("quotient", strOutput.substring(0, intPosition));
        objMap.put("remainder", strOutput.substring(intPosition));

        return objMap;
    }
}
