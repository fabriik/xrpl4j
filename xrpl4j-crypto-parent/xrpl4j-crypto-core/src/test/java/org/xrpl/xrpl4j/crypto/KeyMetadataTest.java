package org.xrpl.xrpl4j.crypto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xrpl.xrpl4j.codec.addresses.VersionType;

/**
 * Unit tests for {@link KeyMetadata}.
 */
public class KeyMetadataTest {

  @Test
  public void testPlatformIdentifierWithNullPlatformIdentifier() {
    Assertions.assertThrows(IllegalStateException.class, () -> KeyMetadata.builder()
      // .platformIdentifier("foo")
      .keyringIdentifier("foo")
      .keyIdentifier("foo")
      .keyPassword("foo")
      .keyVersion("foo")
      .build());
  }

  @Test
  public void testPlatformIdentifierWithNullKeyringIdentifier() {
    Assertions.assertThrows(IllegalStateException.class, () -> KeyMetadata.builder()
      .platformIdentifier("foo")
      // .keyringIdentifier("foo")
      .keyIdentifier("foo")
      .keyPassword("foo")
      .keyVersion("foo")
      .build());
  }

  @Test
  public void testPlatformIdentifierWithNullKeyIdentifier() {
    Assertions.assertThrows(IllegalStateException.class, () -> KeyMetadata.builder()
      .platformIdentifier("foo")
      .keyringIdentifier("foo")
      // .keyIdentifier("foo")
      .keyPassword("foo")
      .keyVersion("foo")
      .build());
  }

  @Test
  public void testPlatformIdentifierWithNullKeyVersion() {
    Assertions.assertThrows(IllegalStateException.class, () -> KeyMetadata.builder()
      .platformIdentifier("foo")
      .keyringIdentifier("foo")
      .keyIdentifier("foo")
      .keyPassword("foo")
      // .keyVersion("foo")
      .build());
  }

  @Test
  public void testPlatformIdentifierBuilder() {
    assertThat(KeyMetadata.builder()
      .platformIdentifier("foo")
      .keyringIdentifier("foo")
      .keyIdentifier("foo")
      .keyVersion("foo")
      .build()).isNotNull();
  }

}