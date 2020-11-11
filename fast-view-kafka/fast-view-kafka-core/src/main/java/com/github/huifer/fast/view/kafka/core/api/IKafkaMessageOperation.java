/*
 *
 * Copyright 2020 HuiFer All rights reserved.
 *
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
 *
 */

package com.github.huifer.fast.view.kafka.core.api;

import java.util.List;

import com.github.huifer.fast.view.kafka.core.serializers.Deserializers;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

public interface IKafkaMessageOperation {
	boolean sendMessage(String topic, String key, String value, KafkaProducer<byte[], byte[]> kafkaProducer);

	List<ConsumerRecord> getMessage(String topicName, Deserializers deserializer, KafkaConsumer<byte[], byte[]> consumer);
}