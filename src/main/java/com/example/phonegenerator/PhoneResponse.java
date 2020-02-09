package com.example.phonegenerator;

import java.util.List;

public class PhoneResponse {

  List<String> combinations;
  Integer totalCount;

  public PhoneResponse(List<String> combinations, Integer total) {
    this.combinations = combinations;
    this.totalCount = total;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public List<String> getCombinations() {
    return combinations;
  }
}
