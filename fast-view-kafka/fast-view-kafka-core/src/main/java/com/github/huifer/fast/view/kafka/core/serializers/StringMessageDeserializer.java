package com.github.huifer.fast.view.kafka.core.serializers;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class StringMessageDeserializer implements MessageDeserializer {


  /**
   * 读取 bytes
   *
   */
  private static byte[] readBytes(ByteBuffer buffer, int size) {
    final var dest = new byte[size];
    if (buffer.hasArray()) {
      System.arraycopy(buffer.array(), buffer.arrayOffset(), dest, 0, size);
    } else {
      buffer.mark();
      buffer.get(dest);
      buffer.reset();
    }
    return dest;
  }

  @Override
  public String deserializeMessage(ByteBuffer buffer) {
    return new String(readBytes(buffer, buffer.limit()), StandardCharsets.UTF_8);
  }
}
