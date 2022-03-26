package org.xrpl.xrpl4j.model.flags;

/*-
 * ========================LICENSE_START=================================
 * xrpl4j :: model
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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class OfferFlagsTests extends AbstractFlagsTest {

  public static Stream<Arguments> data() {
    return getBooleanCombinations(2);
  }

  @ParameterizedTest
  @MethodSource("data")
  public void testDeriveIndividualFlagsFromFlags(
    boolean lsfPassive,
    boolean lsfSell
  ) {
    long expectedFlags = (lsfPassive ? Flags.OfferFlags.PASSIVE.getValue() : 0L) |
      (lsfSell ? Flags.OfferFlags.SELL.getValue() : 0L);

    Flags.OfferFlags flags = Flags.OfferFlags.of(expectedFlags);

    assertThat(flags.getValue()).isEqualTo(expectedFlags);
    assertThat(flags.lsfPassive()).isEqualTo(lsfPassive);
    assertThat(flags.lsfSell()).isEqualTo(lsfSell);
  }
}
