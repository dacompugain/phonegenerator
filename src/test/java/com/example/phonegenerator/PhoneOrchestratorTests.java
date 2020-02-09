package com.example.phonegenerator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
public class PhoneOrchestratorTests {

  @Autowired
  PhoneOrchestrator phoneOrchestrator;

  @Test
  public void validPhoneWithAreaCode() {
    PhoneResponse response = phoneOrchestrator.letterCombinations("2025954670", 0, 3);
    assertEquals(response.totalCount, 102400);
    assertEquals(response.combinations, new ArrayList<>(Arrays.asList("2025954670", "20259546p0", "20259546q0")));
  }

  @Test
  public void validPhoneWithoutAreaCode() {
    PhoneResponse response = phoneOrchestrator.letterCombinations("5954670", 3, 5);
    assertEquals(response.totalCount, 6400);
    assertEquals(response.combinations, new ArrayList<>(Arrays.asList("59546r0", "59546s0", "5954m70",
      "5954mp0", "5954mq0")));
  }

}
