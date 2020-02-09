package com.example.phonegenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneController {

  @Autowired
  PhoneOrchestrator phoneOrchestrator;

  @GetMapping("/phone")
  public ResponseEntity<PhoneResponse> phone(@RequestParam(value = "number") String number,
                                             @RequestParam(value = "skip", required = false, defaultValue = "0") Integer skip,
                                             @RequestParam(value = "take", required = false, defaultValue = "3") Integer take) {
    if (number.isEmpty() || (number.length() != 7 && number.length() != 10)) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    return new ResponseEntity<>(phoneOrchestrator.letterCombinations(number, skip, take), HttpStatus.OK);
  }
}
