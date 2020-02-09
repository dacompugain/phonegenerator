/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.phonegenerator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PhoneControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void validPhoneWithAreaCode() throws Exception {
    mockMvc.perform(get("/phone/?number=2025954670&skip=0&take=5"))
      .andExpect(status().isOk()).andExpect(content().string("{\"combinations\":[\"2025954670\"," +
      "\"20259546p0\",\"20259546q0\",\"20259546r0\",\"20259546s0\"],\"totalCount\":102400}")).andReturn();
  }

  @Test
  public void validPhoneWithoutAreaCode() throws Exception {
    mockMvc.perform(get("/phone/?number=5954670&skip=5&take=3"))
      .andExpect(status().isOk()).andExpect(content().string("{\"combinations\":[\"5954m70\"," +
      "\"5954mp0\",\"5954mq0\"],\"totalCount\":6400}")).andReturn();
  }

  @Test
  public void invalidPhoneNumber() throws Exception {
    mockMvc.perform(get("/phone/?number=15954670&skip=5&take=3"))
      .andExpect(status().is4xxClientError());
  }

  @Test
  public void noPhoneNumber() throws Exception {
    mockMvc.perform(get("/phone/?skip=5&take=3"))
      .andExpect(status().is4xxClientError());
  }
}
