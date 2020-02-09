// Algorithm below was found at leetcode https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/
// I have modified it to accept values 0,1 in addition to 2-9 and to support pagination
// Code and controller logic was written by me Daniel Avery

package com.example.phonegenerator;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
class PhoneOrchestrator {
  Map<String, String> phone = new HashMap<String, String>() {{
    put("0", "0");
    put("1", "1");
    put("2", "2abc");
    put("3", "3def");
    put("4", "4ghi");
    put("5", "5jkl");
    put("6", "6mno");
    put("7", "7pqrs");
    put("8", "8tuv");
    put("9", "9wxyz");
  }};

  List<String> output;

  public void backtrack(String combination, String next_digits) {
    // if there is no more digits to check
    if (next_digits.length() == 0) {
      // the combination is done
      output.add(combination);
    }
    // if there are still digits to check
    else {
      // iterate over all letters which map
      // the next available digit
      String digit = next_digits.substring(0, 1);
      String letters = phone.get(digit);
      for (int i = 0; i < letters.length(); i++) {
        String letter = phone.get(digit).substring(i, i + 1);
        // append the current letter to the combination
        // and proceed to the next digits
        backtrack(combination + letter, next_digits.substring(1));
      }
    }
  }

  public PhoneResponse letterCombinations(String digits, Integer skip, Integer take) {
    output = new ArrayList<>(take);
    if (digits.length() != 0)
      backtrack("", digits);
    // dont allow to take more than available
    Integer end = skip + take;
    if(end > output.size()) {
      end = output.size();
    }
    return new PhoneResponse(output.subList(skip, end), output.size());
  }


}
