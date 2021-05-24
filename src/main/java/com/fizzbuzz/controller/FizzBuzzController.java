package com.fizzbuzz.controller;

import com.fizzbuzz.service.FizzBuzzService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static com.fizzbuzz.util.util.CUSTOM_FIZZ_BUZZ;
import static com.fizzbuzz.util.util.STANDARD_FIZZ_BUZZ;

@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {

    @Autowired
    FizzBuzzService fizzBuzzService;

    @ApiOperation(value = "getStandardSeries", notes = "This endpoint produce a FizzBuzz Series(from 1 to 100) with following rules: " +
            " (a) Fizz: Any Number divisible by 3" +
            " (b) Buzz: Any Number divisible by 5" +
            " (c) FizzBuss: any Number divisible by 3 and 5")
    @GetMapping("/getStandardSeries")
    public List<String> getStandardFizzBuzz() {
        return fizzBuzzService.generateFizzBuzz(STANDARD_FIZZ_BUZZ);
    }


    @ApiOperation(value = "getCustomSeries", notes = "This endpoint produce a FizzBuzz Series(from 1 to 100) with following rules: " +
            " (a) Fizz: Any Number divisible by 3 or it contains 3" +
            " (b) Buzz: Any Number divisible by 5 or it contains 5" +
            " (c) FizzBuss: any Number divisible by 3 and 5 or it contains 3 or 5")
    @GetMapping("/getCustomSeries")
    public List<String> getCustomFizzBuzz() {
        return fizzBuzzService.generateFizzBuzz(CUSTOM_FIZZ_BUZZ);
    }
}
