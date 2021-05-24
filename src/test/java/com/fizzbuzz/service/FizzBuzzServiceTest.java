package com.fizzbuzz.service;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FizzBuzzServiceTest {

    @InjectMocks
    FizzBuzzService fizzBuzzService;
    private List<String> standardResult;
    private List<String> customResult;
    private String fizz;
    private String buzz;
    private String fizzbuzz;

    @BeforeAll
    public void init() {
        standardResult = fizzBuzzService.standardFizzBuzz();
        customResult = fizzBuzzService.customFizzBuzz();
    }


    /**
     * it performs the validation on normal number(i.e A number doesn't fall under FIZZ or BUZZ category )
     * standardResult.get(0) gives you the first element(i.e. number 1) from series.
     */
    @Test
    public void withValidNormalInput() {
        assertEquals("1", standardResult.get(0));
        assertEquals("100", standardResult.get(99));
    }

    /**
     * It performs the validation on number that falls under Fizz category(i.e. anyNumber divisible by 3)
     * standardResult.get(2) gives you the third element(i.e. number 3) from series.
     */
    @Test
    public void withValidFizzInput() {
        assertEquals("Fizz", standardResult.get(2));
        assertEquals("Fizz", standardResult.get(8));

    }

    /**
     * It performs the validation on number that falls under Buzz category(i.e. anyNumber divisible by 5)
     * standardResult.get(4) gives you the fifth element(i.e. number 5) from series.
     */
    @Test
    public void withValidBuzzInput() {
        assertEquals("Buzz", standardResult.get(4));
        assertEquals("Buzz", standardResult.get(19));
    }

    /**
     * It performs the validation on number that falls under FizzBuzz category(i.e. anyNumber divisible by 5 and 3)
     * standardResult.get(14) gives you the fifteenth element(i.e. number 15) from series.
     */
    @Test
    public void withValidFizzBuzzInput() {
        assertEquals("FizzBuzz", standardResult.get(14));
    }

    /**
     * It performs the validation on based on custom rules
     * i.e Fizz category = any number divisible ny or it contains "3"
     * standardResult.get(13) gives you the thirteenth element(i.e. number 13) from series.
     * that is not divisible by 3 but it contains "3"
     */
    @Test
    public void withValidCustomFizzInput() {
        assertEquals("Fizz", customResult.get(12));
    }


}
