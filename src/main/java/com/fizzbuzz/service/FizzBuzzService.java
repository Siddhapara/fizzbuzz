package com.fizzbuzz.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.fizzbuzz.util.util.*;

@AllArgsConstructor
@Service
public class FizzBuzzService {

    private List<String> result = new ArrayList<>();

    /**
     * @param type
     * @return List of FizzBuzz series
     * this method produce the fizzbuzz series based on the defined rules.
     */
    public List<String> generateFizzBuzz(String type) {
        if (type.equalsIgnoreCase(STANDARD_FIZZ_BUZZ))
            return standardFizzBuzz();
        else
            return customFizzBuzz();
    }

    /**
     * Scenario 1
     * it produce the FizzBuzz series from 1 to 100 based on the following rules:
     * Fizz: Any Number divisible by 3
     * Buzz: Any Number divisible by 5
     * FizzBuss: any Number divisible by 3 and 5
     */
    public List<String> standardFizzBuzz() {
        for (int number = 1; number <= 100; number++) {
            if (number % 5 == 0 && number % 3 == 0) {
                result.add("FizzBuzz");
            } else if (number % 3 == 0) {
                result.add("Fizz");
            } else if (number % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(number));
            }
        }
        return result;
    }

    /**
     * Scenario 2
     * it produce the FizzBuzz series from 1 to 100 based on the following rules:
     * Fizz: Any Number divisible by 3 or it contains 3
     * Buzz: Any Number divisible by 5 or it contains 5
     * FizzBuss: any Number divisible by 3 and 5 or it contains 3 or 5
     */
    public List<String> customFizzBuzz() {
        for (int number = 1; number <= 100; number++) {
            if ((number % 5 == 0 && number % 3 == 0) || (String.valueOf(number).contains("3") && String.valueOf(number).contains("5"))) {
                result.add("FizzBuzz");
            } else if (number % 3 == 0 || String.valueOf(number).contains("3")) {
                result.add("Fizz");
            } else if (number % 5 == 0 || String.valueOf(number).contains("5")) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(number));
            }
        }
        return result;
    }
}
