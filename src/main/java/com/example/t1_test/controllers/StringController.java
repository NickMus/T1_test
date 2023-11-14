package com.example.t1_test.controllers;

import com.example.t1_test.utils.IncomingStringParser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 14.11.2023
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StringController {
    private final IncomingStringParser stringParser;

    @RequestMapping(value = "/counter")
    @ResponseBody
    public String parseString(@RequestParam("str") String str) {
        return stringParser.stringValidator(str);
    }
}
