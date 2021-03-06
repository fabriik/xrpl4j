package org.xrpl.xrpl4j.codec.binary;

/*-
 * ========================LICENSE_START=================================
 * xrpl4j :: binary-codec
 * %%
 * Copyright (C) 2020 - 2022 XRPL Foundation and its contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

public class BinaryCodecObjectMapperFactory {

  private static ObjectMapper objectMapper = JsonMapper.builder()
    .addModule(new Jdk8Module())
    .addModule(new GuavaModule())
    .configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true)
    .configure(JsonWriteFeature.WRITE_NUMBERS_AS_STRINGS, false)
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
    .serializationInclusion(JsonInclude.Include.NON_EMPTY)
    .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
    .build();

  public static ObjectMapper getObjectMapper() {
    return objectMapper;
  }

}
