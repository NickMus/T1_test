package com.example.t1_test.utils;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 14.11.2023
 */
@Component
public class IncomingStringParser {

    public String stringValidator(String str) {
        if (str.isEmpty())
            return "";
        Map<String, Integer> integerMap = new HashMap<>();
        Map<String, Integer> letterMap = new HashMap<>();
        Map<String, Integer> otherSymbolsMap = new HashMap<>();
        String[] strings = str.split("");
        for (String s : strings) {
            if (s.matches("[0-9]")) {
                integerMap.merge(s, 1, Integer::sum);
            }
            if (s.matches("[a-zA-Z]")) {
                letterMap.merge(s, 1, Integer::sum);
            } else {
                otherSymbolsMap.merge(s, 1, Integer::sum);
            }
        }
        LinkedHashMap<String, Integer> linkedHashMap =
                Stream.of(letterMap, integerMap, otherSymbolsMap)
                        .flatMap(map -> map.entrySet().stream())
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (m1, m2) -> m1, LinkedHashMap::new));

        return linkedHashMap.toString();
    }
}
