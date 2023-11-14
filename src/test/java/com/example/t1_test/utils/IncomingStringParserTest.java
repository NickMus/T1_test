package com.example.t1_test.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 14.11.2023
 */
class IncomingStringParserTest {
    IncomingStringParser stringParser = new IncomingStringParser();

    @Test
    void shouldReturnStringInDeskOrder() {
        assertEquals("{d=4, c=3, b=2, a=1}", stringParser.stringValidator("abbcccdddd"));
    }

    @Test
    void shouldReturnEmptyResult() {
        assertEquals("", stringParser.stringValidator(""));
    }

    @Test
    void shouldReturnLettersThenIntegersThenOthers() {
        assertEquals("{a=1, B=1, 1=1, 2=1, !=1, $=1}", stringParser.stringValidator("1!a2$B"));
    }
}