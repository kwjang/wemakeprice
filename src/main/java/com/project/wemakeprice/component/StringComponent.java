package com.project.wemakeprice.component;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class StringComponent {
    /**
     * 알파벳 정렬
     * @param strText
     * @return
     */
    public String getAlphabetSort(String strText) {
        String strAlphabet = strText.replaceAll("[^a-zA-Z]", "");

        return Arrays.stream(strAlphabet.split("")).sorted((o1, o2)-> {
            int res = o1.compareToIgnoreCase(o2);
            return (res == 0) ? o1.compareTo(o2) : res;
        }).collect(Collectors.joining());
    }

    /**
     * 숫자 정렬
     * @param strText
     * @return
     */
    public String getNumberSort(String strText) {
        String strNumber = strText.replaceAll("[^0-9]", "");

        return strNumber.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

    /**
     * 알파벳, 숫자 교차 출력
     * @param strAlphabet
     * @param strNumber
     * @return
     */
    public String getCrossOutput(String strAlphabet, String strNumber) {
        // String to Array
        String[] arrAlphabet = strAlphabet.split("");
        String[] arrNumber = strNumber.split("");

        // length
        int intAlphabet = arrAlphabet.length;
        int intNumber = arrNumber.length;
        int intSize = Math.max(arrAlphabet.length, arrNumber.length);

        StringBuilder strOutput = new StringBuilder();

        for (int i = 0; i <= intSize; i++) {
            if (i < intAlphabet) {
                strOutput.append(arrAlphabet[i]);
            }

            if (i < intNumber) {
                strOutput.append(arrNumber[i]);
            }
        }
        
        return strOutput.toString();
    }
}
