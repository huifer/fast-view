package com.github.huifer.fast.view.kafka.core.serializers;

import java.nio.ByteBuffer;

@FunctionalInterface
public interface MessageDeserializer {

  String deserializeMessage(ByteBuffer buffer);
}
